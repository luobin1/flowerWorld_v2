package com.flower.tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTool {
	
   public static byte[] serialize(Object o){
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	try {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
	    objectOutputStream.writeObject(o);
	    return byteArrayOutputStream.toByteArray();
	} catch (IOException e) {
		return null;
	}
   } 
   
   public static Object unserialize(byte[] bytes){
		
		try {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			return  objectInputStream.readObject();
		    
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	   } 
   
}
