package com.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates2(arr));
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
       /* Arrays.stream(nums).collect(
                Collectors.toSet());*/
        //List<int[]> myList = Arrays.asList(nums);
        Set<Integer> result = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        //Set<Integer> mySet = new HashSet<>(Arrays.asList(nums));
        int i = 0;
        for (int num : result) {
            nums[i] = num;
            i++;
        }
        return result.size();
    }

    public static int removeDuplicates2(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                //j++;
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
