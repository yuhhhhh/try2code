package qunaer;

public class exam2 {
    public static void main(String[] args) {
        System.out.println(new exam2().Decrypt(4296,1601,4757));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 解密
     * @param encryptedNumber int整型 待解密数字
     * @param decryption int整型 私钥参数D
     * @param number int整型 私钥参数N
     * @return int整型
     */
    public int Decrypt (int encryptedNumber, int decryption, int number) {
        // write code here
        if (decryption == 1) {
            return encryptedNumber % number;
        }
        long n = (long) encryptedNumber * encryptedNumber;
        int res = Decrypt((int) (n % number), decryption / 2, number);
        if (decryption % 2 == 1) res = res * encryptedNumber % number;
        return res;
    }
}
