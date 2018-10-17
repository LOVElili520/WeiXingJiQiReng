package cn.aze.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Message;
import service.ListService;

/**
 * 
 * �б�ҳ���ʼ������
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// �������ı���
		req.setCharacterEncoding("UTF-8");
		// ����ҳ���ֵ
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		// ��ҳ�洫ֵ
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		
		//ʵ����Service
		ListService listService = new ListService();
		//��ѯ��Ϣ�б�����ֵ��ҳ��
		req.setAttribute("messageList", listService.queryMessageList(command, description));
		//��תҳ��
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
