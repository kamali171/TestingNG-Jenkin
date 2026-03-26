package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Page Object for category & sub-category navigation.
 *
 * LOCATORS REFERENCE:
 * ─────────────────────────────────────────────────────────────────────────────
 *  Element                        │ Locator Type │ Value
 * ─────────────────────────────────────────────────────────────────────────────
 *  Books menu link                │ CSS          │ ul.top-menu > li > a[href='/books']
 *  Computers menu link            │ CSS          │ ul.top-menu > li > a[href='/computers']
 *  Electronics menu link          │ CSS          │ ul.top-menu > li > a[href='/electronics']
 *  Apparel & Shoes menu link      │ CSS          │ ul.top-menu > li > a[href='/apparel-shoes']
 *  Digital Downloads menu link    │ CSS          │ ul.top-menu > li > a[href='/digital-downloads']
 *  Jewelry menu link              │ CSS          │ ul.top-menu > li > a[href='/jewelry']
 *  Gift Cards menu link           │ CSS          │ ul.top-menu > li > a[href='/gift-cards']
 *  Desktops sub-link              │ CSS          │ ul.top-menu a[href='/desktops']
 *  Notebooks sub-link             │ CSS          │ ul.top-menu a[href='/notebooks']
 *  Accessories sub-link           │ CSS          │ ul.top-menu a[href='/accessories']
 *  Camera, photo sub-link         │ CSS          │ ul.top-menu a[href='/camera-photo']
 *  Cell phones sub-link           │ CSS          │ ul.top-menu a[href='/cell-phones']
 *  Category page title            │ CSS          │ div.page-title h1
 *  Breadcrumb current item        │ CSS          │ div.breadcrumb ul li strong.current-item
 *  Product grid items             │ CSS          │ div.product-grid div.item-box
 *  Price range filter links       │ CSS          │ div.price-range-filter ul.price-range-selector li a
 *  Add to cart button (grid)      │ CSS          │ input.product-box-add-to-cart-button
 *  Product title link (grid)      │ CSS          │ h2.product-title a
 * ─────────────────────────────────────────────────────────────────────────────
 */
public class CategoryPage {

    private final WebDriver     driver;
    private final WebDriverWait wait;
    private final Actions       actions;

    // ── Top Navigation – Main Category Links ──────────────────────────────────

    /** Books top-nav link — CSS: ul.top-menu > li > a[href='/books'] */
    @FindBy(css = "ul.top-menu > li > a[href='/books']")
    private WebElement booksMenuLink;

    /** Computers top-nav link — CSS: ul.top-menu > li > a[href='/computers'] */
    @FindBy(css = "ul.top-menu > li > a[href='/computers']")
    private WebElement computersMenuLink;

    /** Electronics top-nav link — CSS: ul.top-menu > li > a[href='/electronics'] */
    @FindBy(css = "ul.top-menu > li > a[href='/electronics']")
    private WebElement electronicsMenuLink;

    /** Apparel & Shoes top-nav link — CSS: ul.top-menu > li > a[href='/apparel-shoes'] */
    @FindBy(css = "ul.top-menu > li > a[href='/apparel-shoes']")
    private WebElement apparelShoesMenuLink;

    /** Digital Downloads top-nav link — CSS: ul.top-menu > li > a[href='/digital-downloads'] */
    @FindBy(css = "ul.top-menu > li > a[href='/digital-downloads']")
    private WebElement digitalDownloadsMenuLink;

    /** Jewelry top-nav link — CSS: ul.top-menu > li > a[href='/jewelry'] */
    @FindBy(css = "ul.top-menu > li > a[href='/jewelry']")
    private WebElement jewelryMenuLink;

    /** Gift Cards top-nav link — CSS: ul.top-menu > li > a[href='/gift-cards'] */
    @FindBy(css = "ul.top-menu > li > a[href='/gift-cards']")
    private WebElement giftCardsMenuLink;

    // ── Computers Sub-Category Links ──────────────────────────────────────────

    /** Desktops sub-nav link — CSS: ul.top-menu a[href='/desktops'] */
    @FindBy(css = "ul.top-menu a[href='/desktops']")
    private WebElement desktopsSubLink;

    /** Notebooks sub-nav link — CSS: ul.top-menu a[href='/notebooks'] */
    @FindBy(css = "ul.top-menu a[href='/notebooks']")
    private WebElement notebooksSubLink;

    /** Accessories sub-nav link — CSS: ul.top-menu a[href='/accessories'] */
    @FindBy(css = "ul.top-menu a[href='/accessories']")
    private WebElement accessoriesSubLink;

    // ── Electronics Sub-Category Links ────────────────────────────────────────

    /** Camera, photo sub-nav link — CSS: ul.top-menu a[href='/camera-photo'] */
    @FindBy(css = "ul.top-menu a[href='/camera-photo']")
    private WebElement cameraPhotoSubLink;

    /** Cell phones sub-nav link — CSS: ul.top-menu a[href='/cell-phones'] */
    @FindBy(css = "ul.top-menu a[href='/cell-phones']")
    private WebElement cellPhonesSubLink;

    // ── Page Heading & Breadcrumb ─────────────────────────────────────────────

    /** Category page H1 title — CSS: div.page-title h1 */
    @FindBy(css = "div.page-title h1")
    private WebElement categoryPageTitle;

    /** Breadcrumb active item — CSS: div.breadcrumb ul li strong.current-item */
    @FindBy(css = "div.breadcrumb ul li strong.current-item")
    private WebElement breadcrumbCurrentItem;

    // ── Product Grid ──────────────────────────────────────────────────────────

    /** All product cards in grid view — CSS: div.product-grid div.item-box */
    @FindBy(css = "div.product-grid div.item-box")
    private List<WebElement> productGridItems;

    // ── Price Filter ──────────────────────────────────────────────────────────

    /** Price range filter links — CSS: div.price-range-filter ul.price-range-selector li a */
    @FindBy(css = "div.price-range-filter ul.price-range-selector li a")
    private List<WebElement> priceRangeFilters;

    // ── Constructor ───────────────────────────────────────────────────────────

    public CategoryPage(WebDriver driver, WebDriverWait wait) {
        this.driver  = driver;
        this.wait    = wait;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // ── Main Category Navigation ──────────────────────────────────────────────

    /** Click Books in the top navigation. */
    public void goToBooks() {
        wait.until(ExpectedConditions.elementToBeClickable(booksMenuLink)).click();
    }

    /** Click Computers in the top navigation. */
    public void goToComputers() {
        wait.until(ExpectedConditions.elementToBeClickable(computersMenuLink)).click();
    }

    /** Click Electronics in the top navigation. */
    public void goToElectronics() {
        wait.until(ExpectedConditions.elementToBeClickable(electronicsMenuLink)).click();
    }

    /** Click Apparel & Shoes in the top navigation. */
    public void goToApparelShoes() {
        wait.until(ExpectedConditions.elementToBeClickable(apparelShoesMenuLink)).click();
    }

    /** Click Digital Downloads in the top navigation. */
    public void goToDigitalDownloads() {
        wait.until(ExpectedConditions.elementToBeClickable(digitalDownloadsMenuLink)).click();
    }

    /** Click Jewelry in the top navigation. */
    public void goToJewelry() {
        wait.until(ExpectedConditions.elementToBeClickable(jewelryMenuLink)).click();
    }

    /** Click Gift Cards in the top navigation. */
    public void goToGiftCards() {
        wait.until(ExpectedConditions.elementToBeClickable(giftCardsMenuLink)).click();
    }

    // ── Computers Sub-Category Navigation ────────────────────────────────────

    /** Hover Computers → click Desktops. */
    public void goToDesktops() {
        actions.moveToElement(computersMenuLink).perform();
        wait.until(ExpectedConditions.elementToBeClickable(desktopsSubLink)).click();
    }

    /** Hover Computers → click Notebooks. */
    public void goToNotebooks() {
        actions.moveToElement(computersMenuLink).perform();
        wait.until(ExpectedConditions.elementToBeClickable(notebooksSubLink)).click();
    }

    /** Hover Computers → click Accessories. */
    public void goToAccessories() {
        actions.moveToElement(computersMenuLink).perform();
        wait.until(ExpectedConditions.elementToBeClickable(accessoriesSubLink)).click();
    }

    // ── Electronics Sub-Category Navigation ──────────────────────────────────

    /** Hover Electronics → click Camera, photo. */
    public void goToCameraPhoto() {
        actions.moveToElement(electronicsMenuLink).perform();
        wait.until(ExpectedConditions.elementToBeClickable(cameraPhotoSubLink)).click();
    }

    /** Hover Electronics → click Cell phones. */
    public void goToCellPhones() {
        actions.moveToElement(electronicsMenuLink).perform();
        wait.until(ExpectedConditions.elementToBeClickable(cellPhonesSubLink)).click();
    }

    // ── Page State / Assertions ───────────────────────────────────────────────

    /** Returns the H1 heading text of the current category page. */
    public String getCategoryPageTitle() {
        return wait.until(ExpectedConditions.visibilityOf(categoryPageTitle)).getText();
    }

    /** Returns true when the H1 matches the expected title (case-insensitive). */
    public boolean isCategoryPageDisplayed(String expectedTitle) {
        return getCategoryPageTitle().equalsIgnoreCase(expectedTitle);
    }

    /** Returns the breadcrumb active-item text. */
    public String getBreadcrumbCurrentItem() {
        return wait.until(ExpectedConditions.visibilityOf(breadcrumbCurrentItem)).getText();
    }

    /** Returns the number of product cards visible in the grid. */
    public int getProductCount() {
        return productGridItems.size();
    }

    /** Returns the current browser URL. */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // ── Product Interaction ───────────────────────────────────────────────────

    /**
     * Returns the product title text at the given 0-based grid index.
     * Locator used inside item: h2.product-title a
     */
    public String getProductTitleByIndex(int index) {
        return productGridItems.get(index)
                .findElement(By.cssSelector("h2.product-title a"))
                .getText();
    }

    /**
     * Click the product name link at a given 0-based grid index.
     * Locator used inside item: h2.product-title a
     */
    public void clickProductByIndex(int index) {
        productGridItems.get(index)
                .findElement(By.cssSelector("h2.product-title a"))
                .click();
    }

    /**
     * Click "Add to cart" for a product directly from the category grid.
     * Locator used inside item: input.product-box-add-to-cart-button
     */
    public void addProductToCartByIndex(int index) {
        WebElement btn = productGridItems.get(index)
                .findElement(By.cssSelector("input.product-box-add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
    }

    // ── Price Filter ──────────────────────────────────────────────────────────

    /** Click the price range filter at the given 0-based index. */
    public void applyPriceFilter(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(priceRangeFilters.get(index))).click();
    }

    /** Returns the number of price range filter options available. */
    public int getPriceFilterCount() {
        return priceRangeFilters.size();
    }
}
