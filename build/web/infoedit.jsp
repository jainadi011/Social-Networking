<%@page import="bean.User"%>
<%@page import="bean.RegisterDao"%>

<%
    
    
    
    
    int flag,status;
    status =1;
    
      //out.println(request.getParameter("info").toString());

    flag=Integer.parseInt(request.getParameter("flag").toString()) ;
    
    
    String attribute;
    if(flag!=5){
    if(flag!=4)
    attribute = request.getParameter("info").toString();
    else
        attribute=request.getParameter("npass");
    if(flag==4){
       status= RegisterDao.matchPassword(Long.parseLong(session.getAttribute("UID").toString()),request.getParameter("info"));
        
    }
    if(status==1)
    status = User.changeInfo(attribute, flag, Long.parseLong(session.getAttribute("UID").toString()));
    else{
                        out.println("old password not Correct");

    }
        
    if(status >0){
        out.println("Update Successful");
    }
    else{
                out.println("There was Some problem");

    }
    }
    else{
       status= RegisterDao.deleteUser(Long.parseLong(session.getAttribute("UID").toString()));
       if(status>0){
           out.println("User Deleted");
           
       }
       else{
                      out.println("there was some problem");

       }
    }


%>