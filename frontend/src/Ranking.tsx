import React, { useEffect, useState } from 'react';

type Ranking = {
  username: string;
  score: number;
}

const Ranking: React.FC = () => {
  const [ranking, setRanking] = useState<Ranking[]>([]);

  useEffect(() => {
    const token = localStorage.getItem("jwt"); // 保存されたJWT取得
    fetch('http://localhost:8080/api/scores/ranking')
      .then((res) => res.json())
      .then((data) => setRanking(data))
      .catch((err) => console.error('Error fetching ranking', err));
  }, []);

  return (
    <div style={{ padding: 24, textAlign: "center" }}>
      <h1>ランキング</h1>
      <table style={{ margin: "0 auto", borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th style={{ border: "1px solid black", padding: 8 }}>順位</th>
            <th style={{ border: "1px solid black", padding: 8 }}>ユーザー</th>
            <th style={{ border: "1px solid black", padding: 8 }}>スコア</th>
          </tr>
        </thead>
        <tbody>
          {ranking.map((r, index) => (
            <tr key={index}>
              <td style={{ border: "1px solid black", padding: 8 }}>
                {index + 1}
              </td>
              <td style={{ border: "1px solid black", padding: 8 }}>
                {r.username}
              </td>
              <td style={{ border: "1px solid black", padding: 8 }}>
                {r.score}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Ranking;