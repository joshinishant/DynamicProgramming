package com.practise.dp;

import java.math.BigInteger;

public class Template {

    private static BigInteger[][] generateLookup(int row,int column){
        BigInteger[][] lookup= new BigInteger[row+1][column+1];


        return lookup;
    }

    private  static BigInteger calculate(BigInteger[] input,BigInteger[][] lookup){


        return BigInteger.ZERO;
    }


    public static void main(String[] args){


        BigInteger[] input={new BigInteger("10"),new BigInteger("22"),new BigInteger("9"),new BigInteger("33"),new BigInteger("21"),new BigInteger("50"),new BigInteger("41"),new BigInteger("60")};
        BigInteger[][] lookup=generateLookup(input.length,input.length);

        BigInteger result=calculate(input,lookup);
        System.out.println(result);
    }
}
