//This class handles all the methods  for posting on page,group and  other users
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Post {

    private int sid;
    private int did;
    private int pid;
    private String contents;
    private String fileid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

//This method manages posts made by user
    public static int Userpost(long source, long destination, String content) {

        int status = -1;

        try {
            Connection con = ConnectionProvider.getCon();

            User u = new User();
            PreparedStatement ps1 = con.prepareStatement("select count(*) as post_count from post");

            ResultSet rs = ps1.executeQuery();
            rs.next();
            long pid;
            pid = (rs.getLong("post_count") + 12000);

            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            String s;
            s = ft.format(new Date());

            //created the user object just to  set the post date using set birthdate function of user class
            u.setBirthDate(s);

            java.util.Date d = u.getBirthDate();

            java.sql.Date s1 = new java.sql.Date(d.getTime());

            PreparedStatement ps = con.prepareStatement("insert into post values(?,?,?,?,?,?)");

            ps.setLong(1, source);
            ps.setLong(2, destination);

            ps.setLong(3, pid);
            ps.setString(4, content);
            ps.setLong(5, 10001);
            ps.setDate(6, s1);
            status = ps.executeUpdate();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return status;

    }
//This method is used to display all the users post in arraylist

    public static void userPostDetails(long id, ArrayList a, ArrayList sourcenames) throws SQLException {
        Connection con = ConnectionProvider.getCon();
        PreparedStatement ps = con.prepareStatement("select fname,CONTENT from post inner join users on users.U_ID=post.S_ID where D_ID = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            a.add(rs.getString("CONTENT"));

            sourcenames.add(rs.getString("fname"));

        }

    }

}
