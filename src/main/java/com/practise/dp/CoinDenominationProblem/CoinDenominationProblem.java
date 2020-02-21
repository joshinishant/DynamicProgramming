package com.practise.dp.CoinDenominationProblem;

import java.math.BigInteger;

public class CoinDenominationProblem {

    private static BigInteger[] createLookup(int value){
        BigInteger[] lookup=new BigInteger[value+1];
        lookup[0]=BigInteger.ZERO;

        for(int i=1;i<value+1;i++){
            lookup[i]=BigInteger.valueOf(Integer.MAX_VALUE);
        }
        return lookup;
    }


    private static BigInteger calculate( BigInteger[] input,BigInteger value,BigInteger[] lookup){

        for(int i=1;i<=value.intValue();i++){
            for(int j=0;j<input.length;j++) {
               if(input[j].compareTo(BigInteger.valueOf(i))<1){
                  lookup[i]=BigInteger.valueOf(Math.min((lookup[i-input[j].intValue()].add(BigInteger.ONE)).intValue(),lookup[i].intValue()));
               }
            }
        }

        return lookup[value.intValue()];
    }

    public static void main(String args[]){

        BigInteger[] input={new BigInteger("9"),new BigInteger("6"),new BigInteger("5"),new BigInteger("1")};
        BigInteger value=new BigInteger("11");
        BigInteger[] lookup= createLookup(value.intValue());
        BigInteger result=calculate(input,value,lookup);

        System.out.println(result);
    }
}
