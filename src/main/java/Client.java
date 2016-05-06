
import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String client_name;
  private int stylist_id;

  public Client(String client_name, int stylist_id) {
    this.client_name = client_name;
    this.stylist_id = stylist_id;
  }

  public String getName(){
    return client_name;
  }

  public int getId() {
    return id;
  }

  public int getStylistId() {
    return stylist_id;
  }
  @Override
  public boolean equals(Object anotherClient) {
    if(!(anotherClient instanceof Client)){
      return false;
    }else {
      Client newClient = (Client) anotherClient;
      return this.getName().equals(newClient.getName()) &&
        this.getId() == newClient.getId() &&
        this.getStylistId() == newClient.getStylistId();
    }
  }
  public static List <Client> all(){
    String sql = "SELECT id, client_name, stylist_id FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (client_name, stylist_id) VALUES (:client_name, :stylist_id)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("client_name", this.client_name)
      .addParameter("stylist_id", this.stylist_id)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client find (int id){
    try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM clients WHERE id=:id";
    Client client = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
       return client;
    }
  }

}
