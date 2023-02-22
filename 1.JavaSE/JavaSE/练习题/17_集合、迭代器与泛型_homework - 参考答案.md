# 巩固题

## 第1题：扑克牌

案例：

​	1、用一个String[]数组存点数

​	2、用一个String[]数组存花色

​	3、用一个String[]数组存大王、小王

​	4、用上面的数组，生成一副扑克牌

​	5、遍历显示全副扑克牌

​	6、模拟给4个人随机发牌，每个人11张牌

​	7、显示每个人的牌和剩余的牌

​	效果如下：

![image-20220201200407860](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220201200407860.png)

```java
package com.atguigu.homework1;

import java.util.ArrayList;
import java.util.Random;

public class Homework1 {
    public static void main(String[] args) {
        String[] dian = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] hua = {"黑桃","红桃","方片","梅花"};
        String[] wang = {"大王","小王"};

        ArrayList<String> list = new ArrayList<String>();
        for (int j = 0; j < hua.length; j++) {
            for (int i = 0; i < dian.length; i++) {
                list.add(hua[j]+dian[i]);
            }
        }
        for (int i = 0; i < wang.length; i++) {
            list.add(wang[i]);
        }

        System.out.println("所有扑克牌：");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"  ");
            if((i+1)%13==0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("发牌：");

        Random rand = new Random();
        ArrayList<String> one = new ArrayList<String>();
        for (int i = 0; i < 11; i++) {
            one.add(list.remove(rand.nextInt(list.size())));
        }

        ArrayList<String> two = new ArrayList<String>();
        for (int i = 0; i < 11; i++) {
            two.add(list.remove(rand.nextInt(list.size())));
        }

        ArrayList<String> three = new ArrayList<String>();
        for (int i = 0; i < 11; i++) {
            three.add(list.remove(rand.nextInt(list.size())));
        }

        ArrayList<String> four = new ArrayList<String>();
        for (int i = 0; i < 11; i++) {
            four.add(list.remove(rand.nextInt(list.size())));
        }

        System.out.println("第1个人：" + one);
        System.out.println("第2个人：" + two);
        System.out.println("第3个人：" + three);
        System.out.println("第4个人：" + four);
        System.out.println("剩余：" + list);
    }
}
```

## 第2题：去重复字符

键盘录入一串字符，去掉其中重复字符，打印出不同的那些字符，必须保证顺序。例如输入：aaaabbbcccddd，打印结果为：abcd。效果如图：

![image-20220201200857993](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220201200857993.png)

提示：LinkedHashSet的使用

```java
package com.atguigu.test06;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入一串字母：");
		String str = input.nextLine();
		System.out.println("str=" + str);
		
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}
		
		System.out.print("去重后：");
		String result = "";
		for (Character object : set) {
			result += object;
		}
		System.out.println(result);
	}
}

```

## 第3题：双色球

案例：双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1—33中选择；蓝色球号码从1—16中选择；请随机生成一注双色球号码。（要求同色号码不重复）

![1559896882586](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1559896882586.png)

开发提示：可以使用TreeSet和ArrayList结合

```java
package com.atguigu.homework3;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Homework3 {
    public static void main(String[] args) {
        TreeSet<Integer> red = new TreeSet<Integer>();
        Random rand = new Random();
        while(red.size()<6){
            red.add(rand.nextInt(33)+1);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(red);
        list.add(rand.nextInt(16)+1);//蓝色号码
        System.out.println("双色球所有号码：" + list);

        System.out.print("红色号码：");
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println("蓝色号码：" + list.get(list.size()-1));
    }
}
```

## 第4题：统计字母次数

![1559747624616](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1559747624616.png)

开发提示：可以使用Map，key是字母，value是该字母的次数

效果演示：例如：String str = "Your future depends on your dreams, so go to sleep.";

![1560042043311](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1560042043311.png)

```java
package com.atguigu.homework4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Homework4 {
    public static void main(String[] args) {
        String str = "Your future depends on your dreams, so go to sleep.";
        str = str.replaceAll("[^a-zA-Z]", "");
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                Integer count = map.get(arr[i]);
                map.put(arr[i], count+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character,Integer> entry : entrySet) {
            System.out.println(entry);
        }
    }
}
```

## 第5题：歌手歌曲

案例：添加你喜欢的歌手以及你喜欢他唱过的歌曲

例如：

![1560042024295](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1560042024295.png)

```java
package com.atguigu.homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Homework5 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> wangfei = new ArrayList<String>();
        wangfei.add("《红豆》");
        wangfei.add("《传奇》");
        wangfei.add("《容易受伤的女人》");
        map.put("王菲", wangfei);
        
        ArrayList<String> zxy = new ArrayList<String>();
        zxy.add("《一路上有你》");
        zxy.add("《吻别》");
        zxy.add("《一千个伤心的理由》");
        map.put("张学友", zxy);

        Set<Map.Entry<String, ArrayList<String>>> entrySet = map.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entrySet) {
            System.out.println(entry);
        }
    }
}
```

## 第6题：省份城市

案例：

​	添加如下省份与城市信息到map中，并遍历显示

```java
浙江省
	绍兴市
	温州市
	湖州市
	嘉兴市
	台州市
	金华市
	舟山市
	衢州市
	丽水市
	杭州市
	宁波市
海南省
	海口市
	三亚市
北京市
	北京市
```

开发提示：

​	其中key为省份名，value为该省份所有的市辖区

```java
package com.atguigu.homework6;

import java.util.*;

public class Homework6 {
    public static void main(String[] args) throws Exception {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("北京市", Arrays.asList("北京市"));
        map.put("海南省", Arrays.asList("海口市","三亚市"));
        map.put("浙江省", Arrays.asList("绍兴市","温州市","湖州市","嘉兴市","台州市","金华市","舟山市","衢州市","丽水市"));

        Set<Map.Entry<String, List<String>>> entrySet = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            System.out.println(entry);
        }
    }
}
```

