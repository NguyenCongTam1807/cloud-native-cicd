pipeline {
    agent any
    tools {
        maven 'Maven 3.9.2'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/NguyenCongTam1807/cloud-native-cicd']])
                                bat 'mvn clean install'
            }
        }

        stage('Build') {
            steps {
                script{
                    def workspaceDir = pwd()
                    bat "docker build -t cloud-native ${workspaceDir}"
                    bat "docker tag cloud_native nctam1807/cloud-native"
                }
            }
        }

        stage('Publish') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'password')]) {
                        bat "docker login -u nctam1807 -p $password"
                        bat "docker push nctam1807/cloud-native"
                    }
                }
            }
        }
    }
}