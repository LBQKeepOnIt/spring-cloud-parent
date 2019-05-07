package cn.com.lbq.order.service.mapper;

import cn.com.lbq.order.api.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订单表
 * @author liboqing 2019-05-06
 */
@Component
public interface OrderMapper {

    /**
     * 新增
     */
    public int insert(@Param("order") Order order);

    /**
     * 删除
     */
    public int delete(@Param("id") int id);

    /**
     * 更新
     */
    public int update(@Param("order") Order order);

    /**
     * Load查询
     */
    public Order load(@Param("id") int id);

    /**
     * 分页查询Data
     */
    public List<Order> pageList(@Param("offset") int offset,
                                @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

    Order getOrderById(@Param("id") String id);
}