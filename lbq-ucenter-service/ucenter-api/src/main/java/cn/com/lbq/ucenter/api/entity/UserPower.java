package cn.com.lbq.ucenter.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  user_power
 * @author liboqing 2019-05-05
 */
@Data
public class UserPower implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 证件正面图片url
     */
    private String attachmentFrontUrl;

    /**
     * 证件反面图片url
     */
    private String attachmentBackUrl;

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

    public UserPower() {
    }

}
