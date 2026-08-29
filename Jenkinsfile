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
	stage('Docker Build'){
	    steps {
		sh 'docker build -t jenkins-demo:1.0 .'
	    }
	}
	stage('Docker deploy'){
	    steps{
              sh '''	
		docker run -d --name jenkinsapp -p 8081:8081 jenkins-demo:1.0
		
		sleep 3
		
		docker ps
		curl -f http://localhost:8081

	      '''
	    }
	}
    }
}
