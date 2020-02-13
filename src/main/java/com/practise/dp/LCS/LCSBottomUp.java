package com.practise.dp.LCS;

import java.math.BigInteger;

public class LCSBottomUp {

    private static BigInteger[][] generateLookup(int input1Size,int input2Size){
        BigInteger[][]lookup=new BigInteger[input1Size][input2Size];


        for(int i=0;i<input1Size;i++){
            lookup[i][0]=BigInteger.ZERO;
        }

        for(int j=0;j<input2Size;j++){
            lookup[0][j]=BigInteger.ZERO;
        }

        return lookup;
    }


    private static BigInteger calculateLCS(String input1,String input2,BigInteger[][]lookup,BigInteger calculatedLCS){

        char[]input1CharArray=input1.toCharArray();
        char[]input2CharArray=input2.toCharArray();

        int lookupCounteri=0,lookupCounterj=0;
        for(int i=0;i<input1CharArray.length;i++){
            lookupCounteri=i+1;
            for(int j=0;j<input2CharArray.length;j++){
                lookupCounterj=j+1;
                if(input1CharArray[i]==input2CharArray[j]){
                    lookup[lookupCounteri][lookupCounterj]=lookup[lookupCounteri-1][lookupCounterj-1].add(BigInteger.ONE);
                }else{
                    lookup[lookupCounteri][lookupCounterj]=lookup[lookupCounteri][lookupCounterj-1].compareTo(lookup[lookupCounteri-1][lookupCounterj])==1?lookup[lookupCounteri][lookupCounterj-1]:lookup[lookupCounteri-1][lookupCounterj];
                }
            }
        }

        return lookup[input1CharArray.length][input2CharArray.length];
    }

    public static void main(String[] args){
        String input1="AGGTAB";
        String input2="GXTXAYB";

        input1="BACDB";
        input2="BDCB";

        BigInteger[][]lookup= generateLookup(input1.length()+1,input2.length()+1);
        BigInteger LCS=calculateLCS(input1,input2,lookup,BigInteger.ZERO);

        System.out.println("Longest common subsequence for "+input1+" and "+input2+" is "+LCS);
    }
}
