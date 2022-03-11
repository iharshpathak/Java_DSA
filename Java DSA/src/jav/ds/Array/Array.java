package jav.ds.Array;

public class Array {

    // print elements and adding or updating elements in array 5-01-2022
    public static void printArray(int [] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }

    public void arrayDemo(){
        int[] myArray = new int[5];
        myArray[0]=5;
        myArray[1]=1;
        myArray[2]=8;
        myArray[3]=2;
        myArray[4]=10;
        myArray[2]=9;

        printArray(myArray);
        System.out.println(myArray.length);
        System.out.println(myArray[myArray.length -1]);

        int[] arr ={5,1,8,10};
        printArray(arr);
    }

    //Remove even integers from an array 6-01-2022
    public static int[] removeEven(int[] arr){
        int oddCount =0;
        for(int i=0; i< arr.length; i++){
            if(arr[i]%2 !=0){
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int idx =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 !=0){
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }

    //Reverse an array 6-01-2022
    public static void reverse(int[] numbers, int start, int end){
        while(start<end){
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    //Find the minimum value in an array
    public static int findMinimum(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    //Find Second max value in an array 22-1-22
    public static int findSecondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                secondMax=max;
                max=arr[i];
            }
            else if(arr[i]>secondMax && arr[i]!=max){
                secondMax=arr[i];
            }
        }
        return secondMax;
    }

    // Move all zeros to the end of the array, without disturbing the order of the array elements (non- zero) 22-1-22
    public static void moveZeroes(int[] arr, int n){
        int j=0;
        for(int i =0; i<n; i++){
            if(arr[i]!=0 && arr[j]==0){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            if(arr[j]!=0){
                j++;
            }
        }
    }

    // Resize an array -> 31-01.2022
    public static int[] resize(int[] arr, int capacity){
        int [] temp = new int[capacity];

        for(int i=0; i<arr.length; i++){
            temp[i]=arr[i];
        }
        return temp;
    }


    //Merge two sorted arrays -> 7-02-2022
    public static int[] merge(int[] arr1, int[] arr2, int n, int m){
        int[] result = new int [n+m];
        int i=0; int j=0; int k=0;

        while(i<n && j<m){
            if (arr1[i] < arr2[j]) {
                result[k]=arr1[i];
                i++;
            }else{
                result[k]=arr2[j];
                j++;
            }
            k++;
        }
        while (i<n){
            result[k]=arr1[i];
            i++;k++;
        }
        while (j<m){
            result[k]=arr2[j];
            j++;k++;
        }
        return result;
    }


    public static void main(String[] args) {
        Array array = new Array();
      //  array.arrayDemo();

       /*
        int [] arr = {3,2,4,7,10,6,5};
        printArray(arr);
        int[] result = removeEven(arr);
        printArray(result);
       */

      /*
       int[] numbers = {2,11,5,10,7,8};
       printArray(numbers);
       reverse(numbers, 0, numbers.length -1);
       printArray(numbers);
       */

     /*   int[] arr = {5,0,9,3,15,0,1,2,0};
        printArray(arr);
       // System.out.println(findMinimum(arr));
       // System.out.println(findSecondMax(arr));
        moveZeroes(arr,9);
        printArray(arr);
      */
      /*  int [] original = new int[]{5,1,2,9,10};
        System.out.println("The size of original array is -> "+original.length);
        original = resize(original,10);
        System.out.println("The size of original array after resize is -> "+original.length);
        */

        int[] arr1= new int[]{0,1,8,10};
        int[] arr2= new int[]{2,4,11,15,20};
        printArray(arr1);
        printArray(arr2);
        int[] merged = merge(arr1,arr2,arr1.length,arr2.length);
        printArray(merged);
    }
}
