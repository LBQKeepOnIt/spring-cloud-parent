package cn.com.lbq.order.api.client;

import cn.com.lbq.order.api.config.FeignMultipartSupportConfig;
import cn.com.lbq.spring.cloud.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/30 16:34
 */
@FeignClient(name = ServiceNameConstants.ORDER_SERVICE, configuration = FeignMultipartSupportConfig.class, fallbackFactory = OrderFileUploadClientFallbackFactory.class)
public interface OrderFileUploadClient {

    @RequestMapping(method = RequestMethod.POST, value = "/file/upload",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(@RequestPart(value = "file") MultipartFile file);

}
