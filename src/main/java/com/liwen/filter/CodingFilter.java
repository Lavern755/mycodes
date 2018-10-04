package com.liwen.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
/**
   *   编码过滤器
 * @author Administrator
 */
@WebFilter(urlPatterns= {"*"},initParams = {@WebInitParam(name="encoding",value="utf-8")})
public class CodingFilter implements Filter {
	
	private String defaultEndcoing = "utf-8"; // 默认的编码
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding(defaultEndcoing);
		resp.setCharacterEncoding(defaultEndcoing);
		chain.doFilter(req, resp);// 放行
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String encoding = config.getInitParameter("encoding"); // 判断请求中是否指定编码
		if (encoding != null) {
			defaultEndcoing = encoding; // 有，就用请求中指定的编码
		}
	}
	
}
