package cn.mldn.util.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAnnotation {
	public String isKeyCol() default "";
	public String isAutoIncrease() default "";
	public String existMultiValue() default "false";
	/**
	 * 可以根据一个字段的值取得另外一个VO对象，如A对象有一个字段 "abid", 现在想在创建A对象的同时根据bid获得B对象，则可以设置如下
	 * "abid:bid"
	 * 
	 */
	public String dependencyField() default "";
}
