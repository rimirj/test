pipeline {
    agent any

    environment {
        // Define the Artifactory server name. This should match the server name configured in Jenkins.
        ARTIFACTORY_SERVER = 'https://personaltrail.jfrog.io/ui/login/'
    }

    stages {
        stage('Checkout') {
            steps {
                // Check out your code from GitHub
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Your build steps here
            }
        }

        stage('Upload to Artifactory') {
            steps {
                script {
                    def server = Artifactory.server env.ARTIFACTORY_SERVER

                    // Use Jenkins Credentials to securely manage Artifactory credentials.
                    def credentials = credentials('ArtifactoryID')  // Replace with your Jenkins credentials ID

                    // Specify the target repository and path in Artifactory where you want to deploy the file.
                    def targetRepo = 'mv1'
                    def targetPath = 'path/to/target/folder/'

                    // Specify the source file to upload.
                    def sourceFile = 'file1.txt'

                    // Deploy the file to Artifactory
                    server.upload spec: '''{
                        "files": [
                            {
                                "pattern": "${sourceFile}",
                                "target": "${targetRepo}/${targetPath}",
                                "props": "build.name=Your-Build-Name;build.number=${BUILD_NUMBER}",
                                "recursive": "false"
                            }
                        ]
                    }''', credentialsId: credentials.id

                    currentBuild.description = "Uploaded to Artifactory: ${targetRepo}/${targetPath}${sourceFile}"
                }
            }
        }
    }
}
