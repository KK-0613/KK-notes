# Java String类

## 特点

- String其实常被称为不可变字符串类型，它的对象在创建后不能被更改。

## 位置：**字符串对象存在哪里？**

- 以""方式给出的字符串对象，在字符串常量池中存储。

且相同的字符串只存储一次。

## String是不可变字符串的原因

- **String变量每次的修改其实都是产生并指向了新的字符串对象。**

- **原来的字符串对象都是没有改变的，所以称不可变字符串。**

## 创建字符串对象的2种方式

- 方式一：直接使用""定义（常用）

```java
String name = "张三"
```

- 方式二：通过String类的构造器创建对象。

通过API文档可以查看对应类的API。（下载：https://www.oracle.com/java/technologies/downloads/）

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220831105911.png)

|             构造器             |                  说明                  |
| :----------------------------: | :------------------------------------: |
|        public String()         | 创建一个空白字符串对象，不含有任何内容 |
| public String(String original) | 根据传入的字符串内容，来创建字符串对象 |
|   public String(char[] chs)    |  根据字符数组的内容，来创建字符串对象  |
|   public String(byte[] chs)    |  根据字节数组的内容，来创建字符串对象  |

### 两种创建方式的区别

- 以“”方式给出的字符串对象，在字符串常量池中存储，而且相同内容只会在其中存储一份。
- 通过构造器new对象，每new一次都会产生一个新对象，放在堆内存中。

### 两种创建方式的原理

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220831111729.png)

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220831111845.png)

## Java编译优化机制

```java
public class Test3 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ab";
        String s3 = s2 + "c";
        System.out.println(s1 == s3); //false
    }
}
```

```java
public class Test4 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a" + "b" + "c";
        System.out.println(s1 == s2); //true
    }
}
```

**注：Java存在编译优化机制，程序在编译时： "a" + "b" + "c" 会直接转成 "abc"**

## String 类常用API - 字符串内容比较

之前一直使用的是"=="来比较，其实这种方式是不适合比较字符串的，因为我们需要的往往是字符串内容的对比，而这种方式比较的是地址（所以一般更适用于基本数据类型的比较），所以我们一般使用String类提供的equals()方法来进行比较：

|                         方法名                         |                             说明                             |
| :----------------------------------------------------: | :----------------------------------------------------------: |
|        public boolean equals (Object anObject)         |    将此字符串与指定对象进行比较。只关心字符内容是否一致！    |
| public boolean equalsIgnoreCase (String anotherString) | 将此字符串与指定对象进行比较，忽略大小写比较字符串。只关心字符内容是否一致！ |

### equals()练习--登录

用户类

```java
package com.kk.stingdemo;

/**
 * @ClassName User
 * @Description //TODO
 * @Author kk
 * @Date 2022/8/31 11:55
 * @Version 1.0
 **/
public class User {
    private String username;
    private String password;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

```

登录类

```java
package com.kk.stingdemo;

import java.util.Scanner;

/**
 * @ClassName Login
 * @Description //TODO
 * @Author kk
 * @Date 2022/8/31 11:56
 * @Version 1.0
 **/
public class Login {
    String username;
    String password;

    public Login() {
    }
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void login(User user,Login login){
        while(true){
            if(login.getUsername().equals(user.getUsername())){
                if(login.getPassword().equals(user.getPassword())){
                    System.out.println("登录成功");
                    break;
                }
                else{
                    System.out.println("密码错误,请重新输入");
                }
            }else{
                System.out.println("用户名错误，请重新输入");
            }
            System.out.println("--------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            login.setUsername(sc.next());
            System.out.println("请输入密码：");
            login.setPassword(sc.next());
        }
    }
}

```

测试类

```java
package com.kk.stingdemo;

import java.util.Scanner;

/**
 * @ClassName StringDemo01
 * @Description //TODO
 * @Author kk
 * @Date 2022/8/31 11:21
 * @Version 1.0
 **/
public class StringDemo01 {
    public static void main(String[] args) {
        User u = new User("zhangsan");
        u.setPassword("123456");
        Login l = new Login();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        l.setUsername(sc.next());
        System.out.println("请输入密码：");
        l.setPassword(sc.next());

        //登录
        l.login(u,l);
    }
}


```

返回结果

```j
请输入用户名：
zhangsan
请输入密码：
123
密码错误,请重新输入
--------------------------
请输入用户名：
zhangsan
请输入密码：
123456
登录成功

```

## String类常用API -遍历、替换、截取、分割操作

| 方法名                                                       | 说明                                                     |
| :----------------------------------------------------------- | :------------------------------------------------------- |
| public int length()                                          | 返回此字符串的长度                                       |
| public char charAt(int index)                                | 获取某个索引位置处的字符                                 |
| public char[] toCharArray()：                                | 将当前字符串转换成字符数组返回                           |
| public String substring(int beginIndex, int endIndex)        | 根据开始和结束索引进行截取，得到新的字符串（包前不包后） |
| public String substring(int beginIndex)                      | 从传入的索引处截取，截取到末尾，得到新的字符串           |
| public String replace(CharSequence target, <br>CharSequence replacement) | 使用新值，将字符串中的旧值替换，得到新的字符串           |
| public String[] split(String regex)                          | 根据传入的规则切割字符串，得到字符串数组返回             |

```java
	package com.kk.string_api_demo;

/**
 * @ClassName ApiDemo01
 * @Description //TODO
 * @Author kk
 * @Date 2022/8/31 13:35
 * @Version 1.0
 **/
public class ApiDemo01 {
    public static void main(String[] args) {
        String name = "zhangsansi";
        System.out.println(name.length()); //字符串长度
        System.out.println(name.charAt(5)); //输出指定位置字符，从0开始
        System.out.println(name.toCharArray()); //转换成字符数组输出
        System.out.println(name.substring(1,9)); //输出第1-9位字符，不包括第9位，从0开始
        System.out.println(name.substring(6)); //输出指定位置到末尾到字符
        System.out.println(name.replace('a','e')); //将a替换成e
    }
}

```

返回结果

```j
10
s
zhangsansi
hangsans
ansi
zhengsensi
```

# String 案例操作

## 案例1 String类开发验证码功能

### 需求

- 随机产生一个5位的验证码，每位可能是数字、大写字母、小写字母。

### 分析

1. 定义一个String类型的变量存储验a-zA-Z0-9之间的全部字符。

2. 循环5次，随机一个范围内的索引，获取对应字符连接起来即可。

### 代码实现

```java
package com.kk.stringdemo02;

import java.util.Random;

/**
 * @ClassName Test
 * @Description //TODO
 * @Author kk
 * @Date 2022/8/31 13:48
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        /*需求
        随机产生一个5位的验证码，每位可能是数字、大写字母、小写字母。
        分析
        1. 定义一个String类型的变量存储a-z,A-Z,0-9之间的全部字符。
        2. 循环5次，随机一个范围内的索引，获取对应字符连接起来即可。*/
        char[] vc = new char[62];
        int j1 = 48, j2 = 65, j3 = 97;
        for (int i = 0; i < vc.length; i++) {
            //数字
            if (i < 10) {
                if ((int) vc[i] == 0) {
                    vc[i] = (char) j1;
                }
                j1++;
            }
            //大写字母
            if (i < 36 && i >= 10) {
                if ((int) vc[i] == 0) {
                    vc[i] = (char) j2;
                }
                j2++;

            }
            //小写字母
            if (i >= 36) {
                if ((int) vc[i] == 0) {
                    vc[i] = (char) j3;
                }
                j3++;
            }
        }
        String vcString =  new String(vc);
        Random r = new Random();
        System.out.println("验证码：");
        for (int i = 0; i < 5; i++) {
            System.out.print(vcString.charAt(r.nextInt(0,vcString.length())));
        }
    }
}

```

返回结果

```j
验证码：
d32Cu
```

## 案例2 模拟用户登录功能

### 需求

- 模拟用户登录功能，最多只给三次机会。

### 分析

1. 系统后台定义好正确的登录名称，密码。
2. 使用循环控制三次，让用户输入正确的登录名和密码，判断是否登录成功，登录成功则不再进行登录；登录失败给出提示，并让用户继续登录。

### 代码实现

用户类：

```java
package com.kk.stringdemo02;

import java.util.Scanner;

/**
 * @ClassName User
 * @Description //TODO
 * @Author kk
 * @Date 2022/8/31 14:39
 * @Version 1.0
 **/
public class User {
    private int userId;
    private String okUsername;
    private String okPassword;

    public User() {
    }
    public User(String okUsername) {
        this.okUsername = okUsername;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOkUsername() {
        return okUsername;
    }

    public void setOkUsername(String okUsername) {
        this.okUsername = okUsername;
    }

    public String getOkPassword() {
        return okPassword;
    }

    public void setOkPassword(String okPassword) {
        this.okPassword = okPassword;
    }

    //注册功能
    public static void register(User[] u){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名注册用户:");
        for (int i = 0; i < u.length; i++) {
            if(u[i].getOkUsername() == null){
                u[i].setOkUsername(sc.next());
                System.out.println("请为用户" + u[i].getOkUsername() + "设置密码：");
                u[i].setOkPassword(sc.next());
                System.out.println("注册成功");
                u[i].setUserId(i);
                break;
            }
        }
    }
    //登录
    public static void login(User[] u){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        String password;
        OUT:
        for (int i = 0; i < 3; i++) {
            for (int i1 = 0; i1 < u.length; i1++) {
                if (u[i1].getOkUsername() != null) {
                    if (u[i1].getOkUsername().equals(username)) {
                        System.out.println("请输入密码：");
                        password = sc.next();
                        if (u[i1].getOkPassword().equals(password)) {
                            System.out.println("登录成功");
                            break OUT;
                        } else {
                            System.out.println("密码错误，请重新输入");
                            break;
                        }
                    }
                }else {
                    System.out.println("未在用户组找到该用户，请重新输入");
                    break;
                }
            }
            System.out.println("----------------------------");
            System.out.println("请输入用户名：");
            username = sc.next();
        }
    }
}

```

测试类：

```java
package com.kk.stringdemo02;

import java.util.Scanner;

/**
 * @ClassName LoginTest01
 * @Description //TODO
 * @Author kk
 * @Date 2022/8/31 14:37
 * @Version 1.0
 **/
public class LoginTest01 {
    public static void main(String[] args) {
        /*需求
        模拟用户登录功能，最多只给三次机会。
        分析
        1. 系统后台定义好正确的登录名称，密码。
        2. 使用循环控制三次，让用户输入正确的登录名和密码，判断是否登录成功，登录成功则不再进行登录；登录失败给出提示，并让用户继续登录。*/

        Scanner sc = new Scanner(System.in);
        User[] u = new User[100];//该系统最多可注册100名用户
        for (int i = 0; i < u.length; i++) {
            u[i] = new User();
        }
        System.out.println("欢迎您，您所在用户组是u用户组，请输入1确认进入系统；");
        int x = sc.nextInt();
        OUT:
        while(x == 1){
            System.out.println("-----------xx信息管理系统-----------");
            System.out.println("1.登录------2.注册------3.退出------");
            System.out.println("----------------------------------");
            System.out.println("请输入您的指令：");
            System.out.println("----------------------------------");
            int c = sc.nextInt();
            System.out.println("----------------------------------");

            switch(c){
                case 1:
                    User.login(u);
                    break OUT;
                case 2:
                    User.register(u);
                    System.out.println("输入9进入登录系统，输入其他任意数字返回菜单:");
                    int l = sc.nextInt();
                    if(l == 9){
                        User.login(u);
                        break OUT;
                    }
                    break;
                case 3:
                    System.out.println("退出系统！");
                    break;
                default:
                    System.out.println("未找到该指令！");
            }
        }
    }
}

```

返回结果：

```j
欢迎您，您所在用户组是u用户组，请输入1确认进入系统；
1
-----------xx信息管理系统-----------
1.登录------2.注册------3.退出------
----------------------------------
请输入您的指令：
----------------------------------
2
----------------------------------
请输入用户名注册用户:
zs
请为用户zs设置密码：
123
注册成功
输入9进入登录系统，输入其他任意数字返回菜单:
4
-----------xx信息管理系统-----------
1.登录------2.注册------3.退出------
----------------------------------
请输入您的指令：
----------------------------------
2
----------------------------------
请输入用户名注册用户:
ls
请为用户ls设置密码：
456
注册成功
输入9进入登录系统，输入其他任意数字返回菜单:
9
请输入用户名：
ls
请输入密码：
123
密码错误，请重新输入
----------------------------
请输入用户名：
ls
请输入密码：
456
登录成功
```

## 案例3 手机号码屏蔽

### 需求

键盘录入一个手机号，将中间四位号码屏蔽，最终效果为：

```java
158****7839
```

### 分析

1. 键盘录入一个字符串。

2. 调用字符串对象的截取API，截取字符串前三位、后四位。

3. 将前三位连接“****”然后继续连接后四位，输出最终结果即可。

### 代码实现

```java
package com.kk.stringdemo01;

import java.util.Scanner;

/**
 * @ClassName StringDemo01
 * @Description //TODO
 * @Author kk
 * @Date 2022/8/31 17:02
 * @Version 1.0
 **/
public class StringDemo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个手机号码：");
        System.out.println("--------原号码------------");
        String phone = sc.next();
        String phone1 = phone.substring(0,3);
        String phone2 = phone.substring(7);
        System.out.println("--------加密后------------");
        System.out.println(phone1 + "****" + phone2);
    }
}

```

返回结果

```j
请输入一个手机号码：
--------原号码------------
13938711119
--------加密后------------
139****1119
```

