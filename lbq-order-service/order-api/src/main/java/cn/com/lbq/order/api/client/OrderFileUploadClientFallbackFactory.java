package cn.com.lbq.order.api.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/30 16:40
 */
@Component
@Slf4j
public class OrderFileUploadClientFallbackFactory implements FallbackFactory<OrderFileUploadClient> {

    @Override
    public OrderFileUploadClient create(Throwable throwable) {
        return new OrderFileUploadClient() {
            @Override
            public String fileUpload(MultipartFile file) {
                log.error("文件上传失败", throwable);
                throw new RuntimeException("文件上传失败");
            }
        };

    }
}