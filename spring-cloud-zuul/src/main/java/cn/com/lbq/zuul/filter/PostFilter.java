package cn.com.lbq.zuul.filter;

import cn.com.lbq.core.exception.BaseException;
import cn.com.lbq.core.exception.BaseExceptionBody;
import cn.com.lbq.core.exception.CommonError;
import cn.com.lbq.core.vo.User;
import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

@Slf4j
public class PostFilter extends ZuulFilter {
	
	@Override
	public String filterType() {
		return POST_TYPE;
	}
	
	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("这是PostFilter！");
		//从RequestContext获取上下文
		RequestContext ctx = RequestContext.getCurrentContext();
		//处理返回中文乱码
		ctx.getResponse().setCharacterEncoding("UTF-8");
		//获取上下文中保存的responseBody
		String responseBody = ctx.getResponseBody();
		//如果responseBody不为空，则说明流程有异常发生
		if (null != responseBody) {
			//设定返回状态码
			ctx.setResponseStatusCode(500);
			//替换响应报文
	        ctx.setResponseBody(responseBody);
		}

		//校验用户
		authUser(ctx);

		return null;
	}

	public static void authUser(RequestContext ctx) {
		HttpServletRequest request = ctx.getRequest();
		Map<String, String> header = httpRequestToMap(request);
		String userId = header.get(User.CONTEXT_KEY_USERID);
		if(StringUtils.isEmpty(userId)) {
			try {
				BaseException BaseException = new BaseException(CommonError.AUTH_EMPTY_ERROR.getCode(),CommonError.AUTH_EMPTY_ERROR.getCodeEn(),CommonError.AUTH_EMPTY_ERROR.getMessage(),1L);
				BaseExceptionBody errorBody = new BaseExceptionBody(BaseException);
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(401);
				ctx.setResponseBody(JSONObject.toJSON(errorBody).toString());
			} catch (Exception e) {
				log.error("println message error",e);
			}
		}else {
			for (Map.Entry<String, String> entry : header.entrySet()) {
				ctx.addZuulRequestHeader(entry.getKey(), entry.getValue());
			}
		}
	}

	private static Map<String, String> httpRequestToMap(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();
		Map<String, String> headers = new HashMap<>();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			headers.put(headerName, request.getHeader(headerName));
		}
		return headers;
	}
}
