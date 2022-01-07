package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.PageObject.Balance_Page;
import ru.netology.PageObject.DashboardPage;
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
        var verificationCode = Data_Helper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var Balance_Page = new Balance_Page();
        int init_amount = Balance_Page.getCardBalance(0);

        System.out.println(init_amount);

        $(".button__content").click();
        $("[data-test-id=amount] input").sendKeys("500");
        $("[data-test-id=from] input").sendKeys("5559 0000 0000 0002");
        $(".button__text").click();

        $("[data-test-id=dashboard]").shouldBe(visible);


        int amount1 = Balance_Page.getCardBalance(0);

       System.out.println(amount1);

       int amount2 = init_amount +500;


        assertEquals(amount1,amount2);


    }

}
