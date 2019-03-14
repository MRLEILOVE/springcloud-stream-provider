package com.leigq.stream.controller;

import com.leigq.stream.entity.OrderMaster;
import com.leigq.stream.provider.OrderProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-07 09:58 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@RestController
public class OrderProviderController {

    @Resource
    private OrderProvider orderProvider;

    /**
     * 发送订单消息
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-07 10:16
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     * @param orderMaster 订单实体
     * @return
     */
    @GetMapping("/orders")
    public String saveOrders(OrderMaster orderMaster) {
        //这里写死测试
        OrderMaster master = new OrderMaster();
        master.setCode("ABC123");
        master.setAmount(new BigDecimal("10"));
        master.setStatus(false);
        master.setId(2L);
        master.setCreateTime(new Date());
        master.setUpdateTime(new Date());
        orderProvider.sendOrder(master);
        // 测试成功，可以发送消息到RabbitMQ
        return "Ok";
    }


}
