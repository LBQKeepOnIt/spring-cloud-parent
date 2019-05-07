package cn.com.lbq.order.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String id;

    private String orderSeqNo;

    private String orderName;

    private String orderPrice;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String remarks;

    private String delFlag;

    private String userId;
}