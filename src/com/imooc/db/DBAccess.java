package com.imooc.db;

import java.io.IOError;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;




/**
 *访问数据库类
 *
 */
public class DBAccess {
	public SqlSession  getSqlSession() throws IOException{
		//通过核心配置文件获取数据库连接信息
		Reader  reader =Resources.getResourceAsReader("config/mybatis/Configuration.xml");
		//通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory  sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession=sqlSessionFactory.openSession();
	
		return sqlSession;
		
	}

}
