import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CubeVoid {
    CubePrint cubePrint = new CubePrint();

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
        List<String> arr = new ArrayList<String>();
        arr.addAll(Arrays.asList(split));

        for(int i = 0; i<arr.size(); i++){
            if(i+1< arr.size()){
                if(arr.get(i+1).equalsIgnoreCase("'")){
                    arr.set(i,arr.get(i)+"'");
                    arr.remove(i+1);
                }
            }
        }

        for(int i = 0; i<arr.size();i++){
            System.out.println(arr.get(i));
            inputCommand(arr.get(i));
            cubePrint.printCube();
        }
    }

    public void inputCommand(String s){

        moveUpL(s);
        moveUpR(s);

        moveLeftL(s);
        moveLeftR(s);

        moveFrontL(s);
        moveFrontR(s);

        moveRightL(s);
        moveRightR(s);

        moveBackL(s);
        moveBackR(s);

        moveDownL(s);
        moveDownR(s);

        exit(s);
    }

    public void moveFrontL(String s){
        if(s.equalsIgnoreCase("f")){
            String[] temp = {cubePrint.arr[0][2][0],cubePrint.arr[0][2][1],cubePrint.arr[0][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[0][2][i] = cubePrint.arr[1][2][i];
                cubePrint.arr[1][i][2] = cubePrint.arr[5][0][i];
                cubePrint.arr[5][0][i] = cubePrint.arr[3][i][0];
                cubePrint.arr[3][i][0] = temp[i];
            }
        }
    }
    public void moveFrontR(String s){
        if(s.equalsIgnoreCase("f'")){
            String[] temp = {cubePrint.arr[5][0][0],cubePrint.arr[5][0][1],cubePrint.arr[5][0][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[5][0][i] = cubePrint.arr[1][i][2];
                cubePrint.arr[1][i][2] = cubePrint.arr[0][2][i];
                cubePrint.arr[0][2][i] = cubePrint.arr[3][i][0];
                cubePrint.arr[3][i][0] = temp[i];
            }
        }
    }

    public void moveUpL(String s){
        if(s.equalsIgnoreCase("u")){
            String[] temp = {cubePrint.arr[2][0][0],cubePrint.arr[2][0][1],cubePrint.arr[2][0][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][0][i] = cubePrint.arr[3][0][i];
                cubePrint.arr[3][0][i] = cubePrint.arr[4][0][i];
                cubePrint.arr[4][0][i] = cubePrint.arr[1][0][i];
                cubePrint.arr[1][0][i] = temp[i];
            }
        }
    }
    public void moveUpR(String s){
        if(s.equalsIgnoreCase("u'")){
            String[] temp = {cubePrint.arr[2][0][0],cubePrint.arr[2][0][1],cubePrint.arr[2][0][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][0][i] = cubePrint.arr[1][0][i];
                cubePrint.arr[1][0][i] = cubePrint.arr[4][0][i];
                cubePrint.arr[4][0][i] = cubePrint.arr[3][0][i];
                cubePrint.arr[3][0][i] = temp[i];
            }
        }
    }

    public void moveLeftL(String s){
        if(s.equalsIgnoreCase("l")){
            String[] temp = {cubePrint.arr[2][0][0],cubePrint.arr[2][1][0],cubePrint.arr[2][2][0]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][i][0] = cubePrint.arr[0][i][0];
                cubePrint.arr[0][i][0] = cubePrint.arr[4][i][2];
                cubePrint.arr[4][i][2] = cubePrint.arr[5][i][0];
                cubePrint.arr[5][i][0] = temp[i];
            }
        }
    }
    public void moveLeftR(String s){
        if(s.equalsIgnoreCase("l'")){
            String[] temp = {cubePrint.arr[2][0][0],cubePrint.arr[2][1][0],cubePrint.arr[2][2][0]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][i][0] = cubePrint.arr[5][i][0];
                cubePrint.arr[5][i][0] = cubePrint.arr[4][i][2];
                cubePrint.arr[4][i][2] = cubePrint.arr[0][i][0];
                cubePrint.arr[0][i][0] = temp[i];
            }
        }
    }

    public void moveRightL(String s){
        if(s.equalsIgnoreCase("r")){
            String[] temp = {cubePrint.arr[2][0][2],cubePrint.arr[2][1][2],cubePrint.arr[2][2][2]};

            for(int i = 0; i< 3; i++) {
                cubePrint.arr[2][i][2] = cubePrint.arr[5][i][2];
                cubePrint.arr[5][i][2] = cubePrint.arr[4][i][0];
                cubePrint.arr[4][i][0] = cubePrint.arr[0][i][2];
                cubePrint.arr[0][i][2] = temp[i];
            }
        }
    }
    public void moveRightR(String s){
        if(s.equalsIgnoreCase("r'")){
            String[] temp = {cubePrint.arr[2][0][2],cubePrint.arr[2][1][2],cubePrint.arr[2][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][i][2] = cubePrint.arr[0][i][2];
                cubePrint.arr[0][i][2] = cubePrint.arr[4][i][0];
                cubePrint.arr[4][i][0] = cubePrint.arr[5][i][2];
                cubePrint.arr[5][i][2] = temp[i];
            }
        }
    }

    public void moveBackL(String s){
        if(s.equalsIgnoreCase("b")){
            String[] temp = {cubePrint.arr[3][0][2],cubePrint.arr[3][1][2],cubePrint.arr[3][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[3][i][2] = cubePrint.arr[5][2][i];
                cubePrint.arr[5][2][i] = cubePrint.arr[1][i][0];
                cubePrint.arr[1][i][0] = cubePrint.arr[0][0][i];
                cubePrint.arr[0][0][i] = temp[i];
            }
        }
    }
    public void moveBackR(String s){
        if(s.equalsIgnoreCase("b'")){
            String[] temp = {cubePrint.arr[3][0][2],cubePrint.arr[3][1][2],cubePrint.arr[3][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[3][i][2] = cubePrint.arr[0][0][i];
                cubePrint.arr[0][0][i] = cubePrint.arr[1][i][0];
                cubePrint.arr[1][i][0] = cubePrint.arr[5][2][i];
                cubePrint.arr[5][2][i] = temp[i];
            }
        }
    }

    public void moveDownL(String s){
        if(s.equalsIgnoreCase("d")){
            String[] temp = {cubePrint.arr[2][2][0],cubePrint.arr[2][2][1],cubePrint.arr[2][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][2][i] = cubePrint.arr[1][2][i];
                cubePrint.arr[1][2][i] = cubePrint.arr[4][2][i];
                cubePrint.arr[4][2][i] = cubePrint.arr[3][2][i];
                cubePrint.arr[3][2][i] = temp[i];
            }
        }
    }
    public void moveDownR(String s){
        if(s.equalsIgnoreCase("d'")){
            String[] temp = {cubePrint.arr[2][2][0],cubePrint.arr[2][2][1],cubePrint.arr[2][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][2][i] = cubePrint.arr[3][2][i];
                cubePrint.arr[3][2][i] = cubePrint.arr[4][2][i];
                cubePrint.arr[4][2][i] = cubePrint.arr[1][2][i];
                cubePrint.arr[1][2][i] = temp[i];
            }
        }
    }

    public void exit(String s){
        if(s.equalsIgnoreCase("q")){
            System.out.println("Bye~");
            System.exit(0);
            return;
        }
    }

}
