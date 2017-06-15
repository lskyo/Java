package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Goddess;
import DBUtil.DBUtil;

import com.mysql.jdbc.Statement;

public class GoddessDao {

	public void addGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "" + "insert into jdbc_goddess"
				+ "(user_name,sex,age,birthday,email,mobile,"
				+ "create_user,create_date,update_user,update_date,isdel)"
				+ "values("
				+ "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";// '?'是占位符
		// 传入sql语句，但不执行
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 传入参数
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		// 执行sql语句
		ptmt.execute();
	}

	public void updateGoddess(Goddess g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " update jdbc_goddess "
				+ " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, "
				+ " update_user=?,update_date=current_date(),isdel=? "
				+ " where id=? ";// '?'是占位符
		// 传入sql语句，但不执行
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 传入参数
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9, g.getId());
		// 执行sql语句
		ptmt.execute();
	}

	public void delGoddess(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " delete from jdbc_goddess " + " where id=? ";// '?'是占位符
		// 传入sql语句，但不执行
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 传入参数
		ptmt.setInt(1, id);
		// 执行sql语句
		ptmt.execute();

	}

	public List<Goddess> query() throws SQLException {
		Connection conn = DBUtil.getConnection();
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("select id,user_name,age from jdbc_goddess");

		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;

		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			gs.add(g);
		}
		return gs;
	}

	public List<Goddess> query(String name) throws SQLException {
		List<Goddess> result = new ArrayList<Goddess>();
		Goddess g = null;
		StringBuilder sb = new StringBuilder();

		Connection conn = DBUtil.getConnection();
		sb.append(" select * from jdbc_goddess ");
		sb.append(" where user_name=? ");

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, name);
		ResultSet rs = ptmt.executeQuery();

		System.out.println(sb.toString());

		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));

			result.add(g);
		}
		return result;
	}

	public List<Goddess> query(String name, String mobile) throws SQLException {
		List<Goddess> result = new ArrayList<Goddess>();
		Goddess g = null;
		StringBuilder sb = new StringBuilder();

		Connection conn = DBUtil.getConnection();
		sb.append(" select * from jdbc_goddess ");
		sb.append(" where user_name like ? and mobile like ? ");

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%" + name + "%");
		ptmt.setString(2, "%" + mobile + "%");

		ResultSet rs = ptmt.executeQuery();

		System.out.println(sb.toString());

		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));

			result.add(g);
		}
		return result;
	}

	public List<Goddess> query(String name, String mobile, String email)
			throws SQLException {
		List<Goddess> result = new ArrayList<Goddess>();
		Goddess g = null;
		StringBuilder sb = new StringBuilder();

		Connection conn = DBUtil.getConnection();
		sb.append(" select * from jdbc_goddess ");
		sb.append(" where user_name like ? and mobile like ? and email like ? ");

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%" + name + "%");
		ptmt.setString(2, "%" + mobile + "%");
		ptmt.setString(3, "%" + email + "%");

		ResultSet rs = ptmt.executeQuery();

		System.out.println(sb.toString());

		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));

			result.add(g);
		}
		return result;
	}

	public List<Goddess> query(List<Map<String, Object>> params) throws SQLException {
		List<Goddess> result = new ArrayList<Goddess>();
		Goddess g = null;
		StringBuilder sb = new StringBuilder();

		Connection conn = DBUtil.getConnection();
		sb.append(" select * from jdbc_goddess where 1=1 ");
		
		if(params != null && params.size() > 0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" and " + map.get("name") +" "+ map.get("rela") +" "+ map.get("value")+ " ");
			}
		}

		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		System.out.println(sb.toString());

		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));

			result.add(g);
		}
		return result;
	}

	public Goddess get(Integer id) throws SQLException {
		Goddess g = null;
		Connection conn = DBUtil.getConnection();
		String sql = "" + " select * from jdbc_goddess " + " where id=? ";// '?'是占位符

		// 传入sql语句，但不执行
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 传入参数
		ptmt.setInt(1, id);
		// 执行sql语句
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));
		}
		return g;
	}
}
