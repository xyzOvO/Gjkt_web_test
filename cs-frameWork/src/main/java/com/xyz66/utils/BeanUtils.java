package com.xyz66.utils;

import org.springframework.beans.BeanWrapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Bean 工具类
 *
 * @author ruoyi
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {
	/**
	 * Bean方法名中属性名开始的下标
	 */
	private static final int BEAN_METHOD_PROP_INDEX = 3;

	/**
	 * 匹配getter方法的正则表达式
	 */
	private static final Pattern GET_PATTERN = Pattern.compile("get(\\p{javaUpperCase}\\w*)");

	/**
	 * 匹配setter方法的正则表达式
	 */
	private static final Pattern SET_PATTERN = Pattern.compile("set(\\p{javaUpperCase}\\w*)");

	/**
	 * Bean属性复制工具方法。
	 *
	 * @param dest 目标对象
	 * @param src  源对象
	 */
	public static void copyBeanProp(Object dest, Object src) {
		try {
			copyProperties(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Copy the property values of the given source bean into the given target bean,
	 * ignoring the given "ignoreProperties".
	 * <p>Note: The source and target classes do not have to match or even be derived
	 * from each other, as long as the properties match. Any bean properties that the
	 * source bean exposes but the target bean does not will silently be ignored.
	 * <p>This is just a convenience method. For more complex transfer needs,
	 * consider using a full {@link BeanWrapper}.
	 * <p>As of Spring Framework 5.3, this method honors generic type information
	 * when matching properties in the source and target objects. See the
	 * documentation for {@link #copyProperties(Object, Object)} for details.
	 *
	 * @param source           the source bean
	 * @param target           the target bean
	 * @param ignoreProperties array of property names to ignore
	 * @return target
	 * @see BeanWrapper
	 */
	public static <S, T> T copyPropertiesAndGetTarget(S source, T target, String... ignoreProperties) {
		if (source == null) {
			return target;
		}
		copyProperties(source, target, ignoreProperties);
		return target;
	}

	/**
	 * 将一个集合转换成指定泛型的集合
	 *
	 * @param sources 带转换的集合
	 * @param cls     目标集合泛型
	 * @param <T>     目标泛型
	 * @return
	 */
	public static <T> List<T> transform(Collection<?> sources, Class<T> cls) {
		return transform(sources, cls, new String[]{});
	}

	/**
	 * 变换
	 * 将一个集合转换成指定泛型的集合
	 *
	 * @param sources          带转换的集合
	 * @param cls              目标集合泛型
	 * @param ignoreProperties 忽略属性
	 * @return {@link List}<{@link T}>
	 */
	public static <T> List<T> transform(Collection<?> sources, Class<T> cls, String... ignoreProperties) {
		return Optional.ofNullable(sources)
				.orElse(Collections.emptyList())
				.stream()
				.map(d -> getT(cls, d, ignoreProperties))
				.collect(Collectors.toList());
	}

	/**
	 * gett
	 *
	 * @param cls              cls
	 * @param d                d
	 * @param ignoreProperties 忽略属性
	 * @return {@link T}
	 */
	private static <T> T getT(Class<T> cls, Object d, String... ignoreProperties) {
		try {
			return copyPropertiesAndGetTarget(d, cls.getDeclaredConstructor().newInstance(), ignoreProperties);
		} catch (InstantiationException
				| IllegalAccessException
				| InvocationTargetException
				| NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取对象的setter方法。
	 *
	 * @param obj 对象
	 * @return 对象的setter方法列表
	 */
	public static List<Method> getSetterMethods(Object obj) {
		// setter方法列表
		List<Method> setterMethods = new ArrayList<Method>();

		// 获取所有方法
		Method[] methods = obj.getClass().getMethods();

		// 查找setter方法

		for (Method method : methods) {
			Matcher m = SET_PATTERN.matcher(method.getName());
			if (m.matches() && (method.getParameterTypes().length == 1)) {
				setterMethods.add(method);
			}
		}
		// 返回setter方法列表
		return setterMethods;
	}

	/**
	 * 获取对象的getter方法。
	 *
	 * @param obj 对象
	 * @return 对象的getter方法列表
	 */

	public static List<Method> getGetterMethods(Object obj) {
		// getter方法列表
		List<Method> getterMethods = new ArrayList<Method>();
		// 获取所有方法
		Method[] methods = obj.getClass().getMethods();
		// 查找getter方法
		for (Method method : methods) {
			Matcher m = GET_PATTERN.matcher(method.getName());
			if (m.matches() && (method.getParameterTypes().length == 0)) {
				getterMethods.add(method);
			}
		}
		// 返回getter方法列表
		return getterMethods;
	}

	/**
	 * 检查Bean方法名中的属性名是否相等。<br>
	 * 如getName()和setName()属性名一样，getName()和setAge()属性名不一样。
	 *
	 * @param m1 方法名1
	 * @param m2 方法名2
	 * @return 属性名一样返回true，否则返回false
	 */

	public static boolean isMethodPropEquals(String m1, String m2) {
		return m1.substring(BEAN_METHOD_PROP_INDEX).equals(m2.substring(BEAN_METHOD_PROP_INDEX));
	}
}
