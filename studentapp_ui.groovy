pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                git branch: 'main', changelog: false, poll: false, url: 'https://github.com/baluwadave/studentapp.ui'
                echo 'git pull done of developer branch'
            }
        }
        stage ('Build'){
            steps{
                sh '/opt/apache-maven-3.9.6/bin/mvn clean package'
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






