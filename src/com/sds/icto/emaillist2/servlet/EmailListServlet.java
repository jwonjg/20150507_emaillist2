package com.sds.icto.emaillist2.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.emaillist.Action;
import com.sds.icto.emaillist.action.FormAction;
import com.sds.icto.emaillist.action.IndexAction;
import com.sds.icto.emaillist.action.InsertAction;

@WebServlet("/emaillist")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			if("form".equals(action)){
				Action a = new FormAction();
				a.execute(request, response);
			}else if("insert".equals(action)){
				Action a = new InsertAction();
				a.execute(request, response);
			}else{
				Action a = new IndexAction();
				a.execute(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
