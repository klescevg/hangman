pipeline {
    agent {
        docker {
            image 'openjdk:11' // Use the same base image as in Dockerfile
        }
    }
    stages {
        stage('Checkout') {
            steps {
                sh '''
                    ls -la
                    java --version
                '''
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

    }
    post {
        always {
            // Clean up any leftover files if needed
            cleanWs()
        }
    }
}
