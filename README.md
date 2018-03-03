# files-upload-server
files upload server for clients via Spring Boot

[![Build Status](https://travis-ci.org/ettingshausen/files-upload-server.svg?branch=master)](https://travis-ci.org/ettingshausen/files-upload-server)
[![Java](https://img.shields.io/badge/Java-1.8-blue.svg?style=flat)](https://travis-ci.org/ettingshausen/files-upload-server)
[![SpringBoot](https://img.shields.io/badge/SpringBoot-2.0-blue.svg?style=flat)](https://travis-ci.org/ettingshausen/files-upload-server)



## Package
```
mvn clean package
```

## Run

```bash
java -jar file-upload-server-0.0.1-SNAPSHOT.jar
```

The default server port is 1234, uploaded files will storage in `D:\test`. 
You can override like this: 
```
java -jar file-upload-server-0.0.1-SNAPSHOT.jar --server.port=8080 --upload.path=D:\\upload\\
```

## Test


![postman](http://wx3.sinaimg.cn/large/685ea4faly1fozmqb7lbwj20mx0ckt9h.jpg)


## License

The repo is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).