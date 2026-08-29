pipeline {
    agent any

    stages {


        stage('Build') {
            steps {
                sh 'mvn clean package -Drevision=${VERSION}'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test -Drevision=${VERSION}'
            }
        }

        stage('Show Artifact') {
            steps {
                sh 'ls -lh target/'
            }
        }
	stage('Verify Source') {
    steps {
        sh '''
            echo "===== App.java ====="
            cat src/main/java/com/example/App.java

            echo "===== JAR timestamp ====="
            ls -lh target/jenkins-demo-${VERSION}.jar
        '''
    }
}
	stage('Docker Build'){
	    steps {
		sh 'docker build -t jenkins-demo:${VERSION} .'
	    }
	}
	stage('Docker deploy') {
    steps {
        sh '''
            docker stop jenkinsapp || true
            docker rm jenkinsapp || true

            docker run -d --name jenkinsapp -p 8081:8081 jenkins-demo:${DOCKER_VERSION}

            sleep 3

            docker ps -a
            docker logs jenkinsapp

            curl -f http://localhost:8081
        '''
    }
}
    }
}
