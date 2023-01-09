pipeline{
    agent any
    stages{
        stage("build"){
            steps{
                echo("building the application")
                mvn clean compile

            }
        }
        stage("test"){
            steps{
                echo("testing the application")
                 mvn clean test
            }
        }
        stage("deploy"){
            steps{
                echo("deploying the application")
               mvn clean package
            }
        }
    }
}