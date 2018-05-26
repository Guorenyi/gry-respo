package cn.mldn.util.web;

import java.util.Base64;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	// 每一个cookie数据最多保存30天的时间
	private static final int MAX_AGE = (int) TimeUnit.SECONDS.convert(30, TimeUnit.DAYS);
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CookieUtil(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	/**
	 * 清除保存的member的数据信息
	 */
	public void cleanMid() {
		Cookie cookie = new Cookie("member", "www.mldn.cn");
		cookie.setPath(this.request.getContextPath());
		cookie.setMaxAge(0);
		this.response.addCookie(cookie); // 保存Cookie的数据
	}

	/**
	 * 向Cooke之中保存有mid的数据信息，但是这个mid在进行保存的时候应该考虑加密处理
	 * 
	 * @param mid
	 *            要保存的用户百年好
	 */
	public void saveMid(String mid) {
		Cookie cookie = new Cookie("member", CookieEncrypt.encrypt(mid));
		cookie.setPath(this.request.getContextPath());
		// 转换之后的类型为long，而setMaxAge()需要的是int类型
		cookie.setMaxAge(MAX_AGE);
		this.response.addCookie(cookie); // 保存Cookie的数据
	}

	/**
	 * 通过Cookie读取保存的用户名
	 * 
	 * @return 返回保存的用户名，如果没有保存返回null
	 */
	public String loadMid() {
		Cookie cookie[] = this.request.getCookies();
		if (cookie == null) {
			return null;
		}
		for (int x = 0; x < cookie.length; x++) {
			if ("member".equals(cookie[x].getName())) {
				return CookieEncrypt.decrypt(cookie[x].getValue()); // 取得用户名
			}
		}
		return null;
	}

	private static class CookieEncrypt { // 实现Cookie数据的加密处理
		private static final int REPEAT = 5; // 重复加密的次数

		public static String encrypt(String str) {
			byte data[] = str.getBytes();
			for (int x = 0; x < REPEAT; x++) {
				data = Base64.getEncoder().encode(data);
			}
			return new String(data);
		}

		public static String decrypt(String str) {
			byte data[] = str.getBytes();
			for (int x = 0; x < REPEAT; x++) {
				data = Base64.getDecoder().decode(data);
			}
			return new String(data);
		}
	}
}
