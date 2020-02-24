package com.practise.dp.BinaryStrings;

import java.math.BigInteger;

public class BinaryStrings {

    private static BigInteger[] generateLookup(int number){
        BigInteger[] lookup= new BigInteger[number+1];


        return lookup;
    }

    private  static BigInteger calculate(BigInteger number){
        BigInteger[] lookupOnes=generateLookup(number.intValue());
        BigInteger[] lookupZeros=generateLookup(number.intValue());

        lookupOnes[0]=lookupZeros[0]=BigInteger.valueOf(1);

        for(int i=1;i<number.intValue();i++){
            lookupZeros[i]=lookupZeros[i-1].add(lookupOnes[i-1]);
            lookupOnes[i]=lookupZeros[i-1];
        }

        return lookupZeros[number.intValue()-1].add(lookupOnes[number.intValue()-1]);
    }


    public static void main(String[] args){

        BigInteger number=new BigInteger("3");
        BigInteger result=calculate(number);
        System.out.println(result);
    }

}
