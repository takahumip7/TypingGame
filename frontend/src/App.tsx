import React, { useState } from 'react';
import Login from "./Login";
import Game from "./Game";

type Word = {
  id: number;
  text: String;
}

const App: React.FC = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <>
      {isLoggedIn ? (
        <Game />
      ) : (
        <Login onLogin={() => setIsLoggedIn(true)} />
      )}
    </>
  );
};

export default App;
