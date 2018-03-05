package com.flower.jedis;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.flower.tool.SerializeTool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientSingle implements JedisClient {
   @Autowired 
   JedisPool jedisPool;
   
   public String get(String key){
	   Jedis jedis = jedisPool.getResource();
	   String result = jedis.get(key);
	   jedis.close();
	   return result;
	}

   public Object get(byte[] key){
	   Jedis jedis = jedisPool.getResource();
	   byte[] result = jedis.get(key);   
	   return SerializeTool.unserialize(result);
	}
   
	public String set(byte[] key, Object o) {
		// TODO Auto-generated method stub
		 Jedis jedis = jedisPool.getResource();
		 String result = jedis.set(key, SerializeTool.serialize(o));
		 jedis.close();
		return result;
	}
   
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		 Jedis jedis = jedisPool.getResource();
		 String result = jedis.set(key, value);
		 jedis.close();
		 
		return result;
	}

	public List<String> lrange(String key) {
		// TODO Auto-generated method stub
		 Jedis jedis = jedisPool.getResource();
		 List<String> list = jedis.lrange(key, 0,jedis.llen(key));
		 jedis.close();
		return list;
	}
	
	public long del(String... key) {
		// TODO Auto-generated method stub
		 Jedis jedis = jedisPool.getResource();
		 long l = jedis.del(key);
		 jedis.close();
		return l;
	}


	
}
