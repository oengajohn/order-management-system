pipeline {
    agent any
    tools{
        maven 'Maven-3.8.7'
    }
    stages {
        stage('Build') {
            steps {
               sh 'mvn -B -DskipTests clean package'
               archiveArtifacts artifacts: '**/target/*.war', fingerprint: true

            }
        }
        stage('Test') {
            steps {
                echo("Running Integration tests")
                sh 'mvn clean verify -Parq-wildfly-managed'
                echo("Running Unit tests")
                sh 'mvn clean test -Punit-test'
            }
            post {
                always {
                    junit 'target/**.xml'
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