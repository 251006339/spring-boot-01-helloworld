package com.hxm.springboot01helloworld.controller;


import com.hxm.springboot01helloworld.dao.DepartmentDao;
import com.hxm.springboot01helloworld.dao.EmployeeDao;
import com.hxm.springboot01helloworld.entities.Department;
import com.hxm.springboot01helloworld.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentdao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        //thymeleaf 默认就回拼串
        //chasspath:templates/xxx.html
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);

        return "emp/list";
    }

    @GetMapping("/emp")/*get方式*/
    public String addEmp(Model model) {


        //thymeleaf 默认就回拼串
        //chasspath:templates/xxx.html
        //查出emp下的部门,

        Collection<Department> departments = departmentdao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    /*保存增加的数据  post方式*/
    @PostMapping("/emp")
    //springmvc自动将请求参数和入参对象的属性进行--绑定;要求请求参数的名字和javabean入参的对象里面的属性名是一样的;
    public String submit(Employee employee) {
        // 日期的格式化:springmvc-dateformat 可以修改配置文件,修改字符串转时间的格式: Formatter    spring.mvc",
        //            可以 修改转换方式
        System.out.println(employee);
        employeeDao.save(employee);
        //保存员工
        //redirect:重定向到一个地址;forward 转发到一个地址; 转发还是post请求forward:/emps
        //redirect:重定向则是 get请求;
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")/*resuful风格的请求 /emp/id  请求修改到前端 */
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);//1001;
        Collection<Department> departments = departmentdao.getDepartments();
        model.addAttribute("depts", departments);
        model.addAttribute("emp", employee);//cahxdao

        return "emp/add";
    }

    @PutMapping("/emp")/*前段传过来修改*/
    public String edit(Employee employee) {
        System.out.println(employee);//获得到对象employee
        employeeDao.save(employee);


        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String toDelete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);

        return "redirect:/emps";
    }

}
