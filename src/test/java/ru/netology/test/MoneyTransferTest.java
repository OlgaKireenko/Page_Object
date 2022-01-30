package ru.netology.test;

import org.junit.jupiter.api.Test;

import ru.netology.page_object.DashboardPage;
import ru.netology.page_object.MoneyTransferPage;
import ru.netology.data.Data_Helper;
import ru.netology.page_object.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        var Page_ObjectV1 = new LoginPage();

        var authInfo = Data_Helper.getAuthInfo();
        var verificationPage = Page_ObjectV1.validLogin(authInfo);
        var verificationCode = Data_Helper.getVerificationCodeFor();
        verificationPage.validVerify(verificationCode);
        var DashboardPage = new DashboardPage();
        int init_amount = DashboardPage.getCardBalance(0);
        System.out.println(init_amount);
        var moneyTransferPage = DashboardPage.addMoney();
        var MoneyTransferPage = new MoneyTransferPage();
        var dashboardPage = MoneyTransferPage.moneyTransfer();
        int amount1 = DashboardPage.getCardBalance(0);

        System.out.println(amount1);

        int amount2 = init_amount + 500;


        assertEquals(amount1, amount2);

    }

}
