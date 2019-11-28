package tests.DE;

import org.testng.annotations.*;

public class C65148_WorkflowBREOnline8020 extends TestBaseDEAudafusion {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        user = new sadRalfData();
    }

    @Test
    public void c65148_WorkflowBREOnline8020() {
        // test steps should be right here.
        logTestStep("Step1", "Step descripton");
        pages.loginPage.login(user);
        pages.worklistPage.navigateToMaterialGridAsAdmin();
        pages.worklistPage.waitForWorkListLoaded();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
    // shut the F down dat thang!
    }
}
