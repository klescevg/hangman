pipeline {
    agent {
        docker {
            image 'openjdk:11' // Use the same base image as in Dockerfile
            //args '-v /var/run/docker.sock:/var/run/docker.sock' // Optional, for Docker access
        }
    }
    stages {
        /*
        stage('Checkout') {
            steps {
                // Clone the repository
                git 'https://github.com/klescevg/hangman.git'
            }
        }

        stage('Build') {
            steps {
                // Compile the project
                sh 'javac -d bin src/com/klescevg/hangman/*.java'
            }
        }
        stage('Run') {
            steps {
                // Run the Hangman game
                sh 'java -cp bin com.klescevg.hangman.Hangman'
            }
        }
        */
    }
    post {
        always {
            // Clean up any leftover files if needed
            cleanWs()
        }
    }
}
