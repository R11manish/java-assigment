import java.sql.*;

public class JdbcBatchConnection {
  public static void main(String[] args) {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc_test", "helloworld");
      conn.setAutoCommit(false);
      Statement query = conn.createStatement();
      // Perform batch operations
      query.addBatch("insert into stutdent values(8, 'radhika', 13)");
      query.addBatch("insert into stutdent values(1, 'ayush' , 14)");
      query.addBatch("update stutdent set name='aman rawat' where name='radhika'");
      query.addBatch("delete stutdent where name='ayush'");
      int queryCount[] = query.executeBatch();
      conn.commit();
      System.out.println("query counts : " + queryCount.length);
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
}
