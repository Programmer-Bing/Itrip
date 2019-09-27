package com.cssl.pojo.dao;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.ProductDetails;
import com.cssl.pojo.Product_shopping;
import com.cssl.pojo.order.OProduct;
import com.cssl.pojo.order.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HomePage_productDao {
    /*首页操作*/
    /***
     * 根据在哪个大区查特价商品（大区：一级分类例如:欧洲，东南亚）
     * @param id
     * @return
     */
    List<HomePage_product> findBargains(Integer id); //根据在哪个大区查特价商品（大区：一级分类例如:欧洲，东南亚）
    List<HomePage_product> findPartyingByCity(Map<String,Object>map); //根据在哪个城市及什么类型查商品
    List<HomePage_product> findPartyingByCities(Map<String,Object>map); //根据在哪些城市及什么类型查商品
    List<HomePage_product> findSellwell(); //根据在哪个大区查热销商品（大区：一级分类例如:欧洲，东南亚）
    /*商品详情页操作*/
    ProductDetails findProductDetails(Integer Product_id);//跟据商品id来查找商品的详情
    /***
     * 跟据商品id查商品
     * @param Product_id
     * @return
     */
    HomePage_product findByP_id(Integer Product_id);
    /***
     * 添加购物车
     * @param product_shopping
     * @return
     */
    Integer addShopping(Product_shopping product_shopping);
    /*购物车页面*/
    /***
     * 查xx用户购物车里的产品
     * @return
     */
    List<Product_shopping>findShoppingByUid(Integer uid);

    /***
     * 删除购物车的商品
     * @param psc_id
     * @return
     */
    Integer delShopping(Integer psc_id);

    /**
     * 地区显示
     */
    List<Map> showregion();

    /**
     * 查询购物车的商品
     * @return
     */
    List<Map> showMycart();

    /**
     * 删除购物车的酒店
     * @param sht
     * @return
     */
    boolean delHotel(@Param("sht") Integer sht);
    boolean delroom(@Param("id")Integer id);

    /***
     * 查询数据库最新添加的一条数据
     * @return
     */
    Product_shopping findNew();

    /***
     * 通过id查购物车的商品
     * @return
     */
    Product_shopping findById(Integer psc_id);

    /***
     * 添加订单
     * @param o
     * @return
     */
    int addOrder(Order o);

    /***
     * 新增订单商品
     * @param op
     * @return
     */
    int addOrderProduct(OProduct op);
    /***
     * 更新订单表的订单状态
     */
    int updOrderState(String order_no);
    int updOrderProductState(String order_no);
}
