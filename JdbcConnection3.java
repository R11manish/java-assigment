import java.security.interfaces.RSAKey;
import java.sql.*;

public class JdbcConnection3 {
  public static void main(String[] args) {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc_test", "helloworld");
      Statement smtm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs = smtm.executeQuery("select * from stutdent");
      int targetRow = 2;
      boolean rowExists = rs.absolute(targetRow);
      System.out.println(rowExists);
      if (rowExists) {
        System.out.println("Student Details:");
        System.out.println("Rollno: " + rs.getInt("rollno"));
        System.out.println("Name: " + rs.getString("name"));
        System.out.println("Age: " + rs.getInt("age"));
      } else {
        System.out.println("No student found with the specified row number.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
