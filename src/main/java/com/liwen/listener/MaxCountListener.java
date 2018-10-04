package com.liwen.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 会话监听器：
 * 	会话创建和销毁的时候修改onLineCount和maxOnlineCount的值
 * @author lw
 */
@WebListener
public class MaxCountListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext sc = se.getSession().getServletContext();
		int onLineCount = Integer.parseInt((String)sc.getAttribute("onLineCount"));
		onLineCount++;
		sc.setAttribute("onLineCount", onLineCount); // 有新的会话，在线人数就加1
		
		int maxOnlineCount = Integer.parseInt((String) sc.getAttribute("maxOnlineCount"));
		if (onLineCount > maxOnlineCount) {
			sc.setAttribute("maxOnlineCount", onLineCount);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sc.setAttribute("date", sdf.format(new Date()));
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext sc = se.getSession().getServletContext();
		int onLineCount = Integer.parseInt((String) sc.getAttribute("onLineCount"));
		--onLineCount;
		sc.setAttribute("onLineCount", onLineCount);
	}
	
}
