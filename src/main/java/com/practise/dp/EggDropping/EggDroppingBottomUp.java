package com.practise.dp.EggDropping;

import java.math.BigInteger;

public class EggDroppingBottomUp {


    private static BigInteger[][] createLookup(BigInteger eggs,BigInteger floors){
        BigInteger[][] lookup= new BigInteger[eggs.intValue()][floors.intValue()];

        for(int i=0;i<eggs.intValue();i++){
            lookup[i][0]=BigInteger.ZERO;
            lookup[i][1]=BigInteger.ONE;
        }

        for(int j=0;j<floors.intValue();j++){
           // lookup[0][j]=BigInteger.ZERO;
            lookup[1][j]=BigInteger.valueOf(j);
        }

        return lookup;
    }


    private static BigInteger calculate(BigInteger eggs,BigInteger floors,BigInteger[][] lookup){

        int minVal;
        for(int i=2;i<eggs.intValue()+1;i++){
            for(int j=2;j<floors.intValue()+1;j++){
                lookup[i][j]=BigInteger.valueOf(Integer.MAX_VALUE);
                for(int k=1;k<j+1;k++){
                    int result=1+Math.max(lookup[i-1][k-1].intValue(),lookup[i][j-k].intValue());

                    if(result<lookup[i][j].intValue()){
                        lookup[i][j]=BigInteger.valueOf(result);
                    }
                }
            }
        }


        return lookup[eggs.intValue()][floors.intValue()];
    }

    public static void main(String args[]){

        BigInteger eggs=new BigInteger("2");
        BigInteger floors=new BigInteger("36");

        BigInteger[][] lookup=createLookup(eggs.add(BigInteger.ONE),floors.add(BigInteger.ONE));
        BigInteger result=calculate(eggs,floors,lookup);
        System.out.println("No of min attempts - "+result);

    }
}
