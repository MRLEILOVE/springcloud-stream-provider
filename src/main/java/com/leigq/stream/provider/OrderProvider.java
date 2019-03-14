package com.leigq.stream.provider;

import com.leigq.stream.entity.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * Stream 实现消息提供者(发送订单消息)
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-13 14:18 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@EnableBinding(value = Source.class)
@Slf4j
public class OrderProvider {

    /*
    * 这里的注入需要注意:
    * 1, 如果使用 @Autowired（按照类型进行注入），则需要使用 @Qualifier 注解配合使用，因为 MessageChannel 接口有多个示例实现
    * 2, 如果使用 @Resource （按照名称进行注入），则需要注入时名称为 output
    * */
//    @Autowired
//    @Qualifier("output")
    @Resource
    private MessageChannel output;

    /**
     * 实现消息的发送，本次发送的消息是一个订单对象（自动变为json）
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-13 14:19
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     */
    public void sendOrder(OrderMaster order) {
        /*
        * 发送消息
        * 需要注意的是withPayload方法你可以传入任何类型的对象，但是需要实现序列化接口
        * */
        output.send(MessageBuilder.withPayload(order).build());
        log.warn("消息发送成功......");
    }

}
