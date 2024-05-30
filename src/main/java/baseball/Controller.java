package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    //    숫자 3개 뽑기
    public List<Integer> randomNumber() {
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
    public String inputUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    //    유효성 검사
    public boolean validate(String number){
        if (number.length()!=3){
            return false;
        }
        if (!number.matches("^[1-9]+$")){
            return false;
        }
        return checkDuplication(separate(number));
    }
    public List<Integer> separate(String number){
        List<Integer> list= new ArrayList<>();
        String[] temp=number.split("");
        for(String s: temp){
            list.add(Integer.parseInt(s));
        }
        return list;
    }
//    중복 확인
    public boolean checkDuplication(List<Integer> list){
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
    public int compareToNumber(List<Integer> com, List<Integer> user){
        int count=0;
        for (int i: user){
            if(com.contains(i)){
                count++;
            }
        }
        return count;
    }

    //    자리 비교하기
    public int compareToSpot(List<Integer> com, List<Integer> user){
        int count= 0;
        for (int i= 0; i< com.size(); i++){
            if(com.get(i).equals(user.get(i))){
                count++;
            }
        }
        return count;
    }

    //    힌트/결과 출력하기
    public void printHint(int ball, int strike){
        if (ball==0){
            System.out.println("낫싱");
        }else if (strike!=3){
            System.out.printf("%d볼 %d스트라이크\n", ball-strike, strike);
        }else {
            System.out.println(strike+"스트라이크");
        }
    }
}
