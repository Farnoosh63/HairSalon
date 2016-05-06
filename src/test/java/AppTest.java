
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

  // @Test
  //   public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("Best Restaurants App");
  //     assertThat(pageSource()).contains("Cuisine");
  //     assertThat(pageSource()).contains("favorite cuisine");
  //   }
  //
  // @Test
  //   public void getCuisineReturnSamePage() {
  //     Cuisine myCuisine = new Cuisine ("Italian");
  //     myCuisine.save();
  //     String cuisinePath = String.format("http://localhost:4567/cuisines/%d", myCuisine.getId());
  //     goTo(cuisinePath);
  //     assertThat(pageSource()).contains("Italian");
  //   }
  //
  // @Test
  //   public void getCuisineGetMultipleRestaurantsReturnAll() {
  //     Cuisine myCuisine = new Cuisine ("Japanese");
  //     myCuisine.save();
  //     Restaurant firstRestaurant = new Restaurant ("SushiLand", myCuisine.getId());
  //     firstRestaurant.save();
  //     Restaurant secondRestaurant = new Restaurant ("SashimiLand", myCuisine.getId());
  //     secondRestaurant.save();
  //     String cuisinePath = String.format("http://localhost:4567/cuisines/%d", myCuisine.getId());
  //     goTo(cuisinePath);
  //     assertThat(pageSource()).contains("SushiLand");
  //     assertThat(pageSource()).contains("SashimiLand");
  //   }

}
