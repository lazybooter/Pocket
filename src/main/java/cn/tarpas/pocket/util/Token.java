package cn.tarpas.pocket.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import sun.misc.BASE64Encoder;

public class Token {
	private static final Jedis redis = ConnectRedis.getConnectRedis();
	private static final Logger LOGGER = LoggerFactory.getLogger(Token.class);
	
	private static String getRandom(){
		String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < 16; i++) {
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();
	}
	
	public static String createToken(String phone, String password){
		StringBuffer str = new StringBuffer();
		
		//信息拼接
		str.append(phone);
		str.append(getRandom());
		str.append(password);
		str.append(System.currentTimeMillis());
		
		String token = str.toString();
		
		//确定计算方法
        MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			token = base64en.encode(md5.digest(token.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			LOGGER.error("MD5算法失效");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			LOGGER.error("转码失败");
		}
        
        redis.set(phone,token);
        
        return token;
		
	}
	
	public static boolean verifyToken(String phone,String token){
		boolean verifyRe = false;
		String pretoken = redis.get(phone);
		if(token.equals(pretoken)){
			verifyRe = true;
		}
		return verifyRe;
	}
	
	public static void main(String[] args) throws Exception {
		Token test = new Token();
		System.out.println(test.createToken("15809207428", "123456"));
	}
}
