#!/usr/bin/env groovy

@Library(['jenkins-sl'])_

pipeline {
  agent {
        dockerfile {
            filename 'Dockerfile'
            dir '.'
            args '-v /root/.m2:/root/.m2'
        }
  }
   
  triggers {
      pollSCM("* * * * *")
  }
  stages {
      stage("Build"){
          steps{
            sh "./scripts/logger.sh 'Build Started'"
            logger 'Build Started'

            commitinfo ''

            logger '${GIT-MESSAGE}'
            logger '${GIT-COMMIT}'
            logger '${GIT-AUTHOR}'
           
            script {
                def helpers = new helpers();
                sh "echo ${helpers.getCurrentTime()}"
            }
            sh "./scripts/build.sh"
            sh "./scripts/logger.sh 'Build Finished'"
          }
      }
      stage("Test"){
          steps{
            sh "./scripts/logger.sh 'Test Started'"
            sh "./scripts/test.sh"
            sh "./scripts/logger.sh 'Test Finished'"
          }
         post {
            always {
                junit 'target/surefire-reports/*.xml'
            }
        }
      }
  }
}