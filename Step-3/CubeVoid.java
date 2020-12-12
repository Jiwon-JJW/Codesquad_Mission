import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CubeVoid {

    CubeShuffle cubeShuffle = new CubeShuffle();

    static int score = 0;

    public void main(){
        Scanner scanner = new Scanner(System.in);
        CubePrint cubePrint = new CubePrint();

        cubePrint.printCube();
        while(true){
            info();
            String command = scanner.next();
            cmd(command);
        }

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
        List<String> arr = new ArrayList<String>();
        arr.addAll(Arrays.asList(split));

        for(int i = 0; i<arr.size(); i++){
            cmdNumber((ArrayList<String>) arr, i);
            if(i+1< arr.size()){
                if(arr.get(i+1).equalsIgnoreCase("'")){
                    arr.set(i,arr.get(i)+"'");
                    arr.remove(i+1);
                }
            }
        }
        score += arr.size();

        System.out.println(arr);

        printCMD((ArrayList<String>) arr);
    }
    public void printCMD(ArrayList<String> arr){
        for(int i = 0; i<arr.size();i++){
            System.out.println(arr.get(i));
            loopNum(arr, i);
            }
        }

    public void cmdNumber(ArrayList<String> arr,int i){
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


}
