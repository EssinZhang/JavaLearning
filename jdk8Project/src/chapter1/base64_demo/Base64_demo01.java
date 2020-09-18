package chapter1.base64_demo;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * description: Demo01 <br>
 * date: 2020/9/17 09:48 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class Base64_demo01 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        String text = "Base64 测试";
        //转成字节数组
        byte[] textBytes = text.getBytes("UTF-8");
        //编码
        String encodeString = encoder.encodeToString(textBytes);
        System.out.println("编码后的结果："+encodeString);
        //解码
        System.out.println("解码后的结果："+new String(decoder.decode(encodeString),"UTF-8"));
    }
}
