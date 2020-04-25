package com.jeeho.common.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jeeho
 * converter 数据转换 前端输入日期格式转换
 * conversionServiceFactoryBean ---> converters 中定义日期数据
 */
public class CustomConverter implements Converter<String,Date> {

    private String datePattern;

    public CustomConverter(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
        try {
            System.out.println(dateFormat.parse(source));
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
