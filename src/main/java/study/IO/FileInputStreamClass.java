package study.IO;

import java.io.*;

/**
 * Created by DEllComputer on 2018/3/20.
 * IO流包括输入流和输出流
 * 1：字节流
 * 1）InputStream抽象了应用程序读取数据的方式,主要有read方法
 * 2）OutputStream抽象了应用程序写出数据的方式，主要有write方法
 */
public class FileInputStreamClass {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/jiangdongcheng/ProjectTest/mavenSpringmvc/src/main/java/fileTest.txt");
        InputStream in = new FileInputStream(file);

        //知识点一：输入流的基本方法
        int b = in.read(); //读取一个字节，无符号填充到int低八位，读到-1就表示读取完了
        byte[] buf = new byte[(int) file.length()];
        in.read(buf, 0, (int) file.length());   //读取数据填充到buf字节数组中
        System.out.println(b);
        System.out.println(new String(buf, "UTF-8"));

        //知识点二：输出流的基本方法
        OutputStream out = new FileOutputStream(file);
        out.write(5);//写出一个byte到流,int的低八位
        byte[] bytes = "你好".getBytes();
        out.write(bytes);//将buf字节数组都写入到流   注意：这个写会是覆盖写，原来的内容将删除
        out.write(bytes, 0, 1);//字节数组bytes从0这个位置开始写1个长度的字节到流

        in.close();   //IO处理完后一定记得关闭
        out.close();

        //测试下面的练习
        printHex(file.getAbsolutePath());
    }


    /**
     * 练习:
     * 读取指定文件的内容，按照16进制输出到控制台
     * 并且每输出10个byte换行
     */
    public static void printHex(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);

        int b;//用来记录是否读到-1了
        int i = 1;
        while ((b = in.read()) != -1) {
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }

        in.close();
    }
}
