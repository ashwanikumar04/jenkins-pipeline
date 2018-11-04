#!/usr/bin/env groovy

@Library(['jenkins-sl'])_

pipeline {
  agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
  }
  triggers {

      pollSCM("* * * * *")

  }
  stages {
      stage("Build"){
          steps{
            new Helpers().getCurrentTime()
            sh "./scripts/logger.sh 'Build Started'"
            //sh "echo ${getCurrentTime()}"
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