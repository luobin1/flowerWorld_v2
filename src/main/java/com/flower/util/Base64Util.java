package com.flower.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import sun.misc.BASE64Decoder;
/**
 * base64����
 * @author senly
 *
 */
public class Base64Util {
	 /**
	  * ��Base64 ת��Ϊfile�ļ�
	  * @param imgStr ͼƬ����
	  * @param name ͼƬ����
	  * @return
	  */
	 public static boolean generateImage(String imgStr,String name)  
	    {   //���ֽ������ַ�������Base64���벢����ͼƬ  
	        if (imgStr == null) //ͼ������Ϊ��  
	            return false;  
	        BASE64Decoder decoder = new BASE64Decoder();  
	        try   
	        {  
	            //Base64����  
	            byte[] b = decoder.decodeBuffer(imgStr);  
	            for(int i=0;i<b.length;++i)  
	            {  
	                if(b[i]<0)  
	                {//�����쳣����  
	                    b[i]+=256;  
	                }  
	            }  
	            //����jpegͼƬ  
	            String imgFilePath = FinalParam.uploadpath+name+".jpg";//�����ɵ�ͼƬ  
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
