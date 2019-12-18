package cn.zyx.product_service.service;

import cn.zyx.product_service.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 商品服务接口
 * @author ZYX'sDay
 */
@Service
public interface ProductService {

    /**
     * 全表信息
     * @return
     */
    List<Product> listProduct();

    /**
     * 根据id查商品
     * @param id
     * @return
     */
    Product getById(int id);
}
