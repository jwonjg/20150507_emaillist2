package com.sds.icto.emaillist2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.emaillist2.vo.EmailListVo;

public class EmailListDao {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "webdb", "webdb");
		return connection;
	}
	
	public void insert(EmailListVo vo) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "insert into email_list values(email_list_no_seq.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getFirstName());
		ps.setString(2, vo.getLastName());
		ps.setString(3, vo.getEmail());
		
		int result = ps.executeUpdate();
		if(result>0) System.out.println("저장 성공");
		
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public List<EmailListVo> fetchList() throws SQLException, ClassNotFoundException{
		ArrayList<EmailListVo> list = new ArrayList<EmailListVo>();
		
		Connection conn = getConnection();
		Statement st = conn.createStatement();
		String sql = "select * from email_list";
		
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			long no = rs.getLong(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);
			
			EmailListVo vo = new EmailListVo();
			vo.setEmail(email);
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			list.add(vo);
		}
		
		if(rs != null) rs.close();
		if(st != null) st.close();
		if(conn != null) conn.close();
		
		return list;
	}
}
