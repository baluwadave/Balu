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
                sh '''mvn sonar:sonar \\
                -Dsonar.projectKey=studentapp-ui \\
                -Dsonar.host.url=http://13.127.230.27:9000 \\
                -Dsonar.login=0eb275c507d99873e3263734c5e2f7a3bb805db3'''             
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






