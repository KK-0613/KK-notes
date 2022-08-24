# Java运算符
计算机的最基本用途之一就是执行数学运算，作为一门计算机语言，Java也提供了一套丰富的运算符来操纵变量。我们可以把运算符分成以下几组：

- 算术运算符
- 关系运算符
- 位运算符
- 逻辑运算符
- 赋值运算符
- 其他运算符

## 算术运算符
包括+、-、*、/、%、++、--，可根据下述的实例举例来理解每个操作符的用法：
```java
public class Test {
 
  public static void main(String[] args) {
     int a = 10;
     int b = 20;
     int c = 25;
     int d = 25;
     System.out.println("a + b = " + (a + b) );
     System.out.println("a - b = " + (a - b) );
     System.out.println("a * b = " + (a * b) );
     System.out.println("b / a = " + (b / a) );
     System.out.println("b % a = " + (b % a) );
     System.out.println("c % a = " + (c % a) );
     System.out.println("a++   = " +  (a++) );
     System.out.println("a--   = " +  (a--) );
     // 查看  d++ 与 ++d 的不同
     System.out.println("d++   = " +  (d++) );
     System.out.println("++d   = " +  (++d) );
  }
}
```
输出结果：
```
a + b = 30
a - b = -10
a * b = 200
b / a = 2
b % a = 0
c % a = 5
a++   = 10
a--   = 11
d++   = 25
++d   = 27
```
## 自增自减运算符
### 1、自增（++）自减（--）运算符是一种特殊的算术运算符，在算术运算符中需要两个操作数来进行运算，而自增自减运算符是一个操作数。

```java
public class selfAddMinus{
    public static void main(String[] args){
        int a = 3;//定义一个变量；
        int b = ++a;//自增运算
        int c = 3;
        int d = --c;//自减运算
        System.out.println("进行自增运算后的值等于"+b);
        System.out.println("进行自减运算后的值等于"+d);
    }
}
```
运行结果为：
```
进行自增运算后的值等于4
进行自减运算后的值等于2
```
解析：

int b = ++a; 拆分运算过程为: a=a+1=4; b=a=4, 最后结果为b=4,a=4<br>
int d = --c; 拆分运算过程为: c=c-1=2; d=c=2, 最后结果为d=2,c=2

### 2、前缀自增自减法(++a,--a): 先进行自增或者自减运算，再进行表达式运算。
### 3、后缀自增自减法(a++,a--): 先进行表达式运算，再进行自增或者自减运算 
实例：
```java
public class selfAddMinus{
    public static void main(String[] args){
        int a = 5;//定义一个变量；
        int b = 5;
        int x = 2*++a;
        int y = 2*b++;
        System.out.println("自增运算符前缀运算后a="+a+",x="+x);
        System.out.println("自增运算符后缀运算后b="+b+",y="+y);
    }
}
```
运行结果为：
```
自增运算符前缀运算后a=6，x=12
自增运算符后缀运算后b=6，y=10
```
## 关系运算符
包括==、!=、>、<、>=、<=，通过下述实例理解：
```java
public class Test {
 
  public static void main(String[] args) {
     int a = 10;
     int b = 20;
     System.out.println("a == b = " + (a == b) );
     System.out.println("a != b = " + (a != b) );
     System.out.println("a > b = " + (a > b) );
     System.out.println("a < b = " + (a < b) );
     System.out.println("b >= a = " + (b >= a) );
     System.out.println("b <= a = " + (b <= a) );
  }
}
```
以上实例编译运行结果如下：
```
a == b = false
a != b = true
a > b = false
a < b = true
b >= a = true
b <= a = false
```
## 位运算符
Java定义了位运算符，应用于整数类型(int)，长整型(long)，短整型(short)，字符型(char)，和字节型(byte)等类型。

位运算符作用在所有的位上，并且按位运算。假设a = 60，b = 13;它们的二进制格式表示将如下：
```java
A = 0011 1100
B = 0000 1101
-----------------
A&B = 0000 1100
A | B = 0011 1101
A ^ B = 0011 0001
~A= 1100 0011
```
|＆|	如果相对应位都是1，则结果为1，否则为0|（A＆B），得到12，即0000 1100|
|---|---|---|
|\||	如果相对应位都是 0，则结果为 0，否则为 1|（A \| B）得到61，即 0011 1101|
|^|	如果相对应位值相同，则结果为0，否则为1|（A ^ B）得到49，即 0011 0001|
|〜|	按位取反运算符翻转操作数的每一位，即0变成1，1变成0。|（〜A）得到-61，即1100 0011|
|<<| 	按位左移运算符。左操作数按位左移右操作数指定的位数。|A << 2得到240，即 1111 0000|
|>>| 	按位右移运算符。左操作数按位右移右操作数指定的位数。|A >> 2得到15,即 1111|
|>>>| 	按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。|	A>>>2得到15,即0000 1111|

下面的简单示例程序演示了位运算符。
```java
public class Test {
  public static void main(String[] args) {
     int a = 60; /* 60 = 0011 1100 */ 
     int b = 13; /* 13 = 0000 1101 */
     int c = 0;
     c = a & b;       /* 12 = 0000 1100 */
     System.out.println("a & b = " + c );
 
     c = a | b;       /* 61 = 0011 1101 */
     System.out.println("a | b = " + c );
 
     c = a ^ b;       /* 49 = 0011 0001 */
     System.out.println("a ^ b = " + c );
 
     c = ~a;          /*-61 = 1100 0011 */
     System.out.println("~a = " + c );
 
     c = a << 2;     /* 240 = 1111 0000 */
     System.out.println("a << 2 = " + c );
 
     c = a >> 2;     /* 15 = 1111 */
     System.out.println("a >> 2  = " + c );
  
     c = a >>> 2;     /* 15 = 0000 1111 */
     System.out.println("a >>> 2 = " + c );
  }
} 
```
以上实例编译运行结果如下：
```
a & b = 12
a | b = 61
a ^ b = 49
~a = -61
a << 2 = 240
a >> 2  = 15
a >>> 2 = 15
```
## 逻辑运算符
下表列出了逻辑运算符的基本运算，假设布尔变量A为真，变量B为假
|操作符|	描述	|例子|
|---|---|---|
|&&|	称为逻辑与运算符。当且仅当两个操作数都为真，条件才为真。|	（A && B）为假。|
|\|\|| 	称为逻辑或操作符。如果任何两个操作数任何一个为真，条件为真。|	(A \|\| B)为真。|
|！|	称为逻辑非运算符。用来反转操作数的逻辑状态。如果条件为true，则逻辑非运算符将得到false。|	!(A && B)为真。|

**实例:**
```java
public class Test {
  public static void main(String[] args) {
     boolean a = true;
     boolean b = false;
     System.out.println("a && b = " + (a&&b));
     System.out.println("a || b = " + (a||b) );
     System.out.println("!(a && b) = " + !(a && b));
  }
}
```
以上实例编译运行结果如下：
```
a && b = false
a || b = true
!(a && b) = true
```

### 短路逻辑运算符
当使用与逻辑运算符时，在两个操作数都为true时，结果才为true，但是当得到第一个操作为false时，其结果就必定是false，这时候就不会再判断第二个操作了。
```java
public class LuoJi{
    public static void main(String[] args){
        int a = 5;//定义一个变量；
        boolean b = (a<4)&&(a++<10);
        System.out.println("使用短路逻辑运算符的结果为"+b);
        System.out.println("a的结果为"+a);
    }
}
```
运行结果为：
```
使用短路逻辑运算符的结果为false
a的结果为5
```
*解析： 该程序使用到了短路逻辑运算符(&&)，首先判断 a<4 的结果为 false，则 b 的结果必定是 false，所以不再执行第二个操作 a++<10 的判断，所以 a 的值为 5。*

## 赋值运算符
