package com.zc.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class MyLocaleResolver implements LocaleResolver {

    //  解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {

        //  获取请求中的语言参数
        String language = httpServletRequest.getParameter("language");

        Locale locale = Locale.getDefault();    //如果没有就使用默认的

        //  如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            //  分隔后数组中存放的分别是  国家，地区  zh，CN
            locale = new Locale(split[0], split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
