package cn.tarpas.pocket.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.info("执行拦截器。。。。。");
		//获取请求的url
		String url = request.getRequestURI();
		LOGGER.info("url"+"============="+url);
		//判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		if(url.indexOf("login.action")!=-1){
			//如果进行登陆提交，放行
			LOGGER.info("放行");
			return true;
		}
				
		//判断session
		HttpSession session  = request.getSession();
		//从session中取出用户身份信息
		String username = (String) session.getAttribute("username");
				
		if(username != null){
			//身份存在，放行
			LOGGER.info("会话对象不为空");
			return true;
		}
		
				
		//执行这里表示用户身份需要认证，跳转登陆页面
		request.getRequestDispatcher("login.html").forward(request, response);
		LOGGER.info("需要登陆");
				
		//return false表示拦截，不向下执行
		//return true表示放行
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		LOGGER.info("postHandle---------------");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LOGGER.info("afterCompletion------------");
		
	}

}
