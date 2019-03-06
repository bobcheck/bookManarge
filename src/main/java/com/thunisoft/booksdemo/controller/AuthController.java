package com.thunisoft.booksdemo.controller;


import com.alibaba.fastjson.JSONObject;
import com.thunisoft.artery.data.QueryManager;
import com.thunisoft.artery.data.annotation.DataTranslate;
import com.thunisoft.artery.data.model.IQueryInfo;
import com.thunisoft.artery.response.ArteryResult;
import com.thunisoft.booksdemo.bean.*;
import com.thunisoft.booksdemo.pojo.Result;
import com.thunisoft.booksdemo.pojo.User;
import com.thunisoft.booksdemo.mapper.SysUserMapper;
import com.thunisoft.booksdemo.service.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * 图书管理系统账号登录注册控制器{新注册的账号默认为普通权限不能对书籍等信息进行修改操作}
 */
@Controller
public class AuthController {

    @Autowired
    private PersonService personService;
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private ReaderInfoService readerInfoService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private BorrowInfoService borrowInfoService;
    @Autowired
    private ReturnInfoService returnInfoService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping(value = "/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/bookinfosel")
    public String bookinfosel() {
        return "bookInfoSel";
    }

    @RequestMapping("/mybook")
    public String mybook() {
        return "myBook";
    }

    @RequestMapping("/readerinfosel")
    public String readerinfosel() {
        return "readerInfoSel";
    }

    @RequestMapping("/returninfo")
    public String myinfo() {
        return "returninfo";
    }

    @GetMapping(value = "/home")
    public String home(Model model){
        User curUser = sysUserService.getCurrentUser();
        model.addAttribute("curUser", curUser);
        return "home";
    }
    @GetMapping(value = "/readerInfoSel")
    public String readerInfoSel(Model model){
        User curUser = sysUserService.getCurrentUser();
        model.addAttribute("curUser", curUser);
        return "menu/readerInfoSel";
    }

    @GetMapping(value = "/borrow")
    public String borrow(Model model){
        User curUser = sysUserService.getCurrentUser();
        model.addAttribute("curUser", curUser);
        return "menu/borrow";
    }
    @GetMapping(value = "/return")
    public String returnbook(Model model){
        User curUser = sysUserService.getCurrentUser();
        model.addAttribute("curUser", curUser);
        return "menu/return";
    }

    @GetMapping(value = "/register")
    public String register(){
        return "register";
    }

    //登录验证  在前端会检验用户
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody User user){
        Result result = new Result(200, "登录成功");
        /*System.out.println(user.getR_Name());
        System.out.println(user.getR_Pwd());*/
        UsernamePasswordToken token = new UsernamePasswordToken(user.getR_Name(), user.getR_Pwd());
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        }
        catch(Exception e){
            result.setMessage("用户名或密码错误");
            result.setCode(201);
        }
        return result;
    }

    //最简单的注册账号功能
    @PostMapping(value = "/register")
    @ResponseBody
    public Result doregister(@RequestBody User user){
        Result result = new Result(201, "此用户名已被占用");
        //首先查看是否有同名用户
        if(sysUserMapper.getUserByName(user.getR_Name()) == null)
        {
            //在这里默认是认为insert等更新语句是执行成功的 但是实际上数据库可能执行失败，可能会因此导致用户显示注册成功但是不能登录的情况
            if(sysUserMapper.insertUser(user) > 0)
            {
                result.setCode(200);
                result.setMessage("注册成功");
            }else {
                result.setCode(500);
                result.setMessage("网络出了点小问题");
            }
            return result;
        }else {
            return result;
        }

    }

    @RequestMapping(value = "/logout")
    public String logout(){
        Result result = new Result(200,"您已注销");
        try {
            SecurityUtils.getSubject().logout();
        }catch(Exception e){
            result.setCode(500);
            result.setMessage(e.getMessage());
        }
        return "redirect:/index";
    }

    //图书信息查询
    @DataTranslate
    @ResponseBody
    @RequestMapping(value = "demo1", produces = "text/html;charset=UTF-8")
    public Object bookinfosel(IQueryInfo qp) {
        return QueryManager.queryPageDataForMybatis(qp, BookInfo.class, bookInfoService::all);
    }

    //读者信息查询
    @DataTranslate
    @ResponseBody
    @RequestMapping(value = "demo2", produces = "text/html;charset=UTF-8")
    public Object readerinfosel(IQueryInfo qp) {
        return QueryManager.queryPageDataForMybatis(qp, ReaderInfo.class, readerInfoService::all);
    }

    //图书信息修改功能
    @ResponseBody
    @RequestMapping(value = "demo3", produces = "text/html;charset=UTF-8")
    public ArteryResult updateBookInfo(@RequestBody BookInfo book) {
        if ((bookInfoService.up(book)) == 1) {
            return ArteryResult.success();
        } else {
            return ArteryResult.failure("404");
        }
    }

    //借阅时读者信息查询
    @DataTranslate
    @ResponseBody
    @RequestMapping(value = "demo4", produces = "text/html;charset=UTF-8")
    public List<ReaderInfo> selreader(@RequestBody LinkedHashMap<String, String> params) {
        ReaderInfo re = new ReaderInfo();
        re.setR_id(Integer.parseInt(params.get("params")));
        return readerInfoService.sel(re);
    }

    //图书借阅
    @ResponseBody
    @RequestMapping(value = "demo5", produces = "text/html;charset=UTF-8")
    public ArteryResult borrowBook(@RequestBody BorrowInfo br) {
        if ((borrowInfoService.bookUpdate(br)==1)) {
            if((borrowInfoService.readerUpdate(br)==1) && (borrowInfoService.insert(br)) == 1) {
                return ArteryResult.success();
            }else{
                return ArteryResult.failure("404");
            }
        } else {
            return ArteryResult.failure("404");
        }
    }

    //读者信息修改功能
    @DataTranslate
    @ResponseBody
    @RequestMapping(value = "demo6", produces = "text/html;charset=UTF-8")
    public ArteryResult updateReader(@RequestBody ReaderInfo reader) {
        if ((readerInfoService.up(reader)) == 1) {
            return ArteryResult.success();
        } else {
            return ArteryResult.failure("404");
        }
    }

    //借书记录查询
    @DataTranslate
    @ResponseBody
    @RequestMapping(value = "demo7", produces = "text/html;charset=UTF-8")
    public Object boorowinfosel(IQueryInfo qp) {
        return QueryManager.queryPageDataForMybatis(qp, BorrowInfo.class, borrowInfoService::all);
    }

    //图书增加功能
    @ResponseBody
    @RequestMapping(value = "demo8", produces = "text/html;charset=UTF-8")
    public ArteryResult addNewBook(@RequestBody BookInfo book) throws Exception {
        String[] str = book.getBk_img().split(",");
        String base64 = str[1];
        String path;
        if(base64==null||"".equals(base64)){

        }else {
            byte[] w = Base64.decodeBase64(base64);
            path = "C:\\Users\\lenovo\\Desktop\\books\\src\\main\\resources\\static\\img\\"+book.getBk_id()+".jpg";
            FileOutputStream write = new FileOutputStream(new File(path));
            write.write(w);
            write.close();
        }
        if ((bookInfoService.insert(book)) == 1) {
            return ArteryResult.success();
        } else {
            return ArteryResult.failure("404");
        }
    }

    //图书删除功能
    @ResponseBody
    @RequestMapping(value = "demo9", produces = "text/html;charset=UTF-8")
    public String deleteBook(@RequestBody LinkedHashMap<String, Integer> params) {
        BookInfo bi = new BookInfo();
        bi.setBk_id(params.get("params"));
        if(bookInfoService.delete(bi)==1){
            return "success";
        }else{
            return "fail";
        }
    }

    //读者增加功能
    @ResponseBody
    @RequestMapping(value = "demo10", produces = "text/html;charset=UTF-8")
    public ArteryResult addNewReader(@RequestBody ReaderInfo reader) {
        if("老师".equals(reader.getR_type())) {
            if ((readerInfoService.insertTeacher(reader)) == 1) {
                return ArteryResult.success();
            } else {
                return ArteryResult.failure("404");
            }
        }else{
            System.out.println(reader.getR_id());
            if ((readerInfoService.insertStu(reader)) == 1) {
                return ArteryResult.success();
            } else {
                return ArteryResult.failure("404");
            }
        }
    }

    //读者删除功能
    @ResponseBody
    @RequestMapping(value = "demo11", produces = "text/html;charset=UTF-8")
    public String deleteReader(@RequestBody LinkedHashMap<String, Integer> params) {
        ReaderInfo ri = new ReaderInfo();
        ri.setR_id(params.get("params"));
        if(readerInfoService.delete(ri)==1){
            return "success";
        }else{
            return "fail";
        }
    }

    //图书归还功能
    @ResponseBody
    @RequestMapping(value = "demo12", produces = "text/html;charset=UTF-8")
    public String returnBook(@RequestBody LinkedHashMap<String, ReturnInfo> params) {
        ReturnInfo r = params.get("params");
        r.setR_date(new Date());
        if(returnInfoService.readerUpdate(r)==1 && returnInfoService.bookUpdate(r)==1){
            if(returnInfoService.insert(r)==1) {
                int i = returnInfoService.delete(r);
                return "success";
            }else{
                return "fail";
            }
        }else{
            return "fail";
        }
    }

    //归还信息查询
    @ResponseBody
    @DataTranslate
    @RequestMapping(value = "demo13", produces = "text/html;charset=UTF-8")
    public Object returnInfo(IQueryInfo qp){
        return QueryManager.queryPageDataForMybatis(qp, ReturnInfo.class, returnInfoService::all);
    }


}
