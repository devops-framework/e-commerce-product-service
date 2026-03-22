# Stage 1: Build với Maven
FROM maven:3.8.4-openjdk-11-slim AS builder
WORKDIR /app

# Vì Dockerfile nằm sâu, chúng ta phải đi ngược ra ngoài 4 cấp thư mục 
# (stg1 -> dockerfile -> ci -> devops -> root)
COPY ../../../../pom.xml .
RUN mvn dependency:go-offline -B

COPY ../../../../src ./src
RUN mvn package -DskipTests

# Stage 2: Runtime với Tomcat (như doanh nghiệp bạn hay dùng)
FROM tomcat:10.1-jdk11-openjdk-slim
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war vừa build xong vào Tomcat
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]