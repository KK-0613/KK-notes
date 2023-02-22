# 巩固题

## 第1题：绳子覆盖点

![1573715386032](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1573715386032.png)

```java
package com.atguigu.homework1;

import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {

        double[] arr = new double[10];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = Math.random() * 100;//[0,100)之间的小数
        }
        arr[arr.length-1] = 0;
        System.out.println("直线上每一个点距离下一个点的距离："+Arrays.toString(arr));

        double length = 150.5;

        int count = 0;
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum<=length) {
                count++;
            }else {
                break;
            }
        }
        System.out.println("长度为：" + length + "的绳子最多能覆盖" +count+"个点");
    }
}
```

## 第2题：二分查找

![1573716432397](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1573716432397.png)

```java
package com.atguigu.homework2;

public class Homework2 {
    public static int binarySearch(int[] intsArray, int des) {
        int left = 0;
        int right = intsArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intsArray[mid] == des) {
                return mid;
            } else if (des > intsArray[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
```



## 第3题：二分查找

![1573721649453](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1573721649453.png)

```java
package com.atguigu.homework3;

public class Homework3 {
    public static int binarySearch(String[] intsArray, String des) {
        int left = 0;
        int right = intsArray.length-1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(intsArray[mid].equals(des)) {
                return mid;
            }else if(des.compareTo(intsArray[mid])>0){//字符串比较大小的方法
                left = mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }
}

```



## 第4题：素数

![1573721839343](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1573721839343.png)

```java
package com.atguigu.homework4;

import java.util.Arrays;

public class Homework4 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(suShu(10)));
    }

    public static int[] suShu(int n){
        int[] arr = new int[n];

        int index=0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if(i%j==0) {
                    flag=false;
                    break;
                }
            }
            if(flag) {
                arr[index++] = i;
            }
        }
        return Arrays.copyOf(arr, index);
    }
}
```

## 第5题：移动某个元素位置

![1573722779249](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1573722779249.png)

```java
package com.atguigu.homework5;

import java.util.Arrays;

public class Homework5 {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,4,5,6,7};
        arr = changPosition(1,5,arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] changPosition(int n1,int n2,int[] ii) {
        int indexN1=-1;
        for (int i = 0; i < ii.length; i++) {
            if(ii[i]==n1) {
                indexN1 = i;
                break;
            }
        }
        int indexN2 = -1;
        for (int i = 0; i < ii.length; i++) {
            if(ii[i]==n2) {
                indexN2 = i;
                break;
            }
        }
        System.arraycopy(ii, indexN1+1, ii, indexN1, indexN2-indexN1);
        ii[indexN2]=n1;
        return ii;
    }
}
```

## 第6题：循环删除元素

![1573716209038](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1573716209038.png)

有一个数组a[1000]存放0-999，要求每隔二个数删掉一个数，到末尾时循环至开头，继续运行。求最后一个被删掉的数的原始下标位置。

以8个数为例：

{0,1,2,3,4,5,6,7}：0->1->2（删掉）->3->4->5（删掉）->6->7->0（删掉）->1->3->4（删掉）->6->7->1（删掉）->3->4->6（删掉）->7->3->4（删掉）->7。

```java
package com.atguigu.homework6;

public class Homework6 {
    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        int i=0;
        int count = 0;
        int delNum = 0;//被删掉的数字个数
        while(true) {
            if(a[i]!=-1) {//被删掉的数不再计入count个数
                count++;
            }
            if(count==3) {//隔两个，第三个删掉
                a[i]=-1;//a[i]=-1，表示被删掉的数
                count=0;//count重新计数
                delNum++;//统计已经被删掉几个了
            }
            if(delNum==a.length-1) {//留下最后一个结束删除过程
                break;
            }
            if(++i==a.length) {//如果下标右移已经到头了，要从头开始
                i=0;
            }
        }

        for (int j = 0; j < a.length; j++) {
            if(a[j]!=-1) {
                System.out.println("最后一个被删掉的数是：a[j]=" + a[j] + "，它的下标：" + j);
            }
        }
    }
}
```



## 第7题：移动元素

![1574169751659](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1574169751659.png)

```java
package com.atguigu.homework7;

import java.util.Arrays;

public class Homework7 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};

        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            move(arr);
            System.out.println(Arrays.toString(arr));
        }

        int value = 4;
        System.out.println(indexOf(arr, moveCount, value));
    }

    public static int indexOf(int[] arr,int moveCount, int value) {
        while(moveCount>arr.length) {
            moveCount = moveCount - arr.length;
        }
        if(value == arr[0]) {
            return 0;
        }else if(value > arr[0]) {
            return Arrays.binarySearch(arr, 1, moveCount, value);
        }else {
            return Arrays.binarySearch(arr, moveCount, arr.length, value);
        }
    }

    public static void move(int[] arr) {
        int temp = arr[arr.length-1];
        System.arraycopy(arr, 0, arr, 1, arr.length-1);
        arr[0] = temp;
    }
}
```

## 第8题：数组排序

![1573715429966](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1573715429966.png)

冒泡排序：

```java
public static void bubbleSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
```

直接选择排序：

```java
public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			if(minIndex!=i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
	}
```

折半插入排序：

```java
public static void sort(int[] arr){
    for (int i=1; i<arr.length; i++){
        //找到[0,i)之间插入arr[i]的位置
        //使用二分查找法
        int left = 0;
        int right=i-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(arr[i]<=arr[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        //在[0,i)插入arr[i]
        if(left < i){
            int temp = arr[i];
            System.arraycopy(arr,left,arr,left+1,i-left);
            arr[left] = temp;
        }
    }
}
```

例如：数组{12,2,6,1,5}

第一次：在[0,1)之间找插入2的位置==>left = [0] ==> {2,12,6,1,5}

第二次：在[0,2)之间找插入6的位置==>left = [1] ==> {2,6,12,1,5}

第三次：在[0,3)之间找插入1的位置==>left = [0] ==>{1,2,6,12,5}

第四次：在[0,4)之间找插入5的位置==>left = [2] ==>{1,2,5,6,12}

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/%E6%8A%98%E5%8D%8A%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F%E8%BF%87%E7%A8%8B%E5%88%86%E6%9E%90.png)

快速排序：

```java
//将[start+1,end]之间的元素分为两拨，左边的所有元素比arr[start]小，右边的所有元素比arr[start]大
public static void sort(int[] arr,int start, int end){
    if(start < end){
        int left = start;
        int right = end+1;
        while(left<right){
            //从左往右，从[start+1]开始找比arr[start]大的数arr[left]，让它与arr[right]交换
            //当arr[++left]大于arr[start]就停止循环，因为此时找到了比arr[start]大的数arr[left]
            while(arr[++left]<=arr[start] && left<end){
            }

            //从右往左，从[end]开始找比arr[start]小的数arr[right]，让它与arr[left]交换
            //当arr[right]小于arr[start]就停止循环，因为此时找到了比arr[start]小的数arr[right]
            while(arr[--right]>=arr[start] && right>start){
            }

            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        //经过上面的while
        //[start+1,right]之间的是比arr[start]小的数
        //(right,end]之间的是比arr[start]大的数
        //交换arr[start]与arr[right]
        if(right>start) {
            int temp = arr[start];
            arr[start] = arr[right];
            arr[right] = temp;
        }

        //经过上面的代码，原来arr[start]的值（基准值）到达了它正确的位置arr[right]，因为左边的数都比它小，右边的数都比它大
        //所以需要分别对[start,right-1]、[right+1,end]之间元素重复上面的操作继续排序
        sort(arr,start,right-1);
        sort(arr,right+1,end);
    }
}
```

快速排序：首元素基准法

在快排的过程中，每一次我们要取一个元素作为枢纽值，以这个数字来将序列划分为两部分。

在此我们选择每次待排序序列的第一个元素作为枢纽值。

![image-20210508115127264](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20210508115127264.png)

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/%E5%BF%AB%E6%8E%92%E6%96%B9%E6%A1%88%E4%BA%8C%EF%BC%881%EF%BC%89.png)

![image-20210508115714484](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20210508115714484.png)

![image-20210508115734824](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20210508115734824.png)

![image-20210508115752046](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20210508115752046.png)

![image-20210508115807538](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20210508115807538.png) 

