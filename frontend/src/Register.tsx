import React, { useState } from 'react';

type Props = {
  onRegister: () => void;
}

const Register: React.FC<Props> = ({ onRegister }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleRegister = async () => {
    try{
      const res = await fetch("http://localhost:8080/api/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({username, password})
      });

      if (!res.ok) throw new Error("登録失敗");

      const msg = await res.text();
      alert(msg);
      onRegister();
    } catch(err) {
      console.error(err);
      alert("登録に失敗しました。");
    }
  };

  return (
    <div style={{ margin:24, textAlign: "center" }}>
      <h2>新規登録</h2>
      <div style={{ margin:5 }}>
        <input type="text" placeholder='ユーザー名' value={username} onChange={(e) => setUsername(e.target.value)} />
      </div>
      <div style={{ margin:5 }}>
        <input type="password" placeholder='パスワード' value={password} onChange={(e) => setPassword(e.target.value)} />
      </div>
      <button onClick={handleRegister}>登録</button>
    </div>
  );
};

export default Register;