FROM openjdk:17
LABEL authors="yangzhipeng7"
# 将工作目录设置为/app
WORKDIR /app

# 将编译好的jar文件复制到/app目录下
# COPY是Dockerfile的一个指令，用于从构建上下文（通常是Dockerfile所在的目录及其子目录）复制文件或目录到Docker镜像中。
# target/my-spring-boot-app-1.0.0.jar指定了源路径，这是相对于Dockerfile位置的路径。在这个例子中，它指的是构建Spring Boot应用后生成的jar文件的路径。这个文件在构建Docker镜像之前必须存在于该路径下。
# app.jar指定了目标路径和文件名，在这里是Docker镜像内的/app目录下，并将复制过来的文件重命名为app.jar。如果目标路径不存在，Docker会自动创建这个目录。
COPY build/libs/springboot-docker-0.0.1-SNAPSHOT.jar app.jar
# 假如文件和jar都在同一个单独的路径下就写成
# COPY CoreApplication.jar /app/app.jar

# 暴露8080端口
EXPOSE 8080

# 运行jar文件
ENTRYPOINT ["java","-jar","app.jar"]
