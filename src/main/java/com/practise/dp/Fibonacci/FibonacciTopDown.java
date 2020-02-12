package com.practise.dp.Fibonacci;

import java.math.BigInteger;

public class FibonacciTopDown {


    private static BigInteger[] setupLookup(int size){
        BigInteger[] lookup= new BigInteger[size];

        lookup[0]=BigInteger.ZERO;
        lookup[1]=BigInteger.ONE;


        return lookup;
    }

    public static BigInteger fibonacci(int number, BigInteger[] lookup){


        if(lookup[number]!=null){
            return lookup[number];
        }

        BigInteger calculatedFibNumber=fibonacci(number-1,lookup).add(fibonacci(number-2,lookup));
        lookup[number]=calculatedFibNumber;
        return calculatedFibNumber;

    }


    public static void main(String args[]){
        int number=300;

        long intitalTime=System.nanoTime();

        BigInteger[] lookup= setupLookup(number+1);
        System.out.println(fibonacci(number,lookup));
        System.out.println("Computation time nanoseconds- "+(System.nanoTime()-intitalTime));
    }
}
