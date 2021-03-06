 package com.wanglei.entity;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpringUtils {
	
	public static boolean isBlank(String str) {
		return (str == null || str.trim().equals(""));
	}
	
	public static boolean haveValue(String str) {
		return !(str == null || str.trim().equals(""));
	}
	
	public static boolean isMobile(String str) {
		//�ƶ��绰�ķ�Χ
		String regex = "^((13[0-9])|(14[5|7])|(15[0-3]|[5-9])|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
	}
	
	public static boolean isEmail(String str) {
		String regex = "\\w+([-+.\\w+])*@\\w+([-+.\\\\w+])*\\.\\w+([-+.\\\\w+])*$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
	}
	
	public static String getRandomStr(int n) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			char c = (char)('A' + random.nextInt(26));
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String getRandomCn(int n ) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getRandomCn());
		}
		return sb.toString();
	}
	
	private static char getRandomCn() {
		
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("����");
        }

        return str.charAt(0);
	}
}
