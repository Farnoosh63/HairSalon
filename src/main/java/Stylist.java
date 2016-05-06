import java.util.List;
import org.sql2o.*;

public class Stylist {
  private String stylist_name;
  private int id;


  public Stylist(String stylist_name) {
    this.stylist_name = stylist_name;
  }

  public String getName() {
    return stylist_name;
  }

  public int getId() {
    return id;
  }

@Override
  public boolean equals(Object otherStylist) {
    if(!(otherStylist instanceof Stylist)) {
      return false;
    }else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(stylist_name) VALUES (:stylist_name)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("stylist_name", this.stylist_name)
      .executeUpdate()
      .getKey();
    }
  }

  public static List<Stylist> all() {
    String sql = "SELECT * FROM stylists";
    try (Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public static Stylist find (int id) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id=:id";
      Stylist stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public List<Client> getClientss() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where stylist_id=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Client.class);
    }
  }



}
