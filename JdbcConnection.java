import java.sql.*;

public class JdbcConnection {
  public static void main(String[] args) {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc_test", "helloworld");
      String sql = "insert into stutdent values(14 , 'anshika' , 12)";
      Statement stmt = con.createStatement();
      int rowsInserted = stmt.executeUpdate(sql);

      if (rowsInserted > 0) {
        System.out.println("Data inserted successfully!");
      }

      stmt.close();
      con.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
