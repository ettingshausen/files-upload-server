# files-upload-server
files upload server for clients via Spring Boot

# Package
```
mvn clean package
```

# Run

```bash
java -jar file-upload-server-0.0.1-SNAPSHOT.jar
```

The default server port is 1234, uploaded files will storage in `D:\test`. 
You can override like this: 
```
java -jar file-upload-server-0.0.1-SNAPSHOT.jar --server.port=8080 --upload.path=D:\\upload\\
```

# Test


![postman](http://wx3.sinaimg.cn/large/685ea4faly1fozmqb7lbwj20mx0ckt9h.jpg)