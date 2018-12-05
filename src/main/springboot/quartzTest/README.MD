### 运行jar包带命令方式

> java -Dspring.application.json='{"name":"test"}' -jar myapp.jar
> java -jar myapp.jar --spring.application.json='{"name":"test"}
> java -jar app.jar --name="Spring"

#### 指定配置文件名称

> $ java -jar myproject.jar --spring.config.name=myproject
> $ java -jar myproject.jar --spring.config.location=classpath:/default.properties,classpath:/override.properties

