import{ chromium, test , expect} from "@playwright/test";

test(`PVR Booking`, async({page}) =>
{
    await page.goto("https://www.pvrcinemas.com/.")
    await page.waitForTimeout(3000);

    await page.locator("(//span[contains(text(), 'Chennai')])[1]").click();
    await page.locator("(//span[contains(text(), 'Cinema')])[1]").click();
    await page.locator("//span[contains(text(), 'Select Cinema')]").click();
    await page.locator("//span[contains(text(), 'INOX Chennai Citi Centre')]").click();
    await page.locator("//li[@class = 'p-dropdown-item']/span[contains(text(), 'Today')]").click();
    //await page.locator("(//li[@class = 'p-dropdown-item']/span)[1]").click();
    await page.locator("//li[@class = 'p-dropdown-item']/span[text() = 'THAAI KIZHAVI']").click();
    //await page.locator("(//li[@class = 'p-dropdown-item']/span)[1]").click();
    await page.locator("//li[@class = 'p-dropdown-item']/span/span[text() = '03:20 PM']").click();
    await page.locator("//div[contains(@class, 'quick-lefts ')]/button[contains(@aria-label, 'Submit')]").click();
    await page.locator("//button[contains(text(), 'Accept')]").click();
    const isseatavailable = await page.locator("//tr[contains(@class, 'seats-row')][3]/td[2]/span[contains(@id, 'N:19')]").isEnabled();
    if(isseatavailable)
    {
        await page.locator("//tr[contains(@class, 'seats-row')][3]/td[2]/span[contains(@id, 'N:19')]").click();
        const seatnumber = await page.locator("//div[@class = 'seat-number']/p").innerText();
        if(seatnumber === "N19")
        {
            console.log("The seat is verified")
        }
        await expect(page.locator("//div[@class = 'grand-total']/h6")).toHaveText("Grand Total");
        await page.locator("//div[@class = 'register-btn']/button[contains(text(), 'Proceed')]").click();
    }

})