<%@page import="bean.RequestManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.User"%>
<%@page import="bean.RegisterDao"%>




<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
    <head>
        <title><% out.println("Friends"); %></title>
        <link href="css/styles.css" rel="stylesheet">
            <meta name="robots" content="noindex,follow" />
    </head>
    <body>
        <ul class="nav">
            <li>
                <a href="user.jsp">Home</a>
            </li>
            <li>
                <a href="ShowPendingRequest.jsp">Requests</a>
            </li>
            <li id="search">
                <form action="searchresult.jsp" method="post">
                    <input type="text" name="fname" id="search_text" placeholder="Search"/>
                    <input type="button" name="search_button" id="search_button"></a>
                </form>
            </li>
            <li>
                <a href="EditInfo.jsp">Edit</a>
            </li>
            <li>
                <a href="logout.jsp">Logout</a>
            </li>

            <br>
                <br>
                    <br>
                         <br>
                             <br>
                                 
                <%
                    ArrayList<User> u = new ArrayList();
                    int i;
                    RequestManager.getFriends(Long.parseLong(session.getAttribute("UID").toString()),u);
                    session.setAttribute("UID", session.getAttribute("UID"));
                    
                %>
                
                  <% if(u.isEmpty())
                        out.println("You Do not have Friends");
                    else{
                      out.println("<br><h1>Your Friends</h1>");
                        for(i=0;i<u.size();i++){
                             

                            if(u.get(i).getU_id() != Long.parseLong(session.getAttribute("UID").toString()))
                            out.println("<br>"+"<form action=\"Udisplay.jsp\" method=\"post\">"+" <button type=\"submit\" class=\"btn2\" name=uemail value=\""+u.get(i).getEmail()+"\"  >"+u.get(i).getName() +"    "+ u.get(i).getLname()+"</button>"+ "</form>"+"<br><br><br><br>");
                            
                        }
                    } %> 
                <br>
                </body>
                </html>
