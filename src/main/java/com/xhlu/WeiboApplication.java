package com.xhlu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeiboApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeiboApplication.class, args);
		System.out.println("weibo数据抓取.....");
		System.out.println("weibo数据抓取结束.....");
	}
}
