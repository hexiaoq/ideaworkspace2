package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

// 控制器类
@Controller
@RequestMapping("/con")
@SessionAttributes(value = "hxq")
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }
    //封装数据到bean中
    @RequestMapping(value = "/saveaccount")
    public String  saveacccount(Account account)
    {
        System.out.println("执行了保存账户的方法,账户信息如下");
        System.out.println(account);
        return "success";

    }
//    自定义类型转换器
    @RequestMapping("saveuser")
    public String saveuser(user user)
    {
        System.out.println("执行了保存账户的方法,账户信息如下");
        System.out.println(user);
        return "success";

    }
    @RequestMapping("testsession")
    public String testsession(Model model)
    {
        System.out.println("执行了session方法");
        model.addAttribute("hxq","何小强");
        return "success";
    }




}
