# 巩固题

## 第1题

（1）使用绝对路径，在D盘下创建一个testIO文件夹，然后在testIO文件夹中创建一个1.txt文件

（2）使用相对路径，在当前模块下创建一个testIO文件夹，然后在testIO文件夹中创建一个1.txt文件

```java
package com.atguigu.homework1;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Homework1 {
    @Test
    public void test01() throws IOException {
        File dir = new File("d:/testIO");
        dir.mkdir();

        File file = new File("d:/testIO/1.txt");
        file.createNewFile();
    }

    @Test
    public void test02() throws IOException {
        File dir = new File("testIO");
        dir.mkdir();

        File file = new File("testIO/1.txt");
        file.createNewFile();
    }
}
```



## 第2题

（1）检查D盘的testIO文件夹下是否存在文件a.txt，如果不存在则创建该文件。

（2）获取D盘的testIO文件夹下的a.txt文件的文件名，文件大小，文件的绝对路径和父路径等信息，并将信息输出在控制台

（3）判断File file = new File("d:\testIO");是否文件,是文件则输出：xxx是一个文件，是否文件夹,是文件夹则输出：xxx是一个文件夹

（4）删除D盘的testIO文件夹下的a.txt文件

（5）删除当前模块下的testIO文件夹下的1.txt文件，然后删除testIO文件夹

```java
package com.atguigu.homework2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Homework2 {
    @Test
    public void test05(){
        File file = new File("d:/testIO/1.txt");
        file.delete();

        File dir = new File("d:/testIO");
        dir.delete();
    }

    @Test
    public void test04(){
        File file = new File("d:/testIO/a.txt");
        file.delete();
    }
    @Test
    public void test03(){
        File file = new File("d:/testIO");
        if(file.isFile()){
            System.out.println(file+"是一个文件。");
        }else if(file.isDirectory()){
            System.out.println(file + "是一个文件夹");
        }
    }
    @Test
    public void test02(){
        File file = new File("d:/testIO/a.txt");
        System.out.println("文件名：" + file.getName());
        System.out.println("文件大小：" + file.length());
        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        System.out.println("文件的父目录：" + file.getParent());
    }
    @Test
    public void test01(){
        File file = new File("d:/testIO/a.txt");
        try {
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



## 第3题

把老师的pdf笔记文档《第14章 IO流.pdf》，复制到当前模块的testIO文件夹下。要求使用缓冲流和文件流一起实现

```java
package com.atguigu.homework3;

import java.io.*;

public class Homework3 {
    public static void main(String[] args) {
        try(
                BufferedInputStream bis = new BufferedInputStream(
                        new FileInputStream("D:/atguigu/第14章 IO流.pdf"));
                BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream("testIO/第14章 IO流.pdf"));
        ){
            byte[] data = new byte[1024];
            int len;
            while((len = bis.read(data))!=-1){
                bos.write(data, 0, len);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
```



## 第4题

把如下这些数据存放到一个data.dat文件中，并且再次读取显示

```java
int a = 10;
char c = 'a';
double d = 2.5;
boolean b = true;
String str = "尚硅谷";
```

```java
package com.atguigu.homework5;

import org.junit.Test;

import java.io.*;

public class Homework5 {
    @Test
    public void test02() throws IOException {
        ObjectInputStream dis = new ObjectInputStream(new FileInputStream("data.dat"));
        System.out.println(dis.readInt());
        System.out.println(dis.readChar());
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readUTF());
        dis.close();
    }

    @Test
    public void test01() throws IOException {
        int a = 10;
        char c = 'a';
        double d = 2.5;
        boolean b = true;
        String str = "尚硅谷";

        ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("data.dat"));
        dos.writeInt(a);
        dos.writeChar(c);
        dos.writeDouble(d);
        dos.writeBoolean(b);
        dos.writeUTF(str);
        dos.close();
    }
}
```



## 第5题

（1）声明一个Message类，包含：发送者、接收者、消息内容、发送时间等属性，属性私有化，提供有参构造，get/set，重写toString

（2）创建一个Message对象，并写到message.dat文件中，并再次读取显示

```java
package com.atguigu.homework6;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fromUser;
    private String toUser;
    private String content;
    private long sendTime;

    public Message(String fromUser, String toUser, String content, long sendTime) {
        super();
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.sendTime = sendTime;
    }

    public Message() {
        super();
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message [fromUser=" + fromUser + ", toUser=" + toUser + ", content=" + content + ", sendTime="
                + sendTime + "]";
    }
}
```

```java
package com.atguigu.homework6;

import org.junit.Test;

import java.io.*;

public class Homework6 {
    @Test
    public void test02() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("message.dat"));
        Object msg = ois.readObject();
        System.out.println(msg);
        ois.close();
    }
    @Test
    public void test01() throws FileNotFoundException, IOException{
        Message msg = new Message("柴老师", "佟老师", "加工资", System.currentTimeMillis());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("message.dat"));
        oos.writeObject(msg);
        oos.close();
    }
}

```



## 第6题

（1）用从键盘输入三句话，用PrintStream打印到一个words.txt文件中

（2）再用Scanner一行一行读取显示

```java
package com.atguigu.homework7;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Homework7 {
    @Test
    public void test02() throws FileNotFoundException {
        Scanner input = new Scanner(new File("words.txt"));
        while(input.hasNextLine()){
            System.out.println(input.nextLine());
        }
        input.close();
    }


    @Test
    public void test01() throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        PrintStream ps = new PrintStream("words.txt");
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入第" + (i+1) + "句要对柴老师说的话：");
            String content = input.nextLine();
            ps.println(content);
        }
        input.close();
        ps.close();
    }
}
```


