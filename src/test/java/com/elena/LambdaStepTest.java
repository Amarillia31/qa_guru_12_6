package com.elena;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    private static final String REPOSITORY = "Amarillia31/qa_guru_12_6";
    private static final int ISSUE_NUMBER = 1;

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open main page", () -> {
            open("https://github.com");
        });

        step("Find repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Click on repository" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
                });

        step("Click on tab issues", () ->{
            $(partialLinkText("Issues")).click();
        });

        step("Check issue number" + ISSUE_NUMBER, () -> {
            $(withText("#1")).shouldBe(Condition.visible);
            Allure.getLifecycle().addAttachment(
                    "PageSource",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
        });
    }
}