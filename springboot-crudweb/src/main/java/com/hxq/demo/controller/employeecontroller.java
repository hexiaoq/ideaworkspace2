package com.hxq.demo.controller;

import com.hxq.demo.dao.DepartmentDao;
import com.hxq.demo.dao.EmployeeDao;
import com.hxq.demo.entities.Department;
import com.hxq.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class employeecontroller {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String lists(Model model)
    {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);

        return "emp/list";
    }
    //前往添加的页面
    @GetMapping("/addemp")
    public String toaddemp(Model model)
    {
        Collection<Department> all=departmentDao.getDepartments();
        model.addAttribute("deps",all);
        return "emp/add";
    }
    //完成添加到数据库并回显的操作
    //多个方法跳转名一样,为restful风格
    @PostMapping("/addemp")
   public String addemp(Employee employee)
   {
       employeeDao.save(employee);
       return "redirect:/emps";

   }
   @GetMapping("/addemp/{id}")
    public String toupdate(@PathVariable("id") Integer id,Model model)
   {
       Employee employee=employeeDao.get(id);
       model.addAttribute("emp",employee);
       return "emp/update";


   }
   @PostMapping("/update")
    public  String update(Employee employee)
   {
       employeeDao.save(employee);
       return "redirect:/emps";
   }
   @GetMapping("delete")
    public String delete(Integer id)
   {employeeDao.delete(id);
   return "redirect:/emps";

   }

}
