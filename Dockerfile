#Use an official Openjdk runtime as a parent image
FROM  openjdk:17

#Set the working directory to /app
WORKDIR /app

#Copy the current directory contents into the container at /app
COPY target/spring-boot-mysql-k8s.jar  /app

#Make port 8080 available to the world outsite this container
EXPOSE 8080

# Run spring-boot-mysql-k8s.jar when container launches
CMD ["java","-jar","spring-boot-mysql-k8s.jar"]