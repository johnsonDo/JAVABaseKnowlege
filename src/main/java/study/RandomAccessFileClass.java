package study;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by DEllComputer on 2018/3/16.
 *
 * RandomAccessFile 是java提供的对文件内容的访问,即可以读文件,也可以写文件
 * RandomAccessFile 支持随机访问文件,可以访问文件的任意位置
 */
public class RandomAccessFileClass {

    public static void main(String[] args) throws IOException {


        //RandomAccessFile构造方法,要传入两个参数,一个是File或者String,一个是模式,模式分为"rw"可读可写和"r"只读
        File file = new File("/Users/jiangdongcheng/ProjectTest/mavenSpringmvc/src/main/java/fileTest.txt");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        //这里有个文件指针的概念:打开文件时,文件指针指向文件开头,此时指针为0;用getFilePointer()可以返回指针所在位置
        System.out.println(raf.getFilePointer());

        //RandomAccessFile提供了写入的方法
        raf.writeInt(666);  //写入一个int型的666
        System.out.println(raf.getFilePointer());

        String s = "中";
        byte[] utf8 = s.getBytes("UTF-8");
        raf.write(utf8);                  //如果直接这样写入,会在开头写入,因为文件指针是指向开头的,因为UTF8编码中文占三个字节,所以写入后指针会后移三位
        System.out.println(raf.getFilePointer());


        //读文件的时候,我们先把指针指向最开始seek()方法可以操作指针位置
        raf.seek(0);
        //一次性读取,将文件中的内容都读到字节数组中,然后输出
        byte[] bytes = new byte[(int)raf.length()];//开辟一个文件这么大的字节数组,保证能装下
        raf.read(bytes);//将文件中的内容读取到bytes数组中
        System.out.println(new String(bytes,"UTF-8"));

        raf.close();//用完记得关闭

    }

}
