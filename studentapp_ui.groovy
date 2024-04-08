pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                git branch: 'main', url: 'https://github.com/baluwadave/Jenkins'
                echo 'Hello World'
            }
        }
        stage ('Build'){
            steps{
                sh 'mvn clean package'
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






