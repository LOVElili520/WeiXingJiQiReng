package service;

import java.util.List;

import bean.Message;
import cn.azo.dao.MessageDao;

/**
 * �б���ص�ҵ����
 *
 */
public class ListService {
	public List<Message> queryMessageList(String command,String description){
		MessageDao messageDao=new MessageDao();
		return messageDao.queryMessageList(command, description);
		
	}
}
