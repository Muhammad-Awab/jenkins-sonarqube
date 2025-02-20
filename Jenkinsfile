pipeline {
    agent any
   tools {
            maven 'Maven 3.8.4' // Ensure Maven is installed in Jenkins
   }

    environment {
        SONAR_TOKEN = credentials('sonarqube-token')
        SONAR_HOST_URL = 'http://34.229.14.188:9000'
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

        stage("Quality Gate") {
            steps {
                script {
                    timeout(time: 5, unit: 'MINUTES') {
                        def qualityGate = waitForQualityGate()
                        if (qualityGate.status != 'OK') {
                            error "Quality Gate failed: ${qualityGate.status}"
                        }
                    }
                }
            }
        }
    }
}
