package com.giangnth.keywords;

import com.giangnth.drivers.DriverManager;
import com.giangnth.helpers.PropertiesHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class WebUI {

    private static int WAIT_TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("wait_timeout"));
    private static double STEP_TIME = Double.parseDouble(PropertiesHelper.getValue("step_time"));
    private static int PAGE_LOAD_TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("page_load_timeout"));


    public static void threadSleep(double second) {
        try {
            Thread.sleep((long) second * 1000);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }

    public static void highlightElement(By by) {
        String script = "arguments[0].style.border='3px solid red'";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(script, getWebElement(by));
    }

    public static void highlightElement(By by, String color) {
        String script = "arguments[0].style.border='3px solid " + color + "'";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(script, getWebElement(by));
    }

    public static void highlightElement(WebElement element) {
        String script = "arguments[0].style.border='3px solid red'";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(script, element);
    }

    public static void highlightElement(WebElement element, String color) {
        String script = "arguments[0].style.border='3px solid " + color + "'";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(script, element);
    }

    // chờ hiển thị có chứa highlight
    public static WebElement waitForElementVisible(By by){
        WebElement element = null;
        try {
            //System.out.println("Driver in WebUI: " +driver);
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by)); //đã đợi và tìm element rồi nên sẽ thay thế cho
            // driver.findElement(by)và nó đã trả về Webelement
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
        return element;
    }

    // chờ hiển thị có chứa highlight + thời gian chờ
    public static WebElement waitForElementVisible(By by, int seconds){
        WebElement element = null;
        try{
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by)); //đã đợi và tìm element rồi nên sẽ thay thế cho
            // driver.findElement(by)và nó đã trả về Webelement
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element Visible with " + seconds + "(s) : "+ by.toString());
            Assert.fail("Timeout waiting for the element Visible with " + seconds + "(s) : "+ by.toString());
        }
        return element;
    }

    //chờ all
    public static List<WebElement> waitForAllElementsVisible(By by) {
        List<WebElement> element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));//đã đợi và tìm element rồi nên sẽ thay thế cho
            // driver.findElement(by)và nó đã trả về Webelement
            highlightElement(by);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for all elements to be visible. " + by.toString());
            Assert.fail("Timeout waiting for all elements to be visible. " + by.toString());
        }
        return element;
    }

    //chờ all + giờ
    public static List<WebElement> waitForAllElementsVisible(By by, int seconds) {
        List<WebElement> element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));//đã đợi và tìm element rồi nên sẽ thay thế cho
            // driver.findElement(by)và nó đã trả về Webelement
            highlightElement(by);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for all elements to be visible. " + by.toString());
            Assert.fail("Timeout waiting for all elements to be visible. " + by.toString());
        }
        return element;
    }

    //chờ để click có chứa highlight
    public static WebElement waitForElementClick(By by){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));//đã đợi và tìm element rồi nên sẽ thay thế cho
            // driver.findElement(by)và nó đã trả về Webelement
            highlightElement(element);
            return element;
        }catch (Throwable error) {
            System.out.println("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
        return element;
    }

    //chờ để click có chứa highlight + thời gian chờ
    public static WebElement waitForElementClick(By by, int seconds){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));//đã đợi và tìm element rồi nên sẽ thay thế cho
            // driver.findElement(by)và nó đã trả về Webelement
            highlightElement(element);
            return element;
        }catch (Throwable error) {
            System.out.println("Timeout waiting for the element clickable with " + seconds + "(s) : "+ by.toString());
            Assert.fail("Timeout waiting for the element clickable with " + seconds + "(s) : "+ by.toString());
        }
        return element;
    }

    //chờ để element xuất hiện trong DOM có chứa highlight + thời gian chờ
    public static WebElement waitForElementPresent(By by, int seconds){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));//đã đợi và tìm element rồi nên sẽ thay thế cho
            // driver.findElement(by)và nó đã trả về Webelement
            highlightElement(element);
            return element;
        }catch (Throwable error) {
            System.out.println("Element not exit with " + seconds + "(s) : "+ by.toString());
            Assert.fail("Timeout waiting for the element clickable with " + seconds + "(s) : "+ by.toString());
        }
        return element;
    }

    //chờ để element xuất hiện trong DOM có chứa highlight + thời gian chờ
    public static WebElement waitForElementPresent(By by){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));//đã đợi và tìm element rồi nên sẽ thay thế cho
            // driver.findElement(by)và nó đã trả về Webelement
            highlightElement(element);
            return element;
        }catch (Throwable error) {
            System.out.println("Element not exit" + by.toString());
            Assert.fail("Element not exit" + by.toString());
        }
        return element;
    }

    //chờ load trang
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return document.readyState")
                .toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load (Javascript). (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }
    }

    //check tồn tại khi vào trang
    public static boolean checkExitsElement(By by) {
        List<WebElement> elements = getWebElements(by);
        if (elements.size() > 0) {
            System.out.println("Phần tử tồn tại: true " + by);
            return true;
        } else {
            System.out.println("Phần tử tồn tại: false " + by);
            return false;
        }
    }

    //Hàm kiểm tra hiển  với WebDriverWait - tương ứng driver.findElement(By).isDisplayed()
    public static boolean checkElementDisplay(By by, int timeoutSeconds) {
        try {
            WebElement element = waitForElementVisible(by, timeoutSeconds);
            highlightElement(element);
            System.out.println("Element found: " + by.toString() + " within " + timeoutSeconds + " seconds.");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element not found: " + by.toString() + " within " + timeoutSeconds + " seconds.");
            return false;
        }
    }

    public static boolean checkSeletedElement(By by) {
        WebElement element = waitForElementPresent(by);
        if (element.isSelected()) {
            System.out.println("Phần tử đã tích chọn: true " + by);
            return true;
        } else {
            System.out.println("Phần tử không tích chọn: false " + by);
            return false;
        }
    }

    public static void openURL(String url) {
        DriverManager.getDriver().get(url);
        System.out.println("URL: " + url);
    }

    public static String getCurrentURL() {
        threadSleep(STEP_TIME);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        return currentUrl;
    }

    public static WebElement getWebElement(By by){
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    //click dựa vào wait động điền giá trị
    public static void clickElement(By by, int seconds) {
        waitForElementClick(by, seconds).click(); //hàm wait đã bao gồm tìm kiếm + chờ và trả ra webelement để click
        System.out.println("Click element: " + by);
    }

//    public static void clickElement(WebDriver driver, By by, int seconds) {
//        waitForElementClick(driver, by, seconds);
//        highlightElement(driver.findElement(by));
//        driver.findElement(by).click();
//        System.out.println("Click element: " + by);
//    }

    //click dựa vào wait cố định 10s
    public static void clickElement(By by) {
        waitForElementClick(by).click();
        System.out.println("Click element: " + by);
    }

    public static void clearElement(By by) {
        waitForElementVisible(by).clear();
        System.out.println("Clear text element: " + by);
    }

    //sendKey dựa vào wait linh động có thể điền giá trị
    public static void setTextElement(By by, String text, int seconds) {
        threadSleep(STEP_TIME);
        waitForElementVisible(by, seconds).sendKeys(text);
        System.out.println("Set text: " + text + " on element: " + by);
    }

    //sendKey dựa vào wait cố định 10s
    public static void setTextElement(By by, String text) {
        threadSleep(STEP_TIME);
        waitForElementVisible(by).sendKeys(text);
        System.out.println("Set text: " + text + " on element: " + by);
    }

    //lấy giá trị text
    public static String getElementText(By by) {
        waitForElementVisible(by);
        WebElement element = getWebElement(by);
        System.out.println("Get text on element: " + by);
        String text = element.getText();
        System.out.println("==> TEXT: " + text);
        return text;
    }

    //lấy giá trị attribute
    public static String getElementAttribute(By by, String attribute) {
        waitForElementVisible(by);
        WebElement element = getWebElement(by);
        System.out.println("Get attribute on element: " + by);
        String textAttribute = element.getAttribute(attribute);
        System.out.println("==> Attribute: " + textAttribute);
        return textAttribute;
    }

    public static void scrollAtTop(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", DriverManager.getDriver().findElement(by));
    }

    public static void scrollAtBottom(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false)", DriverManager.getDriver().findElement(by));
    }

    public static void switchToFrame(By by){
        try{
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(500));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        }catch (Throwable error){
            System.out.println("Timeout waiting for Switch To Frame. " + by.toString());
            Assert.fail("Timeout waiting for Switch To Frame. " + by.toString());
        }
    }

    public static void switchToParentFrame(){
        DriverManager.getDriver().switchTo().parentFrame();
    }

    public static void switchToDefaultContentFrame(){
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public static void switchToAlert(){
        DriverManager.getDriver().switchTo().alert();
    }

    public static void acceptAlert(){
        DriverManager.getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert(){
        DriverManager.getDriver().switchTo().alert().dismiss();
    }

    public static Actions actionClickBase(By by, Keys key, String text) {
        WebElement element = waitForElementVisible(by);
        Actions action = new Actions(DriverManager.getDriver()).moveToElement(element).click();

        if (key != null) {
            action.sendKeys(key);
        }

        if (text != null && !text.isEmpty()) {
            action.sendKeys(text);
        }

        return action;
    }

    public static Actions actionClick(By by) {
        return actionClickBase(by, null, null);
    }

    public static Actions actionClickAndSetText(By by, String text) {
        return actionClickBase(by, null, text);
    }

    public static Actions actionClickAndSetKeys(By by, Keys key) {
        return actionClickBase(by, key, null);
    }

    public static boolean moveToElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).release(getWebElement(by)).build().perform();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
