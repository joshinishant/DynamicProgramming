package com.practise.dp.BinomialCoefficient;

import java.math.BigInteger;

public class BinomialCoefficientTopDown {


    private static BigInteger[] createLookup(BigInteger n){
        BigInteger[] lookup= new BigInteger[n.intValue()];

        lookup[0]=BigInteger.ZERO;
        lookup[1]=BigInteger.ONE;

        return lookup;

    }


    private static BigInteger calculateBinomialCoefficient(BigInteger n,BigInteger k,BigInteger[] lookup){
        if(n.compareTo(k)==-1){
            System.out.println("n cannot be smaller than r");
            return new BigInteger("-1");
        }


        BigInteger nFactorial=calculateFactorial(n,lookup);
        BigInteger nMinuskFactorial=calculateFactorial(n.subtract(k),lookup);
        BigInteger rFactorial=calculateFactorial(k,lookup);

        BigInteger result=nFactorial.divide((nMinuskFactorial.multiply(rFactorial)));
        return  result;
    }


    private static BigInteger calculateFactorial(BigInteger factorial,BigInteger[] lookup){
        if(lookup[factorial.intValue()]==null){
            BigInteger result=factorial.multiply(calculateFactorial(factorial.subtract(BigInteger.ONE),lookup));
            lookup[factorial.intValue()]=result;
            return result;
        }

        return lookup[factorial.intValue()];
    }
    public static void main(String args[]){

        BigInteger n=new BigInteger("200");
        BigInteger k=new BigInteger("50");

        BigInteger[] lookup= createLookup(n.add(BigInteger.ONE));
        BigInteger result=calculateBinomialCoefficient(n,k,lookup);

        if(result.compareTo(BigInteger.ZERO)>-1){
            System.out.println("Binomial co-efficient of n,k is "+result);
        }
    }

}
