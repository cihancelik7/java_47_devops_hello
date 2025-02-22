# DevOps

DevOps Git Maven Docker DockerHub Kubernetes




docker build --platform linux/amd64 --build-arg JAR_FILE=target/devops-application.jar -t cihan0203/devops-application:v001 .
docker build --platform linux/amd64 -t cihan0203/devops-application .
docker push cihan0203/devops-application:v001 .
