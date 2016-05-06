
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.sql2o.*;
import org.junit.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
    public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Java Cut");
      assertThat(pageSource()).contains("Please type the Stylist name");
    }

  @Test
    public void getClientsPage() {
      Stylist myStylist = new Stylist ("Stylist Name 1");
      myStylist.save();
      String clientPath = String.format("http://localhost:4567/stylists/%d", myStylist.getId());
      goTo(clientPath);
      assertThat(pageSource()).contains("Stylist Name 1");
    }

  @Test
    public void getStylistsPage() {
      Stylist myStylist = new Stylist ("Stylist Name 1");
      myStylist.save();
      Client firstClient = new Client ("SushiLand", myStylist.getId());
      firstClient.save();
      Client secondClient = new Client ("SashimiLand", myStylist.getId());
      secondClient.save();
      String cuisinePath = String.format("http://localhost:4567/cuisines/%d", myStylist.getId());
      goTo(cuisinePath);
      assertThat(pageSource()).contains("SushiLand");
      assertThat(pageSource()).contains("SashimiLand");
    }

}
