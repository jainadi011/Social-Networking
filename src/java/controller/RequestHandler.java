
package controller;

import bean.RequestManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;            
import javax.servlet.http.HttpSession;


@WebServlet(name = "RequestHandler", urlPatterns = {"/RequestHandler"})
public class RequestHandler extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        long source,dest,flag;
source =Long.parseLong(request.getParameter("reqsource"));
dest =Long.parseLong(request.getParameter("reqdestination"));
flag =Long.parseLong(request.getParameter("reqflag"));
int status=-1;
             HttpSession session = request.getSession(false);


if(flag==1){
   status= RequestManager.friendsGm(source, dest);
   response.getWriter().println("Request sent");

}
else if(flag==2){
    status=RequestManager.aprooveRequest(source, dest);
       response.getWriter().println("You are now friends");


}
        
    }

   
  

}
