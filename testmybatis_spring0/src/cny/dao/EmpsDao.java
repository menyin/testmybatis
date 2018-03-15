package cny.dao;

import cny.model.Emps;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmpsDao {
    private SqlSessionFactory sqlSessionFactory;
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void add(Emps emps) throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert(this.getClass().getName() + ".add", emps);
        sqlSession.commit();
    }

}
