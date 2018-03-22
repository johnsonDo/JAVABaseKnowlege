package study.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by DEllComputer on 2018/3/21.
 */
public class FileOutputStreamClass {

    public static void main(String[] args) throws IOException{

        //知识点一: FileOutputStream构造方法:如果这个文件存在,则会删除后再创建,如果文件不存在,就直接创建
        FileOutputStream out = new FileOutputStream("testFileOutputStream.txt");
        //这个构造方法的第二个参数true表示追加的意思,如果这个文件不存在就直接创建,如果这个文件存在则不删除,而是在文件后面追加
        FileOutputStream out2 = new FileOutputStream("/Users/jiangdongcheng/ProjectTest/mavenSpringmvc/src/main/java/fileTest.txt",true);

        //知识点二: write方法
        out.write('A'); //写出了'A'的低八位

        byte[] bytes = "中国".getBytes("UTF-8");
        out2.write(bytes); //写入一个byte数组

        out.close();
        out2.close();

    }

    /**
     * 用FileOutputStream和FileInputStream来完成文件的拷贝工作
     * */
    public static void copyFile(String sourceFile , String destFile) throws IOException{
        if(!new File(sourceFile).exists()){
            throw new IllegalArgumentException("文件不存在");
        }

        if(!new File(sourceFile).isFile()){
            throw new IllegalArgumentException("路径不是一个文件");
        }

        FileInputStream in = new FileInputStream(sourceFile);
        FileOutputStream out = new FileOutputStream(destFile);

        byte[] bytes = new byte[2*1024];
        int b;

        while ((b=in.read(bytes,0,bytes.length)) !=-1){
            out.write(bytes,0,b);
            out.flush();
        }

        in.close();
        out.close();


    }



}
