package jav.algo.sorting;

//22-02-2022
public class QuickSort {

    public void printArray(int[] arr){
        int n= arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void qSort(int[] arr, int low, int high){
        if (low<high){
            int p=partition(arr,low,high);
            qSort(arr,low,p-1);
            qSort(arr,p+1,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i=low;
        int j=low;

        while (i<=high){
            if (arr[i]<=pivot){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
            i++;
        }
        return j-1;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{9,-3,5,2,6,8,-6,1,3};
        QuickSort qs= new QuickSort();
        qs.qSort(arr,0, arr.length-1);
        qs.printArray(arr);
    }
}
