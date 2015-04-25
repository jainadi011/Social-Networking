
package controller;

import bean.Post;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserPost", urlPatterns = {"/UserPost"})
public class UserPost extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
             HttpSession session = request.getSession(false);

        
        int status ;
   String content;
   long sourceid,destid;
          sourceid = Long.parseLong(session.getAttribute("postsource").toString());
          destid = Long.parseLong(session.getAttribute("postdestination").toString());
          content=request.getParameter("userpost");
          System.out.println(sourceid+"\n "+destid+ "\n " +content);
          if(content.length()<=300)
          status=Post.Userpost(sourceid, destid, content);
          else{
              status =-1;
              response.getWriter().println("Word limit  exceeded Please  REDUCE the post content size");
                       
          }
          if(status !=-1){
               
               
              response.getWriter().println("Posted");
                          

          }
          else{
              response.getWriter().println("Somthing went wrong");
                     
          }


        
        
        
    }

   
}
