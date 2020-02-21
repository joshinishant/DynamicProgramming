package com.practise.dp.MaxLenChainOfPairs;

import java.math.BigInteger;

public class PairsDTO {

    private BigInteger pairNumber1;
    private BigInteger pairNumber2;


    public BigInteger getPairNumber1() {
        return pairNumber1;
    }

    public void setPairNumber1(BigInteger pairNumber1) {
        this.pairNumber1 = pairNumber1;
    }

    public BigInteger getPairNumber2() {
        return pairNumber2;
    }

    public void setPairNumber2(BigInteger pairNumber2) {
        this.pairNumber2 = pairNumber2;
    }


    public PairsDTO(BigInteger pairNumber1, BigInteger pairNumber2) {
        this.pairNumber1 = pairNumber1;
        this.pairNumber2 = pairNumber2;
    }

    public PairsDTO(int pairNumber1, int pairNumber2) {
        this.pairNumber1 = BigInteger.valueOf(pairNumber1);
        this.pairNumber2 = BigInteger.valueOf(pairNumber2);
    }

    @Override
    public String toString() {
        return "PairsDTO{" +
                "pairNumber1=" + pairNumber1 +
                ", pairNumber2=" + pairNumber2 +
                '}';
    }
}
