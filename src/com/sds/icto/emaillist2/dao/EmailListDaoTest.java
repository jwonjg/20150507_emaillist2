package com.sds.icto.emaillist2.dao;

import java.sql.SQLException;
import java.util.List;

import com.sds.icto.emaillist2.vo.EmailListVo;

public class EmailListDaoTest {
	public static void main(String[] args) {
		try{
			testInsert();
			testFetchList();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void testInsert() throws ClassNotFoundException, SQLException {
		EmailListVo vo = new EmailListVo();
		vo.setFirstName("진원");
		vo.setLastName("정");
		vo.setEmail("jwonjg@naver.com");
		
		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
	}
	
	private static void testFetchList() throws ClassNotFoundException, SQLException {
		EmailListDao dao = new EmailListDao();
		List<EmailListVo> list = dao.fetchList();
		
		for (EmailListVo vo : list) {
			System.out.print(vo.getNo()+" : ");
			System.out.print(vo.getFirstName()+" : ");
			System.out.print(vo.getLastName()+" : ");
			System.out.print(vo.getEmail());
			System.out.println();
		}
	}
}
