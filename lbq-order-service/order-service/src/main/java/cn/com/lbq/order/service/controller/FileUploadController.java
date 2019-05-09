package cn.com.lbq.order.service.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/5 16:36
 */
@RestController
public class FileUploadController {

    @PostMapping(value = "/file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUploadServer(MultipartFile file ) throws Exception{


        return file.getOriginalFilename();
    }

}
