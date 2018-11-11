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

            script {
                def info = new commitinfo().call("");
                sh "echo ${info.author}"got
                sh "echo ${info.commit}"
                sh "echo ${info.shortCommit}"
                sh "echo ${info.message}"
                sh "echo ${info.email}"
            }
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