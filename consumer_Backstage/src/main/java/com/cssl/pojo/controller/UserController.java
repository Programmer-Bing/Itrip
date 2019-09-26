package com.cssl.pojo.controller;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.cssl.pojo.po.Page;
import com.cssl.pojo.service.UserService;
import com.jcraft.jsch.Session;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    @ResponseBody
    public Page findALL(@RequestParam Map<String, Object> map) {
        System.out.println("userMap:" + map);
        Page page = userService.findAll(map);
        System.out.println("消费者UserList:" + page.getList());
        return page;
    }

    @PostMapping("addUser")
    public String addUser(@RequestParam Map<String, Object> map, @RequestParam MultipartFile[] Head_portrait) throws IOException {
        System.out.println("上传来了");
        String imgname="";
        for (MultipartFile file : Head_portrait) {
            //判断文件非空，上传
            if (!file.isEmpty()) {
                //1、连接ftp服务器
                FTPClient ftpClient = new FTPClient();
                ftpClient.setConnectTimeout(1000);
                ftpClient.connect("39.107.103.69", 21);
                //2、登录ftp服务器
                ftpClient.login("ftpuser", "myftpuser");
                ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
                //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                InputStream is = file.getInputStream();
                //4、上传文件
                // 1）指定上传目录
                ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/user/");
                //2）指定文件类型
                //ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //第一个参数：文件在远程服务器的名称
                // 第二个参数：文件流
                ftpClient.setBufferSize(1024*1024*10);
                BufferedInputStream input = new BufferedInputStream(is);
                ftpClient.storeFile(file.getOriginalFilename(), input);
                imgname=file.getOriginalFilename();
                System.out.println("path:"+imgname);
                //5、退出登录
                ftpClient.logout();
            }
        }
        map.put("Head_portrait", imgname);
        int num = userService.addUser(map);
        if (num > 0) {
            return "skip/userTips";
        }
        return "skip/userFailed";
    }

    @RequestMapping("deluser")
    @ResponseBody
    public int deluser(int u_id) {
        System.out.println("u_id:" + u_id);
        return userService.deluser(u_id);
    }

    @RequestMapping("skipModUser")
    public ModelAndView skipModUser(int uid, ModelAndView model) {
        Map<String, Object> map = userService.whereuid(uid);
        model.addObject("user", map);
        model.setViewName("modUser");
        return model;
    }

    @GetMapping("modUser")
    public String modUser(@RequestParam Map<String, Object> map) {
        System.out.println("消费者modUserMap:" + map);
        int num = userService.modUser(map);
        if (num > 0) {
            return "skip/userTips";
        }
        return "skip/userFailed";
    }

    @RequestMapping("selUserAdmin")
    @ResponseBody
    public String selUserAdmin(@RequestParam Map<String,Object> map,ModelAndView model){

        Map<String,Object> adminMap = userService.selUserAdmin(map);

        return "login";
    }
}
