package cn.yh.dao.util;

import java.math.BigDecimal;

public class MathUtil {
	/**
	 * 实现四舍五入
	 * @param num 被四舍五入的数字
	 * @param scale 保留的小数位
	 * @return
	 */
	public static double round(double num,int scale) {
		return new BigDecimal(num).divide(new BigDecimal(1),scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	} 
}
