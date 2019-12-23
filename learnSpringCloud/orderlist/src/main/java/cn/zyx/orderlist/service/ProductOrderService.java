package cn.zyx.orderlist.service;

import cn.zyx.orderlist.domain.ProductOrder;

/**
 * description: 订单业务接口<br>
 * date: 2019/12/18 14:58 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public interface ProductOrderService {

    /**
     * 用户下单接口
     * @param userId
     * @param productId
     * @return
     */
    ProductOrder saveOrder(int userId,int productId);
}
