package keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {
    private static int WAIT_TIMEOUT = 10;

    public static void highlightElement(WebDriver driver, WebElement element) {
        String script = "arguments[0].style.border='3px solid red'";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public static void highlightElement(WebDriver driver, WebElement element, String color) {
        String script = "arguments[0].style.border='3px solid " + color + "'";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public static boolean checkExitsElement(WebDriver driver, By by) {
        List<WebElement> elements = getWebElements(driver, by);
        if (elements.size() > 0) {
            System.out.println("Phần tử tồn tại: true " + by);
            return true;
        } else {
            System.out.println("Phần tử tồn tại: false " + by);
            return false;
        }
    }

    public static void openURL(WebDriver driver, String url) {
        driver.get(url);
        System.out.println("URL: " + url);
    }

    public static WebElement getWebElement(WebDriver driver, By by){
        return driver.findElement(by);
    }

    public static List<WebElement> getWebElements(WebDriver driver, By by) {
        return driver.findElements(by);
    }

    public static void waitForElementVisible(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(WebDriver driver, By by, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementClick(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementClick(WebDriver driver, By by, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void threadSleep(double second) {
        try {
            Thread.sleep((long) second * 1000);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }

    //click dựa vào wait động điền giá trij
    public static void clickElement(WebDriver driver, By by, int seconds) {
        waitForElementClick(driver, by, seconds);
        driver.findElement(by).click();
        System.out.println("Click element: " + by);
    }

    //click dựa vào wait cố định 10s
    public static void clickElement(WebDriver driver, By by) {
        waitForElementClick(driver, by);
        driver.findElement(by).click();
        System.out.println("Click element: " + by);
    }

    public static void clearElement(WebDriver driver, By by) {
        waitForElementVisible(driver, by);
        driver.findElement(by).clear();
        System.out.println("Clear text element: " + by);
    }

    //sendKey dựa vào wait linh động có thể điền giá trị
    public static void setTextElement(WebDriver driver, By by, String text, int seconds) {
        waitForElementVisible(driver, by, seconds);
        driver.findElement(by).sendKeys(text);
        System.out.println("Set text: " + text + " on element: " + by);
    }

    //sendKey dựa vào wait cố định 10s
    public static void setTextElement(WebDriver driver, By by, String text) {
        waitForElementVisible(driver, by);
        driver.findElement(by).sendKeys(text);
        System.out.println("Set text: " + text + " on element: " + by);
    }

    //lấy giá trị text
    public static String getElementText(WebDriver driver, By by) {
        waitForElementVisible(driver, by);
        WebElement element = getWebElement(driver, by);
        System.out.println("Get text on element: " + by);
        String text = element.getText();
        System.out.println("==> TEXT: " + text);
        return text;
    }

    //lấy giá trị attribute
    public static String getElementAttribute(WebDriver driver, By by, String attribute) {
        waitForElementVisible(driver, by);
        WebElement element = getWebElement(driver, by);
        System.out.println("Get attribute on element: " + by);
        String textAttribute = element.getAttribute(attribute);
        System.out.println("==> Attribute: " + textAttribute);
        return textAttribute;
    }

    public static void scrollAtTop(WebDriver driver, By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(by));
    }

    public static void scrollAtBottom(WebDriver driver, By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false)", driver.findElement(by));
    }

    public static void switchToFrame(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }
}
