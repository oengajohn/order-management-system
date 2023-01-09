pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withMaven(maven: 'Maven-3.8.7',){
                    sh 'mvn -B -DskipTests clean package'
                }

            }
        }
        stage('Test') {
            steps {
                withMaven(maven: 'Maven-3.8.7',){
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                // sh './jenkins/scripts/deliver.sh'
                echo "Delivering "
            }
        }
    }
}