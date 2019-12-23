package cn.zyx.product_service.controller;

import cn.zyx.product_service.domain.Product;
import cn.zyx.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 * @author ZYX'sDay
 */
@RestController
@RequestMapping("/product")
public class ProductController {


    @Value("${server.port}")
    private String port;

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
        Product product = productService.getById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);

        result.setName(result.getName()+"data from port="+port);
        return result;
    }
}
