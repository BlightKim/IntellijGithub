package menu;

import menu.register.Daoo;
import menu.register.DaooImpl;
import vo.User;

import java.util.Scanner;

public class OrderMenu implements Runnable {
  Scanner sc;
  Daoo daoo;
  Order order;


  public OrderMenu(Scanner sc) {
    this.sc = sc;
    this.daoo = new DaooImpl();
  }

  public void run() {
    String id = ""; // 아이디 변수
    String password = ""; // 비밀번호 변수
    int choice = 0; // 번호 선택
    int loginTry = 0;

    login:
    while (true) { //
      System.out.print("아이디를 입력하세요 >>");
      id = sc.next();

      System.out.print("비밀번호를 입력하세요 >>");
      password = sc.next();

      if (daoo.login(id, password)) { // id와 password가 일치
        if (loginTry > 5) {
          System.out.println("로그인 시도가 5회를 초과하여 프로그램을 종료합니다.");
          break login;
        }
        omenu:
        while (true) {
          System.out.println("원하시는 항목를 선택해주세요.");
          System.out.println("1.주문  2.주문내역 조회  3.주문 취소  4.뒤로가기");
          choice = sc.nextInt();

          switch (choice) {
            case 1: // 주문
              User user = daoo.selectOne(id);
              order = new Order(this.sc, user, this.daoo);
              order.run();
              continue omenu;

            case 2: // 주문내역 조회
              continue omenu;

            case 3: // 주문 취소
              continue omenu;

            case 4: // 뒤로가기
              break login;


          }
        }
      } else { // 아이디 비밀번호가 일치하지 않을 때
        System.out.println("입력하신 아이디와 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
        loginTry++;
        continue login;
      }
    }
  }
}
