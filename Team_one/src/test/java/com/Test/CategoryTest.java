package com.Test;

import com.Pages.CategoryPage;
import com.Pages.LoginPage;
import com.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CategoryTest extends BaseTest {

    private CategoryPage categoryPage;

    @BeforeClass
    @Override
    public void setUp() throws IOException {
        super.setUp();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.navigateToLoginPage();
        loginPage.login(config.getProperty("user.email"), config.getProperty("user.password"));
        categoryPage = new CategoryPage(driver, wait);
    }

    // ── Books ──────────────────────────────────────────────────────────────────

    @Test(priority = 1, description = "TC-CAT-01: Navigate to Books category")
    public void testBooksCategory() {
        categoryPage.goToBooks();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Books"), "Books page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/books"), "URL should contain /books");
        Assert.assertTrue(categoryPage.getProductCount() > 0, "Books should have products");
    }

    // ── Computers ─────────────────────────────────────────────────────────────

    @Test(priority = 2, description = "TC-CAT-02: Navigate to Computers category")
    public void testComputersCategory() {
        categoryPage.goToComputers();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Computers"), "Computers page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/computers"), "URL should contain /computers");
    }

    @Test(priority = 3, description = "TC-CAT-03: Navigate to Desktops sub-category")
    public void testDesktopsSubCategory() {
        categoryPage.goToDesktops();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Desktops"), "Desktops page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/desktops"), "URL should contain /desktops");
    }

    @Test(priority = 4, description = "TC-CAT-04: Navigate to Notebooks sub-category")
    public void testNotebooksSubCategory() {
        categoryPage.goToNotebooks();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Notebooks"), "Notebooks page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/notebooks"), "URL should contain /notebooks");
    }

    @Test(priority = 5, description = "TC-CAT-05: Navigate to Accessories sub-category")
    public void testAccessoriesSubCategory() {
        categoryPage.goToAccessories();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Accessories"), "Accessories page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/accessories"), "URL should contain /accessories");
    }

    // ── Electronics ───────────────────────────────────────────────────────────

    @Test(priority = 6, description = "TC-CAT-06: Navigate to Electronics category")
    public void testElectronicsCategory() {
        categoryPage.goToElectronics();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Electronics"), "Electronics page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/electronics"), "URL should contain /electronics");
    }

    @Test(priority = 7, description = "TC-CAT-07: Navigate to Camera, photo sub-category")
    public void testCameraPhotoSubCategory() {
        categoryPage.goToCameraPhoto();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Camera, photo"), "Camera page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/camera-photo"), "URL should contain /camera-photo");
    }

    @Test(priority = 8, description = "TC-CAT-08: Navigate to Cell phones sub-category")
    public void testCellPhonesSubCategory() {
        categoryPage.goToCellPhones();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Cell phones"), "Cell phones page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/cell-phones"), "URL should contain /cell-phones");
    }

    // ── Remaining Categories ──────────────────────────────────────────────────

    @Test(priority = 9, description = "TC-CAT-09: Navigate to Apparel & Shoes")
    public void testApparelShoesCategory() {
        categoryPage.goToApparelShoes();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Apparel & Shoes"), "Apparel page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/apparel-shoes"), "URL should contain /apparel-shoes");
    }

    @Test(priority = 10, description = "TC-CAT-10: Navigate to Digital Downloads")
    public void testDigitalDownloadsCategory() {
        categoryPage.goToDigitalDownloads();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Digital downloads"), "Digital downloads page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/digital-downloads"), "URL should contain /digital-downloads");
    }

    @Test(priority = 11, description = "TC-CAT-11: Navigate to Jewelry")
    public void testJewelryCategory() {
        categoryPage.goToJewelry();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Jewelry"), "Jewelry page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/jewelry"), "URL should contain /jewelry");
    }

    @Test(priority = 12, description = "TC-CAT-12: Navigate to Gift Cards")
    public void testGiftCardsCategory() {
        categoryPage.goToGiftCards();
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("Gift Cards"), "Gift Cards page should be displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/gift-cards"), "URL should contain /gift-cards");
    }

    // ── Breadcrumb & Filter ───────────────────────────────────────────────────

    @Test(priority = 13, description = "TC-CAT-13: Verify breadcrumb on Books page")
    public void testBreadcrumbOnBooksPage() {
        categoryPage.goToBooks();
        Assert.assertEquals(categoryPage.getBreadcrumbCurrentItem(), "Books",
                "Breadcrumb should show 'Books'");
    }

    @Test(priority = 14, description = "TC-CAT-14: Verify price filter is available on Books page")
    public void testPriceFilterOnBooksPage() {
        categoryPage.goToBooks();
        Assert.assertTrue(categoryPage.getPriceFilterCount() > 0,
                "Price range filters should be visible on Books page");
    }
}
