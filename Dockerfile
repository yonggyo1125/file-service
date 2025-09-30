FROM openjdk:21-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
RUN mkdir uploads


ENV DB_URL=localhost:5432
ENV FILE_URL=/uploads
ENV FILE_PATH=/uploads

ENTRYPOINT ["java", "-jar", "-Ddb.url=${DB_URL}", "-Ddb.username=${DB_USERNAME}", "-Ddb.password=${DB_PASSWORD}", "-Dfile.url=${FILE_URL}","-Dfile.path=${FILE_PATH}", "app.jar"]

EXPOSE 3000