package menu;

import menu.deleteUser.DeleteUser;
import menu.register.Register;
import menu.showinfor.ShowInfor;

import java.util.Scanner;

public class Menu implements Runnable {
  Scanner sc;
  Register register;
  ShowInfor showInfor;
  DeleteUser deleteUser;
  UpdateInfor updateInfor;
  OrderMenu orderMenu;


  public Menu(Scanner sc) {
    this.sc = sc;
  }

  @Override
  public void run() {
    outer :
    while (true) {
      System.out.println("1.주문  2.회원가입  3.회원정보확인  4.회원정보수정  5.회원탈퇴  0.프로그램 종료");

      System.out.print("번호를 선택해주세요. >>");

      String choice = sc.next();

      switch (choice) {
        case "1" :
          orderMenu = new OrderMenu(this.sc);
          orderMenu.run();
          continue outer;

        case "2" :
          register = new Register(this.sc);
          register.run();
          continue outer;

        case "3" : // 회원정보 확인
          showInfor = new ShowInfor(this.sc);
          showInfor.run();
          continue outer;

        case "4" : // 회원정보 수정
          updateInfor = new UpdateInfor(this.sc);
          updateInfor.run();
          continue outer;

        case "5" : // 회원탈퇴
          deleteUser = new DeleteUser(this.sc);
          deleteUser.run();
          continue outer;

        case "0": // 프로그램 종료
          break outer;
      }
    }
  }
}
