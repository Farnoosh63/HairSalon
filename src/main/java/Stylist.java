import java.util.List;
import org.sql2o.*;

public class Stylist {
  private String stylist_name;
//   private int id;
//
//
  public Stylist(String name) {
    this.stylist_name = stylist_name;
  }

  public String getName() {
    return stylist_name;
  }
//
//   public int getId() {
//     return id;
//   }
//
//   public static List<Cuisine> all(){
//     String sql = "SELECT id, name FROM cuisines";
//     try(Connection con = DB.sql2o.open()) {
//       return con.createQuery(sql).executeAndFetch(Cuisine.class);
//     }
//   }
//
// @Override
//   public boolean equals(Object otherCuisine) {
//     if(!(otherCuisine instanceof Cuisine)) {
//       return false;
//     }else {
//       Cuisine newCuisine = (Cuisine) otherCuisine;
//       return this.getName().equals(newCuisine.getName());
//     }
//   }
//
//   public void save() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "INSERT INTO cuisines (name) VALUES (:name)";
//       this.id = (int) con.createQuery(sql, true)
//         .addParameter("name", this.name)
//         .executeUpdate()
//         .getKey();
//     }
//   }
//
//   public static Cuisine find(int id) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "SELECT * FROM cuisines WHERE id=:id";
//       Cuisine cuisine = con.createQuery(sql)
//         .addParameter("id", id)
//         .executeAndFetchFirst(Cuisine.class);
//       return cuisine;
//     }
//   }
//
//   public List<Restaurant> getRestaurants() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "SELECT * FROM restaurants where cuisine_id=:id";
//       return con.createQuery(sql)
//         .addParameter("id", this.id)
//         .executeAndFetch(Restaurant.class);
//     }
//   }



}
