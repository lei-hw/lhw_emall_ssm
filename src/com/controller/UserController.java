package com.controller;

import com.entity.Users;
import com.service.USerService;
import com.util.SafeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 用户相关接口
 */
@Controller
@RequestMapping("/index")
public class UserController {
    @Resource
    private USerService userService;
//    @Resource
//    private GoodService goodService;
//    @Resource
//    private OrderService orderService;
//    @Resource
//    private CarService carService;

    /**
     * 用户注册
     */
    @GetMapping("/register")
    public String reg() {return "/index/register.jsp";}

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public String register(Users user, HttpServletRequest request){
        if (user.getUsername().isEmpty()){
            request.setAttribute("msg","用户名不能为空！");
        }else if (Objects.nonNull(userService.getByUsername(user.getUsername()))){
            request.setAttribute("msg","用户名已存在！");
        }else {
            userService.add(user);
            request.setAttribute("msg","注册成功！");
            return "/index/login.jsp";
        }
        return "/index/register.jsp";
    }

    /**
     * 用户登入
     */
    @GetMapping("/login")
    public String log(){return "/index/login.jsp";}

    /**
     * 用户登入
     */
    @PostMapping("/login")
    public String login(Users users, HttpServletRequest request, HttpSession session){
        Users loginUser = userService.getByUsernameAndPassword(users.getUsername(),users.getPassword());
            if (Objects.isNull(loginUser)){
                request.setAttribute("msg","用户名或密码错误");
                return "/index/login.jsp";
            }
            session.setAttribute("user",loginUser);
            //还原购物车
            session.setAttribute("cartCount", 0);//carService.getCount(loginUser.getId()));
            String referer = request.getHeader("referer");//来源页面
            System.out.println(referer);
            //return "redirect:index";
            return "/index/index.jsp";
        }

    /**
     * 收货地址
      */


    /**
     * 修改密码
     */
    @GetMapping("/password")
    public String password(){return "/index/password.jsp";}

    /**
     * 修改密码
      */
    @PostMapping("/passwordUpdate")
    public String passwprdUpdate(String password, String passwordNew,HttpServletRequest request,HttpSession session){
        Users user = (Users) session.getAttribute("user");
        user = userService.get(user.getId());
        if (!user.getPassword().equals(SafeUtil.encode(password))){
            request.setAttribute("msg","原密码错误");
        }else {
            userService.updatePassword(user.getId(),passwordNew);
            request.setAttribute("msg","密码修改成功");
        }
        return "/index/password.jsp";
    }
}
