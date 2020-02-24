package com.practise.dp.WaysToScore;

import java.math.BigInteger;

public class WaysToScore {



    private static BigInteger[] generateLookup(int row){
        BigInteger[] lookup= new BigInteger[row+1];
        lookup[0]=BigInteger.valueOf(1);
        for(int i=1;i<=row;i++){
            lookup[i]=BigInteger.ZERO;
        }
        return lookup;
    }

    private  static BigInteger calculate(BigInteger input,BigInteger[] waysToScore,BigInteger[] lookup){

        for(int i=0;i<waysToScore.length;i++){
            for(int j=waysToScore[i].intValue();j<=input.intValue();j++){
                 lookup[j]=lookup[j].add(lookup[j-waysToScore[i].intValue()]);
            }
        }
        return lookup[input.intValue()];
    }


    public static void main(String[] args){
        BigInteger[] waysToScore= {new BigInteger("3"),new BigInteger("5"),new BigInteger("10")};
        BigInteger input= new BigInteger("13");
        BigInteger[] lookup=generateLookup(input.intValue());

        BigInteger result=calculate(input,waysToScore,lookup);
        System.out.println(result);
    }
}
