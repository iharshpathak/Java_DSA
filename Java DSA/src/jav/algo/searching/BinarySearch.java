package jav.algo.searching;
// 6-01-2022
// Works only on sorted data
/* Uses The 3 pointer approach of Beginning,
   Middle and End
   Time Complexity = O(log n)
   */

public class BinarySearch {

   public int binarySearch(int[] nums, int key){
       int BEG =0;
       int END = nums.length -1;
       while (BEG<=END){
           int MID = (BEG+END)/2;
           if (nums[MID]==key) {
               return MID;
           }
           if(key<nums[MID]){
               END=MID-1;
           }
           else{
               BEG = MID+1;
           }
       }
       return -1;
   }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {1,10,20,47,59,65,75,88,99};
        System.out.println(bs.binarySearch(nums,100));
    }
}
