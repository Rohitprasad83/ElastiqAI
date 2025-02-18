package org.elasticAI;

import org.elastiqAI.Pages.TableSortSearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;

public class TableSortSearchResults extends BaseTest{

    public TableSortSearchPage tableSortSearchPage;

    @Test
    public void tableSortSearch(){
        logger.info("staring the table sort search test method");
        tableSortSearchPage = new TableSortSearchPage(driver);
        String search = "New York";
        logger.info("entering {} in search box.",search);
        tableSortSearchPage.enterIntoSearchBox(search);
        int numberOfSearchResults = tableSortSearchPage.numberOfEntriesAfterSearch();
        Assert.assertEquals(numberOfSearchResults, 5);
    }

    @Test
    public void tableSortSearch2(){
        logger.info("staring the table sort search 2 test method");
        tableSortSearchPage = new TableSortSearchPage(driver);
        String search = "New York";
        logger.info("entering {} in search box.",search);
        tableSortSearchPage.enterIntoSearchBox(search);
        int numberOfSearchResults = tableSortSearchPage.numberOfEntriesAfterSearch();
        Assert.assertEquals(numberOfSearchResults, 7);
    }


}
