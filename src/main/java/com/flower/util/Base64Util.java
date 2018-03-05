package com.flower.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import sun.misc.BASE64Decoder;
/**
 * base64工具
 * @author senly
 *
 */
public class Base64Util {
	 /**
	  * 将Base64 转换为file文件
	  * @param imgStr 图片数据
	  * @param name 图片名称
	  * @return
	  */
	 public static boolean generateImage(String imgStr,String name)  
	    {   //对字节数组字符串进行Base64解码并生成图片  
	        if (imgStr == null) //图像数据为空  
	            return false;  
	        BASE64Decoder decoder = new BASE64Decoder();  
	        try   
	        {  
	            //Base64解码  
	            byte[] b = decoder.decodeBuffer(imgStr);  
	            for(int i=0;i<b.length;++i)  
	            {  
	                if(b[i]<0)  
	                {//调整异常数据  
	                    b[i]+=256;  
	                }  
	            }  
	            //生成jpeg图片  
	            String imgFilePath = FinalParam.uploadpath+name+".jpg";//新生成的图片  
	            OutputStream out = new FileOutputStream(imgFilePath);      
	            out.write(b);  
	            out.flush();  
	            out.close();  
	            return true;  
	        }   
	        catch (Exception e)   
	        {  
	        	e.printStackTrace();
	            return false;  
	        }  
	    }  

}
