package ru.netology.data;

import lombok.Value;

public class Data_Helper {
    private Data_Helper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }


    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

   // @Value
   // public static class CreditCard {
    //    private double number;
     //   private int balance;

     //   public static CreditCard getFirstCardInfo() {

     //       return new CreditCard(555_900_000_000_001, 10000);        }

        //public static CreditCard getSecondCardInfo() {
    //return new CreditCard(555900000000002, 10000);        }

}


//public class Data_Helper {}
