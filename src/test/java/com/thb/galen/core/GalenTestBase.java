package com.thb.galen.core;

import static java.util.Arrays.asList;

import com.galenframework.testng.GalenTestNgTestBase;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

public abstract class GalenTestBase extends GalenTestNgTestBase {

    private static final String BASE_URL = "https://oe2.forum-portal.test5.pro/";
    //private static final String BASE_URL = "https://forum-portal.thirdbridge.com/";
    static {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver");
    }

    @Override
    public WebDriver createDriver(Object[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(caps);
        //WebDriver driver = new ChromeDriver();
        if (args.length > 0) {
            if (args[0] != null && args[0] instanceof TestDevice) {
                TestDevice device = (TestDevice)args[0];
                if (device.getScreenSize() != null) {
                    driver.manage().window().setSize(device.getScreenSize());
                }
            }
        }
        return driver;
    }

    public void load(String uri) {
        getDriver().get(BASE_URL + uri);
    }

    @DataProvider(name = "devices")
    public Object [][] devices () {
        return new Object[][] {
                //{new TestDevice("mobile", new Dimension(320, 576), asList("mobile"))},
                //{new TestDevice("tablet", new Dimension(576, 768), asList("tablet"))},
                {new TestDevice("desktop", new Dimension(1360, 800), asList("desktop"))}
        };
    }

    public static class TestDevice {
        private final String name;
        private final Dimension screenSize;
        private final List<String> tags;

        public TestDevice(String name, Dimension screenSize, List<String> tags) {
            this.name = name;
            this.screenSize = screenSize;
            this.tags = tags;
        }

        public String getName() {
            return name;
        }

        public Dimension getScreenSize() {
            return screenSize;
        }

        public List<String> getTags() {
            return tags;
        }

        @Override
        public String toString() {
            return String.format("%s %dx%d", name, screenSize.width, screenSize.height);
        }
    }
}
