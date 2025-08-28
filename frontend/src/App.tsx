import React, { useState } from 'react';
import Login from "./Login";
import Register from "./Register";
import Game from "./Game";
import Ranking from "./Ranking";

const App: React.FC = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [showRegister, setShowRegister] = useState(false);
  const [currentScreen, setCurrentScreen] = useState<"game" | "ranking">("game"); // ログイン後の画面

  const handleLogout = () => {
    localStorage.removeItem("jwt"); // JWT削除
    setIsLoggedIn(false); // ログイン状態をリセット
    setCurrentScreen("game"); // 初期画面に戻す（任意）
  }

  if (!isLoggedIn) {
    // 未ログイン時はLogin/Register切り替え
    return (
      <>
        {showRegister ? (
          <Register onRegister={() => setIsLoggedIn(true)} />
        ) : (
          <Login onLogin={() => setIsLoggedIn(true)} />
        )}

        <div style={{ margin:24, textAlign: "center" }}>
          {showRegister ? (
            <button onClick={() => setShowRegister(false)}>ログインへ</button>
          ) : (
            <button onClick={() => setShowRegister(true)}>新規登録へ</button>
          )}
        </div>
      </>
    );
  }

  // ログイン後
  return (
    <>
      <nav style={{ padding: 10, textAlign: "center" }}>
        <button onClick={() => setCurrentScreen("game")} style={{ marginRight: 10 }}>
          ゲーム
        </button>
        <button onClick={() => setCurrentScreen("ranking")} style={{ marginRight: 10 }}>
          ランキング
        </button>
        <button onClick={handleLogout}> 
          ログアウト
        </button>
      </nav>

      <div style={{ marginTop: 20 }}>
        {currentScreen === "game" && <Game isLoggedIn={isLoggedIn} />}
        {currentScreen === "ranking" && <Ranking />}
      </div>
    </>
  );
};

export default App;
