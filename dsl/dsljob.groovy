def createDeploymentJob(jobName, repoUrl, repobranch) {
    pipelineJob(jobName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                            credentials(repoCredentials)
                        }
                        branches(repobranch)
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}

def createTestJob(jobName, repoUrl) {
    multibranchPipelineJob(jobName) {
        branchSources {
            git {
                id('123456789')
                remote(repoUrl)
                includes('master dev')
            }
        }
        triggers {
            cron("H/5 * * * *")
        }
    }
}

def buildPipelineJobs() {
    def repo = "https://git01.pfsfhq.com/pri/"
    def repoUrl = repo + jobName + ".git"
    def repoCredentials = "jenkins_scm/******"
    def deployName = jobName + "_deploy"
    def testName = jobName + "_Branches"

    //createDeploymentJob(deployName, repoUrl, repobranch)
    createTestJob(testName, repoUrl)
}

buildPipelineJobs()