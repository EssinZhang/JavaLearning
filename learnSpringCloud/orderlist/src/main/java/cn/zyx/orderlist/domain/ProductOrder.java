package cn.zyx.orderlist.domain;

import java.util.Date;

/**
 * description: ProductOrder <br>
 * date: 2019/12/18 14:44 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class ProductOrder {

    /**
     * 订单id
     */
    private int id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 订单交易号
     */
    private String tradeNo;
    /**
     * 价格
     */
    private int price;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 买家用户id
     */
    private int UserId;
    /**
     * 买家用户姓名
     */
    private String userName;

    public ProductOrder() {
    }

    public ProductOrder(int id, String productName, String tradeNo, int price, Date createTime, int userId, String userName) {
        this.id = id;
        this.productName = productName;
        this.tradeNo = tradeNo;
        this.price = price;
        this.createTime = createTime;
        UserId = userId;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
