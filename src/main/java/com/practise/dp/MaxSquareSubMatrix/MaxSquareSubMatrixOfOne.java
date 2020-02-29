package com.practise.dp.MaxSquareSubMatrix;

import java.math.BigInteger;

public class MaxSquareSubMatrixOfOne {

    private static BigInteger[][] generateLookup(BigInteger[][] input){
        int rows=input.length;
        int columns=input.length>0?input[1].length:0;

        BigInteger[][] lookup= new BigInteger[rows][columns];


        for(int i=0;i<rows;i++){
            lookup[i][0]=input[i][0];
        }

        for(int j=0;j<columns;j++){
            lookup[0][j]=input[0][j];
        }

        return lookup;
    }

    private  static void calculate(BigInteger[][] input,BigInteger[][] lookup){


        for(int i=1;i<input.length;i++){
            for(int j=1;j<input[i].length;j++){
                if(input[i][j].equals(BigInteger.ONE)){
                    lookup[i][j]=minimum(lookup[i-1][j],lookup[i][j-1],lookup[i-1][j-1]).add(BigInteger.ONE);
                }
                else{
                    lookup[i][j]=BigInteger.ZERO;
                }
            }
        }


        BigInteger maxNumber=lookup[0][0];
        int counter_i=0,counter_j=0;
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[i].length;j++){
                if(maxNumber.compareTo(lookup[i][j])==-1){
                    maxNumber=lookup[i][j];
                    counter_i=i;
                    counter_j=j;
                }
            }
        }


        for(int i=counter_i-maxNumber.intValue()+1;i<=counter_i;i++){
            for(int j=counter_j-maxNumber.intValue()+1;j<=counter_j;j++){
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }

        return ;
    }


    private static BigInteger minimum(BigInteger number1,BigInteger number2,BigInteger number3){

        if(number1.compareTo(number2)==-1 && number1.compareTo(number3)==-1){
            return number1;
        }
        else if(number2.compareTo(number3)==-1){
            return number2;
        }
        else {
            return number3;
        }
    }


    private static void fillInput(BigInteger[][] input){
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[i].length;j++){
                input[i][j]=BigInteger.ONE;
            }
        }

        input[0][0]= BigInteger.ZERO;
        input[2][0]= BigInteger.ZERO;
        input[2][4]= BigInteger.ZERO;
        input[5][0]= BigInteger.ZERO;
        input[5][1]= BigInteger.ZERO;
        input[5][2]= BigInteger.ZERO;
        input[5][3]= BigInteger.ZERO;
        input[5][4]= BigInteger.ZERO;
        input[1][2]= BigInteger.ZERO;
        input[1][4]= BigInteger.ZERO;
        input[3][4]= BigInteger.ZERO;
    }

    public static void main(String[] args){

        BigInteger[][] input= new BigInteger[6][5];

       fillInput(input);


        BigInteger[][] lookup=generateLookup(input);

         calculate(input,lookup);
    }
}
