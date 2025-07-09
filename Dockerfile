# Giai đoạn build
FROM ubuntu:latest AS build

# Cập nhật và cài đặt OpenJDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Chạy lệnh Maven để build ứng dụng
RUN mvn clean package -DskipTests

# Giai đoạn chạy ứng dụng
FROM openjdk:17-jdk-slim

# Mở cổng 8080
EXPOSE 8080

# Sao chép file JAR từ giai đoạn build
COPY --from=build /target/*.jar jimmysea.jar

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "jimmysea.jar"]