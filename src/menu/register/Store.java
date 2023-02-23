package menu.register;

public class Store {
  private int storeNum;
  private String storeName;
  private int starPoint;
  private int category;

  public Store() {
  }

  public Store(int storeNum, String storeName, int starPoint, int category) {
    this.storeNum = storeNum;
    this.storeName = storeName;
    this.starPoint = starPoint;
    this.category = category;
  }

  public int getStoreNum() {
    return storeNum;
  }

  public void setStoreNum(int storeNum) {
    this.storeNum = storeNum;
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public int getStarPoint() {
    return starPoint;
  }

  public void setStarPoint(int starPoint) {
    this.starPoint = starPoint;
  }

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "Store{" +
            "storeNum=" + storeNum +
            ", storeName='" + storeName + '\'' +
            ", starPoint=" + starPoint +
            ", category=" + category +
            '}';
  }
}
