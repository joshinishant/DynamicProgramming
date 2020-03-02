package com.practise.dp.ConnectedOnesInMatrix;

import java.math.BigInteger;

public class ConnectedOnesInMatrix {

    private static BigInteger[][] generateLookup(BigInteger[][] input){
        int row=input.length+1;
        int column=input.length>0?input[1].length+1:1;

        BigInteger[][] lookup= new BigInteger[row][column];

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){

                if(j==0 && i<row-1){
                    lookup[i][0]=input[i][0];
                }else if(i==0 && j<column-1){
                    lookup[0][j]=input[0][j];
                }else {
                    lookup[i][j]=BigInteger.ZERO;
                }
            }
        }

        return lookup;
    }

    private  static BigInteger calculate(BigInteger[][] input,BigInteger[][] lookup){

        for(int i=1;i<input.length;i++){
            for(int j=1;j<input[i].length;j++){
                BigInteger maxValueInVicinity=findMaxValueinVicinity(i,j,lookup);

                if(input[i][j]==BigInteger.ONE){
                    lookup[i][j]=maxValueInVicinity.add(BigInteger.ONE);
                }
                else {
                    lookup[i][j]=BigInteger.ONE;
                }
            }
        }

        BigInteger maxConectedOnes=lookup[0][0];
        for(int i=0;i<lookup.length;i++){
            for(int j=0;j<lookup[i].length;j++){
             if(maxConectedOnes.compareTo(lookup[i][j])==-1){
                 maxConectedOnes=lookup[i][j];
             }
            }
        }

        return maxConectedOnes;
    }


    private static BigInteger findMaxValueinVicinity(int row,int column,BigInteger[][] lookup){

       if(lookup[row-1][column-1].compareTo(lookup[row-1][column])==1 && lookup[row-1][column-1].compareTo(lookup[row-1][column+1])==1
          && lookup[row-1][column-1].compareTo(lookup[row][column-1])==1 ){
           return lookup[row-1][column-1];
       }
       else if(lookup[row-1][column].compareTo(lookup[row-1][column+1])==1 && lookup[row-1][column].compareTo(lookup[row][column-1])==1 ){
           return lookup[row-1][column];
       }
       else if(lookup[row-1][column+1].compareTo(lookup[row][column-1])==1){
           return lookup[row-1][column+1];
       }
       else {
           return lookup[row][column-1];
       }
    }

    private  static void prepareInput(BigInteger[][] input){

        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[i].length;j++){
                input[i][j]=BigInteger.ZERO;
            }
        }

        input[1][1] = BigInteger.ONE;
        input[1][3] = BigInteger.ONE;
        input[1][5] = BigInteger.ONE;
        input[2][2] = BigInteger.ONE;
        input[2][4] = BigInteger.ONE;
        input[2][6] = BigInteger.ONE;
        input[3][1] = BigInteger.ONE;
        input[3][5] = BigInteger.ONE;
        input[4][2] = BigInteger.ONE;
        input[4][4] = BigInteger.ONE;
        input[5][5] = BigInteger.ONE;

        return ;
    }


    public static void main(String[] args){


        BigInteger[][] input=new BigInteger[6][7];
        prepareInput(input);


        BigInteger[][] lookup=generateLookup(input);

        BigInteger result=calculate(input,lookup);
        System.out.println(result);
    }


}
