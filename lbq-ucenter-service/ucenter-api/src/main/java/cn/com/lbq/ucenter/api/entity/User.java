package cn.com.lbq.ucenter.api.entity;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
* @Description:    
* @Author: liboqing
* @CreateDate: 2019/4/30 10:48
*/

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 删除标记
     */
    private String delFlag;

    public User() {
    }

}