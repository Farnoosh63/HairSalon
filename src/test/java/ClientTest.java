import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_OwnerAddClient_true() {
    Client myClient = new Client("Client Name 1", 1);
    assertTrue(myClient instanceof Client);
  }
  @Test
  public void client_getClientName_String() {
    Client myClient = new Client("Client Name 1", 1);
    assertEquals("Client Name 1", myClient.getName());
  }
  @Test
  public void client_getTwoSameName_true(){
    Client firstClient = new Client("Client Name 1", 1);
    Client secondClient = new Client("Client Name 1", 1);
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void client_saveClientNametoList_true() {
    Client myClient = new Client("Client Name 1", 1);
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }
  @Test
  public void client_getClientId_int() {
    Client myClient = new Client("Client Name 1", 1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }

  @Test
  public void find_findClientInDatabase_true() {
    Client myClient = new Client("Client Name 1", 1);
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertTrue(myClient.equals(savedClient));
  }

  @Test
  public void save_saveStylistIdIntoDB_true() {
    Stylist myStylist = new Stylist ("Stylist Name 1");
    myStylist.save();
    Client myClient = new Client ("Client Name 1", myStylist.getId());
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertEquals(savedClient.getStylistId(), myStylist.getId());
  }
}
