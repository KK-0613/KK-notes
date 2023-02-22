# 巩固题

## 第1题：反转键盘录入的字符串。

参考效果如图所示：

![image-20220124084716264](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220124084716264.png)

```java
package com.atguigu.test01;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请键盘输入字符串：");
		String str = input.next();
		
		StringBuilder s = new StringBuilder(str);
		str = s.reverse().toString();
		System.out.println("反转后：" + str);
		input.close();
	}
}

```



## 第2题：验证qq号码

* 键盘录入QQ号码，验证格式的正确性。
  * 必须是5—12位数字。
  * 0不能开头。

* 效果如图所示：

  ![image-20220124085036154](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220124085036154.png)
  
  ![image-20220124085054255](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220124085054255.png)

```java
package com.atguigu.homework2;

import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入qq号码：");
        String qq = input.next();

        System.out.print("这个qq号是否正确：");
        if(qq.matches("[1-9][0-9]{4,11}+")){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        input.close();
    }
}
```

## 第3题：替换某字符串中的某些字符。

* 键盘录入一个源字符串存储在srcStr变量中，再录入要删除的字符串存储在delStr变量中。
* 删除该字srcStr符串中的所有delStr字符串。
* 并且统计delStr字符串在srcStr中出现的次数

效果如图所示：

![1559729633062](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1559729633062.png)

```java
package com.atguigu.homework3;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入原字符串：");
        String src = input.next();

        System.out.print("请输入要删除的字符串：");
        String del = input.next();

        String result = src.replaceAll(del, "");

        int count = (src.length() - result.length())/del.length();
        System.out.println(del+"共出现了：" + count + "次");
        System.out.println("删除" + del + "后字符串：" + result);

        input.close();
    }
}
```

## 第4题：筛选字符串

定义数组，存入多个字符串。删除长度大于5的字符串，打印删除后的数组。

效果如图所示：

![image-20220124090411928](尚硅谷_15_基础API与常见算法_homework.assets/image-20220124090411928.png)

```java
package com.atguigu.homework4;

import java.util.Arrays;

public class Homework4 {
    public static void main(String[] args) {
        String[] arr = {"helloworld","java","chai","atguigu","lin","yan","I love you"};

        System.out.println("原字符串：");
        System.out.println( Arrays.toString(arr));
        int index = 0;
        int length = arr.length;
        while(index < length){
            if(arr[index].length()>5){
                System.arraycopy(arr, index+1, arr, index, length-index-1);
                length--;
            }else{
                index++;
            }
        }
        System.out.println("删除后：");
        arr = Arrays.copyOf(arr, length);
        System.out.println(Arrays.toString(arr));
    }
}

```

## 第5题：判断回文字符串

如果一个字符串，从前向后读和从后向前读，都是一个字符串，称为回文串，比如mom，dad，noon。

```java
package com.atguigu.homework5;

import org.junit.Test;

public class Homework5 {
    @Test
    public void test01() {
        String str = "noon";
        StringBuilder s = new StringBuilder(str);
        String string = s.reverse().toString();
        if(str.equals(string)){
            System.out.print(str + "是回文数");
        }else{
            System.out.print(str + "不是回文数");
        }
    }

    @Test
    public void test02() {
        String str = "noon";
        char[] arr = str.toCharArray();
        boolean flag = true;
        for (int left = 0,right=arr.length-1; left <=right; left++,right--) {
            if(arr[left] != arr[right]){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.print(str + "是回文数");
        }else{
            System.out.print(str + "不是回文数");
        }
    }
}
```

## 第6题：统计字母出现个数情况

1个字符串中可能包含a-z中的多个字符，字符也可能重复，例如：String data = “aabcexmkduyruieiopxzkkkkasdfjxjdsds”;写一个程序，对于给定一个这样的字符串求出字符串出现次数最多的那个字母以及出现的次数（若次数最多的字母有多个，则全部求出）

![1574169374414](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1574169374414.png)

```java
package com.atguigu.homework7;

public class Homework7 {
    public static void main(String[] args) {
        String str = "aabbyolhljlhlxxmnbwyteuhfhjloiqqbhrg";

        //统计每个字母的次数
        int[] counts = new int[26];
        char[] letters = str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            counts[letters[i]-97]++;
        }

        //找出最多次数值
        int max = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if(max < counts[i]) {
                max = counts[i];
            }
        }
        //找出所有最多次数字母
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == max) {
                System.out.println((char)(i+97));
            }
        }
    }
}
```

## 第7题：拆分

案例：已知一个字符串内容如下，要求拆分出每一个单词，并遍历显示

```java
String str = "1.hello2.world3.java4.string";
```

```java
package com.atguigu.homework8;

public class Homework8 {
    public static void main(String[] args) {
        String str = "1.hello2.world3.java4.string";
        //把开头的1.去掉
        str = str.replaceAll("^\\d\\.","");
        //按照数字.的格式进行拆分
        String[] split = str.split("\\d\\.");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
```

