# 巩固题

## 1、月份

用一个数组，保存12个月的英语单词，从键盘输入1-12，显示对应的单词。

```java
{"January","February","March","April","May","June","July","August","September","October","November","December"}
```

```java
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        String[] monthNames = {"January","February","March","April","May","June","July","August","September","October","November","December"};

        Scanner input = new Scanner(System.in);
        System.out.print("请输入月份值：");
        int month = input.nextInt();

        if(month <1 || month> 7){
            System.out.println("输入有误");
        }else{
            System.out.println("月份" + month +"是" + monthNames[month-1]);
        }

        input.close();
    }
}
```

## 2、打印扑克牌

遍历输出一副扑克牌。

```java
String[] hua = {"黑桃","红桃","梅花","方片"};
String[] dian = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
```

```java
public class Homework2 {
    public static void main(String[] args) {
        String[] hua = {"黑桃","红桃","梅花","方片"};
        String[] dian = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        String[] pu = new String[hua.length*dian.length+2];
        for(int i=0,k=0; i<hua.length; i++){
            for(int j=0; j<dian.length; j++,k++){
                pu[k] = hua[i]+dian[j];
            }
        }
        pu[pu.length-2] = "大王";
        pu[pu.length-1] = "小王";

        for (int i = 1; i <= pu.length; i++) {
            System.out.print(pu[i-1]+" ");
            if(i%13==0){
                System.out.println();
            }
        }
    }
}
```

## 3、正序和逆序输出26个英文字母

要求使用char数组存储26个英文字母，并分别用正序和逆序方式显示输出。要求10个一行。

![image-20211224105504484](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20211224105504484.png)

```java
public class Homework3 {
    public static void main(String[] args) {
        char[] letters = new char[26];

        for (int i=0; i<letters.length; i++){
            letters[i] = (char)('a' + i);
        }

        System.out.println("小写字母的正序排序：");
        int count = 0;
        for (int i = 0; i <letters.length; i++) {
            count++;
            if(count == 10 || i == letters.length-1){
                System.out.println(letters[i]);
                count = 0;
            }else if(count < 10) {
                System.out.print(letters[i]+",");
            }
        }

        System.out.println("小写字母的逆序排序：");
        count = 0;
        for (int i = letters.length-1; i >= 0; i--) {
            count++;
            if(count == 10 || i == 0){
                System.out.println(letters[i]);
                count = 0;
            }else if(count < 10) {
                System.out.print(letters[i]+",");
            }
        }
    }
}

```



## 4、判断数组中的元素值是否对称

判断某个数组是否是对称数组，即数组正序遍历和倒序遍历的结果是一样的。例如：

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/6.jpg)

开发提示：数组中元素首尾比较。


```java
public class Homework4 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,4,3,2,1};

        //(1)先假设它是对称的
        boolean flag = true;

        //(2)遍历，查看数组的元素是否首尾对称
        //left表示左边的下标
        //right表示右边的下标
        for(int left=0,right=arr.length-1; left<right; left++,right--){
            if(arr[left] != arr[right]){
                flag = false;
                break;
            }
        }

        System.out.println(flag?"对称":"不对称");
    }
}
```



# 拔高题

## 1、统计字符出现次数

英语中最长的单词是"pneumonoultramicroscopicsilicovolcanoconiosis"，意思是“肺尘病，矽肺病”，一共有45个英文字母。现在要求统计这个单词中出现了哪些字母，以及它们出现的次数，并且找出出现次数最多的字母。

开发提示：

（1）使用String类型的变量words存储英语单词"pneumonoultramicroscopicsilicovolcanoconiosis"

（2）通过word.toCharArray()可以根据字符串word得到一个char[]类型的数组。

其中toCharArray()是String类型提供的系统函数，就像Math.random()等函数一样，后面会学到，这里先提前用一下。它的作用就是创建一个char[]数组，并把字符串中的每一个字符依次存储到这个char[]数组中。

```java
//以"hello"为例
String word = "hello";
char[] wordCharArray = word.toCharArray();
//此时wordCharArray字符数组内容是 {‘h','e','l','l','o'}
```

（3）声明一个int类型的数组counts，长度为26，分别用来记录26个字母出现的次数，counts[0]记录的是'a'字母的次数，counts[1]记录的是'b'字母的次数，依次类推。

```java
public class Homowork5 {
    public static void main(String[] args) {
        String word = "pneumonoultramicroscopicsilicovolcanoconiosis";
        char[] wordCharArray = word.toCharArray();

        int[] counts = new int[26];
        for (int i = 0; i < wordCharArray.length; i++) {
            counts[wordCharArray[i]-97]++;
        }

        int max = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if(counts[i] > max){
                max = counts[i];
            }
        }

        System.out.println("单词中出现了如下字母：");
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] != 0){
                System.out.println((char)(i+97) +"：" + counts[i]);
            }
        }
        System.out.print("出现次数最多的字母是：");
        for (int i = 0; i < counts.length; i++) {
            if(max == counts[i]){
                System.out.print((char)(i+97) + "\t");
            }
        }
        System.out.println();
    }
}
```

## 2、统计低于平均分的学生人数

先从键盘输入本组学员的人数，再从键盘输入本组学员的姓名和成绩，最后统计：

- 本组学员的平均分，
- 低于平均分的学员人数，
- 哪些学员低于平均分，
- 最高分和最低分分别是谁。

```java
import java.util.Scanner;

public class Homowork6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请录入本组学员人数：");
        int count = input.nextInt();

        int[] grades = new int[count];
        String[] names = new String[count];

        for (int i = 0; i < grades.length; i++) {
            System.out.print("第" + (i+1) + "个学员的姓名：");
            names[i] = input.next();

            System.out.print("第" + (i+1) + "个学员的成绩：");
            grades[i] = input.nextInt();
        }
        input.close();

        //学员姓名和成绩
        System.out.println("所有学员的成绩如下：");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ":" + grades[i]);
        }

        //找出最高分、最低分、累加总分，计算平均分
        int max = grades[0];
        int min = grades[0];
        double sum = 0;
        for (int i = 1; i < grades.length; i++) {
            if(grades[i] > max){
                max = grades[i];
            }
            if(grades[i] < min){
                min = grades[i];
            }
            sum += grades[i];
        }
        double avg = sum/grades.length;

        //输出结果
        System.out.println("最高分成绩是：" + max);
        System.out.println("最第分成绩是：" + min);
        System.out.println("平均分成绩是：" + avg);
        System.out.println("获得最高分的有：");
        for (int i = 0; i < names.length; i++) {
            if(max == grades[i]){
                System.out.println(names[i]);
            }
        }
        System.out.println("获得最第分的有：");
        for (int i = 0; i < names.length; i++) {
            if(min == grades[i]){
                System.out.println(names[i]);
            }
        }
        System.out.println("低于平均分的有：");
        int total = 0;
        for (int i = 0; i < names.length; i++) {
            if(grades[i] < avg){
                System.out.println(names[i]);
                total++;
            }
        }
        System.out.println("低于平均分的一共有：" + total +"人");
    }
}
```



