package menu.showinfor;

import menu.Menu;
import menu.register.Daoo;
import menu.register.DaooImpl;
import vo.User;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowInfor implements Runnable { // 회원정보 확인 클래스
  Scanner sc;
  private Daoo daoo = new DaooImpl();

  public ShowInfor(Scanner sc) {
    this.sc = sc;
  }

  public void run() {
    String id = ""; // 아이디 변수
    String password = ""; // 비밀번호 변수
    String choice = "";

    outer :
    while (true) { // 틀리면 반복
      System.out.print("아이디를 입력하세요 >>");
      id = sc.next().trim();

      System.out.print("비밀번호를 입력하세요 >>");
      password = sc.next().trim();

      if (daoo.login(id, password)) {
        User user = daoo.selectOne(id);

        System.out.println("아이디 : " + idMasking(user.getId()));
        System.out.println("이름 : " + idMasking(user.getName()));
        System.out.println("전화번호 : " + phoneMasking(user.getPhone()));
        System.out.println("주소 : " + user.getAddress());
      } else { // 아이디 패스워드 일치하지 않으면 다시 입력 or 프로그램 종료
        choice :
        while(true) {
          System.out.print("다시 입력하시겠습니까 ? (Y/N) >>");
          choice = sc.next().trim();

          if ("y".equalsIgnoreCase(choice)) { // y면 다시 반복
            continue;
          } else if ("n".equalsIgnoreCase(choice)) { // n이면 메뉴선택
            break outer;
          } else { // y,n 둘 다 아니면 다시 입력하기
            System.out.println("입력이 정확하지 않습니다. 다시 입력해주세요.");
          }
        } // while : choice
      }
    } // while문
  }

  private String idMasking(String id) {
    String maskingId = id.replaceAll("(?<=.{2}).", "*");

    return maskingId;
  }

  private String phoneMasking(String phone) {
    String regex = "(\\d{2,3})-?(\\d{3,4})-?(\\d{4})$";

    Matcher matcher = Pattern.compile(regex).matcher(phone);

    if (matcher.find()) {
      String target = matcher.group(2);
      int length = target.length();
      char[] c = new char[length];
      Arrays.fill(c, '*');

      return phone.replace(target, String.valueOf(c));
    }
    return phone;
  }
}
