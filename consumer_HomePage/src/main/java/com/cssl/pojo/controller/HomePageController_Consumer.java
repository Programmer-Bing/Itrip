package com.cssl.pojo.controller;

import com.alipay.api.internal.util.AlipaySignature;
import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.Product_shopping;
import com.cssl.pojo.method.AlipayConfig;
import com.cssl.pojo.order.Order;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.HomePageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

import static com.cssl.pojo.method.Method.*;

@Controller
public class HomePageController_Consumer {

    @Autowired
    private HomePageClientService service;

    /*,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE*/
    /*特价商品查询*/
    @RequestMapping(value = "/findBargains", method = RequestMethod.GET)
    @ResponseBody
    public List<HomePage_product> findBargains(HttpSession session, @RequestParam(required = false, value = "lp_id") Integer lp_id) {
        System.out.println("sessionId:" + session.getId());
        System.out.println("大区编号：" + lp_id);
        return this.service.findBargains(lp_id);
    }

    /*热销商品查询*/
    @RequestMapping(value = "/findSellwell", method = RequestMethod.GET)
    @ResponseBody
    public List<HomePage_product> findSellwell(HttpSession session) {
        System.out.println("sessionId:" + session.getId());
        return this.service.findSellwell();
    }

    /*唯一城市商品查询*/
    @RequestMapping(value = "/findPartyingByCity", method = RequestMethod.GET)
    @ResponseBody
    public List<HomePage_product> findPartyingByCity(HttpSession session, @RequestParam(required = false, value = "P_cid") Integer P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id) {
        System.out.println("sessionId:" + session.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("P_cid", P_cid);
        map.put("Pt_id", Pt_id);
        System.out.println("map:" + map);
        return this.service.findPartyingByCity(P_cid, Pt_id);
    }

    /*多城市商品查询*/
    @RequestMapping(value = "/findPartyingByCities", method = RequestMethod.GET)
    @ResponseBody
    public List<HomePage_product> findPartyingByCities(HttpSession session, @RequestParam(required = false, value = "P_cid") String P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id) {
        System.out.println("城市不唯一");
        System.out.println("sessionId:" + session.getId());
        System.out.println(P_cid);
        Map<String, Object> map = new HashMap<>();
        map.put("P_cid", P_cid);
        map.put("Pt_id", Pt_id);
        System.out.println("map:" + map);
        return this.service.findPartyingByCities(P_cid, Pt_id);
    }

    /*跟据商品id来查找商品详情*/
    @RequestMapping(value = "/findProductDetails", method = RequestMethod.GET)
    public ModelAndView findProductDetails(HttpSession session, @RequestParam(required = false, value = "Product_id") Integer Product_id, ModelAndView model) {
        System.out.println("sessionId:" + session.getId());
        System.out.println("商品编号：" + Product_id);
        model.addObject("ProductDetails", this.service.findProductDetails(Product_id));
        model.setViewName("HomePage/ProductDetails");
        return model;
    }

    /*添加购物车*/
    @RequestMapping(value = "/addShopping", method = RequestMethod.GET)
    @ResponseBody
    public Integer addShopping(HttpSession session, @RequestParam(value = "map", required = false) String map) {
        System.out.println("sessionId:" + session.getId());
        session.getAttribute(session.getId());
        System.out.println(map);
        Integer num = this.service.addShopping(map);
        System.out.println("num:" + num);

        return num;
    }

    /*立即预定*/
    @RequestMapping("/Reservation")
    public ModelAndView Reservation(HttpSession session, @RequestParam(value = "map", required = false) String map, ModelAndView model, Model model2) {
        System.out.println("sessionId:" + session.getId());
        System.out.println("进入立即结算");
        Integer num = this.service.addShopping(map);
        Map<String, Object> map2 = json2map(map);
        Product_shopping product_shopping = this.service.findNew();
        HomePage_product hp = this.service.findByP_id(product_shopping.getP_id());
        product_shopping.setP_title(hp.getProduct_name());
        List<Product_shopping> list1 = new ArrayList<>();
        List<Product_shopping> list2 = new ArrayList<>();
        list1.add(product_shopping);
        System.out.println(list1);
        model.addObject("Pshopping", list1);
        model2.addAttribute("Hshopping", list2);
        model.setViewName("HomePage/Order_now");
        return model;
    }

    /*xx的购物车的显示*/
    @RequestMapping("/findShoppingByUid")
    public ModelAndView findShoppingByUid(HttpSession session, ModelAndView model, Model model2, @RequestParam(value = "uid", required = false) Integer uid) {
        System.out.println("findShopping成功到消费者模块！！");
        List<List> maps = service.showMycart();
        System.out.println(uid);
        model2.addAttribute("ShoppingC", this.service.findShoppingByUid(uid));
        model2.addAttribute("ShoppingH", maps);
        System.out.println("--------------------");
        model.setViewName("HomePage/ShoppingCart");
        return model;
    }

    /*删除购物车中的商品*/
    @RequestMapping(value = "/delShopping", method = RequestMethod.GET)
    public ModelAndView delShopping(HttpSession session, @RequestParam(value = "psc_id", required = false) Integer psc_id, ModelAndView model, Model model2, @RequestParam(value = "uid", required = false) Integer uid) {
        System.out.println("sessionId:" + session.getId());
        User user = (User) session.getAttribute(session.getId());
        uid = user.getUser_id();
        System.out.println("用户编号： " + uid);
        System.out.println(psc_id);
        Integer num = this.service.delShopping(psc_id);
        System.out.println("num:" + num);
        return findShoppingByUid(session, model, model2, uid);
    }


    /**
     * 删除酒店购物车
     */
    @RequestMapping(value = "/delHotel", method = RequestMethod.GET)
    public ModelAndView delHotel(ModelAndView model, @RequestParam(value = "sht", required = false) Integer sht) {
        service.delHotel(sht);
        model.setViewName("Europe");
        return model;
    }

    @RequestMapping("/PlacingOrder")
    @ResponseBody
    public ModelAndView PlacingOrder(HttpSession session, @RequestParam(value = "map", required = false) String map, ModelAndView model, Model model2) {
        Map<String, Object> map1 = this.service.addOrder(map);
        if ((Integer) map1.get("num") > 0) {
            String wy = payFor(model, (String) map1.get("orderNo"), (String) map1.get("orderMoney"), "iTrip爱去", "kkk");
            model.setViewName(wy);
        }
        return model;
    }

    @RequestMapping("/notify_url")
    public void getNotifyInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——

	/* 实际验证过程建议商户务必添加以下校验：
	1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	4、验证app_id是否为该商户本身。
	*/
        if (signVerified) {//验证成功
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

            if (trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }

            System.out.println("success");

        } else {//验证失败
            System.out.println("fail");

            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }

    }

    @RequestMapping("/return_url")
    public String getReturnInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("----------------------------notify_url------------------------");
        // 商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //付款金额，必填
        String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
        //支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //交易状态
//        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

        System.out.println("商户订单号:" + out_trade_no);
        System.out.println("付款金额:" + total_amount);
        System.out.println("支付宝交易号:" + trade_no);
        // System.out.println("交易状态:" + trade_status);

       /* if(trade_status.equals("TRADE_SUCCESS")){
            System.out.println("交易成功,进行其他业务逻辑处理........");
        }*/
        int num = this.service.updOrder(out_trade_no);
        System.out.println(num);
        return "Europe";
    }
}
