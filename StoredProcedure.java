import java.sql.*;

public class StoredProcedure {
  public static void main(String[] args) {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc_test", "helloworld");
      CallableStatement smtm = conn.prepareCall("{ ? = call getName(?) }");
      smtm.setInt(2, 12);
      smtm.registerOutParameter(1, Types.VARCHAR);
      smtm.execute();
      System.out.println("output :" + smtm.getString(1));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
