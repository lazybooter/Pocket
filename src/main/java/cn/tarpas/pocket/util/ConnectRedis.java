package cn.tarpas.pocket.util;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.tarpas.pocket.controller.LoginAction;
import redis.clients.jedis.Jedis;

public class ConnectRedis {
	private volatile static ConnectRedis connectRedis;
	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectRedis.class);
	//Redis连接参数
	private Jedis jedis = null;
	private static String host = null;
	
	//单例模式
	private ConnectRedis(){
		Properties prop = new Properties();
		InputStream in = ConnectRedis.class.getResourceAsStream("/Pocket.properties");
		try {
			prop.load(in);
			host = prop.getProperty("redis.host");
			jedis = new Jedis(host);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error("读取配置信息失败，无法连接Redis");
		}
	}
	
	public static Jedis getConnectRedis(){
		if(connectRedis == null){
			synchronized (ConnectRedis.class) {
				if(connectRedis == null){
					connectRedis = new ConnectRedis();
				}
			}
		}
		
		return connectRedis.jedis;
	}
	
	/*public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream in = ConnectRedis.class.getResourceAsStream("/Pocket.properties");
		try {
			prop.load(in);
			host = prop.getProperty("redis.host");
			System.out.println(host);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
