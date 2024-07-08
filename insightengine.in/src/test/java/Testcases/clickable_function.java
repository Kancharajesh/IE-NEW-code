package Testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Baseclass.Basetest;

@Listeners(TestListener.class)
public class clickable_function extends Basetest {

    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void TC_01() throws Exception {
        ExtentTest test = extent.createTest("TC_01", "Scroll to Get Started and click");

        // Scroll to Get started
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        test.log(Status.PASS, "Scrolled to Get Started");

        // Click on Get started
        driver.findElement(By.xpath(insight.getProperty("Getstarteds"))).click();
        test.log(Status.PASS, "Clicked on Get Started");

        // Log additional information
        String pageTitle = driver.getTitle();
        test.log(Status.INFO, "Page Title: " + pageTitle);
        System.out.println("Page Title: " + pageTitle);

        Thread.sleep(1500);
    }

    @Test(priority = 2, retryAnalyzer = Retry.class)
    public void TC_02() throws Exception {
        ExtentTest test = extent.createTest("TC_02", "Scroll to How It Works and click");

        // Scroll to How it works
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        test.log(Status.PASS, "Scrolled to How It Works");
        Thread.sleep(1500);

        // Click on How it works
        driver.findElement(By.xpath(insight.getProperty("Howitworks"))).click();
        test.log(Status.PASS, "Clicked on How It Works");
    }

    @Test(priority = 3, retryAnalyzer = Retry.class)
    public void TC_03() throws Exception {
        ExtentTest test = extent.createTest("TC_03", "Scroll and click multiple solutions");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2550)");
        test.log(Status.PASS, "Scrolled to Solutions section");

        List<String> solutionXpaths = List.of("Solution1", "Solution2", "Solution3", "Solution4", "Solution5");

        for (String solution : solutionXpaths) {
            driver.findElement(By.xpath(insight.getProperty(solution))).click();
            test.log(Status.PASS, "Clicked on " + solution);
            Thread.sleep(1000);
        }
    }

    @Test(priority = 4, retryAnalyzer = Retry.class, enabled = false)
    public void TC_04() throws Exception {
        ExtentTest test = extent.createTest("TC_04", "Scroll and click testimonials");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3500)");
        test.log(Status.PASS, "Scrolled to Testimonials section");

        List<String> testimonialXpaths = List.of("Testmon3", "Testmon2", "Testmon4", "Testmon1");

        for (String testimonial : testimonialXpaths) {
            driver.findElement(By.xpath(insight.getProperty(testimonial))).click();
            test.log(Status.PASS, "Clicked on " + testimonial);
            Thread.sleep(1000);
        }
    }

    @Test(priority = 5, retryAnalyzer = Retry.class)
    public void TC_05() throws Exception {
        ExtentTest test = extent.createTest("TC_05", "Navigate to Pricing, Resources, and Insight Engine");

        driver.findElement(By.linkText(insight.getProperty("Pricing"))).click();
        test.log(Status.PASS, "Clicked on Pricing");
        Thread.sleep(1000);

        driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
        test.log(Status.PASS, "Clicked on Resources");
        Thread.sleep(1000);

        driver.findElement(By.linkText(insight.getProperty("InsightEngine"))).click();
        test.log(Status.PASS, "Clicked on Insight Engine");
        Thread.sleep(1000);

        driver.findElement(By.linkText(insight.getProperty("SuperJApp"))).click();
        test.log(Status.PASS, "Clicked on SuperJ App");
        Thread.sleep(1000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        test.log(Status.PASS, "Switched to new tab");
        Thread.sleep(1000);

        driver.switchTo().window(tabs.get(0));
        test.log(Status.PASS, "Switched back to original tab");
        Thread.sleep(1500);

        driver.findElement(By.xpath(insight.getProperty("GetStarted"))).click();
        test.log(Status.PASS, "Clicked on Get Started");
    }

    @Test(priority = 6, retryAnalyzer = Retry.class)
    public void TC_06() throws Exception {
        ExtentTest test = extent.createTest("TC_06", "Navigate to Resources and click various elements");

        driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
        test.log(Status.PASS, "Clicked on Resources");
        Thread.sleep(1500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        test.log(Status.PASS, "Scrolled to section");

        List<String> resourceXpaths = List.of("InsightReport1", "Bitesizesnippets1", "Blogs1", "Casestudy1");

        for (String resource : resourceXpaths) {
            driver.findElement(By.xpath(insight.getProperty(resource))).click();
            test.log(Status.PASS, "Clicked on " + resource);
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,500)");
            test.log(Status.PASS, "Scrolled to next section");
        }
    }

    @Test(priority = 7, retryAnalyzer = Retry.class)
    public void TC_07() throws Exception {
        ExtentTest test = extent.createTest("TC_07", "Navigate to Resources and interact with case studies");

        driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
        test.log(Status.PASS, "Clicked on Resources");
        Thread.sleep(1500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        test.log(Status.PASS, "Scrolled to section");
        Thread.sleep(1500);

        driver.findElement(By.xpath(insight.getProperty("CaseStudyFood&beverages"))).click();
        test.log(Status.PASS, "Clicked on Case Study Food & Beverages");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(insight.getProperty("BlogsBack"))).click();
        test.log(Status.PASS, "Clicked on Back");
        Thread.sleep(1000);

        driver.findElement(By.xpath(insight.getProperty("CaseStdyFMCG"))).click();
        test.log(Status.PASS, "Clicked on Case Study FMCG");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(insight.getProperty("BlogsBack"))).click();
        test.log(Status.PASS, "Clicked on Back");
        Thread.sleep(1000);
    }

    @Test(priority = 8, retryAnalyzer = Retry.class)
    public void TC_08() throws Exception {
        ExtentTest test = extent.createTest("TC_08", "Navigate to Resources and interact with blogs");

        driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
        test.log(Status.PASS, "Clicked on Resources");
        Thread.sleep(1500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        test.log(Status.PASS, "Scrolled to section");
        Thread.sleep(1000);

        driver.findElement(By.xpath(insight.getProperty("Blogs1"))).click();
        test.log(Status.PASS, "Clicked on Blogs");
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);

        List<String> blogParts = List.of("Blogspart1", "Blogspart2", "Blogspart3");

        for (String blogPart : blogParts) {
            driver.findElement(By.xpath(insight.getProperty(blogPart))).click();
            test.log(Status.PASS, "Clicked on " + blogPart);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(insight.getProperty("BlogsBack"))).click();
            test.log(Status.PASS, "Clicked on Back");
        }
        Thread.sleep(2000);
    }

    @Test(priority = 9, retryAnalyzer = Retry.class, enabled = true)
    public void TC_09() throws Exception {
        ExtentTest test = extent.createTest("TC_09", "Navigate to Resources and print blog titles");

        driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
        test.log(Status.PASS, "Clicked on Resources");
        Thread.sleep(1500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        test.log(Status.PASS, "Scrolled to Blogs section");
        Thread.sleep(1000);

        driver.findElement(By.xpath(insight.getProperty("Blogs1"))).click();
        js.executeScript("window.scrollBy(0,500)");
        test.log(Status.PASS, "Clicked on Blogs");
        Thread.sleep(1000);

        WebElement blogContainer = driver.findElement(By.xpath(insight.getProperty("Allblogs")));
        Assert.assertNotNull(blogContainer, "Blog container not found");
        test.log(Status.PASS, "Blog container found");

        List<WebElement> blogElements = blogContainer.findElements(By.xpath(".//div[contains(@class, 'blog-post-class')]"));
        Assert.assertTrue(blogElements.size() > 0, "No blog elements found");
        test.log(Status.PASS, "Total number of blogs: " + blogElements.size());

        for (WebElement blogElement : blogElements) { 
            String blogTitle = blogElement.getText(); // Adjust if title is in a specific child element
            System.out.println("Blog Title: " + blogTitle);
            test.log(Status.PASS, "Blog Title: " + blogTitle);
        }
    }

    @Test(priority = 10, retryAnalyzer = Retry.class)
    public void TC_10() throws Exception {
        ExtentTest test = extent.createTest("TC_10", "Navigate to Pricing and verify sign-up page");

        driver.findElement(By.linkText(insight.getProperty("Pricing"))).click();
        test.log(Status.PASS, "Clicked on Pricing");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        test.log(Status.PASS, "Scrolled to Pricing section");

        driver.findElement(By.xpath(insight.getProperty("pricingstarted01"))).click();
        test.log(Status.PASS, "Clicked on first pricing option");
        Thread.sleep(2000);

        WebElement signup = driver.findElement(By.xpath(prop.getProperty("Signup01")));
        String actualElementText = signup.getText();
        String expectedElementText = "Sign Up";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        test.log(Status.PASS, "Verified Sign Up page");

        driver.navigate().back();
        Thread.sleep(1000); // Wait for the page to load completely before interacting with it
    }
}
