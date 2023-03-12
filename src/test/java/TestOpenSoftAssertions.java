import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestOpenSoftAssertions {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;

    }

    @BeforeEach
    void beforeEach() {
        Configuration.browser = "firefox";
    }

    @Test
    void testOpenSoftAssertions() {
        open("https://github.com/");
        $(".js-site-search-focus").setValue("selenide").pressEnter();
        $(".repo-list .v-align-middle").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".filterable-active").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
