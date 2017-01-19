package com.xhlu.service;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.plugin.ram.RamCrawler;
import com.xhlu.dao.UserRepository;
import com.xhlu.model.User;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *   获取用户信息
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/17 16:33
 */
@Component("userService")
public class UserService extends RamCrawler {

    private String cookie;
    @Autowired
    private UserRepository userRepository;

    private User user;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        /*抽取微博*/
        Elements text = page.select("div.c");
        for (Element doc : text) {
            logger.info("--->{}",doc.text());
        }
    }

    @Override
    public HttpResponse getResponse(CrawlDatum crawlDatum) throws Exception {
        HttpRequest request = new HttpRequest(crawlDatum);
        request.setCookie(cookie);
        return request.getResponse();
    }

    public void getUserInfo(Long uid,String cookie) throws Exception {
        this.user = new User();
        user.setUid(uid);

        this.cookie = cookie;
        this.setThreads(1);
        /*对某人的个人信息进行爬取*/
        this.addSeed(new CrawlDatum("http://weibo.cn/"+uid+"/info"));
        this.start(1);

        userRepository.save(user);
    }


}
