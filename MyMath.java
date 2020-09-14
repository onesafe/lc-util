public class MyMath {

    /**
     * 判断一个数是否是质数
     * @param num 数
     * @return 是质数则返回true
     */
    public static boolean isPrime(int num){
        if(num == 1) return false;
        for(int i = 2; i * i <= num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
