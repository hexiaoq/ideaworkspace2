package com.hxq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequestMapping("/user")
@Controller
public class controller {
    @RequestMapping("/test")
    public String test()
    {
        System.out.println("执行方法成功");
        return "success";
    }
    @RequestMapping("/fileupload")
    public String upload(MultipartFile upload)
    {
        File file=new File("F:\\idea workspace\\springmvc_day02\\uploads");
        if(!file.exists())
        {
            file.mkdirs();
        }
       String name= upload.getOriginalFilename();
        try {
            upload.transferTo(new File("F:\\idea workspace\\springmvc_day02\\uploads",name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";

    }

}
