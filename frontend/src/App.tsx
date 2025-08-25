import React, { useState } from 'react';
import Login from "./Login";
import Register from "./Register";
import Game from "./Game";
import Ranking from "./Ranking";

const App: React.FC = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [showRegister, setShowRegister] = useState(false);
  const [currentScreen, setCurrentScreen] = useState<"game" | "ranking">("game"); // ログイン後の画面

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
        <button onClick={() => setCurrentScreen("ranking")}>
          ランキング
        </button>
      </nav>

      <div style={{ marginTop: 20 }}>
        {currentScreen === "game" && <Game />}
        {currentScreen === "ranking" && <Ranking />}
      </div>
    </>
  );
};

export default App;
