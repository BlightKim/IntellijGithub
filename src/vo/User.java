package vo;

import menu.Menu;

import java.util.Objects;

public class User {
  private String id;
  private String password;
  private String name;
  private String phone;
  private String address;
  private BasketVO basketVO;
  public User() {
  }

  public User(String id, String password, String name, String phone, String address) {
    this.id = id;
    this.password = password;
    this.name = name;
    this.phone = phone;
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public BasketVO getBasketVO() {
    return basketVO;
  }

  public void setBasketVO(BasketVO basketVO) {
    this.basketVO = basketVO;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(phone, user.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, phone);
  }

  @Override
  public String toString() {
    return "User{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

  public void add(MenuVO selectMenu) {
    getBasketVO().menuList.add(selectMenu);
    getBasketVO().totalPrice += selectMenu.getMenuPrice();
  }
}
