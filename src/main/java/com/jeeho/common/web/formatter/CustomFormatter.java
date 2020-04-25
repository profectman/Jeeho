package com.jeeho.common.web.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author jeeho
 * formatter  数据格式化 前端输入日期数字符串数据格式化
 * formattingconversionServiceFactoryBean
 *
 */
public class CustomFormatter implements Formatter<Date> {

    private String datePattern;
    private SimpleDateFormat dateFormat;

    public CustomFormatter(String datePattern) {
        this.datePattern = datePattern;
        dateFormat = new SimpleDateFormat(datePattern);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return dateFormat.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return dateFormat.format(object);
    }

    /**
     *     同时spring mvc任支持使用注解的方式实现数据的格式化操作
     *     @NumberFormat(style = NumberFormat.Style.CURRENCY)
     *     @NumberFormat(style = NumberFormat.Style.PERCENT)
     *     @NumberFormat(style = NumberFormat.Style.CURRENCY,pattern = "#.###")
     *     @DateTimeFormat(pattern = "yyyy-MM-dd")
     */
}
