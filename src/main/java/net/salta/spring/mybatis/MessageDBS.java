package net.salta.spring.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.salta.spring.dbo.Message;
 
public class MessageDBS {
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public MessageDBS(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public Message selectMessage() {
    		Message msg = null;
		SqlSession session = sqlSessionFactory.openSession();

    		try{
    			msg = session.selectOne("Message.selectMessage");
    		} finally {
                session.close();
        }
  //  		System.out.println("Hey hey I am eher "+ msg.getMessage());
    		return msg;
    }
    
}
