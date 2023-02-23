package vo;

import java.util.Objects;

public class MenuVO {
  private int menuNum;
  private String menuName;
  private int menuPrice;
  private int storeNum;

  public MenuVO() {
  }

  public MenuVO(int menuNum, String menuName, int menuPrice, int storeNum) {
    this.menuNum = menuNum;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.storeNum = storeNum;
  }

  public int getMenuNum() {
    return menuNum;
  }

  public void setMenuNum(int menuNum) {
    this.menuNum = menuNum;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public int getMenuPrice() {
    return menuPrice;
  }

  public void setMenuPrice(int menuPrice) {
    this.menuPrice = menuPrice;
  }

  public int getStoreNum() {
    return storeNum;
  }

  public void setStoreNum(int storeNum) {
    this.storeNum = storeNum;
  }

  @Override
  public String toString() {
    return "MenuVO{" +
            "menuNum='" + menuNum + '\'' +
            ", menuName='" + menuName + '\'' +
            ", menuPrice=" + menuPrice +
            ", storeNum=" + storeNum +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MenuVO menuVO = (MenuVO) o;
    return Objects.equals(menuNum, menuVO.menuNum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(menuNum);
  }
}
