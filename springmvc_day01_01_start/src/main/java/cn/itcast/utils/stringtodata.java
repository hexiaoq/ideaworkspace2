package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class stringtodata implements Converter<String,Date> {




    @Override
    public Date convert(String source) {
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        if(source==null)
            throw new RuntimeException("传入的日期为空");
        else
            try {
                return df.parse(source);
            } catch (ParseException e) {
                throw new RuntimeException("转换错误");
            }

    }
}
