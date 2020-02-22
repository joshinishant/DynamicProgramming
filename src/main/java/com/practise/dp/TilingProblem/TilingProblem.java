package com.practise.dp.TilingProblem;

import java.math.BigInteger;

public class TilingProblem {


    private static BigInteger[] generateLookup(int count){
        BigInteger[] lookup= new BigInteger[count+1];
        lookup[0]=BigInteger.ZERO;

        return lookup;
    }

    private  static BigInteger calculate(int n,int m,BigInteger[] lookup){

        for(int i=1;i<=n;i++){

            if(i<m){
                lookup[i]=BigInteger.ONE;
            }else if(i==m){
                lookup[i]=BigInteger.valueOf(2);
            }
            else if(i>m){
                lookup[i]=lookup[i-m].add(lookup[i-1]);
            }
        }

        return lookup[n];
    }


    public static void main(String[] args){


        int n=7;
        int m=4;
        BigInteger[] lookup=generateLookup(n);

        BigInteger result=calculate(n,m,lookup);
        System.out.println(result);
    }
}
