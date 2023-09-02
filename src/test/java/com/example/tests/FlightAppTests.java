package com.example.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightAppTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://flights-app.pages.dev/");
    }

    @Test
    public void testDifferentFromToValues() {
        WebElement fromInput = driver.findElement(By.name("from"));
        WebElement toInput = driver.findElement(By.name("to"));
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(), 'Search')]"));

        fromInput.sendKeys("Istanbul");
        toInput.sendKeys("Istanbul");  // Same value for 'From' and 'To'
        searchButton.click();

        WebElement errorMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        assertEquals("From and To cannot be the same.", errorMessage.getText());
    }

    @Test
    public void testFlightListingCount() {
        WebElement fromInput = driver.findElement(By.name("from"));
        WebElement toInput = driver.findElement(By.name("to"));
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(), 'Search')]"));

        fromInput.sendKeys("Istanbul");
        toInput.sendKeys("Los Angeles");
        searchButton.click();

        int expectedItemCount = 2; // Assuming "From: Istanbul" and "To: Los Angeles" returns 2 flights
        WebElement itemCountElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("item-count")));
        int displayedItemCount = Integer.parseInt(itemCountElement.getText().split(" ")[1]);
        assertEquals(expectedItemCount, displayedItemCount);
    }
    // Test 1: "Found X items" ile listelenen uçuş sayısı aynı olmalı (Başarılı Senaryo)
    @Test
    public void testFlightListingCountSuccess() {
        WebElement fromInput = driver.findElement(By.name("from"));
        WebElement toInput = driver.findElement(By.name("to"));
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(), 'Search')]"));

        fromInput.sendKeys("Istanbul");
        toInput.sendKeys("Los Angeles");
        searchButton.click();

        int expectedItemCount = 2; // Assuming "From: Istanbul" and "To: Los Angeles" returns 2 flights
        WebElement itemCountElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("item-count")));
        int displayedItemCount = Integer.parseInt(itemCountElement.getText().split(" ")[1]);
        assertEquals(expectedItemCount, displayedItemCount);
    }

    // Test 2: "Found X items" ile listelenen uçuş sayısı aynı olmalı (Başarısız Senaryo - Uçuş Yok)
    @Test
    public void testFlightListingCountNoFlights() {
        WebElement fromInput = driver.findElement(By.name("from"));
        WebElement toInput = driver.findElement(By.name("to"));
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(), 'Search')]"));

        fromInput.sendKeys("Istanbul");
        toInput.sendKeys("Ankara"); // Assuming there are no flights between Istanbul and Ankara
        searchButton.click();

        int expectedItemCount = 0; // Expecting no flights
        WebElement itemCountElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("item-count")));
        int displayedItemCount = Integer.parseInt(itemCountElement.getText().split(" ")[1]);
        assertEquals(expectedItemCount, displayedItemCount);
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
