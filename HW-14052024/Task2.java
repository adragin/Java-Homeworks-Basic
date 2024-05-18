package org.lesson21;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(isValidAccountNumber("00000000000001"));
    }

    public static boolean isValidAccountNumber(String accountNumber){
        if (accountNumber == null){
            return false;
        }
        if (accountNumber.length() != 14){
            return false;
        }
        int countZero = 0;
        for (int i = 0; i < accountNumber.length(); i++) {
            if (!Character.isDigit(accountNumber.charAt(i))){
                return false;
            }
            if (accountNumber.charAt(i) == '0'){
                countZero++;
            }
        }
        return (countZero != 14);
    }
}
