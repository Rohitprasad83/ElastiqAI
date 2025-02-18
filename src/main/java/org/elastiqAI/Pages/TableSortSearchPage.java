package org.elastiqAI.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TableSortSearchPage extends BasePage{

    public TableSortSearchPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//label[text()='Search:']/input")
    private WebElement searchBox;

    @FindBy(xpath = "//table[@id='example']/tbody//child::tr")
    private List<WebElement> tableRows;

    public void enterIntoSearchBox(String search){
        waitForElementToBeVisible(searchBox);
        searchBox.clear();
        searchBox.sendKeys(search);
    }

    public int numberOfEntriesAfterSearch(){
        return tableRows.size();
    }
}
