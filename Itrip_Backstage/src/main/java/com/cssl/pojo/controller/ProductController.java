package com.cssl.pojo.controller;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.cssl.pojo.po.Page;
import com.cssl.pojo.service.ProductService;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET,value = "productType")
    public List<Map<String,Object>> productType(){
        return productService.productType();
    }

    @RequestMapping(method = RequestMethod.GET,value = "citiesstatesLs")
    public List<Map<String,Object>> citiesstatesLs(){
        return productService.citiesstatesLs();
    }


    @RequestMapping("findProduct")
    public Page findProduct(@RequestBody Map<String,Object> map){
        System.out.println("map参数:"+map);
        System.out.println("服务者:"+productService.findProduct(map));
        String pageNumber=(String)map.get("pageNumber");
        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
        map2.put("index",null);
        map2.put("size",null);
        map2.put("title",(String)map.get("title"));
        map2.put("pt_id",(String)map.get("pt_id"));
        map2.put("p_cid",(String)map.get("p_cid"));

        int pageIndex=Integer.parseInt(pageNumber);  //当前页数
        int pageSize=4;   //每页显示数量
        List list=productService.findProduct(map2);
        int total=list.size();  //获取总数据量

        map1.put("index",(pageIndex-1)*pageSize);
        map1.put("size",pageSize);
        map1.put("title",(String)map.get("title"));
        map1.put("pt_id",(String)map.get("pt_id"));
        map1.put("p_cid",(String)map.get("p_cid"));
        System.out.println("total:"+total);

        int pages=total%pageSize==0?total/pageSize:total/pageSize+1;  //获取总页数
        List list2=productService.findProduct(map1);
        //System.out.println("list2:"+list2);

        Page page=new Page();
        page.setPageNumber(pageIndex);
        page.setList(list2);
        page.setTotalRecord(total);
        page.setPageSize(pageSize);
        page.setTotalPage(pages);
        System.out.println("提供者pageList:"+page.getList());
        return page;
    }


    @RequestMapping(method = RequestMethod.GET,value = "productSize")
    public int productSize(){
        return productService.productSize();
    }

    @RequestMapping("addProduct")
    public int addProduct(@RequestBody Map<String,Object> map){
        System.out.println("AddProductMap:"+map);
        List<String> picture= (List<String>) map.get("picture");
        System.out.println("picture:"+picture);
        Map<String,Object> map3=new HashMap<>();
        map3.put("product_name",map.get("p_name"));
        map3.put("p_cid",map.get("citiesstates"));
        int selProCount=productService.selProCount(map3);
        System.out.println("selProCount:"+selProCount);
        if(selProCount>0){
            return 0;
        }else{
            Map<String,Object> map1=new HashMap<String,Object>();
            map1.put("product_name",map.get("p_name"));
            map1.put("pt_id",map.get("product"));
            map1.put("p_cid",map.get("citiesstates"));
            map1.put("OrderNumber",map.get("OrderNumber"));
            map1.put("p_imgpath",(String)"http://39.107.103.69/images/"+map.get("img"));
            map1.put("p_price",map.get("price"));
            int num1=productService.addProduct(map1);
            System.out.println("num1:"+num1);
            if(num1<=0){
                return 0;
            }else{
                if(map.get("product").equals("1") || map.get("product").equals("2") || map.get("product").equals("3")){
                    Map selectMap=productService.selectP_id((String) map.get("p_name"));
                    Map<String,Object> map2=new HashMap<>();
                    map2.put("tp_name",map.get("p_name"));
                    map2.put("Days_play",map.get("Days_play"));
                    map2.put("purchases_Number",map.get("purchases_Number"));
                    map2.put("price",map.get("price"));
                    map2.put("comments_Number",map.get("comments_Number"));
                    map2.put("describes",map.get("describes"));
                    map2.put("Collectors_Number",map.get("Collectors_Number"));
                    map2.put("Strategy",map.get("Strategy"));
                    map2.put("ReservationNotes",map.get("ReservationNotes"));
                    map2.put("itrip",map.get("itrip"));
                    map2.put("Product_id",selectMap.get("Product_id"));

                    String image="http://39.107.103.69/images/tourismproduct/"+picture.get(0);
                    for (int i=1;i<picture.size();i++){
                        image=image+",http://39.107.103.69/images/tourismproduct/"+picture.get(i);
                    }

                    System.out.println("图片:"+image);
                    map2.put("picture",image);

                    Map<String,Object> map4=new HashMap<>();
                    map4.put("cd_includes",map.get("cd_includes"));
                    map4.put("cd_excluded",map.get("cd_excluded"));
                    map4.put("cd_description",map.get("cd_excluded"));
                    int num3=productService.addcost_description(map4);

                    Map<String,Object> description=productService.cost_descriptionOrder();

                    map2.put("cd_id",description.get("cd_id"));
                    int num2=productService.addtourismproducts(map2);
                    System.out.println("num2:"+num2);
                    if(num2>0){
                        System.out.println("新增成功！！！");
                        return 1;
                    }
                }else if(map.get("product").equals("4")){
                    Map selectMap=productService.selectP_id((String)map.get("p_name"));
                    Map<String,Object> map2=new HashMap<>();

                    map2.put("h_name",map.get("p_name"));
                    map2.put("Product_id",selectMap.get("Product_id"));
                    map2.put("purchases_Number",map.get("purchases_Number"));
                    map2.put("Star_class",map.get("Star_class"));
                    map2.put("cs_id",map.get("citiesstates"));
                    map2.put("describes",map.get("describes"));
                    map2.put("Specific_address",map.get("Specific_address"));
                    map2.put("score",map.get("score"));
                    map2.put("Reservation_Notes",map.get("Reservation_Notes"));
                    map2.put("tips",map.get("tips"));

                    String image="http://39.107.103.69/images/hotel/"+picture.get(0);
                    for (int i=1;i<picture.size();i++){
                        image=image+",http://39.107.103.69/images/hotel/"+picture.get(i);
                    }
                    System.out.println("图片:"+image);
                    map2.put("picture1",image);
                    int num2=productService.addhotel(map2);
                    System.out.println("num2:"+num2);
                    if(num2>0){
                        System.out.println("新增成功！！！");
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    @RequestMapping("delproduct")
    public int delproduct(@RequestBody Map<String,Object> map){
        System.out.println("服务者DelProductMap:"+map);
        int pt_id=(int)map.get("pt_id");
        int p_id=(int) map.get("p_id");
        int num2=0;
        if(pt_id==1 || pt_id==2 || pt_id==3){
            num2= productService.deltourism(p_id);
        }else if(pt_id==4){
            num2= productService.delhotel(p_id);
        }
        int num1= productService.delproduct(p_id);
        if(num1>0 && num2>0){
            return 1;
        }
        return 0;
    }



    @RequestMapping("tourismproductsP_id")
    public Map<String,Object> tourismproductsP_id(@RequestBody int p_id){
        return productService.tourismproductsP_id(p_id);
    }

    @RequestMapping("productP_id")
    public Map<String,Object> productP_id(@RequestBody int p_id){
        return productService.productP_id(p_id);
    }

    @RequestMapping("cost_descriptionC_id")
    public Map<String,Object> cost_descriptionC_id(@RequestBody int cd_id){
        return productService.cost_descriptionC_id(cd_id);
    }

    @RequestMapping("hotelP_id")
    public Map<String,Object> hotelP_id(@RequestBody int p_id){
        return productService.hotelP_id(p_id);
    }

    @RequestMapping("setProduct")
    public int setProduct(@RequestBody Map<String,Object> map){
        System.out.println("服务者setProductMap:"+map);
        Map<String,Object> map1=new HashMap<>();

        int num2=0;
        int num1=0;

        map1.put("p_name",map.get("p_name"));
        map1.put("pt_id",map.get("product"));
        map1.put("p_cid",map.get("citiesstates"));
        map1.put("price",map.get("price"));
        map1.put("OrderNumber",map.get("OrderNumber"));
        map1.put("p_id",map.get("p_id"));
        if(map.get("img")!=null){
            String img="http://39.107.103.69/images/"+map.get("img");
            map1.put("p_img",img);
            num1=productService.setProduct(map1);
        }else{
            num1=productService.setProduct1(map1);
        }
        if(map.get("product").equals("1") || map.get("product").equals("2") || map.get("product").equals("3")){
            Map<String,Object> map2=new HashMap<>();
            map2.put("tp_name",map.get("p_name"));
            map2.put("Days_play",map.get("Days_play"));
            map2.put("purchases_Number",map.get("purchases_Number"));
            map2.put("price",map.get("price"));
            map2.put("comments_Number",map.get("comments_Number"));
            map2.put("describes",map.get("describes"));
            map2.put("Collectors_Number",map.get("Collectors_Number"));
            map2.put("Strategy",map.get("Strategy"));
            map2.put("ReservationNotes",map.get("ReservationNotes"));
            map2.put("itrip",map.get("itrip"));
            map2.put("cd_id",map.get("citiesstates"));
            map2.put("p_id",map.get("p_id"));

            int num3=productService.setDescription(map);
            List<String> list=(List<String>)map.get("picture");
            if(list.size()>0){
                String image="http://39.107.103.69/images/tourismproduct/"+list.get(0);
                for (int i=1;i<list.size();i++){
                    image=image+",http://39.107.103.69/images/tourismproduct/"+list.get(i);
                }
                map2.put("picture",image);    //图片
                num2=productService.setTourism(map2);
            }else{
                num2=productService.setTourism1(map2);
            }
        }else if(map.get("product").equals("4")){
            Map<String,Object> map2=new HashMap<>();
            map2.put("h_name",map.get("p_name"));
            map2.put("purchases_Number",map.get("purchases_Number"));
            map2.put("Star_class",map.get("Star_class"));
            map2.put("cs_id",map.get("citiesstates"));
            map2.put("describes",map.get("describes"));
            map2.put("Specific_address",map.get("Specific_address"));
            map2.put("score",map.get("score"));
            map2.put("Reservation_Notes",map.get("Reservation_Notes"));
            map2.put("tips",map.get("tips"));
            map2.put("p_id",map.get("p_id"));
            List<String> list=(List<String>)map.get("picture");
            System.out.println("图片集合:"+list.size());
            if(list.size()>0){
                String image="http://39.107.103.69/images/hotel/"+list.get(0);
                for (int i=1;i<list.size();i++){
                    image=image+",http://39.107.103.69/images/hotel/"+list.get(i);
                }
                map2.put("picture",image);    //图片
                num2=productService.setHotel(map2);
            }else{
                num2=productService.setHotel1(map2);
            }
        }
        if(num1>0 && num2>0){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("roominformation")
    public Page roominformation(@RequestBody Map<String,Object> map){
        System.out.println("roominformationmap参数:"+map);
        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
        List<Map<String,Object>> productNames=new ArrayList<>();
        List<Integer> product_id=new ArrayList<>();
        if(!map.get("name").equals("0")){
            String name=(String)map.get("name");
            productNames=productService.productName(name);
            System.out.println("productNameSize:"+productNames.size());
            if(productNames.size()>0){
                for (int i=0;i<productNames.size();i++){
                    product_id.add((int)productNames.get(i).get("h_id"));
                }
            }else{
                product_id.add(999);
            }
        }
        String pageNumber=(String)map.get("pageIndex");
        System.out.println("roominformationPageIndex参数:"+pageNumber);

        map2.put("index",null);
        map2.put("size",null);

        int pageIndex=Integer.parseInt(pageNumber);  //当前页数
        int pageSize=4;   //每页显示数量
        List list=productService.roominformation(map2);
        int total=list.size();  //获取总数据量

        map1.put("index",(pageIndex-1)*pageSize);
        map1.put("size",pageSize);
        System.out.println("product_id:"+product_id.size());
        map1.put("product_id",product_id);
        System.out.println("total:"+total);

        int pages=total%pageSize==0?total/pageSize:total/pageSize+1;  //获取总页数
        List list2=productService.roominformation(map1);
        //System.out.println("list2:"+list2);

        Page page=new Page();
        page.setPageNumber(pageIndex);
        page.setList(list2);
        page.setTotalRecord(total);
        page.setPageSize(pageSize);
        page.setTotalPage(pages);
        System.out.println("提供者pageList:"+page.getList());
        return page;
    }

    @RequestMapping("hotel")
    public List<Map<String,Object>> hotel(){
        return productService.hotel();
    }

    @RequestMapping("addroom")
    public int addroom(@RequestBody Map<String,Object> map){
        Map<String,Object> map1=new HashMap<>();
        map1.put("rif_name",map.get("rif_name"));
        map1.put("occupants_num",map.get("occupants_num"));
        map1.put("area",map.get("area"));
        map1.put("Check_time",map.get("Check_time"));
        map1.put("price",map.get("price"));
        map1.put("introduce",map.get("introduce"));
        String img="http://39.107.103.69/images/hotel/"+map.get("photo");
        map1.put("photo",img);
        map1.put("h_id",map.get("h_id"));
        map1.put("bed_type",map.get("bed_type"));
        map1.put("breakfast",map.get("breakfast"));
        return productService.addroom(map1);
    }

    @RequestMapping("setRoom")
    public int setRoom(@RequestBody Map<String,Object> map){
        int num=0;
        Map<String,Object> map1=new HashMap<>();
        map1.put("rif_name",map.get("rif_name"));
        map1.put("occupants_num",map.get("occupants_num"));
        map1.put("area",map.get("area"));
        map1.put("Check_time",map.get("Check_time"));
        map1.put("price",map.get("price"));
        map1.put("introduce",map.get("introduce"));
        map1.put("h_id",map.get("h_id"));
        map1.put("bed_type",map.get("bed_type"));
        map1.put("breakfast",map.get("breakfast"));
        map1.put("rif_id",map.get("rif_id"));
        if(map.get("photo")!=null){
            String img="http://39.107.103.69/images/hotel/"+map.get("photo");
            map1.put("photo",img);
            num=productService.setRoom(map1);
        }else{
            num=productService.setRoom1(map1);
        }
        return num;
    }

    @RequestMapping("selsetRoom")
    public Map<String,Object> selsetRoom(@RequestBody int id){
        return productService.selsetRoom(id);
    }

    @RequestMapping("delRoom")
    public int delRoom(@RequestBody int id){
        return productService.delRoom(id);
    }

    @RequestMapping("order_no")
    public Page order_no(@RequestBody Map<String,Object> map){
        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();

        map1.put("pageIndex",null);
        map1.put("pageSize",null);
        map1.put("no",map.get("no"));
        map1.put("uid",map.get("uid"));
        List<Map<String,Object>> orderSize=productService.order_no(map1);
        int total=orderSize.size();       //获取总数量
        String pageNumber=(String) map.get("pageIndex");   //获取当前页
        int pageIndex=Integer.parseInt(pageNumber);
        int pageSize=3;   //每页显示数量
        int pages=total%pageSize==0?total/pageSize:total/pageSize+1;

        map2.put("pageIndex",(pageIndex-1)*pageSize);
        map2.put("pageSize",pageSize);
        map2.put("no",map.get("no"));
        map2.put("uid",map.get("uid"));
        List<Map<String,Object>> order_no=productService.order_no(map2);
        for(int i=0;i<order_no.size();i++){
            String no=(String)order_no.get(i).get("order_no");
            List<Map<String,Object>> OrderProductMap=productService.order_Product(no);
            order_no.get(i).put("product",OrderProductMap);
            System.out.println("OrderProductMap:"+OrderProductMap);
        }
        Page page=new Page();
        page.setTotalPage(pages);
        page.setList(order_no);
        page.setIndex(pageIndex);
        page.setPageSize(pageSize);
        return page;
    }

    @RequestMapping("delOrder")
    public int delOrder(@RequestBody String no){
        System.out.println("delOrder:"+no);
        int num2= productService.delOrderPro(no);
        int num1= productService.delOrder(no);
        if(num1>0){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("setState")
    public int setState(@RequestBody Map<String,Object> map){
        return productService.setState(map);
    }

    @RequestMapping("setProState")
    public int setProState(@RequestBody Map<String,Object> map){
        return productService.setProState(map);
    }
}