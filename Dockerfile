# Use an official Java runtime as a base image
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the project files to the working directory in the container
COPY . /app

# Compile the Java source files
RUN mkdir bin && javac -d bin src/com/klescevg/hangman/*.java

# Define the default command to run your application
CMD ["java", "-cp", "bin", "com.klescevg.hangman.Hangman"]
