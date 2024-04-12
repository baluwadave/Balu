pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/baluwadave/studentapp.ui'
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
                sh '''/opt/apache-maven-3.9.6/bin/mvn sonar:sonar \\
                -Dsonar.projectKey=studentapp-ui \\
                -Dsonar.host.url=http://13.127.46.220:9000 \\
                -Dsonar.login=3beda3d515009d7f90566b92bd884563ad2657cf'''           
                echo "test done"
                waitForQualityGate abortPipeline: false, credentialsId: 'sonar-token'
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







