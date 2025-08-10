import React, { useEffect, useState } from 'react';

type Word = {
  id: number;
  text: String;
}

const App: React.FC = () => {
  const [words, setWords] = useState<Word[]>([]);
  const [currentIndex, setCurrentIndex] = useState(0);
  const [input, setInput] = useState('');
  const [typedCharCount, setTypedCharCount] = useState(0);
  const [score, setScore] = useState(0);
  const [timeLeft, setTimeLeft] = useState(30);
  const [gameOver, setGameOver] = useState(false);
  const [startTime, setStartTime] = useState<number | null>(null);

  // 単語取得
  useEffect(() => {
    fetch('http://localhost:8080/api/words')
      .then((res) => res.json())
      .then((data) => setWords(data))
      .catch((err) => console.error('Error fetching words', err));
  }, []);

  // タイマー処理
  useEffect(() => {
    if (timeLeft > 0 && words.length > 0 && !gameOver) {
      const timer = setInterval(() => {
        setTimeLeft(prev => prev -1);
      }, 1000);
      return () => clearInterval(timer);
    }else if (timeLeft === 0 && !gameOver) {
      finishGame();
    }
  }, [timeLeft, words, gameOver]);

  //全単語打ち終えたら即終了
  useEffect(() => {
    if (!gameOver && currentIndex >= words.length && words.length > 0) {
      finishGame();
    }
  }, [timeLeft, words, gameOver]);

  // ゲーム終了処理
  const finishGame = () => {
    setGameOver(true);
    if (startTime !== null) {
      const elapsedSec = (Date.now() - startTime) / 1000;
      const typingSpeed = currentIndex / elapsedSec;
      const finalScore = Math.round(typingSpeed * typedCharCount);
      setScore(finalScore);

      // スコア送信（バックエンドにPOST）
      fetch('http://localhost:8080/api/scores', {
        method: 'POST',
        headers: {'Content-Tyoe': 'application/json' },
        body: JSON.stringify({
          username: 'guest', //ログイン機能と連携
          score: finalScore,
        }),
      })
        .then((res) => {
          if (!res.ok) throw new Error('スコア送信失敗');
            console.log('スコア送信成功');
        })
        .catch((err) => console.error('Error fetching words', err));
    }
  };

  // 入力チェック
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.target.value;
    setInput(value);

    if (value === words[currentIndex]?.text) {
      const wordLength = value.length;
      setScore(prev => prev + wordLength);
      setInput('');
      setCurrentIndex(prev => prev + 1);
    }
  };

  // 再スタート処理
  const handleRestart = () => {
    setTypedCharCount(0);
    setStartTime(null);
    setTimeLeft(30);
    setScore(0);
    setCurrentIndex(0);
    setInput('');
    setGameOver(false);

    // 単語再取得
    fetch('http://localhost:8080/api/words')
      .then((res) => res.json())
      .then((data) => setWords(data))
      .catch((err) => console.error('Error fetching words', err));
  }

  return (
    <div style={{ padding: 24, fontFamily: 'sans-serif', textAlign: 'center' }}>
      <h1>タイピングゲーム</h1>
      <p>残り時間： { timeLeft } 秒</p>
      <p>スコア： { score } </p>

      {gameOver ? (
        <>
          <h2>ゲーム終了！お疲れ様でした。</h2>
          <button onClick={handleRestart} style={{ padding: 10, fontSize: 16}}>もう一度プレイ</button>
        </>
      ) : words.length > 0 ? (
        <>
          <h2>次の単語：</h2>
          <h3 style={{ fontSize: 32}}>{words[currentIndex]?.text || 'おしまい！'}</h3>
          <input 
            type="text"
            value={input}
            onChange={handleChange}
            disabled={gameOver}
            autoFocus
            style={{ padding: 8, fontSize: 18}}
          />
        </>
      ) : (
        <p>単語をロード中...</p>
      )}
    </div>
  );
};

export default App;
