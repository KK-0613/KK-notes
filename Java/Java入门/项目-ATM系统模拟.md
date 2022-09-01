# ATM系统

## 项目介绍及功能演示

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901155924.png)



## 技术选型

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901155608.png)

## 账户类、首页设计

首页效果图：

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901160333.png)

### **系统准备内容分析：**

1. 每个用户的账户信息都是一个对象，需要提供账户类。

2. 需要准备一个容器，用于存储系统全部账户对象信息。

3. 首页只需要包含：登录和注册2个功能。

### **实现步骤：**

1. 定义账户类，用于后期创建账户对象封装用户的账户信息。

2. 账户类中的信息至少需要包含（卡号、姓名、密码、余额、取现额度）

3. 需要准备一个ArrayList的集合，用于存储系统用户的账户对象。

4. 需要展示欢迎页包含2个功能：开户功能、登录账户。

### 代码实现

账户类：

```java
package com.kk.atm;

/**
 * @ClassName Account
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/1 16:33
 * @Version 1.0
 **/
public class Account {
    private String cardId; //卡号
    private String name; //姓名
    private String password; //密码
    private double balance; //余额
    private double cashWithdrawalAmount;//取现额度

    public Account() {
    }

    public Account(String cardId, String name, String password, double balance, double cashWithdrawalAmount) {
        this.cardId = cardId;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.cashWithdrawalAmount = cashWithdrawalAmount;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCashWithdrawalAmount() {
        return cashWithdrawalAmount;
    }

    public void setCashWithdrawalAmount(double cashWithdrawalAmount) {
        this.cashWithdrawalAmount = cashWithdrawalAmount;
    }
}

```

主类：

```java
package com.kk.atm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName main
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/1 16:39
 * @Version 1.0
 **/
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        System.out.println("=========欢迎您进入KK银行ATM系统=========");
        System.out.println("1.登录账户");
        System.out.println("2.注册开户");
        System.out.print("请输入指令1、2选择对应的操作：");
        int command = sc.nextInt();
      	switch (command) {
            case 1:
                login();
                break;
            case 2:
                register(sc, accounts);
                break;
        }
    }
}
	
```





## 用户开户功能实现

### 用户开户功能界面图：

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901160822.png)

### 分析

****

- 开户功能其实就是就是往系统的集合容器中存入一个新的账户对象的信息。

### **开户功能实现步骤**

1. 定义方法完成开户：

2. 键盘录入姓名、密码、确认密码（需保证两次密码一致）

3. 生成账户卡号，卡号必须由系统自动生成8位数字（必须保证卡号的唯一）

4. 创建Account账户类对象用于封装账户信息（姓名、密码、卡号）

5. 把Account账户类对象存入到集合accounts中去。

### 代码实现

```java
public static void register(Scanner sc, ArrayList<Account> accounts) {
        Random r = new Random();
        Account account = new Account();
        String carId = "";
        System.out.println("==========欢迎您进入KK银行开户系统=========");
        System.out.println("请输入您的姓名：");
        account.setName(sc.next());
        System.out.println("请输入您的密码：");
        account.setPassword(sc.next());
        while (true) {
            System.out.println("请确认您的密码：");
            if (account.getPassword().equals(sc.next())) {
                System.out.println("请输入您的取现额度：");
                account.setCashWithdrawalAmount(sc.nextDouble());
                break;
            } else {
                System.out.println("两次输入的密码不一致，请重新输入：");
            }
        }
        for (int i = 0; i < 8; i++) {
            int x = r.nextInt(0, 9);
            carId = carId + x;
        }
        account.setCardId(carId);
        System.out.println(account.getName()
                + "贵宾，您的账户已开户成功，您的卡号是：" + account.getCardId());

    }
```

返回结果

```j
=========欢迎您进入KK银行ATM系统=========
1.登录账户
2.注册开户
请输入指令1、2选择对应的操作：2
==========欢迎您进入KK银行开户系统=========
请输入您的姓名：
kk
请输入您的密码：
123456
请确认您的密码：
123
两次输入的密码不一致，请重新输入：
请确认您的密码：
123456
请输入您的取现额度：
3000
kk贵宾，您的账户已开户成功，您的卡号是：68138531
```



## 用户登录功能实现

### 用户登录功能实现界面图：

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901161151.png)

### 分析及实现步骤

1. 定义方法：
2. 让用户键盘录入卡号，根据卡号查询账户对象。
3. 如果没有找到了账户对象，说明卡号不存在，提示继续输入卡号。
4. 如果找到了账户对象，说明卡号存在，继续输入密码。
5. 如果密码不正确，提示继续输入密码
6. 如果密码正确，提示登陆成功！！

### 代码实现





## **用户操作页设计、查询账户、退出账户功能**

### **用户操作页设计、查询账户、退出账户功能界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901161429.png)

### **用户操作页设计、查询账户、退出账户功能分析**

1. 用户登录成功后，需要进入用户操作页。

2. 查询就是直接展示当前登录成功的账户对象的信息。

3. 退出账户是需要回到首页的。

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901161703.png)

## **用户存款功能实现**

### **用户存款功能实现界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901161827.png)

### **存款分析**

1. 存款就是拿到当前账户对象。
2. 然后让用户输入存款的金额。
3. 调用账户对象的setMoney方法将账户余额修改成存钱后的余额。
4. 存钱后需要查询一下账户信息，确认是否存钱成功了！

### 代码实现





## **用户取款功能实现**

### **用户取款功能实现界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901162055.png)

### **取款分析**

1. 取款需要先判断账户是否有钱。
2. 有钱则拿到自己账户对象。
3. 然后让用户输入取款金额
4. 判断取款金额是否超过了当次限额，以及余额是否足够
5. 满足要求则调用账户对象的setMoney方法完成金额的修改

  ### 代码实现







## **用户转账功能实现**

### **用户转账功能实现界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901162239.png)

### **分析**

1. 转账功能需要判断系统中是否有2个账户对象及以上。
2. 同时还要判断自己账户是否有钱。
3. 接下来需要输入对方卡号，判断对方账户是否存在。
4. 对方账户存在还需要认证对方户主的姓氏。
5. 满足要求则可以把自己账户对象的金额修改到对方账户对象中去。

### 代码实现





## **用户密码修改、销户功能实现**

### **用户密码修改、销户功能实现界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901162449.png)

### **分析**

1. 修改密码就是把当前对象的密码属性使用set方法进行更新。个账户对象及以上。

2. 销户是从集合对象中删除当前对象，并回到首页。



### 代码实现

