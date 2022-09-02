# ATM系统

## 项目介绍及功能演示

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901155924.png)



## 技术选型

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901155608.png)

## 账户类、首页设计

首页效果图：

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902123019.png)

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

        while(true){
            System.out.println("1.登录账户");
            System.out.println("2.注册开户");
            System.out.print("请输入指令1、2选择对应的操作：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    login(sc,accounts);
                    break;
                case 2:
                    register(sc, accounts);
                    break;
                default:
                    System.out.println("指令错误");
            }
            System.out.println("输入0退出系统：");
            int x = sc.nextInt();
            if(x == 0){
                break;
            }
        }
    }
}
```





## 用户开户功能实现

### 用户开户功能界面图：

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902123145.png)

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

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902123249.png)

### 分析及实现步骤

1. 定义方法：
2. 让用户键盘录入卡号，根据卡号查询账户对象。
3. 如果没有找到了账户对象，说明卡号不存在，提示继续输入卡号。
4. 如果找到了账户对象，说明卡号存在，继续输入密码。
5. 如果密码不正确，提示继续输入密码
6. 如果密码正确，提示登陆成功！！

### 代码实现

```java
public static void login(Scanner sc, ArrayList<Account> accounts) {
        System.out.println("==========欢迎您进入KK银行登录界面=========");
        if(accounts.size() == 0){
            System.out.println("警告，当前系统内部无用户，请注册开户后重新进入系统");
            return;
        }
        OUT:
        while (true) {
            System.out.println("请输入您的卡号：");
            String carId = sc.next();
            for (int i = 0; i < accounts.size(); i++)  {
                if (accounts.get(i).getCardId().equals(carId)) {
                    for (int j = 4; j >= 0; j--) {
                        System.out.println("请输入您的密码：");
                        if (accounts.get(i).getPassword().equals(sc.next())) {
                            System.out.println("登录成功！" + accounts.get(i).getName() + "贵宾，正在进入系统······");
                            actionPage(sc,accounts.get(i),accounts);
                            break OUT;
                        }else{
                            System.out.println("密码错误！请重新输入密码（剩余" + (j+1) +"次）：");
                        }
                    }
                }
            }
            System.out.println("卡号不存在，请重新输入：");
        }
    }
```

测试结果

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
kk贵宾，您的账户已开户成功，您的卡号是：60263640
输入0退出系统,输入其他任意数字返回菜单：
1
1.登录账户
2.注册开户
请输入指令1、2选择对应的操作：1
==========欢迎您进入KK银行登录界面=========
请输入您的卡号：
60263640
请输入您的密码：
1234
密码错误！请重新输入密码（剩余5次）：
请输入您的密码：
123456
登录成功！kk贵宾，欢迎您进入系统
输入0退出系统,输入其他任意数字返回菜单：
0

进程已结束,退出代码0
```





## **用户操作页设计、查询账户、退出账户功能**

### **用户操作页设计、查询账户、退出账户功能界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902123414.png)

### **用户操作页设计、查询账户、退出账户功能分析**

1. 用户登录成功后，需要进入用户操作页。

2. 查询就是直接展示当前登录成功的账户对象的信息。

3. 退出账户是需要回到首页的。

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902123455.png)



### 代码实现

```java
//用户操作页设计、查询账户、退出账户功能
    public static void actionPage(Scanner sc,Account account,ArrayList<Account> accounts){
        System.out.println("==========欢迎您进入KK银行用户操作界面=========");

        while(true){
            System.out.println("1.查询\t\t\t\t2.存款");
            System.out.println("3.取款\t\t\t\t4.转账");
            System.out.println("5.修改密码\t\t\t6.退出");
            System.out.println("7.注销当前账户");
            System.out.print("您可以选择对应指令进行操作：");
            int command = sc.nextInt();
            switch(command){
                case 1:
                    query(account); //查询
                    break;
                case 2:
                    deposit(sc,account); //存款
                    break;
                case 3:
                    withdrawMoney(sc,account); //取款
                    break;
                case 4:
                    transfer(sc,accounts,account); //转账
                    break;
                case 5:
                    changePassword(sc,account); //修改密码
                    break;
                case 6:
                    frontPage(sc,accounts); //退出
                    break;
                case 7:
                    accounts.remove(account); //注销账户
                    System.out.println("注销成功,输入0退出用户操作界面，输入其他任意键继续操作：");
                    if(!sc.next().equals("0")){
                        frontPage(sc,accounts);
                    }
                    return;
                default:
                    System.out.println("未找到该指令");
            }
            System.out.println("=============================");
            System.out.println("输入任意键继续操作：");
            sc.next();
        }
    }

    //查询功能
    public static void query(Account account){
        System.out.println("==========欢迎您进入KK银行用户详情界面=========");
        System.out.println("您的账户信息如下：");
        System.out.println("卡号：" + account.getCardId());
        System.out.println("姓名：" + account.getName());
        System.out.println("余额：" + account.getBalance());
        System.out.println("当次取现额度：" + account.getCashWithdrawalAmount());
    }
```

测试结果

```j
=========欢迎您进入KK银行ATM系统=========
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：2
==========欢迎您进入KK银行开户系统=========
请输入您的姓名：
kk
请输入您的密码：
123
请确认您的密码：
123
请输入您的取现额度：
2222
kk贵宾，您的账户已开户成功，您的卡号是：06420260
输入0退出系统,输入其他任意键返回菜单：
d
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：1
==========欢迎您进入KK银行登录界面=========
请输入您的卡号：
06420260
请输入您的密码：
123
登录成功！kk贵宾，正在进入系统······
==========欢迎您进入KK银行用户操作界面=========
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：1
==========欢迎您进入KK银行用户详情界面=========
您的账户信息如下：
卡号：06420260
姓名：kk
余额：0.0
当次取现额度：2222.0
=============================
输入任意键继续操作：
d
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：6
=========欢迎您进入KK银行ATM系统=========
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：
```



## **用户存款功能实现**

### **用户存款功能实现界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902123541.png)

### **存款分析**

1. 存款就是拿到当前账户对象。
2. 然后让用户输入存款的金额。
3. 调用账户对象的setMoney方法将账户余额修改成存钱后的余额。
4. 存钱后需要查询一下账户信息，确认是否存钱成功了！

### 代码实现

```java
public static void deposit(Scanner sc,Account account){
        System.out.println("==========欢迎您进入KK银行用户存款界面=========");
        System.out.println("请输入您要存入的金额：");
        account.setBalance(sc.nextDouble());
        System.out.println("存款成功！");
        query(account);

    }
```

返回结果

```j
=========欢迎您进入KK银行ATM系统=========
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：2
==========欢迎您进入KK银行开户系统=========
请输入您的姓名：
kk
请输入您的密码：
123
请确认您的密码：
123
请输入您的取现额度：
2222
kk贵宾，您的账户已开户成功，您的卡号是：80135582
输入0退出系统,输入其他任意键返回菜单：
d
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：1
==========欢迎您进入KK银行登录界面=========
请输入您的卡号：
80135582
请输入您的密码：
123
登录成功！kk贵宾，正在进入系统······
==========欢迎您进入KK银行用户操作界面=========
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：2
==========欢迎您进入KK银行用户存款界面=========
请输入您要存入的金额：
1000
存款成功！
==========欢迎您进入KK银行用户详情界面=========
您的账户信息如下：
卡号：80135582
姓名：kk
余额：1000.0
当次取现额度：2222.0
=============================
输入任意键继续操作：
d
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：2
==========欢迎您进入KK银行用户存款界面=========
请输入您要存入的金额：
1500
存款成功！
==========欢迎您进入KK银行用户详情界面=========
您的账户信息如下：
卡号：80135582
姓名：kk
余额：2500.0
当次取现额度：2222.0
=============================
输入任意键继续操作：

```





## **用户取款功能实现**

### **用户取款功能实现界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902123622.png)

### **取款分析**

1. 取款需要先判断账户是否有钱。
2. 有钱则拿到自己账户对象。
3. 然后让用户输入取款金额
4. 判断取款金额是否超过了当次限额，以及余额是否足够
5. 满足要求则调用账户对象的setMoney方法完成金额的修改

  ### 代码实现

```java
public static void withdrawMoney(Scanner sc,Account account){
        System.out.println("==========欢迎您进入KK银行用户取款界面=========");
        if(account.getBalance() < 100){
            System.out.println("账户余额已不足100元，请先存款哦");
        }else{
            while(true){
                System.out.println("请输入取款的金额（100的倍数）：");
                double money = sc.nextDouble();
                if(money > account.getCashWithdrawalAmount()){
                    System.out.println("您的取款金额超出当次限额！");
                }else if(money <= account.getBalance()){
                    System.out.println("取款成功");
                    account.setBalance(-money);
                    query(account);
                    break;
                }else{
                    System.out.println("您的余额不足");
                }
            }
        }
    }
```

返回结果

```j
=========欢迎您进入KK银行ATM系统=========
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：2
==========欢迎您进入KK银行开户系统=========
请输入您的姓名：
kk
请输入您的密码：
123
请确认您的密码：
123
请输入您的取现额度：
1000
kk贵宾，您的账户已开户成功，您的卡号是：47024760
输入0退出系统,输入其他任意键返回菜单：
d
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：1
==========欢迎您进入KK银行登录界面=========
请输入您的卡号：
47024760
请输入您的密码：
2
密码错误！请重新输入密码（剩余5次）：
请输入您的密码：
123
登录成功！kk贵宾，正在进入系统······
==========欢迎您进入KK银行用户操作界面=========
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：3
==========欢迎您进入KK银行用户取款界面=========
账户余额已不足100元，请先存款哦
=============================
输入任意键继续操作：
d
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：2
==========欢迎您进入KK银行用户存款界面=========
请输入您要存入的金额：
1500
存款成功！
==========欢迎您进入KK银行用户详情界面=========
您的账户信息如下：
卡号：47024760
姓名：kk
余额：1500.0
当次取现额度：1000.0
=============================
输入任意键继续操作：
d
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：3
==========欢迎您进入KK银行用户取款界面=========
请输入取款的金额（100的倍数）：
1300
您的取款金额超出当次限额！
请输入取款的金额（100的倍数）：
1000
取款成功
==========欢迎您进入KK银行用户详情界面=========
您的账户信息如下：
卡号：47024760
姓名：kk
余额：500.0
当次取现额度：1000.0
=============================
输入任意键继续操作：
d
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：3
==========欢迎您进入KK银行用户取款界面=========
请输入取款的金额（100的倍数）：
600
您的余额不足
请输入取款的金额（100的倍数）：
200
取款成功
==========欢迎您进入KK银行用户详情界面=========
您的账户信息如下：
卡号：47024760
姓名：kk
余额：300.0
当次取现额度：1000.0
=============================
输入任意键继续操作：

```



## **用户转账功能实现**

### **用户转账功能实现界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902132124.png)

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902132212.png)

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902132302.png)



### **分析**

1. 转账功能需要判断系统中是否有2个账户对象及以上。
2. 同时还要判断自己账户是否有钱。
3. 接下来需要输入对方卡号，判断对方账户是否存在。
4. 对方账户存在还需要认证对方户主的姓氏。
5. 满足要求则可以把自己账户对象的金额修改到对方账户对象中去。

### 代码实现

```java
//转账
    public static void transfer(Scanner sc, ArrayList<Account> accounts, Account accountOut) {
        System.out.println("==========欢迎您进入KK银行用户转账界面=========");
        if (accounts.size() < 2) {
            System.out.println("当前银行系统用户少于两个，不能进行转账操作");
        } else if (accountOut.getBalance() == 0) {
            System.out.println("账户余额不足，不能进行转账操作");
        } else {
            OUT:
            while(true){
                System.out.println("请输入收款账户：");
                String accountIn = sc.next();
//                System.out.println("xxx");
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getCardId().equals(accountIn)) {
                        if (accounts.get(i).getName().length() == 2) {
                            System.out.println("您即将要转账给" + accounts.get(i).getName().charAt(0) + "*");
                            while (true) {
                                System.out.println("请输入对方完整姓名确认转账:");
                                if (accounts.get(i).getName().equals(sc.next())) {
                                    while(true){
                                        System.out.println("请输入转账金额：");
                                        double money = sc.nextDouble();
                                        if(money > accountOut.getBalance())
                                        {
                                            System.out.println("转账金额大于您的余额");
                                        }else {
                                            accountOut.setBalance(-money);
                                            accounts.get(i).setBalance(money);
                                            System.out.println("转账成功！");
                                            query(accountOut);
                                            break OUT;
                                        }
                                    }
                                } else {
                                    System.out.println("输入的完整姓名有误，请重新输入");
                                }
                            }
                        } else if (accounts.get(i).getName().length() == 3) {
                            System.out.println("您即将要转账给" + accounts.get(i).getName().charAt(0) + "*"
                                    + accounts.get(i).getName().charAt(2));
                            while (true) {
                                System.out.println("请输入对方完整姓名确认转账:");
                                if (accounts.get(i).getName().equals(sc.next())) {
                                    while(true){
                                        System.out.println("请输入转账金额：");
                                        double money = sc.nextDouble();
                                        if(money > accountOut.getBalance())
                                        {
                                            System.out.println("转账金额大于您的余额");
                                        }else {
                                            accountOut.setBalance(-money);
                                            accounts.get(i).setBalance(money);
                                            System.out.println("转账成功！");
                                            query(accountOut);
                                            break OUT;
                                        }
                                    }
                                } else {
                                    System.out.println("输入的完整姓名有误，请重新输入");
                                }
                            }
                        } else {
                            System.out.println("您即将要转账给" + accounts.get(i).getName().charAt(0) + "**"
                                    + accounts.get(i).getName().substring(3));
                            while (true) {
                                System.out.println("请输入对方完整姓名确认转账:");
                                if (accounts.get(i).getName().equals(sc.next())) {
                                    while(true){
                                        System.out.println("请输入转账金额：");
                                        double money = sc.nextDouble();
                                        if(money > accountOut.getBalance())
                                        {
                                            System.out.println("转账金额大于您的余额");
                                        }else {
                                            accountOut.setBalance(-money);
                                            accounts.get(i).setBalance(money);
                                            System.out.println("转账成功！");
                                            query(accountOut);
                                            break OUT;
                                        }
                                    }
                                } else {
                                    System.out.println("输入的完整姓名有误，请重新输入");
                                }
                            }
                        }
                    }
                }
                System.out.println("未找到该账户，请重新输入：");
            }
        }

    }
```

测试结果

```j
=========欢迎您进入KK银行ATM系统=========
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：2
==========欢迎您进入KK银行开户系统=========
请输入您的姓名：
张扬
请输入您的密码：
123
请确认您的密码：
123
请输入您的取现额度：
2000
张扬贵宾，您的账户已开户成功，您的卡号是：62533387
输入0退出系统,输入其他任意键返回菜单：
62
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：1
==========欢迎您进入KK银行登录界面=========
请输入您的卡号：
62533387
请输入您的密码：
123
登录成功！张扬贵宾，正在进入系统······
==========欢迎您进入KK银行用户操作界面=========
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：4
==========欢迎您进入KK银行用户转账界面=========
当前银行系统用户少于两个，不能进行转账操作
=============================
输入任意键继续操作：
d
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：6
=========欢迎您进入KK银行ATM系统=========
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：2
==========欢迎您进入KK银行开户系统=========
请输入您的姓名：
杨老五
请输入您的密码：
123
请确认您的密码：
123
请输入您的取现额度：
2000
杨老五贵宾，您的账户已开户成功，您的卡号是：10043887
输入0退出系统,输入其他任意键返回菜单：
d
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：1
==========欢迎您进入KK银行登录界面=========
请输入您的卡号：
62533387
请输入您的密码：
123
登录成功！张扬贵宾，正在进入系统······
==========欢迎您进入KK银行用户操作界面=========
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：4
==========欢迎您进入KK银行用户转账界面=========
账户余额不足，不能进行转账操作
=============================
输入任意键继续操作：
d
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：2
==========欢迎您进入KK银行用户存款界面=========
请输入您要存入的金额：
2000
存款成功！
==========欢迎您进入KK银行用户详情界面=========
您的账户信息如下：
卡号：62533387
姓名：张扬
余额：2000.0
当次取现额度：2000.0
=============================
输入任意键继续操作：
d
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：4
==========欢迎您进入KK银行用户转账界面=========
请输入收款账户：
10043887
您即将要转账给杨*五
请输入对方完整姓名确认转账:
杨小五
输入的完整姓名有误，请重新输入
请输入对方完整姓名确认转账:
杨老五
请输入转账金额：
3000
转账金额大于您的余额
请输入转账金额：
2000
转账成功！
==========欢迎您进入KK银行用户详情界面=========
您的账户信息如下：
卡号：62533387
姓名：张扬
余额：0.0
当次取现额度：2000.0
=============================
输入任意键继续操作：

```





## **用户密码修改、销户功能实现**

### **用户密码修改、销户功能实现界面图：**

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220902135621.png)

### **分析**

1. 修改密码就是把当前对象的密码属性使用set方法进行更新。个账户对象及以上。

2. 销户是从集合对象中删除当前对象，并回到首页。



### 代码实现

```java
//修改密码
    public static void changePassword(Scanner sc,Account account) {
        System.out.println("==========欢迎您进入KK银行用户密码修改界面=========");
        while(true){
            System.out.println("请您输入当前账户密码：");
            String password = sc.next();
            if(account.getPassword().equals(password)){
                while(true){
                    System.out.println("请您输入新密码：");
                    password = sc.next();
                    System.out.println("请您再次输入新密码：");
                    if(password.equals(sc.next())){
                        System.out.println("密码修改成功");
                        account.setPassword(password);
                        return;
                    }else {
                        System.out.println("两次输入的密码不一致，请重新输入新密码：");
                    }
                }
            }else{
                System.out.println("密码错误，请重新输入：");
            }
        }
    }
```

测试结果

```j
=========欢迎您进入KK银行ATM系统=========
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：2
==========欢迎您进入KK银行开户系统=========
请输入您的姓名：
kk
请输入您的密码：
123
请确认您的密码：
123
请输入您的取现额度：
2000
kk贵宾，您的账户已开户成功，您的卡号是：41087235
输入0退出系统,输入其他任意键返回菜单：
1
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：1
==========欢迎您进入KK银行登录界面=========
请输入您的卡号：
41087235
请输入您的密码：
123
登录成功！kk贵宾，正在进入系统······
==========欢迎您进入KK银行用户操作界面=========
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：5
==========欢迎您进入KK银行用户密码修改界面=========
请您输入当前账户密码：
1234
密码错误，请重新输入：
请您输入当前账户密码：
123
请您输入新密码：
123456
请您再次输入新密码：
123456
密码修改成功
=============================
输入任意键继续操作：
d
1.查询				2.存款
3.取款				4.转账
5.修改密码			6.退出
7.注销当前账户
您可以选择对应指令进行操作：7
注销成功
=========欢迎您进入KK银行ATM系统=========
1.登录账户
2.注册开户
3.退出
请输入指令选择对应的操作：1
==========欢迎您进入KK银行登录界面=========
警告，当前系统内部无用户，请注册开户后重新进入系统
输入0退出系统,输入其他任意键返回菜单：
```

