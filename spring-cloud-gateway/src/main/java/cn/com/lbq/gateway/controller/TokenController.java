package cn.com.lbq.gateway.controller;

import cn.com.lbq.gateway.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
	
	@GetMapping("/getToken/{name}")
    public String get(@PathVariable("name") String name)  {
        return JwtUtil.generateToken(name);
    }
	
}
