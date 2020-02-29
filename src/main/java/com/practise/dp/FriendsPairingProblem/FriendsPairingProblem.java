package com.practise.dp.FriendsPairingProblem;

import java.math.BigInteger;

public class FriendsPairingProblem {

    private static BigInteger[] generateLookup(int numberOfFriends){
        BigInteger[] lookup= new BigInteger[numberOfFriends+1];
        return lookup;
    }

    private  static BigInteger calculate(BigInteger input,BigInteger[] lookup){

        for(int i=0;i<=input.intValue();i++){

            if(i<=2){
                lookup[i]=BigInteger.valueOf(i);
            }else {
                lookup[i]=lookup[i-1].add(lookup[i-2].multiply(BigInteger.valueOf(i).subtract(BigInteger.ONE)));
            }
        }

        return lookup[input.intValue()];
    }


    public static void main(String[] args){


        BigInteger input=BigInteger.valueOf(3);
        BigInteger[] lookup=generateLookup(input.intValue());

        BigInteger result=calculate(input,lookup);
        System.out.println("Number of ways to pair "+input.intValue()+" friends - "+result);
    }
}
