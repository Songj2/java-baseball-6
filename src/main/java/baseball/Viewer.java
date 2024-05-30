package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Viewer {

    public void startGame(){
        String userInputData;
        int game= 1;
        Controller controller = new Controller();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(game==1) {

            List<Integer> computer = controller.randomNumber();

            while (true) {
                userInputData = controller.inputUserNumber();

                if (!controller.validate(userInputData)) {
                    System.out.println("잘못된 값을 입력하셨습니다.");
                    throw new IllegalArgumentException();
                } else {
                    List<Integer> user = controller.separate(userInputData);
                    int ball = controller.compareToNumber(computer, user);
                    int strike = controller.compareToSpot(computer, user);

                    controller.printHint(ball, strike);
                    if (strike == computer.size()) {
                        System.out.print(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            game= Integer.parseInt(Console.readLine());
        }
    }
}
