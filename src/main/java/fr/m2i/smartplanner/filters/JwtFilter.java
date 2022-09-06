package fr.m2i.smartplanner.filters;


import fr.m2i.smartplanner.cruds.CalendarPrivilegeCrud;
import fr.m2i.smartplanner.cruds.UserCrud;
import fr.m2i.smartplanner.models.CalendarPrivilege;
import fr.m2i.smartplanner.models.User;
import fr.m2i.smartplanner.utils.JwtUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.*;

@WebFilter({"/api/calendarPrivileges/*","/api/contacts/*","/api/events/*","/api/privileges/*","/api/roles/*","/api/users/*"})
public class JwtFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {


//        List<String>headers = new ArrayList<>();
////        Enumeration<String> enumeration  =((HttpServletRequest)request).getHeaderNames();
////        while (enumeration.hasMoreElements()){
////            headers.add(enumeration.nextElement());
////        }
////        System.out.println(headers);

        try{

            String authorization = ((HttpServletRequest)request).getHeader("authorization");
            String token = authorization.substring("Bearer ".length());

            JwtUtil jwtUtil = new JwtUtil();

            String username = jwtUtil.getUsernameFromToken(token);

            UserCrud userCrud = new UserCrud();

            User user = userCrud.getUserByName(username);

        }
        catch(Exception e){
            return;
        }


        chain.doFilter(request, response);
    }
}
