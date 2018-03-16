package study;

import java.io.File;
import java.io.IOException;

/**
 * Created by DEllComputer on 2018/3/16.
 *
 * File类常用API介绍
 * java.io.File类用于表示文件或者目录
 * File类只用于表示文件(目录)的信息(名称,大小等),不能用于文件内容的访问
 */
public class FileClass {

    public static void main(String[] args) throws IOException {

        //知识点一
        //构造一个File类
        File file = new File("/Users/jiangdongcheng/ProjectTest/mavenSpringmvc/src/main/java/fileTest.txt");
        System.out.println(file.exists());  //这个方法是判断这个file是否存在

        //知识点二
        File file1 = new File("testDir");
        if(!file1.exists()){
            file1.mkdir();  //如果这个目录不存在,就创建这个文件夹,你不指定存放位置的话,会默认创建到我们项目的根目录下
        }else{
            file1.delete(); //如果这个目录存在,就删除这个目录
        }


        //知识点三
        //注意,在windows系统中,分隔符是"\",而在lunix是"/",为了兼容多个系统,这里介绍下File的静态变量File.separator
        File file2 = new File("e:"+File.separator);


        //知识点四:判断File的路径是一个文件夹,还是一个文件
        System.out.println(file.isDirectory());//判断file这个路径是不是一个文件夹
        System.out.println(file.isFile());//判断file这个路径是不是一个文件


        //知识点五
        File file3 = new File("fileTest.txt");
        if(!file3.exists()){
            file3.createNewFile();   //如果file3这个文件不存在,就创建这个新文件
        }else{
            file3.delete();    //如果存在,就删除这个文件
        }

        //知识点六
        File file4 = new File("/Users/jiangdongcheng/ProjectTest/mavenSpringmvc","fileTest1.txt"); //也可以这样来构造File,第一个参数是路径,第二个参数是文件名
        if(!file4.exists()){
            file4.createNewFile();
        }else{
            file4.delete();
        }


        //知识点七
        System.out.println(file4.getAbsolutePath());  //获取文件绝对路径 '/Users/jiangdongcheng/ProjectTest/mavenSpringmvc/fileTest1.txt'
        System.out.println(file4.getName());   //获取file4的name  'fileTest1.txt'

        //知识点八
        System.out.println(file4.getParent());  //获取file4的父目录'/Users/jiangdongcheng/ProjectTest/mavenSpringmvc'

        //知识点九
        File file5 = new File("testD"+File.separator+"testD1");
        if(!file5.exists()){
            file5.mkdirs();   //注意如果需要创建多级目录需要使用mkdirs()方法
        }
        File file6 = new File("test"+File.separator+"test1");
        if(!file6.exists()){
            boolean bool = file6.mkdir();   //如果需要创建多级目录,但是却调用mkdir()方法,就会创建不成功,返回false
            System.out.println(bool);
        }

        //知识点10
        //利用File提供的listFiles()方法递归遍历文件夹下所有的文件名
        File file7 = new File("文件夹路径");
        printAll(file7);
    }


    /**
     * 这个方法是实现打印出文件夹下所有的文件和目录的名字
     * */
    public static void printAll(File dir){
        if(!dir.exists()){
            //如果文件夹不存在
            throw new IllegalArgumentException("目录"+dir.getAbsolutePath()+"不存在");
        }
        if(!dir.isDirectory()){
            //如果传来的路径不是文件夹
            throw new IllegalArgumentException(dir.getAbsolutePath()+"不是目录");
        }

        //File中有list()方法,是返回目录下所有文件,文件夹的名称,因为我们要递归遍历文件夹下的文件夹下的文件,所以不能用这个方法
        String[] fileNames = dir.list();


        //我们可以使用File提供的listFiles(),返回File对象,我们可以通过File判断是文件还是文件夹,如果是文件夹就继续遍历
        File[] files = dir.listFiles();

        for(File file : files){

            if(file.isDirectory()){
               //如果这个file是目录,就继续调用此方法
                printAll(file);

            }else {
                //如果是文件输出文件名字
                System.out.println(file.getName());
            }
        }


    }



}
