# TypingGame
## ログイン画面
<img width="425" height="275" alt="スクリーンショット 2025-08-17 9 29 43" src="https://github.com/user-attachments/assets/7acb7872-c442-4a2e-9dcd-26e78b4e716a" />

---

## タイピング画面
<img width="425" height="466" alt="スクリーンショット 2025-08-17 9 32 12" src="https://github.com/user-attachments/assets/5378fff6-1ac1-4753-bc5b-7cd905cfdd66" />

---

## ランキング機能
<img width="477" height="501" alt="スクリーンショット 2025-08-25 21 50 40" src="https://github.com/user-attachments/assets/6263ed29-ea0f-4621-a090-d6b7dbd79d05" />

---

## 終了画面
<img width="425" height="466" alt="スクリーンショット 2025-08-17 9 32 29" src="https://github.com/user-attachments/assets/930bc233-19d8-4c6f-8f67-40066791950d" />

---


## プロジェクト概要
- タイピング速度と正確さを競うシンプルなWebアプリ
- バックエンド：Spring Boot + MySQL + JWT認証
- フロントエンド：React

---

## 使用技術
- Java 21 / Spring Boot
- React 19
- MySQL 9
- JWT認証（Spring Security）
- Docker / Docker Compose

---

## セットアップ方法
- Docker を利用する場合

 - リポジトリのルートで以下を実行<br>
 docker compose up -d db<br>
 docker compose up -d backend<br>
 docker compose up -d frontend<br>
 - DB起動後にAppを起動する<br>
  1.db コンテナ : MySQL を起動<br>
  2.backend コンテナ : Spring Boot アプリケーションを起動<br>
  3.frontend コンテナ : react アプリケーションを起動<br>

 - 停止・削除する場合<br>
  docker compose down -v<br>

---

### 必要環境
- Java 21
- Node.js 20
- MySQL 9
- Docker / Docker Compose
