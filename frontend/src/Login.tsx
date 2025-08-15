import React, { useState } from 'react';

type Props = {
  onLogin: () => void;
}

const Login: React.FC<Props> = ({ onLogin }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async () => {
    try{
      const res = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({username, password})
      });

      if (!res.ok) throw new Error("ログイン失敗");

      const token = await res.text(); // JWTが返ってくる
      localStorage.setItem("jwt", token); //保存
      alert("ログイン成功");
      onLogin();
    } catch(err) {
      console.error(err);
      alert("ログインに失敗しました。");
    }
  };

  return (
    <div style={{ padding:24, textAlign: "center" }}>
      <h2>ログイン</h2>
      <input type="text" placeholder='ユーザー名' value={username} onChange={(e) => setUsername(e.target.value)} /><br></br>
      <input type="password" placeholder='パスワード' value={password} onChange={(e) => setPassword(e.target.value)} /><br></br>
      <button onClick={handleLogin}>ログイン</button>
    </div>
  );
};

export default Login;