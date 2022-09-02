package com.kk.atm;

import com.sun.security.jgss.GSSUtil;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;
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

        frontPage(sc, accounts);
    }

    //首页
    public static void frontPage(Scanner sc, ArrayList<Account> accounts) {
        System.out.println("=========欢迎您进入KK银行ATM系统=========");

        OUT:
        do {
            System.out.println("1.登录账户");
            System.out.println("2.注册开户");
            System.out.println("3.退出");
            System.out.print("请输入指令选择对应的操作：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    login(sc, accounts);
                    break;
                case 2:
                    register(sc, accounts);
                    break;
                case 3:
                    break OUT;
                default:
                    System.out.println("指令错误");
            }
            System.out.println("输入0退出系统,输入其他任意键返回菜单：");
        } while (!sc.next().equals("0"));
    }

    //注册
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

        accounts.add(account);

    }

    //登录
    public static void login(Scanner sc, ArrayList<Account> accounts) {
        System.out.println("==========欢迎您进入KK银行登录界面=========");
        if (accounts.size() == 0) {
            System.out.println("警告，当前系统内部无用户，请注册开户后重新进入系统");
            return;
        }
        OUT:
        while (true) {
            System.out.println("请输入您的卡号：");
            String carId = sc.next();
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getCardId().equals(carId)) {
                    for (int j = 4; j >= 0; j--) {
                        System.out.println("请输入您的密码：");
                        if (accounts.get(i).getPassword().equals(sc.next())) {
                            System.out.println("登录成功！" + accounts.get(i).getName() + "贵宾，正在进入系统······");
                            actionPage(sc, accounts.get(i), accounts);
                            break OUT;
                        } else {
                            System.out.println("密码错误！请重新输入密码（剩余" + (j + 1) + "次）：");
                        }
                    }
                }
            }
            System.out.println("卡号不存在，请重新输入：");
        }
    }

    //用户操作页设计、查询账户、退出账户功能
    public static void actionPage(Scanner sc, Account account, ArrayList<Account> accounts) {
        System.out.println("==========欢迎您进入KK银行用户操作界面=========");

        while (true) {
            System.out.println("1.查询\t\t\t\t2.存款");
            System.out.println("3.取款\t\t\t\t4.转账");
            System.out.println("5.修改密码\t\t\t6.退出");
            System.out.println("7.注销当前账户");
            System.out.print("您可以选择对应指令进行操作：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    query(account); //查询
                    break;
                case 2:
                    deposit(sc, account); //存款
                    break;
                case 3:
                    withdrawMoney(sc, account); //取款
                    break;
                case 4:
                    transfer(sc,accounts,account); //转账
                    break;
                case 5:
                    changePassword(sc,account); //修改密码
                    break;
                case 6:
                    frontPage(sc, accounts); //退出
                    return;
                case 7:
                    accounts.remove(account); //注销账户
                    System.out.println("注销成功");
                    frontPage(sc, accounts);
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
    public static void query(Account account) {
        System.out.println("==========欢迎您进入KK银行用户详情界面=========");
        System.out.println("您的账户信息如下：");
        System.out.println("卡号：" + account.getCardId());
        System.out.println("姓名：" + account.getName());
        System.out.println("余额：" + account.getBalance());
        System.out.println("当次取现额度：" + account.getCashWithdrawalAmount());
    }

    //存款
    public static void deposit(Scanner sc, Account account) {
        System.out.println("==========欢迎您进入KK银行用户存款界面=========");
        System.out.println("请输入您要存入的金额：");
        account.setBalance(sc.nextDouble());
        System.out.println("存款成功！");
        query(account);

    }

    //取款
    public static void withdrawMoney(Scanner sc, Account account) {
        System.out.println("==========欢迎您进入KK银行用户取款界面=========");
        if (account.getBalance() < 100) {
            System.out.println("账户余额已不足100元，请先存款哦");
        } else {
            while (true) {
                System.out.println("请输入取款的金额（100的倍数）：");
                double money = sc.nextDouble();
                if (money > account.getCashWithdrawalAmount()) {
                    System.out.println("您的取款金额超出当次限额！");
                } else if (money <= account.getBalance()) {
                    System.out.println("取款成功");
                    account.setBalance(-money);
                    query(account);
                    break;
                } else {
                    System.out.println("您的余额不足");
                }
            }
        }
    }

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
}