FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# 依存関係のキャッシュ用
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle
RUN ./gradlew dependencies --no-daemon || return 0

# ソースコードをコピーしてビルド
COPY . .
RUN ./gradlew bootJar --no-daemon

# 実行用ステージ
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/typinggame-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Spring Boot を起動
ENTRYPOINT ["java", "-jar", "app.jar"]
