package cn.zyx.service;


import javax.jms.Destination;

/**
 * 消息生产
 */

public interface ProducerService {
    /**
     * 指定消息队列，还有消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, final String message);

    /**
     * 使用默认消息队列，发送消息
     * @param message
     */
    public void sendMessage(final String message);

    /**
     * 消息发布者
     * @param msg
     */
    public void publish(String msg);
}
