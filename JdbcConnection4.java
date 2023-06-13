import java.sql.*;
import java.util.Scanner;

public class JdbcConnection4 {
  public static void main(String[] args) {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Scanner sc = new Scanner(System.in);
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc_test", "helloworld");
      String sqlQuery = "insert into stutdent values(? , ? , ?)";
      PreparedStatement smtm = conn.prepareStatement(sqlQuery);
      System.out.println("How many Records you want to insert");
      int noOfRecords = sc.nextInt();
      for (int i = 0; i < noOfRecords; i++) {
        System.out.println("Record " + (i + 1));

        System.out.println("Roll no of the stutdent");
        int rollno = sc.nextInt();

        System.out.println("Age of the stutdent");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Name of the stutdent :");
        String name = sc.nextLine();

        smtm.setInt(1, rollno);
        smtm.setString(2, name);
        smtm.setInt(3, age);

        int rowsInserted = smtm.executeUpdate();
        if (rowsInserted > 0) {
          System.out.println("Record inserted successfully!");
        }
      }
      sc.close();
      smtm.close();
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
