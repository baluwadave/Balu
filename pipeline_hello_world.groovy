pipeline   {
    agent any 
        stages{
            stage ('Pull'){
                steps{
                     echo "pull done"
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