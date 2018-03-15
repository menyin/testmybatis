package cny.service.impl;

import cny.dao.StudentDao;
import cny.model.Student;
import cny.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent(Student student) {
        studentDao.add(student);
        int i=1/0;//构造错误，用于测试spring事务管理
    }
}
