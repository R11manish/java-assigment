import java.sql.*;

public class UpdateProcedure {
  public static void main(String[] args) {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc_test", "helloworld");
      CallableStatement smtm = conn.prepareCall("{Call updateMarks(? , ?)}");
      smtm.setInt(1, 12);
      smtm.setInt(2, 40);
      smtm.execute();
      System.out.println("Updated Successfully");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
