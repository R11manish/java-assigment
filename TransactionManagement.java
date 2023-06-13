import java.sql.*;

public class TransactionManagement {
  public static void main(String[] args) {
    Connection conn = null;
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc_test", "helloworld");
      conn.setAutoCommit(false);
      Statement smtm = conn.createStatement();
      int result = smtm.executeUpdate("insert into stutdent values(5 , 'radhika' , 8)");
      System.out.println(result + " records affected");
      result = smtm.executeUpdate("insert into stutdent values(5 , 'aman' , 10)");
      System.out.println(result + " records affected");
      conn.commit();
      smtm.close();
      conn.close();
    } catch (Exception e) {
      try {
        if (conn != null) {
          conn.rollback();
          System.out.println("Transaction Failed");
        }
      } catch (SQLException rollbackException) {
        rollbackException.printStackTrace();
      }
      e.printStackTrace();
    }
  }
}
