package ru.netology.PageObject;

import com.codeborne.selenide.ElementsCollection;
import io.github.bonigarcia.wdm.managers.SeleniumServerStandaloneManager;
import lombok.val;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.elements;

public class Balance_Page {

    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public Balance_Page() {
    }

    public int getCardBalance(int id) {
        //if (id = **** **** **** 0001) {

        val text = cards.get(id).text();

        return extractBalance(text);

    }


    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}

