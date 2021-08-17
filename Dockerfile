FROM openjdk:8

ADD out/artifacts/SampleSpringBoot_jar/SampleSpringBoot.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]