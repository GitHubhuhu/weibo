package com.xhlu.service;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.plugin.ram.RamCrawler;
import com.xhlu.util.WeiboCrawler;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *   获取用户信息
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/17 16:33
 */
@Component()
public class UserInformation extends RamCrawler {

    private String cookie;


    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        /*抽取微博*/
        Elements weibos = page.select("div.c");
        for (Element weibo : weibos) {
            System.out.println(weibo.text());
        }
    }

    @Override
    public HttpResponse getResponse(CrawlDatum crawlDatum) throws Exception {
        HttpRequest request = new HttpRequest(crawlDatum);
        request.setCookie(cookie);
        return request.getResponse();
    }

    public void getUserInfo(String uid,String cookie) throws Exception {
        this.cookie = cookie;
        this.setThreads(1);
        /*对某人的个人信息进行爬取*/
        this.addSeed(new CrawlDatum("http://weibo.cn/"+uid+"/info"));
        this.start(1);
    }


}
