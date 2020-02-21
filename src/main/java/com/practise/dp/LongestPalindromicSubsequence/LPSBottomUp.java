package com.practise.dp.LongestPalindromicSubsequence;

import java.math.BigInteger;

public class LPSBottomUp {

    private static BigInteger[][]createLookup(BigInteger stringLength){

        BigInteger[][] lookup= new BigInteger[stringLength.intValue()][stringLength.intValue()];

        for(int i=0;i<stringLength.intValue();i++){
            lookup[i][i]=BigInteger.ONE;
        }


        return lookup;
    }


    private static BigInteger calculate(String palindromicString,BigInteger[][] lookup){

        for(int cl=2;cl<=palindromicString.length();cl++){
            for(int k=0;k<palindromicString.length()-cl+1;k++){
                int l=k+cl-1;
                if(palindromicString.charAt(k)==palindromicString.charAt(l) && cl==2){
                    lookup[k][l]=BigInteger.valueOf(2);
                }
                else if(palindromicString.charAt(k)==palindromicString.charAt(l)){
                    lookup[k][l]=BigInteger.valueOf(2).add(lookup[k+1][l-1]);
                }
                else {
                    lookup[k][l]=BigInteger.valueOf(Math.max(lookup[k+1][l].intValue(),lookup[k][l-1].intValue()));
                }

            }
        }
        return (lookup[0][palindromicString.length()-1]);
    }

    public static void main(String args[]){
        String palindromicString="BABBAB";
        BigInteger[][] lookup=createLookup(BigInteger.valueOf(palindromicString.length()));
        BigInteger result=calculate(palindromicString,lookup);


        System.out.println(" Longest Palindromic Subsequence for "+palindromicString+" - "+result);
    }
}
