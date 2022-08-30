# Java SE（前置工作）
## 官网下载jdk
[Oracle官方下载地址](https://www.oracle.com/java/technologies/downloads/ 'jdk18下载地址')<br>
根据自己的系统下载相应的版本即可：
![下载页面](https://s2.loli.net/2022/08/19/mVtPj4izaYfJwFe.png)
下载完成后点开安装即可（注意安装路径不要包含空格或者中文，否则后续在写java时可能会莫名其妙报错），安装完成后，打开命令行窗口，输入

    java -version
    
回车后返回以下内容（返回的版本号与安装的jdk版本号对应）即代表安装成功。

    java version "18.0.2.1" 2022-08-18
    Java(TM) SE Runtime Environment (build 18.0.2.1+1-1)
    Java HotSpot(TM) 64-Bit Server VM (build 18.0.2.1+1-1, mixed mode, sharing)
    
## java和javac
java:执行命令
javac:编译命令

## 命令行窗口的常用命令
|常用命令|作用|
|---|---|
|盘符|切换到某个盘下：D:,C:|
|dir|查看当前路径下的文件信息|
|cd|进入单级目录：cd itheima<br>进入多级目录：cd D:\itheima\JavaSE\第一天<br>回退到上级目录：cd ..<br>回退到盘符根目录:cd \|
|cls|清屏|

