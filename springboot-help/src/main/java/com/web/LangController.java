package com.web;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 配置多语言环境
 */
@Controller
@RequestMapping("/lang")
public class LangController {
    @Resource
    private MessageSource messageSource;

    @GetMapping({"/", "/index"})
    public String lang() {
        return "lang";
    }

    @GetMapping("/test")
    public Map<String, String> test(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
//        LocaleContextHolder.getLocale()
        Locale locale = RequestContextUtils.getLocale(request);
//        log.info("locale ： " + locale.getLanguage());
        String msg1 = messageSource.getMessage("login.failure.msg", null, locale);
        String[] params = {"Jack Zhang", "今天是星期一"};
        String msg2 = messageSource.getMessage("login.failure.msg", params, locale);
        map.put("msg1", msg1);
        map.put("msg2", msg2);
        return map;
    }

    @GetMapping("/changeSessionLanauage")
    public String changeSessionLanauage(HttpServletRequest request, String lang) {
//        log.info(lang);
        if ("zh".equals(lang)) {
            //代码中即可通过以下方法进行语言设置
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
        } else if ("en".equals(lang)) {
            //代码中即可通过以下方法进行语言设置
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
        }
        return "redirect:/lang/index";
    }
}
