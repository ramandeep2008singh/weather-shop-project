package com.weathershop.framework.utilities;

import com.weathershop.framework.base.DriverContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.*;

/**
 * This util class is created to keep all the common methods belonging all the Test classes
 */
public class CommonTestUtil {

    public static String getUrl() {
        return DriverContext.getDriver().getCurrentUrl();
    }

    public static int removeDegreeAndConvertToNumber(WebElement element) {
        String one[] = element.getText().split(" ");
        return Integer.parseInt(one[0]);
    }

    public static BigDecimal bigDecimalAddition(BigDecimal dec1, BigDecimal dec2) {
        BigDecimal sum;
        sum = dec1.add(dec2);
        return sum;
    }

    public static void sendKeysWithJavaScript(String text, WebElement element) {
        JavascriptExecutor js= (JavascriptExecutor) DriverContext.getDriver();
        js.executeScript("arguments[1].value = arguments[0]; ", text, element);
    }

    public static BigDecimal convertStringToBigDecimal(String text) {
        return new BigDecimal(text);
    }

    public static void addLeastExpensiveProductToCart(List<WebElement> elementPrices, List<WebElement> elementButtons) {
        WaitUtil.waitForPageToLoad();
        ArrayList<Integer> prodPrices = new ArrayList<Integer>();
        for (int i = 0; i < elementPrices.size(); i++) {
            Integer priceInt = Integer.valueOf(elementPrices.get(i).getText().replaceAll("[^0-9]", ""));
            prodPrices.add(priceInt);
        }
        Integer minPrice = Collections.min(prodPrices);
        for (int i = 0; i < elementPrices.size(); i++) {
            Integer priceInt1 = Integer.valueOf(elementPrices.get(i).getText().replaceAll("[^0-9]", ""));
            if (priceInt1.equals(minPrice)) {
                elementButtons.get(i).click();
                break;
            }
        }
    }

    public static Map<String, BigDecimal> getLeastExpensiveProduct(List<WebElement> elementNames,
                                                                   List<WebElement> elementPrices,
                                                                   List<WebElement> elementButtons,
                                                                   String spfNr) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < elementNames.size(); i++) {
            if (elementNames.get(i).getText().contains(spfNr)) {
                String productPrice = elementPrices.get(i).getText(); // Iterate and fetch product price
                productPrice = productPrice.replaceAll("[^0-9]", ""); // Replace anything with space other than numbers
                BigDecimal currentElementPrice = new BigDecimal(productPrice);
                Product prod = new Product();
                prod.key = spfNr;
                prod.name = elementNames.get(i).getText();
                prod.price = currentElementPrice;
                products.add(prod);
            }
        }
        Product minProd = extractMinProductPrice(products);
        return Map.of(minProd.name, minProd.price);
    }

    private static Product extractMinProductPrice(List<Product> products) {
        Collections.sort(products, Comparator.comparing((Product p) -> p.price));
        return products.get(0);
    }

    private static class Product {
        private String key;
        private String name;
        private BigDecimal price;
    }

}
