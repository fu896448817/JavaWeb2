package com.javaweb.util.core;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class NumberFormatUtil {
	
	/**
	BigDecimal bigDecimal = new BigDecimal("0.000");bigDecimal.setScale(3,RoundingMode.HALF_UP);
	注意:toString()最终的结果并不一定是理想中的精度结果,建议采用类似bigDecimal.floatValue()的写法
	*/
	
	//保留小数位数(new DecimalFormat("#,##0.00").format(number))
	public static String roundNumber(Object number,int degree){
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setMaximumFractionDigits(degree);
		return numberFormat.format(number);
	}
	
	//保留小数位数(new DecimalFormat("#,##0.00").format(number))
	public static String roundNumber(Object number,int degree,RoundingMode roundingMode){
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setMaximumFractionDigits(degree);
		numberFormat.setRoundingMode(roundingMode);
		return numberFormat.format(number);
	}

}
