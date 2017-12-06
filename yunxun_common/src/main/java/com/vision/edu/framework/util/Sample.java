package com.vision.edu.framework.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;

public class Sample {
	//设置APPID/AK/SK
    public static final String APP_ID = "9944271";
    public static final String API_KEY = "fxVyEeBml50iHoX0hqCKg9c9";
    public static final String SECRET_KEY = "d415acafbc3ba67dcdae5029c44acfed";
    public static void main(String[] args) throws IOException {
        // 初始化一个FaceClient
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用API
    }
    

    public static String getAudio(String text){
        // 初始化一个FaceClient
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "2");//语速，取值0-9，默认为5中语速
        //options.put("pit", "5");//音调，取值0-9，默认为5中语调	
        //options.put("per", "4");//发音人选择, 0为女声，1为男声，3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女
        TtsResponse res1 = client.synthesis(text, "zh", 1, options);
        System.out.println(res1.getErrorCode());
        byte[] data = res1.getData();
        try {
            /*String path = "D:/";
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            File tempWav = new File(file, "temp.wav");
            if (!tempWav.exists())
                tempWav.createNewFile();
            FileOutputStream fos = new FileOutputStream(tempWav);
            fos.write(data);
            fos.flush();
            fos.close();*/
            String uuid = UUID.randomUUID().toString();
            String postFix = ".wav";
            String fileName = uuid + postFix;
            UploadUtil.remove2Sftp(data, "audio", fileName);
            return fileName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "出错了";
    }
}
