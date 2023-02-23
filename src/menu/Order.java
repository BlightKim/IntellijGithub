package menu;

import menu.register.Daoo;
import menu.register.DaooImpl;
import menu.register.Store;
import vo.BasketVO;
import vo.MenuVO;
import vo.OrdersVO;
import vo.User;

import java.util.List;
import java.util.Scanner;

public class Order implements Runnable {
  Scanner sc;
  User user;
  private Daoo daoo;

  public Order(Scanner sc, User user, Daoo daoo) {
    this.sc = sc;
    this.user = user;
    this.daoo = daoo;
    user.setBasketVO(new BasketVO());
  }

  public void run() {
    String choice = "";
    int categoryNum = 0; // 카테고리 번호
    int storeNum = 0; // 가계 번호 (콘솔 창)
    int realStoreNum = 0; // 데이터베이스의 가계번호
    int menuNum = 0;
    int realMenuNum = 0;

    System.out.println("카테고리를 선택해주세요.");
    System.out.println("=============================================");
    System.out.println("1.양식  2.한식  3.일식  4.중식  5.치킨  6.분식");

    categoryNum = sc.nextInt();

    System.out.println("식당을 선택해주세요.");
    System.out.println("=============================================");
    List<Store> storeList = daoo.StoreList(categoryNum);
    showStoreList(storeList); // 식당리스트 보여주기

    storeNum = sc.nextInt();
    realStoreNum = storeList.get(storeNum-1).getStoreNum();

    System.out.println("메뉴를 선택해주세요.");
    System.out.println("=============================================");
    List<MenuVO> menuList = daoo.menuList(realStoreNum);
    showMenuList(menuList); //메뉴리스트 보여주기

    menuNum = sc.nextInt();

    MenuVO selectMenu = menuList.get(menuNum-1);

    user.add(selectMenu);

    System.out.print("주문하시겠습니까 ?(Y/N) >>");
    choice = sc.next();

//    if("y".equalsIgnoreCase(choice)) {
//      OrdersVO ordersVO = new OrdersVO(user.getId(),
//              selectMenu.getMenuNum(),
//              cnt,
//              starPoint,
//              selectMenu.getStoreNum()
//              );
//    }


  }

  private void showMenuList(List<MenuVO> menuList) {
    for(int i = 0; i < menuList.size(); i++) {
      System.out.print((i+1) + "." + menuList.get(i).getMenuName() + " " + menuList.get(i).getMenuPrice() + "  ");
    }
    System.out.println();
  }

  private static void showStoreList(List<Store> storeList) {
    for(int i = 0; i < storeList.size(); i++) {
      System.out.print((i+1) + "." + storeList.get(i).getStoreName() + "  ");
    }
    System.out.println();
  }
}
