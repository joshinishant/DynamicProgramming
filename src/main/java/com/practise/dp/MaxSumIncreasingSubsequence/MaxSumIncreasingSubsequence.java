package com.practise.dp.MaxSumIncreasingSubsequence;

import java.math.BigInteger;

public class MaxSumIncreasingSubsequence {

    private static BigInteger[] generateLookup(BigInteger[] input){
        BigInteger[] lookup= new BigInteger[input.length];

        for(int i=0;i<input.length;i++){
            lookup[i]=input[i];
        }

        return lookup;
    }

    private  static BigInteger calculate(BigInteger[] input,BigInteger[] lookup){

         for(int i=1;i<input.length;i++){
            for(int j=0;j<i;j++){
                if(input[i].compareTo(input[j])==1 && lookup[i].compareTo(lookup[j].add(input[i]))==-1){
                    lookup[i]=lookup[j].add(input[i]);
                }
            }
        }

        BigInteger max=lookup[0];
        for(int i=1;i<input.length;i++){
            if(max.compareTo(lookup[i])==-1){
                max=lookup[i];
            }
        }

        return max;
}


    public static void main(String[] args){


        BigInteger[] input={new BigInteger("1"),new BigInteger("101"),new BigInteger("2"),new BigInteger("3"),new BigInteger("100"),new BigInteger("4"),new BigInteger("5")};
        BigInteger[] lookup=generateLookup(input);

        BigInteger result=calculate(input,lookup);
        System.out.println("Maximum sum of increasing susequence of the given array - "+ result);
    }
}
