package com.xhlu;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import com.xhlu.util.WeiboCrawler;
import org.junit.Test;

/**
 * <pre>
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/17 11:31
 */
public class JsoupTest {


    @Test
    public void fistTest() throws Exception {
        WeiboCrawler crawler = new WeiboCrawler("weibo_crawler", false);
        crawler.setThreads(3);
        /*对某人微博前5页进行爬取*/
        for (int i = 1; i <= 5; i++) {
            crawler.addSeed(new CrawlDatum("http://weibo.cn/zhouhongyi?vt=4&page=" + i)
                    .putMetaData("pageNum", i + ""));
        }
        crawler.start(1);
    }

}
