package com.liwen.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * 统计网站最多在线人数：
 *  上下文监听器
 * @author lw
 */
@WebListener
public class InitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("onLineCount", 0);
		sce.getServletContext().setAttribute("maxOnlineCount", 0);
	}

}
