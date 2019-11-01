#!/usr/bin/env groovy

// Configure using microservice-pipelines and using "master" branch
@Library("jenkins-pipeline-refactor@jenkins-pipeline-template") _

// Entry point into microservice-pipelines
jenkinsJob.call()

//def code = "email notification"

pipeline {
	
    agent { label 'master' }
	
	environment {
		def mailRecipients = "Shawn.Williams@primerica.com,DevOps@corp.primerica.com,Pinuno.Fuentes@Primerica.com,Pam.Johnson@Primerica.com"
	}
  		 
    stages {
        stage('Load Build') {
            steps {
                load './scripts/build.groovy'
            }
        }
        stage('Create jar file ')
            steps {
                shell(readFileFromWorkspace('./scripts/deliver.sh'))
            }
        }
        stage('Load Test') {
            steps {
                load './scripts/test.groovy'
            }
            post {
                always {
                    junit 'target/surefire-reports/TEST*.xml'
                    archiveArtifacts 'target/*jar'
                }
            }
        }
        stage('Veracode Scan ')
            steps {
                shell(readFileFromWorkspace('./scripts/veracode.sh'))
            }
        }
    }
	post ('Load Email Library') {
	    success {
	load './scripts/emailnotificationsuccess.groovy'
	    }
	   failure {
	load './scripts/emailnotificationfailed.groovy'
	    }
	}	
    
}