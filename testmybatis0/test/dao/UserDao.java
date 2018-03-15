package dao;

import mode.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    /*基本测试*/
    @Test
    public void add1(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
            int result = sqlSession.insert(this.getClass().getName()+".add1");
            sqlSession.commit();
            System.out.println("马云插入成功");
            System.out.println("本次操作影响行数" +result);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSqlSession();
        }

    }
    @Test
    public void add2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User("lqd", "刘强东", 54);
        try {
            int result = sqlSession.insert(this.getClass().getName()+".add2",user);
            sqlSession.commit();
            System.out.println(user.getName()+"插入成功");
            System.out.println("本次操作影响行数" +result);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSqlSession();
        }

    }

    /*curd测试*/
    @Test
    public void  add(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User("ljc", "李嘉诚", 68);
        try {
            int result = sqlSession.insert(this.getClass().getName() + ".add", user);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }

    }
    @Test
    public void delete(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            int result = sqlSession.delete(this.getClass().getName() + ".delete", 555);
            System.out.println("影响行数"+result);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }
    @Test
    public void update(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User("777", "阿里巴巴", 50);
        try {
            int result = sqlSession.update(this.getClass().getName() + ".update", user);
            System.out.println("影响行数"+result);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }
    @Test
    public void selectAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            List<User> users= sqlSession.selectList(this.getClass().getName() + ".selectAll");
            for (User user : users) {
                System.out.println(user.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }
    @Test
    public void selectOne() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            String id = "777";
            User user= sqlSession.selectOne(this.getClass().getName() + ".selectOne",id);
            System.out.println(user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }

    /*分页查询*/
    @Test
    public void pageListAll(){//无条件分页
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Map<String,Object> map = new HashMap<String, Object>() ;
        map.put("startIndex", 3);
        map.put("pageSize", 4);
        try {
            //方法全名
            String methodName = this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName();
            List<User> users = sqlSession.selectList(methodName,map);
            for (User user:users) {
                System.out.println(user.getName());
            }
        } catch (Exception e) {
            System.out.println("cny_note：查询出错！");
            e.printStackTrace();
        } finally {
        }
    }
    @Test
    public void pageListByCodition(){//带条件查询
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String methodName = this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("startIndex", 3);
        map.put("pageSize", 4);
        map.put("minAge", 18);
        List<User> users = sqlSession.selectList(methodName, map);
        for (User user:users) {
            System.out.println(user.getName());
        }

    }

    /*动态sql*/
    @Test
    public void dynamicInsert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String methodName = this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName();
//        User user = new User("lsh","李少辉",0);//测试1
//        User user = new User("jl","贾玲",18);//测试2
        User user = new User("ldy",null,0);//测试3
        try {
            int insert = sqlSession.insert(methodName, user);
            System.out.println("受影响行数为"+insert);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();

        } finally {
            MyBatisUtil.closeSqlSession();
        }

    }

    @Test
    public void dynamicDelete() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String methodName = this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName();
        String[] ids = {"777", "bkn"};
        try {
            int delete = sqlSession.delete(methodName, ids);
            sqlSession.commit();
            System.out.println("受影响行数"+delete);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }
    @Test
    public void dynamicUpdate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String methodName = this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName();
//        User user = new User("666","马总",49);
        User user = new User("666","马总裁",0);
        try {
            int update = sqlSession.update(methodName, user);
            System.out.println("s受影响行数：" +update);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
    }

    @Test
    public void dynamicSelect(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User userCondition = new User();
//        userCondition.setAge(18);
        userCondition.setName("李四");
        String methodName = this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            List<User> users=sqlSession.selectList(methodName,userCondition);
            for (User user : users) {
                System.out.println(user.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }

    }
}
