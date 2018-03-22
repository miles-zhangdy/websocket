package com.ssm.common.redis;

import java.util.Collection;
import java.util.Set;

public interface SpringRedisClient {
	
	/**
	 * 存入缓存
	 * @author zhangdaye
	 */
	public void setKey(String key, Object value);
	/**
	 * 获取缓存信息
	 * @author zhangdaye
	 */
	public Object getKey(String key);

	/**
	 * 自增
	 * 
	 * @param key
	 */
	public void incr(String key);

	/**
	 * 在上一个元素的左边存
	 * 
	 * @param key
	 * @param value
	 */
	public void lPush(String key, String value);

	/**
	 * 查看是否有这个键
	 * 
	 * @param key
	 * @return
	 */
	public boolean checkKey(String key);

	/**
	 * 按键取
	 * 
	 * @param key
	 * @return
	 */
	public Object lIndex(String key);

	/**
	 * 求长度
	 * 
	 * @param key
	 * @return
	 */
	public Long lLength(String key);

	/**
	 * 从上一个元素的左边取值
	 * 
	 * @param key
	 * @return
	 */
	public String lPop(String key);

	/**
	 * 按正则表达式匹配的键取值
	 * 
	 * @param pattern
	 * @return
	 */
	public Set<String> getKeys(String pattern);

	/**
	 * 
	 * @Description: remove
	 * @param @param key
	 * @return void
	 * @throws
	 * @author zhangdaye
	 * @date 2016-5-30
	 */
	public void deleteKey(String key);

	/**
	 * 
	 * @Description: 批量移除
	 * @param @param keys
	 * @return void
	 * @throws
	 * @author zhangdaye
	 * @date 2016-5-30
	 */
	public void deleteKeys(Collection<String> keys);

}
