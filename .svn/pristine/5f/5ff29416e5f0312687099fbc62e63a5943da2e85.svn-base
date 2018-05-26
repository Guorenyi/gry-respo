package cn.mldn.util.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidateRuleAnnotation {
	//是否必填
	public boolean mandatory() default false;
	//长度,-1表示不判断长度
	public int length() default -1;
	//检查值的范围，如“1:100”,表示最小值为1，最大值为100
	public String between()    default "";
	//值的枚举值，比如性别检查：“男:女”
	public String contains() default "";
	//数据格式 ,可以用正则表达式
	public String formatRegex() default "";
	
}
