pipeline {
    agent any

    stages {


        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Show Artifact') {
            steps {
                sh 'ls -lh target/'
            }
        }
    }
}
