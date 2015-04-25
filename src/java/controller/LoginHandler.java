
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginHandler", urlPatterns = {"/LoginHandler"})
public class LoginHandler extends HttpServlet {

    
    
   Connection conn = bean.ConnectionProvider.getCon();
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String email    = request.getParameter("email");
            String password = request.getParameter("password");
            String check;
            
            
            HashMap users = new HashMap();
            bean.RegisterDao.getDataForLoginValidation(users,conn);
            
            
            
            if(password.equals(users.get(email))){
                bean.User u = new bean.User();
                u.setEmail(email);
                try {
                    u.getUserData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                HttpSession session = request.getSession(true);

                 String name = u.getName();
                 session.setAttribute("Uname", name);

                 session.setAttribute("UID", u.getU_id());

                 if (u.getCategory().equals("A") || u.getCategory().equals("B")) {
                        session.setAttribute("Catagory", "Student");
                 }
                 else {
                        session.setAttribute("Catagory", "Faculty");
                  }
                    check ="you are succssefully logged in";
                    
                    request.getRequestDispatcher("user.jsp").forward(request, response);

            }
            else{
                check ="Sorry there was a problem";
                request.getRequestDispatcher("index.html").forward(request, response);

            }
            

            
            
    }

}
