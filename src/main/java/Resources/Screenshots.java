package Resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import basePage.BasePage;

public class Screenshots extends BasePage implements ITestListener {

	public Screenshots() throws IOException {
		super();
	}

	public void onTestFailure(ITestResult result) {

		try {
			takeSnapShot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
