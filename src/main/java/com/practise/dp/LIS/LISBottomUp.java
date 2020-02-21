package com.practise.dp.LIS;

import java.math.BigInteger;

public class LISBottomUp {

    private static BigInteger[] generateLookup(int size){
        BigInteger[] lookup= new BigInteger[size+1];

        for(int i=0;i<size;i++){
            lookup[i]= new BigInteger("1");
        }

        return lookup;
    }

    private  static BigInteger calculateLIS(BigInteger[] input){
        BigInteger[] lookup=generateLookup(input.length);

        for(int i=1;i<input.length;i++){
            for(int j=0;j<i;j++){
                if(input[i].compareTo(input[j])==1 && lookup[i].compareTo(lookup[j].add(BigInteger.ONE))==-1){
                    lookup[i]=lookup[j].add(BigInteger.ONE);
                }
            }
        }

        BigInteger max=lookup[0];
        for(int i=0;i<input.length;i++){
            if(max.compareTo(lookup[i])==-1){
                max=lookup[i];
            }
        }
        return max;
    }


    public static void main(String[] args){
        BigInteger[] input={new BigInteger("10"),new BigInteger("22"),new BigInteger("9"),new BigInteger("33"),new BigInteger("21"),new BigInteger("50"),new BigInteger("41"),new BigInteger("60")};
        BigInteger LISResult=calculateLIS(input);
        System.out.println(LISResult);
    }
}
