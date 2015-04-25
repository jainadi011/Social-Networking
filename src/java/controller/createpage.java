
package controller;

import bean.Page;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "createpage", urlPatterns = {"/createpage"})
public class createpage extends HttpServlet {


    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

       

         Page p =new Page();
         p.setPname(request.getParameter("name").toLowerCase());
         p.setDescription(request.getParameter("userpost"));
         p.setU_id(Long.parseLong(session.getAttribute("UID").toString()));
         p.setCatagory(request.getParameter("category"));
         int status;
   

         status = Page.createPage(p.getU_id(), p);
        if(status>0){
              String site = "userpages.jsp";
              response.getWriter().println("page Created" );
                       response.setHeader("Refresh", "2;"+site);
        }
        else{
                String site = "userpages.jsp";
              response.getWriter().println("there was some problem" );
                       response.setHeader("Refresh", "3;"+site);
        }
        
    }

}
