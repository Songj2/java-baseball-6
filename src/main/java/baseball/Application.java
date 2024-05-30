package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userNumber;
        boolean numberMatched = false;

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer= randomNumber();

        inputUserNumber();
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
//    1. 숫자인가
//    2. 중복인가

//    숫자 비교하기

//    자리 비교하기

//    힌트/결과 출력하기

//    재시작 혹은 종료
}
