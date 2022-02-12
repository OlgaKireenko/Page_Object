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
    void shouldTransferMoneyFromSecondToFirstCard() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = Data_Helper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = Data_Helper.getVerificationCodeFor();
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var initBalanceFirstCard = dashboardPage.getCardBalance(0);
        var initBalanceSecondCard = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.addMoney(0);
        var amountToTransfer = 500;
        var cardInfo = Data_Helper.getSecondCardNumber();
        dashboardPage = moneyTransferPage.moneyTransfer(String.valueOf(amountToTransfer), cardInfo.getNumber());;
        var actualBalanceFirstCard = dashboardPage.getCardBalance(0);
        var expectedBalanceFirstCArd = initBalanceFirstCard + amountToTransfer;
        var actualBalanceSecondCard = dashboardPage.getCardBalance(1);
        var expectedBalanceSecondCArd = initBalanceSecondCard - amountToTransfer;
        assertEquals(expectedBalanceFirstCArd, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCArd, actualBalanceSecondCard);
    }

    @Test
    void shouldTransferMoneyFromFirstToSecondCard() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = Data_Helper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = Data_Helper.getVerificationCodeFor();
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var initBalanceFirstCard = dashboardPage.getCardBalance(0);
        var initBalanceSecondCard = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.addMoney(1);
        var amountToTransfer = 1000;
        var cardInfo = Data_Helper.getFirstCardNumber();
        dashboardPage = moneyTransferPage.moneyTransfer(String.valueOf(amountToTransfer), cardInfo.getNumber());;
        var actualBalanceFirstCard = dashboardPage.getCardBalance(0);
        var expectedBalanceFirstCArd = initBalanceFirstCard - amountToTransfer;
        var actualBalanceSecondCard = dashboardPage.getCardBalance(1);
        var expectedBalanceSecondCArd = initBalanceSecondCard + amountToTransfer;
        assertEquals(expectedBalanceFirstCArd, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCArd, actualBalanceSecondCard);
    }

}
