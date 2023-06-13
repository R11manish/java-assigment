import java.sql.*;

public class JdbcConnection2 {
  public static void main(String[] args) {

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc_test", "helloworld");
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select * from stutdent");

      while (rs.next())
        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

      stmt.close();
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
