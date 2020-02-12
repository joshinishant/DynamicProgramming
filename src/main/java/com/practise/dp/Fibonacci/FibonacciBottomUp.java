package com.practise.dp.Fibonacci;

import java.math.BigInteger;

public class FibonacciBottomUp {


    private static BigInteger[] setupLookup(int size){
        BigInteger[] lookup= new BigInteger[size];

        lookup[0]=BigInteger.ZERO;
        lookup[1]=BigInteger.ONE;


        return lookup;
    }

    public static BigInteger fibonacci(int number,BigInteger[] lookup){


        if(lookup[number]!=null){
            return lookup[number];
        }

        for(int i=2;i<=number;i++){
           lookup[i]= lookup[i-1].add(lookup[i-2]);
        }


        return lookup[number];

    }


    public static void main(String args[]){
        int number=300;

        long intitalTime=System.nanoTime();
        BigInteger[] lookup= setupLookup(number+1);
        System.out.println(fibonacci(number,lookup));
        System.out.println("Computation time nanoseconds- "+(System.nanoTime()-intitalTime));
    }
}
