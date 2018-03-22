package study.IO;

import java.io.*;

/**
 * Created by DEllComputer on 2018/3/22.
 * 字节流之数据输入输出流
 * 这些输入输出流存在writeInt();readInt()等方法
 */
public class DataInAndOutStream {

    public static void main(String[] args) throws IOException{

        DataOutputStream out = new DataOutputStream(new FileOutputStream("testData.txt"));
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("testData.txt"));



        out.writeInt(12);
        out.writeInt(13);
        out.writeUTF("中国");

        int number1 = dataInputStream.readInt();
        int number2 = dataInputStream.readInt();
        String str = dataInputStream.readUTF();

        System.out.println(number1+"  "+number2 + " " +str );
        dataInputStream.close();

        out.close();


    }




}
