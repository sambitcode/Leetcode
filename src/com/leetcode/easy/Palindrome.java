package com.leetcode.easy;

public class Palindrome {

    public static void main(String[] args){
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        if(x<=0)
            return false;
        else{
            int result = 0;
            int copyOfX = x;
            while(x>0){
                int mod = x%10;
                result = (result*10) + mod;
                x = x/10;
            }
            return result == copyOfX;
        }

    }

}
