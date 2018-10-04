package com.liwen.filter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 **下载计数过滤器
 * @author lw
 */
public class DownloadCounterFilter implements Filter {
	
	private ExecutorService executorService = Executors.newSingleThreadExecutor(); // 单线程
	private Properties downloadLog;
	private File logFile;
	
	@Override
	public void destroy() {
		executorService.shutdown();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		final String uri = req.getRequestURI(); // 获取请求的url
		executorService.execute(new Runnable() {
			
			private String value;

			@Override
			public void run() {
				value = downloadLog.getProperty(uri);
				if (value == null) {
					downloadLog.setProperty(uri, "1");
				}else {
					int count = Integer.parseInt(value); // 整型和字符串之间的类型转换
					downloadLog.setProperty(uri, String.valueOf(++count));
				}
				
				try {
					downloadLog.store(new FileWriter(logFile), "");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		chain.doFilter(request, response); // 放行
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String appPath = config.getServletContext().getRealPath("/");
		logFile = new File(appPath, "download.txt");
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		downloadLog = new Properties();
		try {
			downloadLog.load(new FileReader(logFile));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
