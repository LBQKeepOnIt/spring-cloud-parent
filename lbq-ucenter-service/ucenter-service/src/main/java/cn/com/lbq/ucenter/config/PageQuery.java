package cn.com.lbq.ucenter.config;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.CaseFormat;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * 带分页的信息列表封装类
 *
 * @author shide
 * @date 2017/12/10
 */
@ApiModel
@Slf4j
public class PageQuery<T> extends Page<T> {
    private static final String PAGE = "page";
    private static final String LIMIT = "limit";
    private static final String ORDER_BY_FIELD = "orderByField";
    private static final String IS_ASC = "isAsc";

    /**
     * 查询参数（ 不会传入到 xml 层，这里是 Controller 层与 service 层传递参数预留 ）
     */
    private Map<String, Object> condition;

    public PageQuery() {
    }

    public PageQuery(Map<String, Object> params) {
        super(Integer.parseInt(params.getOrDefault(PAGE, 1).toString())
                , Integer.parseInt(params.getOrDefault(LIMIT, 10).toString()));

        String orderByField = params.getOrDefault(ORDER_BY_FIELD, "").toString();
        log.info("排序字段：{}" + orderByField);

        if (StringUtils.isNotEmpty(orderByField)) {
            orderByField = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, orderByField);

            log.info("排序字段格式化后：{}" + orderByField);

            Boolean isAsc = Boolean.parseBoolean(params.getOrDefault(IS_ASC, Boolean.TRUE).toString());

            if (isAsc) {
                setAsc(orderByField);
            } else {
                setDesc(orderByField);
            }
        }

        params.remove(PAGE);
        params.remove(LIMIT);
        params.remove(ORDER_BY_FIELD);
        params.remove(IS_ASC);

        //查询条件
        this.setCondition(params);
    }

    public Page<T> setCondition(Map<String, Object> condition) {
        this.condition = condition;
        return this;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }
}
