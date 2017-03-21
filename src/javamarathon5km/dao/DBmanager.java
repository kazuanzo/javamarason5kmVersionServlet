package javamarathon5km.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javamarathon5km.domain.BaseballTeam;

public class DBmanager {
	private String driver = "com.mysql.jdbc.Driver";
	private String sql = "select * from baseball_teams where id =";
	private String url = "jdbc:mysql://localhost/data1";;
	private String user = "hoge";
	private String password = "adeba255@";
	private Connection connection;
	private Statement statement;
	private ResultSet rs;

	ArrayList<BaseballTeam> BaseballTeamlist = new ArrayList<>();
	BaseballTeam BaseballTeam = new BaseballTeam();

	public ArrayList<BaseballTeam> allBaseballTeam() {

		try {
			
			Class.forName(driver);

			// DB接続処理
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			// sql文
			rs = statement.executeQuery(sql + "id;");

			while (rs.next()) {
				BaseballTeam BaseballTeam = new BaseballTeam();
				BaseballTeam.setId(rs.getInt("id"));
				BaseballTeam.setTeamName(rs.getString("team_name"));
				BaseballTeam.setLeagueName(rs.getString("league_name"));
				BaseballTeam.setHeadquarters(rs.getString("headquarters"));
				BaseballTeam.setInauguration(rs.getString("inauguration"));
				BaseballTeam.setHistory(rs.getString("history"));
				BaseballTeamlist.add(BaseballTeam);
			}

		} catch (SQLException e) {
			System.out.println("SQLEROOR");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERORR");
		}

		return BaseballTeamlist;

	}

	public BaseballTeam selectBaseballTeam(String JsBaseballTeam) {
		try {
			Class.forName(driver); // ドライバ登録処理

			// DB接続処理
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			// sql文
			rs = statement.executeQuery(sql + JsBaseballTeam + ";");
			
			while (rs.next()) {
				
				BaseballTeam.setId(rs.getInt("id"));
				BaseballTeam.setTeamName(rs.getString("team_name"));
				BaseballTeam.setLeagueName(rs.getString("league_name"));
				BaseballTeam.setHeadquarters(rs.getString("headquarters"));
				BaseballTeam.setInauguration(rs.getString("inauguration"));
				BaseballTeam.setHistory(rs.getString("history"));
			
			}
		} catch (SQLException e) {
			System.out.println("SQLEROOR");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERORR");
		}

		return BaseballTeam;
		
	}
	
	public ArrayList<BaseballTeam> getBaseballTeamlist() {
		return BaseballTeamlist;
	}

	public BaseballTeam getBaseballTeam() {
		return BaseballTeam;
	}

}
