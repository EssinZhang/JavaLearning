package chapter6;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description 电商订单数据处理，根据下⾯的list1和list2 各10个订单
 *                  统计出同时被两个⼈购买的商品列表(交集)
 *                  统计出两个⼈购买商品的差集
 *                  统计出全部被购买商品的去重并集
 *                  统计两个⼈的分别购买订单的平均价格
 *                  统计两个⼈的分别购买订单的总价格
 * @Author ZhangYixin
 * @Date 2020/10/20 11:07
 * @Version 1.0
 */
public class Requirement1 {
    public static void main(String[] args) {
        // 总价 35
        List<VideoOrder> videoOrders1 = Arrays.asList(new VideoOrder("20190242812", "springboot教程", 3),
                new VideoOrder("20194350812", "微服务SpringCloud", 5),
                new VideoOrder("20190814232", "Redis教程", 9),
                new VideoOrder("20190523812", "⽹⻚开发教程", 9),
                new VideoOrder("201932324", "百万并发实战Netty", 9));
        // 总价 54
        List<VideoOrder> videoOrders2 = Arrays.asList(new VideoOrder("2019024285312", "springboot教程", 3),
                new VideoOrder("2019081453232", "Redis教程", 9),
                new VideoOrder("20190522338312", "⽹⻚开发教程", 9),
                new VideoOrder("2019435230812", "Jmeter压⼒测试", 5),
                new VideoOrder("2019323542411", "Git+Jenkins持续集成", 7),
                new VideoOrder("2019323542424", "Idea全套教程", 21));

        List<VideoOrder> sameVideoOrders = matchingSame(videoOrders1, videoOrders2);
        System.out.println("两订单相同商品："+sameVideoOrders);

        // 差集
        List<VideoOrder> videoOrdersDifferent1 = matchingDifferent(videoOrders1, videoOrders2);
        List<VideoOrder> videoOrdersDifferent2 = matchingDifferent(videoOrders2, videoOrders1);
        System.out.println("订单1——两订单不同商品："+videoOrdersDifferent1);
        System.out.println("订单2——两订单不同商品："+videoOrdersDifferent2);

        // 并集
        List<VideoOrder> videoOrdersAll = matchingAll(videoOrders1, videoOrders2);
        System.out.println("两订单商品集合种类："+videoOrdersAll);

        // 订单价格计算
        IntSummaryStatistics video1 = videoOrders1.stream().collect(Collectors.summarizingInt(obj -> obj.getMoney()));
        IntSummaryStatistics video2 = videoOrders2.stream().collect(Collectors.summarizingInt(obj -> obj.getMoney()));
        System.out.println("订单1平均价格："+video1.getAverage()+"------订单2平均价格："+video2.getAverage());
        System.out.println("订单1总价："+video1.getSum()+"------订单2总价："+video2.getSum());
    }

    /**
     * 一个找出两个订单中相同商品的方法并返回
     * @param inputA
     * @param inputB
     * @return
     */
    public static List<VideoOrder> matchingSame(List<VideoOrder> inputA,List<VideoOrder> inputB){
        ArrayList<VideoOrder> result = new ArrayList<>();
        inputA.forEach(obj1 ->{
            boolean match = inputB.stream().anyMatch(obj2 -> obj2.getTitle().equals(obj1.getTitle()));
            if (match) {
                result.add(obj1);
            }
        });
        return result;
    }

    /**
     * 取两订单的差集
     * @param inputA
     * @param inputB
     * @return
     */
    public static List<VideoOrder> matchingDifferent (List<VideoOrder> inputA,List<VideoOrder> inputB){
        ArrayList<VideoOrder> result = new ArrayList<>();
        inputA.forEach(obj1 ->{
            boolean match = inputB.stream().anyMatch(obj2 -> obj2.getTitle().equals(obj1.getTitle()));
            if (!match) {
                result.add(obj1);
            }
        });
        return result;
    }

    /**
     *  取并集的方法就是将交集和差集的结果整合到一块   我觉得这样有点憨
     * @param inputA
     * @param inputB
     * @return
     */
    public static List<VideoOrder> matchingAll (List<VideoOrder> inputA,List<VideoOrder> inputB){
        List<VideoOrder> result1 = matchingSame(inputA, inputB);
        List<VideoOrder> result2 = matchingDifferent(inputA, inputB);
        List<VideoOrder> result3 = matchingDifferent(inputB, inputA);
        result1.addAll(result2);
        result1.addAll(result3);
        return result1;
    }
}
