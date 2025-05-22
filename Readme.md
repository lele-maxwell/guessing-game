# 🎮 Guessing Game - Java Edition

A fun console-based number guessing game in Java supporting **Single Player** and **Local Multiplayer** modes with different difficulties (Easy / Normal / Hard)!

---

## 🏗️ Project Structure

```plaintext
.
├── src/
│   └── GuessingGame.java
├── Dockerfile
├── docker-compose.yml (optional)
├── .dockerignore
└── README.md
```

---

## 🚀 How to Run the Game

### 1. Run Locally (Without Docker)

First, ensure you have **Java JDK 17+** installed.

```bash
# Step 1: Compile the code
mkdir -p bin
javac -d bin -Werror src/GuessingGame.java

# Step 2: Run the program
java -cp bin GuessingGame
```

---

### 2. Run Using Docker

#### a) Build and Run (Without Compose)

```bash
# Step 1: Build the Docker image
docker build -t guessing-game .

# Step 2: Run the container interactively
docker run -it guessing-game
```

---

#### b) Run Using Docker Compose

```bash
# Step 1: Build and run the service
docker-compose up --build
```

> ℹ️ You can modify `docker-compose.yml` to customize container names, restart policies, etc.

---

## 📜 Gameplay Overview

1. Choose your **Difficulty**:
   - Easy (Range 1-10)
   - Normal (Range 1-100)
   - Hard (Range 1-200)
2. Choose **Game Mode**:
   - Single Player 🎯
   - Local Multiplayer 🤝
3. You have **5 ❤️ lives** and a starting **Score of 1000 points**.
4. Every wrong guess reduces life and score.
5. Win by guessing correctly before lives/time run out!

Enjoy! 🎉

---

## 🐳 Dockerfile (Multi-Stage Build)

```Dockerfile
# Stage 1: Build the Java application
FROM openjdk:17-slim AS build

WORKDIR /app

# Copy source code
COPY src/ ./src

# Compile
RUN mkdir -p bin \
    && javac -d bin -Werror src/*.java

# Stage 2: Runtime
FROM openjdk:17-slim

WORKDIR /app

# Copy compiled classes from build stage
COPY --from=build /app/bin ./bin

# Default command
CMD ["java", "-cp", "bin", "GuessingGame"]
```

---

## 🐳 docker-compose.yml (Optional)

```yaml
version: '3.8'

services:
  guessing-game:
    build: .
    container_name: guessing-game
    stdin_open: true  # For interactive input
    tty: true         # Allocate pseudo-TTY
```

---

## 📄 .dockerignore (Recommended)

```bash
bin/
*.class
*.jar
*.log
*.tmp
```

---

## 📬 License

This project is free and open-source under the **MIT License**.

---

Happy Guessing! 🎯🎮

