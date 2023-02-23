package vo;

public class OrdersVO {
  private String id;
  private String menuNum;
  private int cnt;
  private int starPoint;
  private int storeNum;

  public OrdersVO() {
  }

  public OrdersVO(String id, String menuNum, int cnt, int starPoint, int storeNum) {
    this.id = id;
    this.menuNum = menuNum;
    this.cnt = cnt;
    this.starPoint = starPoint;
    this.storeNum = storeNum;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMenuNum() {
    return menuNum;
  }

  public void setMenuNum(String menuNum) {
    this.menuNum = menuNum;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public int getStarPoint() {
    return starPoint;
  }

  public void setStarPoint(int starPoint) {
    this.starPoint = starPoint;
  }

  public int getStoreNum() {
    return storeNum;
  }

  public void setStoreNum(int storeNum) {
    this.storeNum = storeNum;
  }

  @Override
  public String toString() {
    return "OrdersVO{" +
            "id='" + id + '\'' +
            ", menuNum='" + menuNum + '\'' +
            ", cnt=" + cnt +
            ", starPoint=" + starPoint +
            ", storeNum=" + storeNum +
            '}';
  }
}
