# Java方法参数传递案例练习

## 案例1 打印整型数组内容

### 需求

**设计一个方法用于输出任意整型数组的内容，要求输出成如下格式：**

​		"该数组内容为：[11,22,33,44,55]"

### 实现

```java
package com.kk.demo;

public class Demo04 {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55};
        arrayPrint(arr);
    }
    public static void arrayPrint(int[] array){
        System.out.print("该数组内容为：[");
        if(array != null && array.length > 0){
            for (int i = 0; i < array.length; i++) {
                System.out.print(i == array.length - 1? array[i] : array[i] + "，");
            }
        }
        System.out.println("]");
    }
}

```

返回结果

```j
该数组内容为：[11，22，33，44，55]
```

## 案例2 从数组中查询指定元素的索引

### 需求

**设计一个方法可以接收整型数组，和要查询的元素值；最终要返回元素在该数组中索引，如果数组中不存在该元素则返回-1**

```j
例如，[11，22，33，44，55]
    输入元素：44。返回索引3
    输入元素：88。返回索引-1
```

### 实现

```java
package com.kk.demo;

public class Demo05 {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55};
        System.out.println(searchIndex(arr,11));
        System.out.println(searchIndex(arr,88));
    }

    public static int searchIndex(int[] arr,int n){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == n){
                return i;
            }
        }
        return -1;
    }
}

```

返回结果

```j
0
-1
```

## 案例3 比较两个数组是否一样

### 需求

**如果两个数组的类型、元素个数、元素顺序和内容是一样的我们就认为这两个数组是一模一样的。**

```java
例如，如下两个数组是一样的
    int[] arrs = {10,20,30}
	int[] arrs = {10,20,30}
```

**请使用方法完成：能够判断任意两个整型数组是否一样，并返回true或false**

### 实现

```java
package com.kk.demo;

public class Demo06 {
    public static void main(String[] args) {

        int[] arr1 = {11,22,33};
        int[] arr2 = {11,22,33};
        int[] arr3 = {22,33,44};
        System.out.println(arrayEqually(arr1, arr2));
        System.out.println(arrayEqually(arr1,arr3));

    }

    public static boolean arrayEqually(int[] arr1, int[] arr2) {
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}

```

返回结果

```j
true
false
```

