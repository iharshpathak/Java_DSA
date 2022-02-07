package jav.algo.strings;

//2-2-2022

public class StringPalindrome {

    public boolean isPalindrome(String word){

        char[] charArray= word.toCharArray();
        int start =0;
        int end = word.length()-1;

        while (start<end){
            if(charArray[start]!=charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        StringPalindrome stringPalindrome = new StringPalindrome();
        if (stringPalindrome.isPalindrome("madam")){
            System.out.println("The String is Palindrome !!");
        }else{
            System.out.println("The String is not Palindrome !!");
        }
    }
}
