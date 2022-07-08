package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

import Base.Base;

public class ExtentReportManager extends Base{
	public static ExtentReports report;

	public static ExtentReports getReportInstance() {

		if (report == null) {

			String reportName = DateUtils.getTimeStamp() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\Report\\" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			report.setSystemInfo("OS", "Windows 11 Home Single Language");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Build Number", "22000.675");
			report.setSystemInfo("Version", "21H2");
			report.setSystemInfo("Browser", "Google Chrome");

			htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
			htmlReporter.config().setReportName("All Headlines UI Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

		}

		return report;
	}

}
