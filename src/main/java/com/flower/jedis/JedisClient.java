package com.flower.jedis;

import java.util.List;
import java.util.Set;



public interface JedisClient {
	public String get(String key);
	public Object get(byte[] key);
	public String set(String key,String value);
	public String set(byte[] key, Object o);
	public List<String> lrange(String key);
	public long del(String... key);
	
	
}
