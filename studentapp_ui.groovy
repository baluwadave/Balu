pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                git branch: 'main', changelog: false, poll: false, url: 'https://github.com/baluwadave/studentapp'
                echo 'git pull done of developer branch'
            }
        }
        stage ('Build'){
            steps{
                sh "mvn clean package"
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






