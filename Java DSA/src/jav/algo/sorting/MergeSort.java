package jav.algo.sorting;
//19-02-2022
public class MergeSort {

    public void printArray(int[] arr){
        int n= arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void mSort(int[] arr, int[] temp, int low, int high){
        if (low < high){
            int mid = low + (high-low)/2;
            mSort(arr,temp,low,mid);
            mSort(arr,temp,mid+1,high);
            merge(arr, temp, low, mid, high);
        }
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for(int i=low; i<=high; i++){
            temp[i]=arr[i];
        }
        int i=low;
        int j=mid+1;
        int k=low;
        while (i<=mid && j<=high){
            if (temp[i]<=temp[j]){
                arr[k]=temp[i];
                i++;
            }else {
                arr[k]=temp[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            arr[k]=temp[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
       int[] arr= new int[]{9,5,2,4,3,-1};
       MergeSort ms = new MergeSort();
       ms.mSort(arr, new int[arr.length],0, arr.length-1);
       ms.printArray(arr);
    }
}
