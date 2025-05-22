# Use official OpenJDK image to compile and run Java app
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy your Java source file into the container
COPY GuessingGame.java .

# Compile the Java source file
RUN javac GuessingGame.java

# Set the command to run the Java program
CMD ["java", "GuessingGame"]

