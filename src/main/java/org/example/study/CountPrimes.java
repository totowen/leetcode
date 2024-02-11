package org.example.study;

/**
 * 统计N以内的素数
 * 素数：只能被1和自身整除的数，0、1除外
 * 解题：从2开始遍历，范围为小于n的整数x，x余数为0的情况等于2的数
 */
public class CountPrimes {


    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
//        System.out.println(countPrimes.countPrimes(20));
        System.out.println(countPrimes.eratosthenes(20));


    }

    public int eratosthenes(int n){
        //初始化数组默认元素为false ,0和1除外，标记所有从2开始的系数，后面只要是2的倍数就会跳过ans的计算。只有素数会被ans统计。
        boolean[] isPrime = new boolean[n+1];
        int ans = 0;
        for (int i = 2; i <= n; i++) {
             if(!isPrime[i]){
                 ans +=1;
                 for (int j = i*i; j <= n; j+=i) {
                     isPrime[j] = true;
                 }
             }
        }
        return ans;

    }

    public int countPrimes(int n) {

        if (n == 0 || n == 1) {
            return 0;
        }

        int count = 0;
        for (int i = 2; i <=n; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if (i % j == 0) {
                    temp++;
                }
                if(temp>2){
                    break;
                }
            }
            if(temp==2){
                System.out.println(i);
                count++;
            }
        }

        return count;
    }

}
