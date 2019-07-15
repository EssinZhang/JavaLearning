package cn.zyx.controller;

import cn.zyx.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@PropertySource({"classpath:application.properties"})
public class FileController {


    @Value("${web.fileUpload.path}")
    private static final String filePath = "";

    @RequestMapping(value = "images")
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {
        String name = request.getParameter("file_name");
        System.out.println("用户名："+name);

        //获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为："+fileName);

        //获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的文件名后缀："+suffixName);

        //文件上传后的路径·
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath+fileName);
        System.out.println("文件上传后的路径："+dest);

        try {
            file.transferTo(dest);
            return new JsonData(0,fileName);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return new JsonData(-1,"fail");
    }


}