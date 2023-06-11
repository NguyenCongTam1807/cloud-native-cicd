pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                def workspaceDir = pwd()
                bat 'mvn clean package'
                bat "docker build -t cloud-native ${workspaceDir}"
                bat "docker tag cloud_native nctam1807/cloud-native"
            }
        }

        stage('Publish') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'password')]) {
                    bat "docker login -u nctam1807 -p $password"
                    bat "docker push nctam1807/cloud-native"
                }
            }
        }
    }
}