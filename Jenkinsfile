pipeline {
    agent any

    tools {
        maven 'Maven 3.8.4' // Ensure Maven is installed in Jenkins
    }

    environment {
        SONARQUBE_URL = 'http://34.229.14.188:9000'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/Muhammad-Awab/jenkins-sonarqube' // Change to your repository
            }
        }

        stage('Build and Unit Test') {
            steps {
                sh 'mvn clean test' // Running unit tests
                echo 'Unit Tests Completed'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean verify sonar:sonar'
                    echo 'SonarQube Analysis Completed'
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
