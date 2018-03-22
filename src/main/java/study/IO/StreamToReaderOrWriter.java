package study.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DEllComputer on 2018/3/22.
 * 字节字符转换流
 */
public class StreamToReaderOrWriter {

    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream("/Users/jiangdongcheng/ProjectTest/mavenSpringmvc/testData.txt");
        InputStreamReader reader = new InputStreamReader(fileInputStream);

        int b;
        while((b = reader.read())!=-1){  //read()返回的是16为无符号整数，是字符的unicode编码,所以可以通过char做强制类型转换
            System.out.println((char)b);
        }
    }
}
