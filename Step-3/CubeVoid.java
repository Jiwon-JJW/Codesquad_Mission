import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CubeVoid {
    char[][][] answerCube = {
            {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}},
            {{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}},
            {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
            {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}},
            {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}},
            {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}},
    };

    CubeShuffle cubeShuffle = new CubeShuffle();
    CubePrint cubePrint = new CubePrint();

    static int score = 0;

    public void main(){
        cubeShuffle.start = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("원본");
        cubePrint.printCube();
        System.out.println("=========================================");
        cubeShuffle.shuffle();
        cubePrint.printCube();

        while(answer()){
            answer();
            info();
            String command = scanner.next();
            try {
                cmd(command);
            }catch (Exception e){
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
        System.out.println("큐브를 풀었습니다 ! 축하합니다!");
        scanner.close();
        cubeShuffle.exit("q");

    }

    public void info(){
        System.out.println("=========================================");
        System.out.println("> U  윗줄을 시계방향으로 돌린다");
        System.out.println("> U' 윗줄을 반시계방향으로 돌린다");
        System.out.println("> R  오른쪽줄을 시계방향으로 돌린다");
        System.out.println("> R' 오른쪽줄을 반시계방향으로 돌린다");
        System.out.println("> L  왼쪽줄을 시계방향으로 돌린다");
        System.out.println("> L' 왼쪽줄을 반시계방향으로 돌린다");
        System.out.println("> B  아랫줄을 시계방향으로 돌린다");
        System.out.println("> B' 아랫줄을 반시계방향으로 돌린다");
        System.out.println("> F  전면을 시계방향으로 돌린다");
        System.out.println("> F' 전면을 반시계방향으로 돌린다");
        System.out.println("> Q  프로그램을 종료한다.");
        System.out.println("=========================================");

        System.out.println("명령어를 입력하여주세요.");
        System.out.print("CUBE >");
    }

    public void cmd(String command){
        String[] split = command.split("");
        List<String> keyword = new ArrayList<String>();
        keyword.addAll(Arrays.asList(split));

        for(int i = 0; i<keyword.size(); i++){
            saveLoopNumber((ArrayList<String>) keyword, i);
            if(i+1< keyword.size()){
                if(keyword.get(i+1).equalsIgnoreCase("'")){
                    keyword.set(i,keyword.get(i)+"'");
                    keyword.remove(i+1);
                }
            }
        }
        score += keyword.size();
        printCMD((ArrayList<String>) keyword);
    }

    public void printCMD(ArrayList<String> arr){
        for(int i = 0; i<arr.size();i++){
            System.out.println(arr.get(i));
            loopNum(arr, i);
            cubePrint.printCube();
            }
        }

    public void saveLoopNumber(ArrayList<String> arr,int i){
        try {
            if(0 < Integer.parseInt(arr.get(i)) && 9 > Integer.parseInt(arr.get(i))){
                arr.set(i+1,arr.get(i)+arr.get(i+1));
                arr.remove(i);
            }
        }catch (NumberFormatException e){
            return;
        }

    }
    public void loopNum(ArrayList<String> arr,int i) {
        try {
            if (0 < arr.get(i).charAt(0) || 9 > arr.get(i).charAt(0)) {
                int n = Integer.parseInt(String.valueOf(arr.get(i).charAt(0)));

                if (arr.get(i).length() == 2) {
                    String answer = String.valueOf(arr.get(i).charAt(1));
                    cubeShuffle.inputCommand(answer,n);
                }
                if (arr.get(i).length() == 3) {
                    String answer = arr.get(i).charAt(1) + String.valueOf(arr.get(i).charAt(2));
                    cubeShuffle.inputCommand(answer,n);
                }
            }
        }catch (NumberFormatException e){
            cubeShuffle.inputCommand(arr.get(i),1);
            return;
        }
    }

    public boolean answer(){
        boolean b = false;
        for(int k = 0; k < answerCube.length; k++) {
            for (int i = 0; i < answerCube[0].length; i++) {
                for (int j = 0; j < answerCube[0][0].length; j++) {
                    String a = String.valueOf(answerCube[k][i][j]);
                    String c = String.valueOf(CubeShuffle.cube[k][i][j]);
                    b = a.equalsIgnoreCase(c);
                    if(b == false){
                        return true;
                    }
                }
            }
        }
        if (b == true){
            return false;
        }
        return true;
    }
}
