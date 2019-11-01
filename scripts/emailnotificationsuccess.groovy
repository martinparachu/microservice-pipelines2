#!/usr/bin/env groovy

def mailRecipients = "Shawn.Williams@primerica.com,DevOps@corp.primerica.com,Pinuno.Fuentes@Primerica.com,Pam.Johnson@Primerica.com"

def emailnotify() {

        echo "Sending Success Build Status email............"
	    emailext attachLog: true, attachmentsPattern: 'generatedFile.txt',
	    mimeType: 'text/html',
	    subject: "SUCCESS: Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
	    to: "mario.velasco@globant.com",
	    replyTo: "${mailRecipients}",
	    body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
	    recipientProviders: [developers(), requestor()]
}
emailnotify()