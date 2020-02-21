package com.practise.dp.BoxStacking;

import java.util.Arrays;

public class BoxStackingProblem {

    private static class Box implements Comparable<Box>{

        private int l, w, h, area;
        public Box(int l, int w, int h) {
            this.h = h;
            this.l = l;
            this.w = w;
            this.area=l*w;
        }


        public int getL() {
            return l;
        }

        public void setL(int l) {
            this.l = l;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public int compareTo(Box o) {
            return o.area-this.area;
        }
    }

    private static int[] generateLookup(Box[] boxArray){
        int[] lookup= new int[boxArray.length];


        for(int i=0;i<boxArray.length;i++){
            lookup[i]=boxArray[i].getH();
        }
        return lookup;
    }

    private static Box[] createAndFillBoxArray(Box[] boxArray){
        Box[] newBoxArray= new Box[boxArray.length*3];

        for(int i=0;i<boxArray.length;i++){
            newBoxArray[3*i]=new Box(boxArray[i].l,Math.max(boxArray[i].h,boxArray[i].w),Math.min(boxArray[i].h,boxArray[i].w));
            newBoxArray[3*i+1]=new Box(boxArray[i].w,Math.max(boxArray[i].l,boxArray[i].h),Math.min(boxArray[i].l,boxArray[i].h));
            newBoxArray[3*i+2]=new Box(boxArray[i].h,Math.max(boxArray[i].w,boxArray[i].l),Math.min(boxArray[i].w,boxArray[i].l));
        }
        sortArray(newBoxArray);

        return newBoxArray;
    }

    private static Box[] sortArray(Box[] boxArray){
        Arrays.sort(boxArray);
        return  boxArray;
    }


    private static int calculate(Box[] boxArray,int[] lookup){



        for(int i=1;i<boxArray.length;i++){
            for(int j=0;j<i;j++){
                if(boxArray[i].getW()< boxArray[j].getW() && boxArray[i].getL()<boxArray[j].getL() && lookup[i]<lookup[j]+boxArray[i].getH()){
                    lookup[i]=lookup[j]+boxArray[i].getH();
                }
            }
        }

        int max=-1;
        for(int i=0;i<boxArray.length;i++){
            if(lookup[i]>max){
                max=lookup[i];
            }
        }

        return max;
    }

    public static void main(String args[]){
        Box[] boxArray = new Box[4];
        boxArray[0] = new Box(4, 6, 7);
        boxArray[1] = new Box(1, 2, 3);
        boxArray[2] = new Box(4, 5, 6);
        boxArray[3] = new Box(10, 12, 32);

        boxArray=createAndFillBoxArray(boxArray);
        int[] lookup=generateLookup(boxArray);
        int result=calculate(boxArray,lookup);


        System.out.println(result);
    }




}
