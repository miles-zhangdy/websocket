package com.ssm.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtils implements Serializable{
	
	private static final long serialVersionUID = 5992055343904383832L;

	public static <T> T copyBeanToBean(Object bean, Class<T> clazz) {
		Method[] method1 = bean.getClass().getMethods();
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Method[] method2 = t.getClass().getMethods();
		String methodName1 = "";
		String methodFix1 = "";
		String methodName2 = "";
		String methodFix2 = "";
		for (int i = 0; i < method1.length; i++) {
			methodName1 = method1[i].getName();
			methodFix1 = methodName1.substring(3, methodName1.length());
			if (methodName1.startsWith("get")) {
				for (int j = 0; j < method2.length; j++) {
					methodName2 = method2[j].getName();
					methodFix2 = methodName2.substring(3, methodName2.length());
					if (methodName2.startsWith("set")) {
						if (methodFix2.equals(methodFix1)) {
							Object[] objs1 = new Object[0];
							Object[] objs2 = new Object[1];
							try {
								objs2[0] = method1[i].invoke(bean, objs1);
								method2[j].invoke(t, objs2);
							} catch (Exception e) {
								e.printStackTrace();
							}
							continue;
						}
					}
				}
			}
		}
		return t;
	}

	public static <T> List<T> listTransfer(List<?> list, Class<T> t) {
		List<T> newList = new ArrayList<T>();
		for (Object object : list) {
			newList.add(copyBeanToBean(object, t));
		}
		return newList;

	}

	public static Map<String, Object> objectToMap(Object bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(bean.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			Method getter = property.getReadMethod();
			Object value = null;
			try {
				value = getter.invoke(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put(key, value);
		}
		return map;
	}
	
	public static void transMap2Bean(Object bean, Map<String, Object> map) {

		if (null == bean || null == map) {
			return;
		}

		try {
			PropertyDescriptor[] propertyDescriptors = propertyDescriptor(bean);
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (map.containsKey(key)) {
					Object value = map.get(key);
					Method setter = property.getWriteMethod();
					if (null != setter) {
						setter.invoke(bean, value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static PropertyDescriptor[] propertyDescriptor(Object obj)
			throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		return beanInfo.getPropertyDescriptors();
	}
}