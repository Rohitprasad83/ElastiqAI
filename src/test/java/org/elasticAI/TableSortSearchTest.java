package org.elasticAI;

import org.elastiqAI.Pages.TableSortSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableSortSearchTest extends BaseTest{

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
}
