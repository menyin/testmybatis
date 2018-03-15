package cny.controller;

import cny.model.Emps;
import cny.service.EmpsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/emps")
public class EmpsAction {
    @Resource
    private EmpsService empsService;
    public void setEmpsService(EmpsService empsService) {
        this.empsService = empsService;
    }

    @RequestMapping("/register")
    public String register(Emps emps,Model model) {
        try {
            empsService.register(emps);
            model.addAttribute("result", "保存成功了");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("保存操作出错~！！做日志记录");
            return "fail";
        } finally {
        }
        return "success";
    }
}
