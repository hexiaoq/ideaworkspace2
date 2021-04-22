package com.hxq.mybatis_plus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;

public class generateCode {
    public static void main(String[] args) {
        AutoGenerator generator=new AutoGenerator();

        GlobalConfig gc=new GlobalConfig();
        String property = System.getProperty("user.dir");
        gc.setOutputDir(property);
        gc.setAuthor("hxq");
        gc.setSwagger2(true);
        generator.setGlobalConfig(gc);

     



    }


}
