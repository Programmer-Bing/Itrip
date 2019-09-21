package com.cssl.pojo.controller;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
public class UserController01 {


    /***
     * 上传
     * @param files
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/ajaxUpload", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public int ajaxUpload(@RequestParam("file") MultipartFile[] files ) throws Exception {
        System.out.println("上传来了");
        for (MultipartFile file : files) {
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
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //第一个参数：文件在远程服务器的名称
                // 第二个参数：文件流
                ftpClient.storeFile("tx.jpg", is);
                System.out.println(file.getOriginalFilename());
                //5、退出登录
                ftpClient.logout();
            }
        }
        return 1;
    }

}
