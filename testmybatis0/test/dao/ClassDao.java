package dao;

import mode.Class;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.List;

public class ClassDao {
    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String methodName = this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName();
        Class classModel = new Class("04","二年一班");
        int insert = 0;
        try {
            insert = sqlSession.insert(methodName, classModel);
            sqlSession.commit();
            System.out.println("影响行数" +insert);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }
    @Test
    public void selectOne() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String methodName = this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Class classModel = sqlSession.selectOne(methodName,"01");
            System.out.println(classModel.getName());
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }
}
