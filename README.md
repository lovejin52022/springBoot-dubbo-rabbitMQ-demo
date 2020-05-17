# Spring Boot DEMO
准备写一个关于kotlin + gradle 的 demo，包含以下功能点：
* dubbo + zookeeper
* rabbitMQ
* swagger
* logback
* mybatis
* migration
 
> docker-compose.yaml 文件来搭建 rabbitMQ + zookeeper 单机环境

### 环境运行方式
1. 在docker-compose.yaml 目录下运行环境 docker-compose up -d
2. 其中 127.0.0.1:8090 为 Dubbo OPS
3. 其中 127.0.0.1:15672 查看 rabbitMQ 默认用户root密码root
4. 新建rabbitMQ用户，用户名springboot,密码123456，权限设置。

