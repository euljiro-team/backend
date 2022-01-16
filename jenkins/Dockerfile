FROM jenkins/jenkins:2.289.1-jdk11

USER root
RUN curl -sSL https://get.docker.com/ | sh
USER jenkins


#RUN usermod -aG docker jenkins
#
#USER jenkins

#docker build -t minssan9/jenkins-dind:latest .
#docker run -it -d --group-add 0 -v "//var/run/docker.sock:/var/run/docker.sock" -p 8222:8080 --name jenkins minssan9/jenkins-dind:latest
