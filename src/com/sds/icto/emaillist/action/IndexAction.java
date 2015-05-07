package com.sds.icto.emaillist.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.emaillist.Action;
import com.sds.icto.emaillist2.dao.EmailListDao;
import com.sds.icto.emaillist2.servlet.WebUtil;
import com.sds.icto.emaillist2.vo.EmailListVo;

public class IndexAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		EmailListDao dao = new EmailListDao();
		List<EmailListVo> list = dao.fetchList();
		request.setAttribute("list", list);
		WebUtil.forward("/view/show_emaillist.jsp", request, response);
	}
}
