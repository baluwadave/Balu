pipeline {
    agent any
    options {
        // Timeout counter starts AFTER agent is allocated
        timeout(time: 1, unit: 'SECONDS')
    }
    stages {
        stage('Pull') {
            steps {
                git branch: 'main', credentialsId: 'balu-github-jenkins', url: 'https://github.com/baluwadave/Jenkins.git'
                echo 'Hello World'
            }
        }
        stage ('Build'){
            steps{
                echo "build done"
            }
        }
        stage ('Test'){
            steps{
                echo "test done"
            }
        } 
        stage ('Quality-Test'){
            steps{
                echo "Quality-check done"
            }
        }
        stage ('Depoly'){
            steps{
                echo "depoly done"
            }
        }                                                            
    }
}






