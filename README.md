# Hangman Game

## Introduction
Welcome to the Hangman game project. This version of the classic word-guessing game is designed to run in command-line interface. Challenge yourself to guess the word before your man gets hanged!

## Features
- Possibility to select a language (English/Russian).
- At the start, the app lets you start a new game or quit.
- When a new game starts, it picks a word randomly, and you begin to guess it.
- After you guess a letter, it shows how many mistakes you've made and the hangman's current state with ASCII art.
- After the game ends, it shows if you won or lost and goes back to letting you start a new game or quit.


## Getting Started
These instructions will allow you to get a copy of the project and run it on your local machine.

### Installing
1. Clone the repository:
```bash
git clone https://github.com/klescevg/hangman.git
```
2. Navigate to the Project Directory:
```bash
cd hangman/
```
4. Compile project:
```bash
javac -d bin src/com/klescevg/hangman/*.java
```
6. Run main class:
```bash
java -cp bin com.klescevg.hangman.Hangman
```


