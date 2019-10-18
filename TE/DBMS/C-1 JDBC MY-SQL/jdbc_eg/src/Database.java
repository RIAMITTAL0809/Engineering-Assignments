import java.sql.*;
import java.util.*;

public class Database {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");

			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into user values('mittalria0809@gmail.com','abc')");
			// stmt.executeUpdate("delete from user where id='mittalria0809@gmail.com'");
			ResultSet rs = stmt.executeQuery("select * from user");

			while (rs.next())
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
