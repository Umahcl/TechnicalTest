import{ chromium, test , expect} from "@playwright/test";

test(`Decathlon`, async({page}) =>
{
    await page.goto("https://www.decathlon.in/")
    await page.waitForTimeout(3000);
    const title = await page.title();
    console.log(title);
    if(title.startsWith("Buy Sporting Goods, Sportswear and Equipments"))
    {
        console.log("The page title is verified");
    }
    await page.locator("(//span[contains(text(), 'Search for  ')])[1]").click();
    await expect(page.locator("(//span[contains(text(), 'Search for  ')])[1]")).toBeEnabled();
    await page.getByText("Shoes For Men").click();
    await page.locator("(//span[contains(text(), 'Search for  ')])[1]").press('Enter')

    const pagetitleshoe = await page.title();
    console.log(pagetitleshoe);
    await expect.soft(pagetitleshoe).toContain("Search | Shoes");
    await page.locator("//input[@type = 'checkbox']/following::span[contains(text(), 'Men')]").click();
    await page.locator("//span[contains(text(), 'Running')]").click();
    await page.locator("//span[contains(text(), 'Uk 9.5')]").click();
    await page.locator("(//img[@alt = 'Sorting'])[2]").click();
    await page.locator("//a[contains(text(), 'Price: High to Low')]").click();
    await page.locator("(//img[contains(@alt, 'Men Running and Trail Running Shoes, Kiprun JF 190 Grip - Silver Grey')])[1]").click();
    await page.locator("//div[contains(text(), 'UK 10.5 - EU 45')]").click();
    await page.locator("//span[contains(text(), 'ADD TO CART')]").click();
    await expect (page.locator("//h3[contains(text(), 'Product added to cart')]")).toBeVisible();
    await page.locator("(//a[@href = '/checkout/cart'])[2]").click();
    const totalcost = await page.locator("//div[@data-test-id = 'cart:cart-checkout-total-cart-value']/p").innerText();
    console.log(`The total cost of the shoe is ${totalcost}`)
})