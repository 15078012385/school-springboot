package com.atguigu.schoolspringboot.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.atguigu.schoolspringboot.dao.AdminMapper;
import com.atguigu.schoolspringboot.pojo.Admin;
import com.atguigu.schoolspringboot.pojo.UserPasswordDTO;
import com.atguigu.schoolspringboot.service.AdminService;
import com.atguigu.schoolspringboot.utils.MD5;
import com.atguigu.schoolspringboot.utils.RespResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;


/**
 * @author xiaochen
 * @description admin控制器
 * @date 2022-06-22
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    private static String salt = "Make in xiaochen";

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Object login(@RequestBody Admin admin, HttpServletRequest httpServletRequest) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", admin.getUsername());
        wrapper.eq("password", MD5.encrypt(salt + admin.getPassword() + salt));
        Admin db_admin = adminService.getOne(wrapper);
        if (db_admin == null) {
            return new RespResult<>("500", "登录失败,账号信息有误.", null);
        }
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user", db_admin);

        return new RespResult("200", "登录成功", db_admin);
    }

    @GetMapping("/logout")
    public Object logout(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("user");
        return new RespResult<>("200", "退出成功", null, null);
    }

    @PostMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody Admin admin) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", admin.getUsername());
        Admin db_admin = adminService.getOne(wrapper);
        if (db_admin == null) {
            admin.setPassword(MD5.encrypt(salt + admin.getPassword() + salt));
            adminService.save(admin);
            return RespResult.success();
        } else if (admin.getId() != null) {
            adminService.updateById(admin);
            return RespResult.success();
        } else {
            return new RespResult<>("500", "注册失败，账户已存在", null);
        }

    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        adminService.removeById(id);
        return RespResult.success();
    }

    @PostMapping("/del/batch")
    public Object deleteBatch(@RequestBody List<Integer> ids) {
        adminService.removeByIds(ids);
        return RespResult.success();
    }


    @GetMapping
    public Object findAll() {
        return RespResult.success(adminService.list());
    }

    @GetMapping("/{id}")
    public Object findOne(@PathVariable Integer id) {
        return RespResult.success(adminService.getById(id));
    }

    @PostMapping("/updatePassword")
    public Object updatePassword(@RequestBody UserPasswordDTO userPasswordDTO) {
        Admin dbAdmin = adminService.getById(userPasswordDTO.getId());
//        前端传过来的旧密码
        String oldPassword = MD5.encrypt(salt + userPasswordDTO.getPassword() + salt);
//        前端传过来的新密码
        String newPassword = MD5.encrypt(salt + userPasswordDTO.getNewPassword() + salt);
//      如果原来的密码正确，则进行下一步操作
        if (dbAdmin.getPassword().equals(oldPassword)) {
            Admin newAdmin = new Admin(dbAdmin.getId(), dbAdmin.getUsername(), newPassword, dbAdmin.getLoginTime(), dbAdmin.getAvatarUrl(), dbAdmin.getPhone(), dbAdmin.getAphorism());
            adminService.updateById(newAdmin);
            return new RespResult<>("200", "修改成功", null, null);
        } else {
            return new RespResult<>("500", "原密码错误", null, null);
        }
    }


}
