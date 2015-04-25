
package controller;

import bean.Group;
import bean.GroupManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CreateGroup", urlPatterns = {"/CreateGroup"})
public class CreateGroup extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
     HttpSession session = request.getSession(false);

    Group g =new Group();
    g.setGname(request.getParameter("name"));
    g.setU_id(Long.parseLong(session.getAttribute("UID").toString()));
    g.setCatagory(request.getParameter("category"));
    int status;
    status = GroupManager.createGroup(g.getU_id(), g);
    if(status>0){
        String site = "usergroups.jsp";
              response.getWriter().println("group Created" );
                       response.setHeader("Refresh", "2;"+site);
    }
    else{
        String site = "usergroups.jsp";
              response.getWriter().println("there was some problem" );
                       response.setHeader("Refresh", "3;"+site);
    }

    }

    

}
