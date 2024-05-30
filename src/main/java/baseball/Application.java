package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userNumber;
        int start= 1;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(start==1) {

            List<Integer> computer = randomNumber();

            while (true) {
                userNumber = inputUserNumber();

                if (!validate(userNumber)) {
                    System.out.println("잘못된 값을 입력하셨습니다.");
                    throw new IllegalArgumentException();
                } else {
                    List<Integer> user = separate(userNumber);
                    int ball = compareToNumber(computer, user);
                    int strike = compareToSpot(computer, user);

                    printHint(ball, strike);
                    if (strike == computer.size()) {
                        System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임종료");
                        break;
                    }
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            start= Integer.parseInt(Console.readLine());
        }
    }

    //    숫자 3개 뽑기
    public static List<Integer> randomNumber() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNum)) {
                list.add(randomNum);
            }
        }
        return list;
    }
//    숫자 3개 입력 받기
    public static String inputUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber= Console.readLine();
        return userNumber;
    }

    //    유효성 검사
    public static boolean validate(String number){
        if (number.length()!=3){
            return false;
        }
        if (!number.matches("^[1-9]+$")){
            return false;
        }
        return checkDuplication(separate(number));
    }
    public static List<Integer> separate(String number){
        List<Integer> list= new ArrayList<>();
        String[] temp=number.split("");
        for(String s: temp){
            list.add(Integer.parseInt(s));
        }
        return list;
    }
    public static boolean checkDuplication(List<Integer> list){
        for (int i=0; i<list.size()-1; i++){
            int target=list.get(i);
            for (int j=i+1; j<list.size();j++) {
                if (target == list.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

//    숫자 비교하기
    public static int compareToNumber(List<Integer> com, List<Integer> user){
        int count=0;
        for (int i: user){
            if(com.contains(i)){
                count++;
            }
        }
        return count;
    }

//    자리 비교하기
    public static int compareToSpot(List<Integer> com, List<Integer> user){
        int count= 0;
        for (int i= 0; i< com.size(); i++){
            if(com.get(i)==user.get(i)){
                count++;
            }
        }
        return count;
    }

//    힌트/결과 출력하기
    public static void printHint(int ball, int strike){
        if (ball==0){
            System.out.println("낫싱");
        }else if (strike!=3){
            System.out.printf("%d볼 %d스트라이크\n", ball-strike, strike);
        }else {
            System.out.println(strike+"스트라이크");
        }
    }
}
