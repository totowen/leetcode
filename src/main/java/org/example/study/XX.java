package org.example.study;

/**
 * X的平方根
 *
 * 在不适用sqrt(x)函数的情况下，得到x的平方根整数部分
 *
 */
public class XX {

    public static void main(String[] args) {
        System.out.println(new XX().xx(10));
    }

    public int xx(int x){
        if(x<0){
            return -1;
        }

        for (int i = 0; i <= x; i++) {
            if(i*i<x&&(i+1)*(i+1)>x){
                return i;
            }
        }

        return -1;
    }

}
