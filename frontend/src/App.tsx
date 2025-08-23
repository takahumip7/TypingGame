import React, { useState } from 'react';
import Login from "./Login";
import Register from "./Register";
import Game from "./Game";

const App: React.FC = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [showRegister, setShowRegister] = useState(false);

  if (isLoggedIn) {
    return <Game />
  }

  return (
    <>
      {showRegister ? (
<<<<<<< HEAD
        <Register onRegister={() => setIsLoggedIn(true)} />
=======
        <Register onRegister={() => setIsLoggedIn(false)} />
>>>>>>> c0eef99c787acb39136987d17696290517a9c4a6
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
};

export default App;
