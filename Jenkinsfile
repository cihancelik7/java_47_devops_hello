pipeline {
    agent any

    tools {
        maven 'Maven3'
        // java 'Java21'
    }
    environment {
        IMAGE_NAME = 'cihan0203/devops-application'
        IMAGE_USERNAME = 'cihan0203'
        GIT_URL = 'https://github.com/cihancelik7/java_47_devops_hello'
    }

    stages {
        stage('Test Mvn') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: GIT_URL]])
                sh 'mvn clean install'
            }
        }

        stage('Docker Image') {
            steps {
                sh 'docker build --platform linux/arm64 -t cihan0203/devops-application .'
            }
        }

        stage('Docker Image to Docker Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhub')]) {
                        sh 'docker login -u cihan0203 -p ${dockerhub}'
                        sh 'docker push cihan0203/devops-application:latest'
                    }
                }
            }
        }

        stage('Deploy 2 K8s') {
            steps {
                script {
                    kubernetesDeploy configs: 'deploymentservice.yaml', kubeConfig: [path: ''], kubeconfigId: 'kubernetes', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
                }
            }
        }
    }
}