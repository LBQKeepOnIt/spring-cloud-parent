//package cn.com.lbq.core.intercepter;
//import cn.springcloud.book.common.vo.User;
//
//public class UserContextHolder {
//	public static ThreadLocal<User> context = new ThreadLocal<User>();
//	public static User currentUser() {
//		return context.get();
//	}
//	public static void set(User user) {
//		context.set(user);
//	}
//	public static void shutdown() {
//		context.remove();
//	}
//}
