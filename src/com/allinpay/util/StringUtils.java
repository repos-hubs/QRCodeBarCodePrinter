package com.allinpay.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class StringUtils {
	
	public static int DEFAULT_STRING_LENGTH = 12;

	/**
	 * @Title: stringFormat
	 * @Description: ��ʽ���ַ��ȣ���������
	 * 				��ʾʡ�Ժ�,��ֺ��ָ���ĸ������2���ֽڣ���ĸ����һ���ֽ�.
	 * @param str Ҫ��ʽ�����ַ�
	 * @param n �����ֽ���
	 * @return
	 * @return: String
	 */
	public static String stringFormat(String str, int n) {
		
		String temp = "";

		try {
			// ���ȱ���Ҫ�ĳ���nС���Ǹ�����,ֱ�ӷ���ԭ�ַ�
			Log2.d("printer str fortmat:", "length:" + str.getBytes("GBK").length);
			if (str.getBytes("GBK").length <= DEFAULT_STRING_LENGTH || isDouble(str)) {
			
				return str;
			} else {
				int num = 0;
				char[] charArray = str.toCharArray();
				for (int i = 0; i < charArray.length && num < n; i++) {
					if ((int) charArray[i] >= 0x4E00 && (int) charArray[i] <= 0x9FA5) {// �Ƿ���
					
						temp += charArray[i];
						num += 2;
					} else {
						temp += charArray[i];
						num++;
					}
				}
				return (temp + BCConvert.qj2bj(".."));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	/**
	 * @Title: isDouble
	 * @Description: TODO
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean isDouble(String str) {
	    Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
	    return pattern.matcher(str).matches();
	}
	
	/**
	 * @Title: ToDBC
	 * @Description: ת���
	 * @param input
	 * @return
	 * @return: String
	 */
	public static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i< c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i]> 65280 && c[i]< 65375) {
				c[i] = (char) (c[i] - 65248);
			}
		}
		return new String(c);
	}
	
	/**
	 * @Title: ToSBC
	 * @Description: תȫ��
	 * @param input
	 * @return
	 * @return: String
	 */
	public static String ToSBC(String input) {
		
		char[] c = input.toCharArray();
		for (int i = 0; i< c.length; i++) {
			if (c[i] == 32) {
				c[i] = (char) 12288;
				continue;
			}
			if (c[i]< 127) {
				c[i] = (char) (c[i] + 65248);
			}
		}
		return new String(c);
	}
	
	public static String Utf8ToGBK(String input)
	{
		String utf8;
		String gbk = null;
		try {
			utf8 = new String(input.getBytes( "UTF-8"));
			String unicode = new String(utf8.getBytes(),"UTF-8");   
			gbk = new String(unicode.getBytes("GBK")); 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return gbk;
		
	}
	
}
