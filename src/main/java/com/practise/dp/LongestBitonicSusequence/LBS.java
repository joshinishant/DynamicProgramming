package com.practise.dp.LongestBitonicSusequence;

import java.math.BigInteger;

public class LBS {

    private static BigInteger[] generateLookup(int row){
        BigInteger[] lookup= new BigInteger[row];

        for(int i=0;i<row;i++){
            lookup[i]=BigInteger.ONE;
        }
        return lookup;
    }

    private  static BigInteger calculate(BigInteger[] input){

        BigInteger[] lookupLIS=generateLookup(input.length);
        BigInteger[] lookupLDS=generateLookup(input.length);


        for(int i=1;i<input.length;i++){
            for(int j=0;j<i;j++){
                if(input[i].compareTo(input[j])==1 && lookupLIS[i].compareTo(lookupLIS[j].add(BigInteger.ONE))==-1 ){
                    lookupLIS[i] = lookupLIS[j].add(BigInteger.ONE);
                }
            }
        }


        for(int i=input.length-2;i>=0;i--){
            for(int j=input.length-1;j>i;j--){

                if(input[i].compareTo(input[j])==1 && lookupLDS[i].compareTo(lookupLDS[j].add(BigInteger.ONE))==-1 ){
                    lookupLDS[i] = lookupLDS[j].add(BigInteger.ONE);
                }
            }
        }
        BigInteger max=BigInteger.ZERO;
        for(int i=0;i<input.length;i++){
            BigInteger result=lookupLIS[i].add(lookupLDS[i]).subtract(BigInteger.ONE);
            if(result.compareTo(max)==1){
                max=result;
            }
        }


        return max;
    }


    public static void main(String[] args){


        BigInteger[] input={new BigInteger("1"),new BigInteger("11"),new BigInteger("2"),new BigInteger("10"),new BigInteger("4"),new BigInteger("5"),new BigInteger("2"),new BigInteger("1")};

        BigInteger result=calculate(input);
        System.out.println(result);
    }
}
