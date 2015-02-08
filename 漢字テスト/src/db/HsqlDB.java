package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqlDB {

	private Connection connection;

	public HsqlDB() {
		try {
			// データベースに接続
			connection = DriverManager.getConnection(
					"jdbc:hsqldb:mem:test", "sa", "");

			// テーブル作成
			Statement st = connection.createStatement();
			st.executeUpdate("CREATE TABLE TEST_TABLE (VALUE VARCHAR(100))");


		} catch (SQLException e) {

		}
	}

	public void insert(String s) throws SQLException{
		String insertStatement =
	            "insert into TEST_TABLE values ( ? )";
	        PreparedStatement prepStmt =
	        		connection.prepareStatement(insertStatement);

	        prepStmt.setString(1, s);


	        int result = prepStmt.executeUpdate();
	        prepStmt.close();
	}

	public void select()throws SQLException{
		// データ取得
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM TEST_TABLE");

		while (rs.next()) {
			System.out.println(
					" VALUE="
					+ rs.getString("VALUE"));
		}

		st.close();
		connection.close();

	}


}
