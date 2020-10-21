import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.EducationPage;
import pages.MainPage;
import pages.SearchPage;

public class SeleniumTest extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    EducationPage educationPage = new EducationPage();

    @Test
    public void test1() {
        mainPage.skipLocation();
        mainPage.compareHowMuchElementsInSubHeader(11);
        mainPage.compareTitlesInSubHeader(0, "Students");
        mainPage.compareTitlesInSubHeader(1, "Instructors");
        mainPage.compareTitlesInSubHeader(2, "Book Authors");
        mainPage.compareTitlesInSubHeader(3, "Professionals");
        mainPage.compareTitlesInSubHeader(4, "Researchers");
        mainPage.compareTitlesInSubHeader(5, "Institutions");
        mainPage.compareTitlesInSubHeader(6, "Librarians");
        mainPage.compareTitlesInSubHeader(7, "Corporations");
        mainPage.compareTitlesInSubHeader(8, "Societes");
        mainPage.compareTitlesInSubHeader(9, "Journal Editors");
        mainPage.compareTitlesInSubHeader(10, "Govemment");
    }

    @Test
    public void test2() {
        mainPage.textInSerachField("Java");
        mainPage.checkAreaIsDisplayed();
        mainPage.checkSearchResultIsCorrect("Java");
    }

    @Test
    public void test3() {
        mainPage.skipLocation();
        mainPage.textInSerachField("Java");
        mainPage.clickSearchButton();
        searchPage.checkHowTitelsInPage(10);
        searchPage.checkAllTitlesContainsJava();
        searchPage.checkAddCartButtonIsDisplayed();
    }

    @Test
    public void test4() {
        mainPage.skipLocation();
        mainPage.clickToSubHeaderEducationElement();
        educationPage.educationHeaderISDisplayed();
        educationPage.checkCountAndDisplayElementsInLeftSidePanel(13);
        educationPage.compareTitlesElementsInLeftSidePanel(0, "Information & Library Science");
        educationPage.compareTitlesElementsInLeftSidePanel(1, "Education & Public Policy");
        educationPage.compareTitlesElementsInLeftSidePanel(2, "K-12 General");
        educationPage.compareTitlesElementsInLeftSidePanel(3, "Higher Education General");
        educationPage.compareTitlesElementsInLeftSidePanel(4, "Vocational Technology");
        educationPage.compareTitlesElementsInLeftSidePanel(5, "Conflict Resolution & Mediation (School settings)");
        educationPage.compareTitlesElementsInLeftSidePanel(6, "Curriculum Tools-General");
        educationPage.compareTitlesElementsInLeftSidePanel(7, "Special Education Needs");
        educationPage.compareTitlesElementsInLeftSidePanel(8, "Theory of Education");
        educationPage.compareTitlesElementsInLeftSidePanel(9, "Education Special Topics");
        educationPage.compareTitlesElementsInLeftSidePanel(10, "Educational Research & Statistics");
        educationPage.compareTitlesElementsInLeftSidePanel(11, "Literacy & Reading");
        educationPage.compareTitlesElementsInLeftSidePanel(12, "Classroom Management");
    }
}