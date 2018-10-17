package cn.azo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Message;

/**
 * 和message表相关的数据库操作
 * @author 22120
 *
 */
 public class MessageDao {

	 /**
	  * 根据查询条件查询消息列表
	  */
	 public List<Message> queryMessageList(String command,String description){
		 List<Message> messageList =new ArrayList<>();
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/weixn", "lili",
					"123456");
			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION, CONTENT from MESSAGE where 1=1");
			List<String> paramList = new ArrayList<>();
		
			if (command != null && !"".equals(command.trim())) {
			    sql.append(" and COMMAND=?");
			    paramList.add(command);
			}
			if (description != null && !"".equals(description.trim())) {
			    sql.append(" and DESCRIPTION like '%' ? '%' ");
			    paramList.add(description);
			}

			PreparedStatement statement = conn.prepareStatement(sql.toString());
			for (int i = 0; i < paramList.size(); i++) {

				statement.setString(i+1, paramList.get(i));
			}

			ResultSet rSet = statement.executeQuery();
			

			while (rSet.next()) {
				Message message = new Message();
				messageList.add(message);
				message.setId(rSet.getString("ID"));
				message.setCommand(rSet.getString("COMMAND"));
				message.setDescription(rSet.getString("DESCRIPTION"));
				message.setContent(rSet.getString("CONTENT"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			return messageList;
	}
}
