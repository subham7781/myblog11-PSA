package com.myblog11.myblog;


import lombok.Data;
import org.apache.catalina.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Data
public class Testclass1 {
    public static void main(String[] args) {
        int[]x = {65,54,35,65,55,45};
        int temp;
        for (int i = 0; i <x.length-1 ; i++) {
            for (int j = 0; j < x.length-1; j++) {
                if (x[j]>x[j+1]){
                    temp=x[j];
                    x[j]=x[j+1];
                    x[j+1]=temp;
                }

            }
            for (int j : x){
                System.out.println(j);
            }
        }
    }
}