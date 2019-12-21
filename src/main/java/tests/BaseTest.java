package tests;

import logger.LoggerTool;

public class BaseTest {

    public void logTestStep(String stepName, String stepActionsToPerform, String stepExpectedResults) {
        LoggerTool.logInfo(stepName + "; \n" + stepActionsToPerform + "\n" + stepExpectedResults);

    }
}
