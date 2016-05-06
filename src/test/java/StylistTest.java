import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
// import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_OwnerAddStylist_true() {
    Stylist newStylist = new Stylist ("Stylist_name1");
    assertEquals(true, newStylist instanceof Stylist);
  }

  // @Test
  // public void Cuisine_getNameReturnName_String() {
  //   Cuisine myCuisine = new Cuisine ("Italian");
  //   assertEquals("Italian", myCuisine.getName());
  // }
  //
  // @Test
  // public void Cuisine_getTwoSameCuisines_true() {
  //   Cuisine firstCuisine = new Cuisine ("Italian");
  //   Cuisine secondCuisine = new Cuisine ("Italian");
  //   assertTrue(firstCuisine.equals(secondCuisine));
  // }
  //
  //
  // @Test
  // public void Cuisine_saveIfCuisinetheSame_true() {
  //   Cuisine myCuisine = new Cuisine ("Italian");
  //   myCuisine.save();
  //   assertTrue(Cuisine.all().get(0).equals(myCuisine));
  // }
  //
  // @Test
  // public void Cuisine_saveAssigneIdToCuisineObj_int() {
  //   Cuisine myCuisine = new Cuisine ("Italian");
  //   myCuisine.save();
  //   Cuisine savedCuisine = Cuisine.all().get(0);
  //   assertEquals(savedCuisine.getId(), myCuisine.getId());
  // }
  //
  //
  //
  // @Test
  // public void Cuisine_getAllReturnAll_true() {
  //   Cuisine myCuisine = new Cuisine ("Italian");
  //   myCuisine.save();
  //   assertTrue(Cuisine.all().contains(myCuisine));
  // }
  //
  //
  // @Test
  // public void Cuisine_findCuisineInDataBase_true() {
  //   Cuisine myCuisine = new Cuisine ("Italian");
  //   myCuisine.save();
  //   Cuisine savedCuisine =Cuisine.find(myCuisine.getId());
  //   assertTrue(myCuisine.equals(savedCuisine));
  // }
}
