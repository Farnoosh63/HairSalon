import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_OwnerAddStylist_true() {
    Stylist newStylist = new Stylist ("Stylist_name1");
    assertEquals(true, newStylist instanceof Stylist);
  }

  @Test
  public void Stylist_getStylistName_String() {
    Stylist myStylist = new Stylist ("Stylist_name1");
    assertEquals("Stylist_name1", myStylist.getName());
  }

  @Test
  public void Stylist_getTwoSameName_true() {
    Stylist firstStylist = new Stylist ("Stylist_name1");
    Stylist secondStylist = new Stylist ("Stylist_name1");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void Stylist_saveStylistNametoList_true() {
    Stylist myStylist = new Stylist ("Stylist_name1");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void Stylist_saveOneIdToEachStylist_int() {
    Stylist myStylist = new Stylist ("Stylist_name1");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(savedStylist.getId(), myStylist.getId());
  }

  @Test
  public void Stylist_getAllReturnAll_true() {
    Stylist firstStylist = new Stylist ("Stylist_name1");
    firstStylist.save();
    Stylist secondStylist = new Stylist ("Stylist_name2");
    secondStylist.save();
    assertTrue(Stylist.all().contains(secondStylist));
  }

  @Test
  public void Stylist_findStylistInDataBase_true() {
    Stylist myStylist = new Stylist ("Stylist_name1");
    myStylist.save();
    Stylist savedStylist =Stylist.find(myStylist.getId());
    assertTrue(myStylist.equals(savedStylist));
  }
}
