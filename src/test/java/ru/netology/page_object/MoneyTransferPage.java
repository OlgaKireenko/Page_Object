package ru.netology.page_object;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoneyTransferPage {
    private SelenideElement calculate = $("[data-test-id=dashboard]");

    public MoneyTransferPage() {

        calculate.shouldBe(visible);
    }

    public DashboardPage moneyTransfer(String amount, String cardNumber) {
        $("[data-test-id=amount] input").sendKeys(amount);

        $("[data-test-id=from] input").sendKeys(cardNumber);

        $(".button__text").click();
        return new DashboardPage();

    }

}
