pipeline {
    agent any

    tools {
        maven 'Maven3'
        // java 'Java21'
    }

    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/cihancelik7/java_47_devops_hello']])
                sh 'mvn clean install'
            }
        }
        stage('Docker Image') {
            steps {
                sh 'docker build --platform linux/amd64 -t cihan0203/devops-application .'
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

        stage('Kubernetes Pod') {
            steps {

            }
        }

    }
}