package ru.netology.test;

import org.junit.jupiter.api.Test;

import ru.netology.PageObject.DashboardPage;
import ru.netology.PageObject.MoneyTransferPage;
import ru.netology.PageObject.VerificationPage;
import ru.netology.data.Data_Helper;
import ru.netology.PageObject.Page_ObjectV1;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        var Page_ObjectV1 = new Page_ObjectV1();

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

        //$(".button__content").click();
        //$("[data-test-id=amount] input").sendKeys("500");
       // $("[data-test-id=from] input").sendKeys("5559 0000 0000 0002");
        //$(".button__text").click();

       // $("[data-test-id=dashboard]").shouldBe(visible);




        assertEquals(amount1, amount2);

    }

}
