package chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description RequirementDemo01
 * @Author ZhangYixin
 * @Date 2020/10/21 9:35
 * @Version 1.0
 */
public class RequirementDemo01 {

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

        // 交集
        List<VideoOrder> result1 = videoOrders1.stream().filter(obj -> videoOrders2.contains(obj)).collect(Collectors.toList());
        System.out.println("交集："+result1);

        // 差集
        List<VideoOrder> result2forDiff = videoOrders1.stream().filter(obj -> !videoOrders2.contains(obj)).collect(Collectors.toList());
        List<VideoOrder> result3forDiff = videoOrders2.stream().filter(obj -> !videoOrders1.contains(obj)).collect(Collectors.toList());
        System.out.println("订单1的差集："+result2forDiff);
        System.out.println("订单2的差集："+result3forDiff);

        // 去重并集
        // 先拿到所有的并集 为不影响原集合所以不能直接用addAll()
        List<VideoOrder> midList = videoOrders1.parallelStream().collect(Collectors.toList());
        midList.addAll(videoOrders2);
        List<VideoOrder> resultForAll = midList.stream().distinct().collect(Collectors.toList());
        System.out.println("订单去重并集："+resultForAll);

        // 订单平均价格
        Double order1Average = videoOrders1.stream().collect(Collectors.averagingInt(VideoOrder::getMoney));
        System.out.println("订单1平均价格："+order1Average);
        Double order2Average = videoOrders2.stream().collect(Collectors.averagingInt(VideoOrder::getMoney));
        System.out.println("订单2平均价格："+order2Average);

        // 订单总价
        int order1Sum = videoOrders1.stream().collect(Collectors.summingInt(VideoOrder::getMoney)).intValue();
        System.out.println("订单1总价格："+order1Sum);
        int order2Sum = videoOrders2.stream().collect(Collectors.summingInt(VideoOrder::getMoney)).intValue();
        System.out.println("订单1总价格："+order2Sum);
    }

}
