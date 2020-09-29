package cn.smbms.filter;

import cn.smbms.pojo.User;
import cn.smbms.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //从session中获取用户
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        if(user == null){ //已经被移除或者注销了，或者未登陆
            response.sendRedirect("/smbms/error.jsp");
        }else {
            chain.doFilter(req,resp);
        }


    }

    @Override
    public void destroy() {

    }
}
