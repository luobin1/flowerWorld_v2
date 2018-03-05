package com.flower.tool;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * ������֤��ӿ�
 * Created by Administrator on 2017/8/14.
 */
public class SendMassage {
	@SuppressWarnings("unused")
	private String phone;
	@SuppressWarnings("unused")
	private String code;
    //��Ʒ����:��ͨ�Ŷ���API��Ʒ,�����������滻
    static final String product = "Dysmsapi";
    //��Ʒ����,�����������滻
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO �˴���Ҫ�滻�ɿ������Լ���AK(�ڰ����Ʒ��ʿ���̨Ѱ��)
    static final String accessKeyId = "LTAIDwOjS1aZWC5M";
    static final String accessKeySecret = "R1zur600bU6Ik3buGV389diu131Xv7";


    public static SendSmsResponse sendSms(String phone,String code) throws ClientException {

        //������������ʱʱ��
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //��ʼ��acsClient,�ݲ�֧��region��
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //��װ�������-��������������̨-�ĵ���������
        SendSmsRequest request = new SendSmsRequest();
        //����:�������ֻ���
        request.setPhoneNumbers(phone);
        //����:����ǩ��-���ڶ��ſ���̨���ҵ�
        request.setSignName("MFW��������");
        //����:����ģ��-���ڶ��ſ���̨���ҵ�
        request.setTemplateCode("SMS_105905021");
        //��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"�װ���${name},������֤��Ϊ${code}"ʱ,�˴���ֵΪ
        request.setTemplateParam("{\"code\":\""+code+"\"}");

        //ѡ��-���ж�����չ��(�����������û�����Դ��ֶ�)
        //request.setSmsUpExtendCode("90997");

        //��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������
        request.setOutId("yourOutId");

        //hint �˴����ܻ��׳��쳣��ע��catch
        SendSmsResponse sendSmsResponse=null;
        try {
        	sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return sendSmsResponse;
    }



}
