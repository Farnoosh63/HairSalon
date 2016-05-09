
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
  public void getStylistsPageInsertClients() {
    Stylist myStylist = new Stylist ("Stylist Name 1");
    myStylist.save();
    Client firstClient = new Client ("Client Name 1", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client ("Client Name 2", myStylist.getId());
    secondClient.save();
    String clientPath = String.format("http://localhost:4567/stylists/%d", myStylist.getId());
    goTo(clientPath);
    assertThat(pageSource()).contains("Client Name 1");
    assertThat(pageSource()).contains("Client Name 2");
  }

  @Test
  public void getListOfStylistsPage() {
    Stylist myStylist = new Stylist ("Stylist Name 1");
    myStylist.save();
    String stylistPath = String.format("http://localhost:4567/stylists/%d", myStylist.getId());
    goTo(stylistPath);
    click("a", withText ("Manage Stylist list"));
    assertThat(pageSource()).contains("Stylist Name 1");
  }

  @Test
  public void getClientupdateClientPage() {
    Stylist myStylist = new Stylist ("Stylist Name 1");
    myStylist.save();
    myStylist.getId();
    Client oldClient = new Client ("Client Name 1", myStylist.getId());
    oldClient.save();
    String clientPath = String.format("http://localhost:4567/stylists/%d", myStylist.getId());
    goTo(clientPath);
    click("a", withText ("Update Client Name"));
    Client newClient = new Client ("Client Name 1 updated", myStylist.getId());
    newClient.save();
    goTo(clientPath);
    assertThat(pageSource()).contains("Client Name 1 updated");
  }

}
