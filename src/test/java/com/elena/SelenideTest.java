package com.elena;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Owner("Amarillia31")
@Severity(SeverityLevel.BLOCKER)
@Feature("Issues at repository")
@Story("Find issue at repository")
public class SelenideTest {

    @Test
    @DisplayName("First test")
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Amarillia31/qa_guru_12_6");
        $(".header-search-input").submit();

        $(linkText("Amarillia31/qa_guru_12_6")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).click();
    }

}