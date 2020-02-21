package com.practise.dp.MaxLenChainOfPairs;

import java.math.BigInteger;

public class MaxLenChainOfPairs {

    private static BigInteger[] generateLookup(int row){
        BigInteger[] lookup= new BigInteger[row];

        for(int i=0;i<row;i++){
            lookup[i]=BigInteger.ONE;
        }

        return lookup;
    }

    private  static BigInteger calculate(PairsDTO[] input,BigInteger[] lookup){
        for(int i=1;i<input.length;i++){
            for (int j=0;j<i;j++){
                if(input[j].getPairNumber2().compareTo(input[i].getPairNumber1())==-1 && lookup[i].compareTo(lookup[j].add(BigInteger.ONE))==-1){
                    lookup[i]=lookup[j].add(BigInteger.ONE);
                }
            }
        }

        BigInteger max=lookup[0];
        for (int j=1;j<input.length;j++){
           if(lookup[j].compareTo(max)==1){
               max=lookup[j];
           }
        }
        return max;
    }



    public static void main(String[] args){


        //PairsDTO[] input={new PairsDTO(5,24),new PairsDTO(39,60),new PairsDTO(15,28),new PairsDTO(27,40),new PairsDTO(50,90)};
        PairsDTO[] input={new PairsDTO(5,24),new PairsDTO(15,25),new PairsDTO(27,40),new PairsDTO(50,60)};

        BigInteger[] lookup=generateLookup(input.length);

        BigInteger result=calculate(input,lookup);
        System.out.println(result);
    }
}
