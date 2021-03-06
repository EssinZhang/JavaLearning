package cn.zyx.product_service.controller;

import cn.zyx.product_service.domain.Product;
import cn.zyx.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 控制层
 * @author ZYX'sDay
 */
@RestController
@RequestMapping("/product")
@RefreshScope
public class ProductController {


    @Value("${server.port}")
    private String port;

    @Value("${env}")
    private String env;

    @Autowired
    private ProductService productService;

    /**
     * 获得所有商品信息
     * @return
     */
    @RequestMapping("productList")
    public Object productList(){
        return productService.listProduct();
    }

    /**
     * 根据di查询商品
     * @param id
     * @return
     */
    @RequestMapping("getById")
    public Object getProductById(int id){
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Product product = productService.getById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);

        result.setName(result.getName()+"data from port="+port+" env: "+env);
        return result;
    }
}
