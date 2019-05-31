package com.winning.fileuploadserver.controller;

import com.winning.fileuploadserver.domain.ResultBody;
import io.swagger.annotations.Api;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ettingshausen
 */
@Api(value = "File Upload", tags = "File")
@RestController
public class FileUploadControl {

    @Resource
    private Environment env;

    /**
     * Batch upload
     * swagger-ui does't support MultipartFile[]
     * @param files Multi files
     * @return file names
     */
    @ApiIgnore
    @PostMapping(value = "/upload")
    public Object batchUpload(@RequestParam("files") MultipartFile[] files) {

        ResultBody resultBody = new ResultBody();
        resultBody.setCode("0");

        String uploadedFileName = Arrays.stream(files).map(MultipartFile::getOriginalFilename)
                .filter(x -> !StringUtils.isEmpty(x))
                .collect(Collectors.joining("|"));
        if (StringUtils.isEmpty(uploadedFileName)) {
            resultBody.setMessage("上传文件为空！");
        }
        try {
            saveUploadedFiles(Arrays.asList(files));
            resultBody.setMessage("调用成功！");
            Map<String, Object> map = new HashMap<>();
            map.put("filename", uploadedFileName);
            resultBody.setResult(map);

        } catch (IOException e) {
            e.printStackTrace();
            resultBody.setCode("500");
            resultBody.setMessage(e.getMessage());
        }
        return resultBody;
    }

    @PostMapping("/file")
    public ResultBody upload(@RequestParam("file") MultipartFile file) {

        ResultBody resultBody = new ResultBody();
        resultBody.setCode("0");

        try {
            byte[] bytes = file.getBytes();
            if (!Files.exists(Paths.get(getFilePath()))) {
                Files.createDirectories(Paths.get(getFilePath()));
            }
            Path path = Paths.get(getFilePath() + file.getOriginalFilename());
            Files.write(path, bytes);
            resultBody.setMessage("调用成功！");
            resultBody.setResult(file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            resultBody.setCode("500");
            resultBody.setMessage(e.getMessage());
        }

        return resultBody;
    }


    private List<String> saveUploadedFiles(List<MultipartFile> files) throws IOException {
        List<String> paths = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            byte[] bytes = file.getBytes();
            if (!Files.exists(Paths.get(getFilePath()))) {
                Files.createDirectories(Paths.get(getFilePath()));
            }
            Path path = Paths.get(getFilePath() + file.getOriginalFilename());
            Files.write(path, bytes);
        }
        return paths;
    }

    private String getFilePath() {
        return env.getProperty("upload.path");
    }

}
