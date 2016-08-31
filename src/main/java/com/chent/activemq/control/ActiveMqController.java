package com.chent.activemq.control;

import com.chent.activemq.mq.producer.queue.QueueSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangqingbin on 2016/8/31.
 */
@Controller
@RequestMapping("/")
public class ActiveMqController {

    @Resource
    QueueSender queueSender;
    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String test(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception{
        modelMap.addAttribute("hello","welcome activemq QwQ");
        return "hello";
//        response.getWriter().print("welcome activemq QwQ");
    }

    @RequestMapping(method = RequestMethod.GET,value = "/send")
    public void send(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            for(int i=0;i<200;i++){
                queueSender.send("spring.queue","第"+(i+1)+"条消息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
