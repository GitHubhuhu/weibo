package com.xhlu;

import com.xhlu.service.UserService;
import com.xhlu.util.HttpUtil4;
import com.xhlu.util.WeiboCN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ResourceBundle;

@SpringBootApplication
@Controller
public class WeiboApplication {
    public static Logger logger = LoggerFactory.getLogger(WeiboApplication.class);


    private static String cookie;
    @Autowired
    private UserService userService;

    public static void main(String[] args) throws IOException {
        //微博登陆
        ResourceBundle resourceBundle = ResourceBundle.getBundle("user");
        String userName = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        logger.info("登陆用户 {}",userName);
        try {
            cookie = WeiboCN.getSinaCookie(userName, password);
        } catch (Exception e) {
            logger.error("-->微博登陆失败....",e);
            return;
        }
        logger.info("-->微博模拟登陆成功.....");

        //启动web服务
        SpringApplication.run(WeiboApplication.class, args);
        //模拟请求自己
        HttpUtil4.httpGet("http://localhost:8080/");
    }

    @RequestMapping("/")
    @ResponseBody
    public  String home() {

        Long uid = 2030089501l;
        try {
            userService.getUserInfo(uid,cookie);
        } catch (Exception e) {
            logger.error("-->获取用户{}信息失败....",uid,e);
            return "抓取失败";
        }

        logger.info("-->微博数据抓取结束.....");
        return "抓取微博!";

    }


}
