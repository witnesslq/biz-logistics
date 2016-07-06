package cc.aisc.logistics.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sjf on 16-5-27.
 */
@Component
public class SimpleCORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Methods", "POST, TRACE, HEAD, GET, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Max-Age", "3600");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
