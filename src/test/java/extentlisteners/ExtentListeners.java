package extentlisteners;

import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentListeners implements ITestListener {

	public ExtentHtmlReporter htmlreporter;

	public ExtentReports reports;

	public ExtentTest logger;

	// static Date d = new Date();

	// static String fileName = "Extent_" + d.toString().replace(":", "_").replace("
	// ", "_") + ".html";

	public void onTestStart(ITestResult result) {

		String tiemstamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String report = "Test-Report"+tiemstamp+".html";

		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+report);

		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

		reports = new ExtentReports();

		reports.attachReporter(htmlreporter);
//l3
	}

	public void onTestSuccess(ITestResult result) {

		logger = reports.createTest(result.getName());

		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

//		
//		String methodName=result.getMethod().getMethodName();
//		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
//		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//		test.pass(m);
//		

	}

	public void onTestFailure(ITestResult result) {

		logger = reports.createTest(result.getName());

		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

//		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
//		test.fail(excepionMessage);
//		
//	
//		
//		String methodName=result.getMethod().getMethodName();
//		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " FAILED"+"</b>";		
//	
//		try {
//			
//			String screenshot = "C:\\Users\\way2automation\\Desktop\\dd.png";
//			test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",
//					MediaEntityBuilder.createScreenCaptureFromPath(screenshot)
//							.build());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
//		test.log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {

		logger = reports.createTest(result.getName());

		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

//		String methodName=result.getMethod().getMethodName();
//		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
//		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
//		test.skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		reports.flush();

	}

}
