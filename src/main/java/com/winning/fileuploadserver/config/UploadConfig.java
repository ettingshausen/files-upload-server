package com.winning.fileuploadserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author ettingshausen
 * @date 2019/5/31 17:15
 */
@Configuration
@ConfigurationProperties(prefix = "upload", ignoreUnknownFields = false)
public class UploadConfig {

    private String path;

    private List<String> paths;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}
