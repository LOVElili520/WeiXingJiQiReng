package com.imooc.db;

import java.io.IOError;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;




/**
 *�������ݿ���
 *
 */
public class DBAccess {
	public SqlSession  getSqlSession() throws IOException{
		//ͨ�����������ļ���ȡ���ݿ�������Ϣ
		Reader  reader =Resources.getResourceAsReader("config/mybatis/Configuration.xml");
		//ͨ��������Ϣ����һ��SqlSessionFactory
		SqlSessionFactory  sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession=sqlSessionFactory.openSession();
	
		return sqlSession;
		
	}

}
