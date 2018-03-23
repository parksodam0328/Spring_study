import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Bye 생성
        Bye bye = new Bye();
        String message = bye.getMessage("sodam park");
        System.out.println(message);

        Connection con = null;
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","password");

        Statement st = null;
        ResultSet rs = null;

        st=con.createStatement();
        rs=st.executeQuery("show databases");

        rs=st.getResultSet();

        while(rs.next()){
            String str = rs.getString(1);
            System.out.println(str);
        }
    }


}
