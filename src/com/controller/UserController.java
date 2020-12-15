package com.controller;

import com.config.ExceptionConfig;
import com.entity.Orders;
import com.entity.Users;
import com.service.CartService;
import com.service.GoodService;
import com.service.OrderService;
import com.service.USerService;
import com.util.PageUtil;
import com.util.SafeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
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
    @Resource
    private GoodService goodService;
    @Resource
    private OrderService orderService;
    @Resource
    private CartService cartService;

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

    /**
     * 加入购物车
     * @param goodId
     * @param session
     * @return
     */
    @PostMapping("/cartBuy")
    public @ResponseBody boolean carBuy(int goodId,HttpSession session){
        Users user = (Users) session.getAttribute("user");
        return cartService.save(goodId,user.getId());
    }

    /**
     * 查看购物车
     * @param request
     * @param session
     * @return
     */
    @GetMapping("/cart")
    public String cart(HttpServletRequest request,HttpSession session){
        Users user = (Users) session.getAttribute("user");
        request.setAttribute("cartList", cartService.getList(user.getId()));
        request.setAttribute("cartCount", cartService.getCount(user.getId()));
        request.setAttribute("cartTotal", cartService.getTotal(user.getId()));
        return "/index/cart.jsp";
    }

    /**
     * 直接购买
     * @param goodId
     * @param session
     * @return
     * @throws ExceptionConfig.MyException
     */
    @PostMapping("/orderAdd")
    public String orderAdd(int goodId,HttpSession session) throws ExceptionConfig.MyException{
        Users user = (Users) session.getAttribute("user");
        int orderId = orderService.add(goodId,user.getId());
        return "redirect:orderPay?id="+orderId;//跳转支付
    }

    /**
     * 购物车结算
     * @param request
     * @param session
     * @return
     * @throws ExceptionConfig.MyException
     */
    @GetMapping("/orderSave")
    public String orderSave(ServletRequest request, HttpSession session) throws
            ExceptionConfig.MyException {
        Users user = (Users) session.getAttribute("user");
        int orderId = orderService.save(user.getId());
        session.removeAttribute("cartCount");//清除购物车session
        return "redirect:orderPay?id=" + orderId;//跳转支付
    }

    /**
     * 查看订单
     * @param request
     * @param session
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/order")
    public String order(HttpServletRequest request, HttpSession session,
                        @RequestParam(required = false, defaultValue = "1") int page,
                        @RequestParam(required = false, defaultValue = "6")int size){
        Users user = (Users) session.getAttribute("user");
        request.setAttribute("orderList", orderService.getListByUserid(user.getId(),page,size));
        request.setAttribute("pageHtml", PageUtil.getPageHtml(request,orderService.getCountByUserid(user.getId()),page,size));
        return "/index/order.jsp";
    }

    /**
     * 支付页面
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/orderPay")
    public String orderPay(int id, ServletRequest request){
        request.setAttribute("order", orderService.get(id));
        return "/index/pay.jsp";
    }

    /**
     * 支付（模拟）
     * @param order
     * @return
     */
    @PostMapping("/orderPay")
    public String orderPay(Orders order){
        orderService.pay(order);
        return "/index/payok.jsp";
    }

}
