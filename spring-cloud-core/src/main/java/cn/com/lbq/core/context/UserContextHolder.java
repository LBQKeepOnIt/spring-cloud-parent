package cn.com.lbq.core.context;

import cn.com.lbq.core.vo.User;

/**
 * 用户上下文
 * @author zhudeming
 */
public class UserContextHolder {
	
	public static ThreadLocal<User> context = new ThreadLocal<User>();
	
	public static User currentUser() {
		return context.get();
	}

	public static void set(User user) {
		context.set(user);
	}

	public static void shutdown() {
		context.remove();
	}
	
}
