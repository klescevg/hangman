pipeline {
    agent {
        docker {
            image 'openjdk:17' // Use the same base image as in Dockerfile
        }
    }

    environment {
        APP_VERSION = "1.0.$BUILD_ID"
    }

    stages {
        stage('Check') {
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
                sh 'java -D app.version=${APP_VERSION} -cp bin com.klescevg.hangman.Hangman'
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
