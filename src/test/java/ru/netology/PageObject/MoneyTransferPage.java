package ru.netology.PageObject;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.Data_Helper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoneyTransferPage {
    private SelenideElement calculate = $("[data-test-id=dashboard]");

    public MoneyTransferPage() {

        calculate.shouldBe(visible);
    }

    public DashboardPage moneyTransfer() {
        $("[data-test-id=amount] input").sendKeys("500");


        //Todo, вставить метод который возвращает номер карты из DataHelper
        $("[data-test-id=from] input").sendKeys("5559 0000 0000 0002");


        $(".button__text").click();
        return new DashboardPage();

    }

}
