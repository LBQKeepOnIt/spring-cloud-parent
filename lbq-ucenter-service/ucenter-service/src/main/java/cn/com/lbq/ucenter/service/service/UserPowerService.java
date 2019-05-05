package cn.com.lbq.ucenter.service.service;

import cn.com.lbq.ucenter.api.entity.UserPower;
import cn.com.lbq.ucenter.service.mapper.UserPowerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/5 10:55
 */
@Service
public class UserPowerService {

    @Resource
    private UserPowerMapper userPowerMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void saveUserPower(UserPower userPower) {
        UserPower up1 = new UserPower();
        up1.setRealName("transpo3");
        up1.setIdNumber("123456");
        userPowerMapper.insert(up1);

        UserPower up2 = new UserPower();
        up2.setRealName("transpo4");
//        up2.setIdNumber("1222222");
        userPowerMapper.insert(up2);
    }
}
