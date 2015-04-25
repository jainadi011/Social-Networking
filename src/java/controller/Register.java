
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {


    
   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int status;
        status =0;
        bean.User u =new bean.User();
        u.setName(request.getParameter("name"));
        u.setLname(request.getParameter("lname"));
        u.setEmail(request.getParameter("email"));
        u.setAddress(request.getParameter("address"));
        u.setPassword(request.getParameter("password"));
        u.setBirthDate(request.getParameter("birthdate"));
        u.setCategory(request.getParameter("category"));
        u.setDepartment(request.getParameter("department"));
        u.setQue(request.getParameter("que"));
        u.setAns(request.getParameter("ans"));
       
       status= bean.RegisterDao.register(u);
        
       if(status>0){
            response.getWriter().println("U are Successfully registered" );

            String site = "index.html";
            response.setHeader("Refresh", "1;" + site);
        }
        else if(status==-1){
         response.getWriter().println("email already registered" );
         String site = "register.html";
         response.setHeader("Refresh", "4;"+site);
   
       } 
        else{
                        String site = "index.html";
              response.getWriter().println("there was some problem" );
                       response.setHeader("Refresh", "4;"+site);

        }



        
       

        
        
    }

   
  
}
