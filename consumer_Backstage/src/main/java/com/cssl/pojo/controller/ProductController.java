package com.cssl.pojo.controller;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.cssl.pojo.po.Page;
import com.cssl.pojo.service.UserService;
import com.jcraft.jsch.Session;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private UserService userService;

    @RequestMapping("productType")
    @ResponseBody
    public List<Map<String, Object>> productType(){
        return userService.productType();
    }

    @RequestMapping("citiesstates")
    @ResponseBody
    public List<Map<String,Object>> citiesstatesLs(){
        List<Map<String,Object>> list=userService.citiesstatesLs();
        return list;
    }

    @RequestMapping("findProduct")
    @ResponseBody
    public Page findProduct(@RequestParam Map<String,Object> map){
        System.out.println("分页map:"+map);
        Page page=userService.findProduct(map);
        System.out.println("消费者pageList:"+page.getList());
        return page;
    }

    @PostMapping("addProduct")
    public String addProduct(@RequestParam Map<String,Object> map,@RequestParam MultipartFile[] picture,@RequestParam MultipartFile[] img) throws IOException {
        //1、连接ftp服务器
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(1000);
        ftpClient.connect("39.107.103.69", 21);
        //2、登录ftp服务器
        ftpClient.login("ftpuser", "myftpuser");
        ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        String image=null;
        List<String> imgName=new ArrayList<>();
        if(map.get("product").equals("1") || map.get("product").equals("2") || map.get("product").equals("3")){
            for (MultipartFile file : img){
                if(!file.isEmpty()){
                    //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                    InputStream is = file.getInputStream();
                    //4、上传文件
                    // 1）指定上传目录
                    ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/");
                    //2）指定文件类型
                    //ftpClient.enterLocalPassiveMode();
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                    //第一个参数：文件在远程服务器的名称
                    // 第二个参数：文件流
                    ftpClient.setBufferSize(1024*1024*10);
                    BufferedInputStream input = new BufferedInputStream(is);
                    ftpClient.storeFile(file.getOriginalFilename(), input);
                    image=file.getOriginalFilename();
                }
            }


            for (MultipartFile file : picture){
                if(!file.isEmpty()){
                    //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                    InputStream is = file.getInputStream();
                    //4、上传文件
                    // 1）指定上传目录
                    ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/tourismproduct");
                    //2）指定文件类型
                    //ftpClient.enterLocalPassiveMode();
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                    //第一个参数：文件在远程服务器的名称
                    // 第二个参数：文件流
                    ftpClient.setBufferSize(1024*1024*10);
                    BufferedInputStream input = new BufferedInputStream(is);
                    ftpClient.storeFile(file.getOriginalFilename(), input);
                    imgName.add(file.getOriginalFilename());
                }
            }
        }else if(map.get("product").equals("4")){
            for (MultipartFile file : img){
                if(!file.isEmpty()){
                    //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                    InputStream is = file.getInputStream();
                    //4、上传文件
                    // 1）指定上传目录
                    ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/");
                    //2）指定文件类型
                    //ftpClient.enterLocalPassiveMode();
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                    //第一个参数：文件在远程服务器的名称
                    // 第二个参数：文件流
                    ftpClient.setBufferSize(1024*1024*10);
                    BufferedInputStream input = new BufferedInputStream(is);
                    ftpClient.storeFile(file.getOriginalFilename(), input);
                    image=file.getOriginalFilename();
                }
            }


            for (MultipartFile file : picture){
                if(!file.isEmpty()){
                    //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                    InputStream is = file.getInputStream();
                    //4、上传文件
                    // 1）指定上传目录
                    ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/hotel/");
                    //2）指定文件类型
                    //ftpClient.enterLocalPassiveMode();
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                    //第一个参数：文件在远程服务器的名称
                    // 第二个参数：文件流
                    ftpClient.setBufferSize(1024*1024*10);
                    BufferedInputStream input = new BufferedInputStream(is);
                    ftpClient.storeFile(file.getOriginalFilename(), input);
                    imgName.add(file.getOriginalFilename());
                }
            }
        }

        ftpClient.logout();
        map.put("img",image);
        map.put("picture",imgName);
        System.out.println("消费者AppProductMap:"+map);
        int num=userService.addProduct(map);
        System.out.println("运行结果："+num);
        if(num>0){
            return "tips";
        }
        return "failed";
    }

    @RequestMapping("delproduct")
    @ResponseBody
    public int delproduct(int p_id,int pt_id){
        System.out.println("消费者p_id:"+p_id);
        Map<String,Object> map=new HashMap<>();
        map.put("p_id",p_id);
        map.put("pt_id",pt_id);
        return userService.delproduct(map);
    }

    @RequestMapping("delbatches")
    @ResponseBody
    public int delbatches(String p_id){
        String[] pid=p_id.split("\\,");
        int num=0;
        for (int i=1;i<pid.length;i++){
            System.out.println("pid:"+pid[i]);
            Map<String,Object> proMap=userService.productP_id(Integer.parseInt(pid[i]));
            Map<String,Object> map=new HashMap<>();
            map.put("p_id",pid[i]);
            map.put("pt_id",proMap.get("Pt_id"));
            num=num+userService.delproduct(map);
        }
        return num;
    }

    @RequestMapping("selSetProduct")
    public ModelAndView selSetProduct(@RequestParam Map<String,Object> map,ModelAndView model){
        System.out.println("消费者selSetProductMap:"+map);
        String p_id=(String)map.get("p_id");
        String pt_id=(String)map.get("pt_id");
        if(pt_id.equals("1") || pt_id.equals("2") || pt_id.equals("3")){
            Map<String,Object> touMap= userService.tourismproductsP_id(Integer.parseInt(p_id));
            Map<String,Object> proMap= userService.productP_id(Integer.parseInt(p_id));
            int cd_id=(int) touMap.get("cd_id");
            Map<String,Object> description=userService.cost_descriptionC_id(cd_id);
            String picture=(String) touMap.get("picture");
            String[] strArr=picture.split("\\,");
            model.addObject("list",touMap);
            model.addObject("list2",proMap);
            model.addObject("list3",description);
            model.addObject("picture",strArr);
            System.out.println("touMap:"+touMap);
            System.out.println("proMap:"+proMap);
            System.out.println("description:"+description);
            model.setViewName("modProduct");
        }else if(pt_id.equals("4")){
            Map<String,Object> proMap=userService.productP_id(Integer.parseInt(p_id));
            Map<String,Object> hotelMap=userService.hotelP_id(Integer.parseInt(p_id));
            String picture=(String) hotelMap.get("picture1");
            String[] strArr=picture.split("\\,");
            model.addObject("list1",proMap);
            model.addObject("list2",hotelMap);
            model.addObject("picture",strArr);
            model.setViewName("modHotel");
        }
        return model;
    }

    @PostMapping("setProduct")
    public String setProduct(@RequestParam Map<String,Object> map,@RequestParam MultipartFile[] img,@RequestParam MultipartFile[] picture) throws IOException {

        System.out.println("消费者setProduct:"+map);

        //1、连接ftp服务器
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(1000);
        ftpClient.connect("39.107.103.69", 21);
        //2、登录ftp服务器
        ftpClient.login("ftpuser", "myftpuser");
        ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        if(img.length!=0){
            for (MultipartFile file : img){
                if(!file.isEmpty()){
                    //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                    InputStream is = file.getInputStream();
                    //4、上传文件
                    // 1）指定上传目录
                    ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/");
                    //2）指定文件类型
                    //ftpClient.enterLocalPassiveMode();
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                    //第一个参数：文件在远程服务器的名称
                    // 第二个参数：文件流
                    ftpClient.setBufferSize(1024*1024*10);
                    BufferedInputStream input = new BufferedInputStream(is);
                    ftpClient.storeFile(file.getOriginalFilename(), input);
                    map.put("img",file.getOriginalFilename());
                }
            }
        }
        List<String> imgName=new ArrayList<>();
        if(picture.length!=0){
            for (MultipartFile file : picture){
                if(!file.isEmpty()){
                    //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                    InputStream is = file.getInputStream();
                    //4、上传文件
                    // 1）指定上传目录
                    if(map.get("product").equals("4")){
                        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/hotel/");
                    }else{
                        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/tourismproduct/");
                    }
                    //2）指定文件类型
                    //ftpClient.enterLocalPassiveMode();
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                    //第一个参数：文件在远程服务器的名称
                    // 第二个参数：文件流
                    ftpClient.setBufferSize(1024*1024*10);
                    BufferedInputStream input = new BufferedInputStream(is);
                    ftpClient.storeFile(file.getOriginalFilename(), input);
                    imgName.add(file.getOriginalFilename());
                }
            }
            map.put("picture",imgName);
        }
        ftpClient.logout();
        int num=userService.setProduct(map);
        if(num>0){
            return "tips";
        }else{
            return "failed";
        }
    }

    @RequestMapping("roominformation")
    @ResponseBody
    public Page roominformation(@RequestParam Map<String,Object> map){
        return userService.roominformation(map);
    }

    @RequestMapping("hotel")
    @ResponseBody
    public List<Map<String,Object>> hotel(){
        return userService.hotel();
    }

    @PostMapping("addroom")
    public String addroom(@RequestParam Map<String,Object> map,@RequestParam MultipartFile[] photo) throws IOException {
        String imgname="";
        for (MultipartFile file : photo) {
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
                ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/hotel/");
                //2）指定文件类型
                //ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //第一个参数：文件在远程服务器的名称
                // 第二个参数：文件流
                ftpClient.setBufferSize(1024*1024*10);
                BufferedInputStream input = new BufferedInputStream(is);
                ftpClient.storeFile(file.getOriginalFilename(), input);
                imgname=file.getOriginalFilename();
                map.put("photo",imgname);
                System.out.println("path:"+imgname);
                //5、退出登录
                ftpClient.logout();
            }
        }
        int num=userService.addroom(map);
        if(num>0){
            return "skip/roomTips";
        }
        return "skip/roomFailed";
    }

    @RequestMapping("selsetRoom")
    public ModelAndView selsetRoom(@RequestParam int id,ModelAndView model){
        Map<String,Object> roomMap=userService.selsetRoom(id);
        model.addObject("room",roomMap);
        model.setViewName("modRoomInformation");
        return model;
    }

    @PostMapping("setRoom")
    public String setRoom(@RequestParam Map<String,Object> map,@RequestParam MultipartFile[] photo) throws IOException {
        String imgname="";
        int num=0;
        if(photo.length!=0){
            for (MultipartFile file : photo) {
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
                    ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/hotel/");
                    //2）指定文件类型
                    //ftpClient.enterLocalPassiveMode();
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                    //第一个参数：文件在远程服务器的名称
                    // 第二个参数：文件流
                    ftpClient.setBufferSize(1024*1024*10);
                    BufferedInputStream input = new BufferedInputStream(is);
                    ftpClient.storeFile(file.getOriginalFilename(), input);
                    imgname=file.getOriginalFilename();
                    map.put("photo",imgname);
                    System.out.println("path:"+imgname);
                    //5、退出登录
                    ftpClient.logout();
                }
            }
        }
        num=userService.setRoom(map);
        if(num>0){
            return "skip/roomTips";
        }
        return "skip/roomFailed";
    }

    @RequestMapping("delRoom")
    @ResponseBody
    public int delRoom(@RequestParam int id){
        return userService.delRoom(id);
    }

    @RequestMapping("delbatchesRoom")
    @ResponseBody
    public int delbatchesRoom(String id){
        int num=0;
        String[] ids=id.split("\\,");
        for (int i=1;i<ids.length;i++){
            num=num+userService.delRoom(Integer.parseInt(ids[i]));
        }
        return num;
    }

    @RequestMapping("order_no")
    @ResponseBody
    public Page order_no(@RequestParam Map<String,Object> map){
        return userService.order_no(map);
    }

    @RequestMapping("delOrder")
    @ResponseBody
    public int delOrder(@RequestParam String no){
        System.out.println("delOrder:"+no);
        return userService.delOrder(no);
    }

    @RequestMapping("fordelorder")
    @ResponseBody
    public int fordelOrder(@RequestParam String fordel){
        String[] fordelorder=fordel.split("\\,");
        int num=0;
        for (int i=1;i<fordelorder.length;i++){
            num+=userService.delOrder(fordelorder[i]);
        }
        if(num==fordelorder.length-1){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("setState")
    @ResponseBody
    public int setState(@RequestParam Map<String,Object> map){
        return userService.setState(map);
    }

    @RequestMapping("setProState")
    @ResponseBody
    public int setProState(@RequestParam Map<String,Object> map){
        return userService.setProState(map);
    }
}
