import menu.Menu;
import menu.register.Daoo;
import menu.register.DaooImpl;
import vo.User;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Menu menu = new Menu(sc);

      menu.run(); //note 메뉴 실행
  }
}
