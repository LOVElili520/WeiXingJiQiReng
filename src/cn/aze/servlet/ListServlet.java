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
 * 列表页面初始化控制
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置中文编码
		req.setCharacterEncoding("UTF-8");
		// 接收页面的值
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		// 向页面传值
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		
		//实例化Service
		ListService listService = new ListService();
		//查询消息列表，并传值给页面
		req.setAttribute("messageList", listService.queryMessageList(command, description));
		//跳转页面
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
