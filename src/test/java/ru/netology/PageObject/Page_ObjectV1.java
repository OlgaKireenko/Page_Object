package ru.netology.PageObject;

import ru.netology.data.Data_Helper;

import static com.codeborne.selenide.Selenide.$;

public class Page_ObjectV1 {
    public VerificationPage validLogin(Data_Helper.AuthInfo info) {
        $("[data-test-id=login] input").setValue(info.getLogin());
        $("[data-test-id=password] input").setValue(info.getPassword());
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
}


