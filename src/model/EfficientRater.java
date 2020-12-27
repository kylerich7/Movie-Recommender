package src.model;

import java.util.ArrayList;
import java.util.HashMap;

public class EfficientRater implements Rater {

  private final String myID;
  private final HashMap<String, Rating> myRatings;

  public EfficientRater(String id) {
    myID = id;
    myRatings = new HashMap<String, Rating>();
  }

  public void addRating(String item, double rating) {
    myRatings.put(item, new Rating(item, rating));
  }

  public boolean hasRating(String item) {
    return myRatings.containsKey(item);
  }

  public String getID() {
    return myID;
  }

  public double getRating(String item) {
    if (myRatings.containsKey(item)) {
      return myRatings.get(item).getValue();
    }

    return -1;
  }

  public int numRatings() {
    return myRatings.size();
  }

  public ArrayList<String> getItemsRated() {

    return new ArrayList<String>(myRatings.keySet());
  }
}
