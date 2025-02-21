pipeline {
    agent any

    tools {
        maven 'Maven 3.8.4'
    }

    environment {
        SONAR_TOKEN = credentials('sonarqube-token')
        SONAR_HOST_URL = 'http://35.174.6.122:9000'
        SNAP_REPO = "maven-snapshots"
        RELEASE_REPO = "maven-releases"
        NEXUS_USER = "admin"
        NEXUS_PASS = credentials('nexuslogin')
        NEXUS_IP = "98.84.159.218"
        NEXUS_PORT = "8081"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/Muhammad-Awab/jenkins-sonarqube.git'
            }
        }

        stage('Build and Unit Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean verify sonar:sonar -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }

        stage('Upload Artifact to Nexus') {
            steps {
                nexusArtifactUploader(
                    nexusVersion: 'nexus3',
                    protocol: 'http',
                    nexusUrl: "${NEXUS_IP}:${NEXUS_PORT}",
                    groupId: 'assesment2',
                    version: "${env.BUILD_ID}-${env.BUILD_TIMESTAMP}",
                    repository: "${RELEASE_REPO}",
                    credentialsId: "nexuslogin",
                    artifacts: [
                        [artifactId: 'artifact',
                         classifier: '',
                         file: 'target/test-springboot-0.0.1-SNAPSHOT.jar',
                         type: 'jar']
                    ]
                )
            }
        }

        stage("Quality Gate") {
            steps {
                script {
                    timeout(time: 10, unit: 'MINUTES') {
                        def qualityGate = waitForQualityGate()
                        if (qualityGate.status != 'OK') {
                            error "Quality Gate failed: ${qualityGate.status}"
                        }
                    }
                }
            }
        }
    }
post {
    always {
        echo 'Sending Slack Notification...'
        slackSend(
            channel: '#testing',
            color: currentBuild.currentResult == 'SUCCESS' ? 'good' : 'danger',
            message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL}",
            tokenCredentialId: 'slack-webhook'  

        )
    }
}
}
