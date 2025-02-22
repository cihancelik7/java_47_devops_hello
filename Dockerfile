# Uygulama icin JDK lazim
#FROM openjdk:17
FROM amazoncorretto:21

#Bizim projemizdeki JAR dosyamizin Docker icinde calisacagi konum
ARG JAR_FILE=target/*.jar

#Jar dosyasini bu isimle Docker'in icine kopyala
COPY ${JAR_FILE} devops-application.jar

#terminal komutlari icin CMD kullanilir
CMD apt-get update -y

#projenin Docker uzerinde calisacagi ic port
EXPOSE 8080

#Uygulamanin calismasini saglar
ENTRYPOINT ["java", "-jar","devops-application.jar"]