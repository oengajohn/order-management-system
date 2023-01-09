pipeline {
    agent any
    tools{
        maven 'Maven-3.8.7'
    }
    stages {
        stage('Build') {
            steps {
               sh 'mvn -B -DskipTests clean package'

            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean verify -Parq-wildfly-managed'
            }
            post {
                always {
                    // junit 'target/surefire-reports/*.xml'
                    echo("Show junit reports results")
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