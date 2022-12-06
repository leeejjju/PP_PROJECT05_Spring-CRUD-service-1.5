package com.example;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {

    private static final Logger logger= LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model){
        //logger.info()
        Date date = new Date();
        DateFormat dateFormat =
                DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "index";
    }


    @RequestMapping("classlist")
    public String list(Model model){
        List<String> list = new ArrayList<String>();
        list.add("Yeji Song");
        list.add("Hanmin Park");
        list.add("Jinju Lee");

        model.addAttribute("classlist", list);
        String msg = "동뱅지킴이 List";
        model.addAttribute("title", msg);

        return "board/list";
    }
}

