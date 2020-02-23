package com.practise.dp.MaxPalindromicSubsstring;

public class MaxPalindromicSubsstring {


    private static boolean[][] generateLookup(int row){
        boolean[][] lookup= new boolean[row+1][row+1];

        for(int i=0;i<=row;i++){
            lookup[i][i]=true;
        }


        return lookup;
    }

    private  static void calculate(String input,boolean[][] lookup){

        int finalLength=0,startIndex=0;
        for (int i = 0; i < input.length() - 1; i=i+1) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                lookup[i][i + 1] = true;
                startIndex = i;
                finalLength = 2;
            }
        }


        for(int length=2;length<=input.length();length++){
            for(int i=0;i+length-1<input.length();i++){
                int j=i+length-1;
                if(input.charAt(i)==input.charAt(j) && lookup[i+1][j-1]){
                   lookup[i][j]=true;

                    if(length>finalLength){
                        finalLength=length;
                        startIndex=i;
                    }
                }
            }
        }

        if(finalLength==0 && startIndex==0){
            System.out.print("Maximum Palindromic Subsstring  - "+input.substring(startIndex));
        }else{
            System.out.print("Maximum Palindromic Subsstring  - "+input.substring(startIndex,startIndex+finalLength));
        }
    }


    public static void main(String[] args){


        String input="geeksskeeg";
        boolean[][] lookup = generateLookup(input.length());
        calculate(input,lookup);
    }
}
