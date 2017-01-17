package com.xhlu;

import com.xhlu.util.HttpUtil4;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WeiboApplication {
	public static Logger logger = LoggerFactory.getLogger(WeiboApplication.class);
	public static void main(String[] args) throws IOException {
		SpringApplication.run(WeiboApplication.class, args);
		logger.info("weibo数据抓取.....");
		test();

		logger.info("weibo数据抓取结束.....");
	}


	/**
	 * http://www.open-open.com/jsoup/
	 * @return
	 */

	public static String test() throws IOException {

		Document document = Jsoup.connect("http://weibo" +
				".com/u/1992433012?refer_flag=1001030102_&is_hot=1#1484618394990").get();
		System.out.println(document.toString());
		return "";

	}



}
