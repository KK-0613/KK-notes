# 巩固题

## 第1题：咨询

案例：客户端模拟学生咨询，服务器端模拟咨询老师，进行交互。

 客户端收到信息：

​	欢迎咨询尚硅谷！

​	这个月的所有期班都已经满了，只能报下一个月的了！

![image-20220201215554646](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220201215554646.png)

 服务器端收到信息：

​	你好，我想报名这个月的JavaEE就业班！

​	好的，赶紧给我占个座！

![image-20220201215531434](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220201215531434.png)

### 服务器端

```java
package com.atguigu.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();

        // 获取输出流
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("欢迎咨询尚硅谷!");

        // 获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(socket.getInetAddress().getHostAddress() + "留言：" + LocalDateTime.now());
        System.out.println(br.readLine() + "\n");

        ps.println("这个月的所有期班都已经满了，只能报下一个月的了！");

        System.out.println(socket.getInetAddress().getHostAddress() + "留言：" + LocalDateTime.now());
        System.out.println(br.readLine());

        socket.close();
        server.close();
    }
}

```

### 客户端

```java
package com.atguigu.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888); // 创建Socket指定ip地址和端口号
        // 获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());

        // 获取输出流
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("你好，我想报名这个月的JavaEE就业班！");

        System.out.println(br.readLine());

        ps.println("好的，赶紧给我占个座！");

        ps.close();
        socket.close();
    }
}

```



## 第2题：上传照片

案例：客户端给服务器端上传照片

要求：（1）客户端上传的照片，需要是jpg格式的，并且大小在2M（含）以内的，否则不能上传

（2）要求上传成功后，服务器要返回上传成功，如果上传失败，服务器返回上传失败

（3）客户端上传到服务器端的照片，存储在项目名下"photo"的文件夹中，并且以“照片原文件名+时间戳.jpg”命名

### 服务器端

```java
package com.atguigu.homework3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) throws IOException {
        //开启服务器
        ServerSocket server = new ServerSocket(8888);
        //接收一个客户端的连接
        Socket socket = server.accept();
        //获取输入流
        ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());
        //获取输出流
        PrintStream ps = new PrintStream(socket.getOutputStream());
        //(1)先读取文件名
        String filename = dis.readUTF();

        //(2)生成唯一的文件名
        String destfile = "photo" + "/" +  filename + System.currentTimeMillis() + ".jpg";

        //(3)读取文件内容，并写入目标文件
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(destfile);
            byte[] data = new byte[1024];
            int len;
            while((len = dis.read(data)) != -1){
                fos.write(data, 0, len);
            }
            //返回结果给客户端
            ps.println("接收成功！");
        } catch (Exception e) {
            //返回结果给客户端
            ps.println("接收失败！");
        }finally{
            fos.close();
        }

        dis.close();
        ps.close();
        socket.close();
        server.close();
    }
}


```

### 客户端

```java
package com.atguigu.homework3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //连接服务器
        Socket socket = new Socket("127.0.0.1", 8888);

        //选择要上传的文件
        Scanner input = new Scanner(System.in);
        System.out.println("请选择要上传的文件：");
        //例如：D:\尚硅谷_0325班_柴林燕_JavaSE\笔记\第14章 IO流.docx
        String fileStr = input.nextLine();
        File file = new File(fileStr);

        if (!fileStr.endsWith(".jpg")) {
            System.out.println("照片必须是.jpg格式");
            input.close();
            socket.close();
            return;
        }
        if (file.length() > 1024 * 1024 * 2) {
            System.out.println("照片必须在2M(含)以内");
            input.close();
            socket.close();
            return;
        }

        //获取输出流
        ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());
        //先发送文件名
        dos.writeUTF(file.getName().substring(0, file.getName().lastIndexOf(".")));

        //从file读取内容，给服务器发送
        FileInputStream fis = new FileInputStream(file);


        //发送文件内容
        byte[] data = new byte[1024];
        int len;
        while ((len = fis.read(data)) != -1) {
            dos.write(data, 0, len);
        }
        socket.shutdownOutput();//告诉服务器，我发送完毕


        //接收结果
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = br.readLine();
        System.out.println(result);

        fis.close();
        dos.close();
        br.close();
        socket.close();
        input.close();
    }

}

```



## 第3题：群发

案例：模拟给全部同学群发“欢迎来到尚硅谷”。

开发提示：使用UDP群发

### 发送端

```java
package com.atguigu.homework4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
    public static void main(String[] args)throws Exception {
        //(1)先建立一个DatagramSocket
        DatagramSocket ds = new DatagramSocket();

        //(2)准备发送的数据
        String str = "欢迎来到尚硅谷";
        byte[] data = str.getBytes();

        for (int i = 0; i <= 255; i++) {
            //(3)把数据包装成一个数据报
            //DatagramPacket(byte[] buf, int length, InetAddress address, int port)
            /*
             * 第一个参数：要发送的数据的字节数组
             * 第二个参数：数组的长度
             * 第三个参数：接收方的IP地址
             * 第三个参数：接收方的端口号
             *
             * 好比发快递，需要填写接收方的IP和端口号
             */
            InetAddress ip = InetAddress.getByName("192.168.11."+i);
            int port = 8888;
            DatagramPacket dp = new DatagramPacket(data,data.length,ip,port);

            try {
                //(4)发送数据报
                //通过socket发送
                ds.send(dp);
            } catch (Exception e) {
            }
        }


        //(5)断开
        ds.close();
    }
}

```

### 接收端

```java
package com.atguigu.homework4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive {
    public static void main(String[] args)throws Exception {
        //1、准备一个socket，用来接收消息
        //接收方，先确定端口号，监听数据的端口号
        //好比，要收到快递，需要先确定自己的地址和手机号，然后对方才能给你发
        DatagramSocket ds = new DatagramSocket(8888);

        //2、准备一个数据报，来接收数据
        //DatagramPacket(byte[] buf, int length)
        byte[] data = new byte[1024*64];//64K
        DatagramPacket dp = new DatagramPacket(data,data.length);

        //3、接收数据
        ds.receive(dp);

        //4、拆包裹
        byte[] result = dp.getData();
        int len = dp.getLength();//实际接收的数据的长度
        System.out.println(new String(result,0,len));

        //5、关闭
        ds.close();
    }
}
```



