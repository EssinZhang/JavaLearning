package chapter6;

/**
 * @Description VideoOrder
 * @Author ZhangYixin
 * @Date 2020/10/20 11:09
 * @Version 1.0
 */
public class VideoOrder {

    private String tradeNO;

    private int money;

    private String title;

    public VideoOrder() {
    }

    public VideoOrder(String tradeNO, String title, int money) {
        this.tradeNO = tradeNO;
        this.money = money;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VideoOrder){
            return this.title.equals(((VideoOrder) obj).getTitle());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.title.hashCode();
    }

    public String getTradeNO() {
        return tradeNO;
    }

    public void setTradeNO(String tradeNO) {
        this.tradeNO = tradeNO;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "title='" + title +
                ", money=" + money + '\'' +
                '}';
    }
}
