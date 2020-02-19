package com.practise.dp.Knapsack;

import java.math.BigInteger;

public class KnapsackTopDown {


    private static BigInteger[][] createLookup(BigInteger n,BigInteger w){
        BigInteger[][] lookup= new BigInteger[n.intValue()][w.intValue()];

        return lookup;
    }

    private static BigInteger calculateKnapSack(BigInteger W,BigInteger n,BigInteger[] value,BigInteger[] weights,BigInteger[][] lookup){

        for(int i=0;i<n.intValue()+1;i++){
            for(int j=0;j<W.intValue()+1;j++){
                if(i==0 || j==0 ){
                    lookup[i][j]=BigInteger.ZERO;
                }
                else if(weights[i-1].compareTo(BigInteger.valueOf(j))<1){
                    lookup[i][j]=BigInteger.valueOf(Math.max(lookup[i-1][j].intValue(),value[i-1].intValue()+lookup[i-1][j-weights[i-1].intValue()].intValue()));
                }
                else {
                    lookup[i][j]=lookup[i-1][j];
                }
            }

        }

        return lookup[n.intValue()][W.intValue()];
    }

    public static void main(String args[]){
        BigInteger W=BigInteger.valueOf(50);
       // BigInteger W=BigInteger.valueOf(11);
        //BigInteger W=BigInteger.valueOf(15);

        BigInteger[] value={BigInteger.valueOf(60),BigInteger.valueOf(100),BigInteger.valueOf(120),};
        BigInteger[] weights={BigInteger.valueOf(10),BigInteger.valueOf(20),BigInteger.valueOf(30)};

    /*
        BigInteger[] value={BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(4),BigInteger.valueOf(10),BigInteger.valueOf(4)};
        BigInteger[] weights={BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(9),BigInteger.valueOf(4)};

        */
/*

        BigInteger[] value={BigInteger.valueOf(4),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(10)};
        BigInteger[] weights={BigInteger.valueOf(12),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(1),BigInteger.valueOf(4)};

        */

        BigInteger n=BigInteger.valueOf(value.length);
        BigInteger w=BigInteger.valueOf(weights.length);
        BigInteger[][] lookup=createLookup(n.add(BigInteger.ONE),W.add(BigInteger.ONE));

        BigInteger result=calculateKnapSack(W,n,value,weights,lookup);
        System.out.println("Knapsack Value - "+result);

    }
}

