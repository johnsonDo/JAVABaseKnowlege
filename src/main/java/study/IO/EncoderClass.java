package study.IO;

import java.io.UnsupportedEncodingException;

/**
 * Created by DEllComputer on 2018/3/16.
 * 编码测试
 */
public class EncoderClass {



    public static void main(String[] args) throws UnsupportedEncodingException {
        //编码问题测试
        String s = "测试ABC";
        byte[] bytes = s.getBytes();  //将字符串转换为byte字节数组
        for(byte b : bytes){
            //把字节转换为int以16进制方式输出
            System.out.println(Integer.toHexString(b & 0xff));
        }

        //因为项目采用的是UTF-8的编码格式,所以这里参数可以不写,如果编码格式换成其他的,str就会输出乱码;
        String str = new String(bytes,"UTF-8");
        System.out.println(str);
    }
}
