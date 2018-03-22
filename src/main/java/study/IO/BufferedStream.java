package study.IO;

import java.io.*;

/**
 * Created by DEllComputer on 2018/3/22.
 * 4-5 字节缓冲流
 * 记住缓冲输出流一定要记得用flush()方法刷新缓冲区
 */
public class BufferedStream {

    public static void main(String[] args) {
       String sourceFile = "/Users/jiangdongcheng/Desktop/烟火里的尘埃.mp3";
       String destFile = "/Users/jiangdongcheng/Desktop/烟火里的尘埃2.mp3";
        try {
            copyFile(sourceFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 利用字节缓冲流，进行文件的拷贝
     * */
    public static void copyFile(String sourceFile,String destFile) throws IOException{
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));

        int b;
        byte[] bytes = new byte[5*1024];

        while((b=bufferedInputStream.read(bytes,0,bytes.length))!=-1){
            bufferedOutputStream.write(bytes,0,b);
            bufferedOutputStream.flush();
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();


    }
}
