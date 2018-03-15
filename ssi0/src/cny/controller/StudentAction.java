package cny.controller;

import cny.model.Student;
import cny.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/student")
public class StudentAction {

    @Resource
    private StudentService studentService;
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/add")
    public String addStudent(Model model, Student student) {
        try {
            studentService.addStudent(student);
            model.addAttribute("result", "测试访问成功！");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("result", "测试访问失败！");
        } finally {
        }
        return "success";
    }
}
