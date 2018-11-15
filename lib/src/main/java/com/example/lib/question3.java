package com.example.lib;

import java.util.ArrayList;
import java.util.List;

public class question3 {
    public static void main(String[] args) {
        int[] numbers = new int[]{0, 2, 1, 8, 4, 9};
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (i + 1 >= numbers.length){

            }else {
                if (sum > (sum + numbers[i + 1])) {

                }
            }
        }
    }
}
