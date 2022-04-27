package com.elena;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class AnnotatedStepsTest {
    private static final String REPOSITORY = "Amarillia31/qa_guru_12_6";
    private static final int ISSUE_NUMBER = 1;

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}