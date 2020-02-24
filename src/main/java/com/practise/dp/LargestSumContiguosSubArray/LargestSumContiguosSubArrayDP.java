package com.practise.dp.LargestSumContiguosSubArray;

import java.math.BigInteger;

public class LargestSumContiguosSubArrayDP {


    private static BigInteger[] createlookup(int size){
        BigInteger[] lookup=new BigInteger[size];
        lookup[0]=BigInteger.ZERO;
        return  lookup;
    }



    private  static BigInteger calculate(BigInteger[] input,BigInteger[] lookup){

        for(int i=1;i<input.length+1;i++){
            lookup[i]=BigInteger.valueOf(Math.max((lookup[i-1].add(input[i-1])).intValue(),input[i-1].intValue()));
        }

        BigInteger maxValue=lookup[1];
        for(int i=2;i<input.length+1;i++){
            if(lookup[i].compareTo(maxValue)==1){
                maxValue=lookup[i];
            }
        }
        return maxValue;
    }


    public static void main(String[] args){


        BigInteger[] input={new BigInteger("-2"),new BigInteger("-3"),new BigInteger("4"),new BigInteger("-1"),new BigInteger("-2"),new BigInteger("1"),new BigInteger("5"),new BigInteger("-3")};
        BigInteger[] lookup=createlookup(input.length+1);
        BigInteger result=calculate(input,lookup);
        System.out.println(" Max sum of com.practise.dp.LargestSumContiguosSubArray -  "+result);
    }
}
