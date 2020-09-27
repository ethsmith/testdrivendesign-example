package me.ethsmith.tdd;

import java.util.Arrays;

public class Calculator {

    // Step One Add
//    public int Add(String numbers) {
//        String[] nums = numbers.split(",");
//
//        if (nums.length == 0 || nums[0].equals("")) {
//            return 0;
//        }
//
//        if (nums.length == 1) {
//            return Integer.parseInt(nums[0]);
//        }
//
//        return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
//    }

    // Step Two Add
    // Refactor with tests to make it better
//    public int Add(String numbers) {
//        String[] nums = numbers.split(",");
//        int sum = 0;
//
//        for (String i : nums) {
//            if (i.equals("")) continue;
//            sum += Integer.parseInt(i);
//        }
//
//        return sum;
//    }


    // Step Three Add
//    public int Add(String numbers) {
//        String[] nums = numbers.split("[,\n]");
//        int sum = 0;
//
//        for (String i : nums) {
//            if (i.equals("")) continue;
//            sum += Integer.parseInt(i);
//        }
//
//        return sum;
//    }

    // Step Four Add
    public int Add(String numbers) {
        String delimeter = "[,\n]";

        if (numbers.startsWith("//")) {
            delimeter = String.valueOf(numbers.split("\n")[0].charAt(2));
            numbers = numbers.split("\n")[1];
        }

        String[] nums = numbers.split(delimeter);
        int sum = 0;

        for (String i : nums) {
            if (i.equals("")) continue;
            sum += Integer.parseInt(i);
        }

        return sum;
    }
}
