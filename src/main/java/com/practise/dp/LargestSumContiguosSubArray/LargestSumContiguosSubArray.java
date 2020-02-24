package com.practise.dp.LargestSumContiguosSubArray;

import java.math.BigInteger;

public class LargestSumContiguosSubArray {





    private  static BigInteger calculate(BigInteger[] input){

        BigInteger max_so_far=input[0],max_ending_here=input[0];
        int startIndex=0,endIndex=0;
        for(int i=1;i<input.length;i++){

            if((max_ending_here.add(input[i])).compareTo(input[i])==-1){
                max_ending_here=input[i];
                startIndex=i;
                endIndex=i;
            }else{
                max_ending_here=max_ending_here.add(input[i]);
            }


            if(max_so_far.compareTo(max_ending_here)==-1){
                max_so_far=max_ending_here;
                endIndex=i;
            }

        }

        System.out.println(" com.practise.dp.LargestSumContiguosSubArray starts and ends with index - "+startIndex+" , "+endIndex);

        return max_so_far;
    }


    public static void main(String[] args){


        BigInteger[] input={new BigInteger("-2"),new BigInteger("-3"),new BigInteger("4"),new BigInteger("-1"),new BigInteger("-2"),new BigInteger("1"),new BigInteger("5"),new BigInteger("-3")};

        BigInteger result=calculate(input);
        System.out.println(" Max sum of com.practise.dp.LargestSumContiguosSubArray -  "+result);
    }
}
