package dao;

import mode.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

public class StudentDao {
    @Test
    public void selectOne() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String methodName = this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Student student= sqlSession.selectOne(methodName,"s1");
            System.out.println(student.getId()+":"+student.getName()+":"+student.getAge()+":"+student.getaClass().getId()+":"+student.getaClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }
}
