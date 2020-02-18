package com.practise.dp.EditDistance;

import java.math.BigInteger;

public class EditDistanceBottomUp {



    private static BigInteger[][] prepareLookup(int length,int breadth){
        BigInteger[][] lookup= new BigInteger[length][breadth];

        return lookup;
    }

    public static void main(String args[]) {

        String string1 = "AABACABA";
        String string2 = "ADRATYU";


        BigInteger[][] lookup = prepareLookup(string1.length()+1, string2.length()+1);
        BigInteger hammingDistance=calculate(lookup,string1,string2);

        System.out.println("Hamming distance for "+string1+" and "+string2+" is - "+hammingDistance);
    }

    private static BigInteger calculate(BigInteger[][] lookup,String string1,String string2){


        char[]input1CharArray=string1.toCharArray();
        char[]input2CharArray=string2.toCharArray();

        for(int i=0;i<string1.length()+1;i++){
            for(int j=0;j<string2.length()+1;j++){

                if(i==0){
                    lookup[i][j]=BigInteger.valueOf(j);
                }
                else if(j==0){
                    lookup[i][j]=BigInteger.valueOf(i);
                }

                else if(input1CharArray[i-1]==input2CharArray[j-1]){
                    lookup[i][j]=lookup[i-1][j-1];
                }
                else {
                    //Finding min of (lookup[i-1][j] INSERT, lookup[i][j-1]DELETE and lookup[i-1][j-1]MODIFY)
                    if(lookup[i][j-1].compareTo(lookup[i-1][j])<1 && lookup[i][j-1].compareTo(lookup[i-1][j-1])<1){
                        lookup[i][j]=lookup[i][j-1].add(BigInteger.ONE);
                    }
                    else if(lookup[i-1][j-1].compareTo(lookup[i][j-1])<1 && lookup[i-1][j-1].compareTo(lookup[i-1][j])<1){
                        lookup[i][j]=lookup[i-1][j-1].add(BigInteger.ONE);
                    }
                    else{
                        lookup[i][j]=lookup[i-1][j].add(BigInteger.ONE);
                    }

                }
            }
        }


        return lookup[string1.length()][string2.length()];
    }
}
