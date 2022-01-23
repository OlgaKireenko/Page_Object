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

    public static VerificationCode getVerificationCodeFor() {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardNumber {
        private String number;
    }
    public static CardNumber getFirstCardNumber(){
        return new CardNumber("5559 0000 0000 0001");
    }
    public static CardNumber getSecondCardNumber(){


        return new CardNumber("5559 0000 0000 0002");
    }
    //@Value
    //public static class InitialBalance {
       // private String number;
    //}
   // public static InitialBalance getFirstCardBalance(){    }

}