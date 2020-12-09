import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CubeVoid {
    String[] cube = {"R","R","W","G","C","W","G","B","B"};

    public void printMain(){
        Scanner scanner = new Scanner(System.in);

        printCube();
        while (true) {
            info();
            String command = scanner.next();
            cmd(command);
        }
    }

    public void info(){
        System.out.println("=========================================");
        System.out.println("> U  가장 윗줄을 왼쪽으로 한 칸 밀기 RRW -> RWR");
        System.out.println("> U' 가장 윗줄을 오른쪽으로 한 칸 밀기 RRW -> WRR");
        System.out.println("> R  가장 오른쪽 줄을 위로 한 칸 밀기 WWB -> WBW");
        System.out.println("> R' 가장 오른쪽 줄을 아래로 한 칸 밀기 WWB -> BWW");
        System.out.println("> L  가장 왼쪽 줄을 아래로 한 칸 밀기 RGG -> GRG");
        System.out.println("> L' 가장 왼쪽 줄을 위로 한 칸 밀기 RGG -> GGR");
        System.out.println("> B  가장 아랫줄을 오른쪽으로 한 칸 밀기 GBB -> BGB");
        System.out.println("> B' 가장 아랫줄을 왼쪽으로 한 칸 밀기 GBB -> BBG");
        System.out.println("> Q  프로그램을 종료한다.");
        System.out.println("=========================================");

        System.out.println("명령어를 입력하여주세요.");
        System.out.print("CUBE >");
    }

    public void cmd(String command){
        String[] split = command.split("");
        List<String> cmdArr = new ArrayList<String>();
        cmdArr.addAll(Arrays.asList(split));

        for(int i =0; i< cmdArr.size(); i++) {
            if (i + 1 < cmdArr.size()) {
                if (cmdArr.get(i + 1).equalsIgnoreCase("'")) {
                    cmdArr.set(i, cmdArr.get(i) + "'");
                    cmdArr.remove(i+1);
                }
            }
        }

        for(int i= 0; i<cmdArr.size(); i++){
            System.out.println(cmdArr.get(i));
            inputCommand(cmdArr.get(i));
        }
    }

    public void printCube() {
        for(int i = 1; i <= cube.length; i++){
            System.out.printf("%2s",cube[i-1]);
            if(i%3 == 0) {
                System.out.println();
            }
        }
    }

    public void inputCommand(String s) {
        if(s.equalsIgnoreCase("u")){
            cubeMoveLeft(0);
            printCube();
            return;
        }
        if(s.equalsIgnoreCase("u'")){
            cubeMoveRight(0);
            printCube();
            return;
        }
        if(s.equalsIgnoreCase("r")){ // 가장 오른쪽 줄을 위로 한 칸
            cubeMoveUp(2);
            printCube();
            return;
        }
        if(s.equalsIgnoreCase("r'")){
            cubeMoveDown(2);
            printCube();
            return;
        }
        if(s.equalsIgnoreCase("l")){
            cubeMoveDown(0);
            printCube();
            return;
        }
        if(s.equalsIgnoreCase("l'")){ // 가장 왼쪽 줄을 위로 한 칸
            cubeMoveUp(0);
            printCube();
            return;
        }
        if(s.equalsIgnoreCase("b")){
            cubeMoveRight(6);
            printCube();
            return;
        }
        if(s.equalsIgnoreCase("b'")){
            cubeMoveLeft(6);
            printCube();
            return;
        }
        if(s.equalsIgnoreCase("q")){
            System.out.println("Bye~");
            System.exit(0);
        }
        else {
            System.out.println("잘못 입력하셨습니다.");
            return;
        }
    }

    public void cubeMoveUp(int n){

        String temp = cube[n];
        cube[n] = cube[n+3];
        cube[n+3] = cube[n+6];
        cube[n+6] = temp;

    }

    public void cubeMoveDown(int n){
        String temp = cube[n+6];
        cube[n+6] = cube[n+3];
        cube[n+3] = cube[n];
        cube[n] = temp;

    }
    public void cubeMoveLeft(int n){

        String temp = cube[n];
        cube[n] = cube[n+1];
        cube[n+1]= cube[n+2];
        cube[n+2]=temp;

    }
    public void cubeMoveRight(int n){
        String temp = cube[n+2];
        cube[n+2] = cube[n+1];
        cube[n+1]= cube[n];
        cube[n]=temp;
    }
}
