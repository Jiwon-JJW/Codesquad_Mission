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

    public char[][] setFaceL(char face[][]){
        char[][] newFace = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newFace[j][2-i] = face[i][j];
            }
        }

        return newFace;

    }
    public char[][] setFaceR(char face[][]){
        char[][] newFace = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newFace[2-j][i] = face[i][j];
            }
        }

        return newFace;
    }

    public void moveFrontL(String s){
        if(s.equalsIgnoreCase("f")){
            char[] temp = {cubePrint.arr[0][2][0],cubePrint.arr[0][2][1],cubePrint.arr[0][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[0][2][i] = cubePrint.arr[1][2][i];
                cubePrint.arr[1][i][2] = cubePrint.arr[5][0][i];
                cubePrint.arr[5][0][i] = cubePrint.arr[3][i][0];
                cubePrint.arr[3][i][0] = temp[i];
            }
            cubePrint.arr[2] = setFaceL(cubePrint.arr[2]);
        }
    }
    public void moveFrontR(String s){
        if(s.equalsIgnoreCase("f'")){
            char[] temp = {cubePrint.arr[5][0][0],cubePrint.arr[5][0][1],cubePrint.arr[5][0][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[5][0][i] = cubePrint.arr[1][i][2];
                cubePrint.arr[1][i][2] = cubePrint.arr[0][2][i];
                cubePrint.arr[0][2][i] = cubePrint.arr[3][i][0];
                cubePrint.arr[3][i][0] = temp[i];
            }
            cubePrint.arr[2] = setFaceR(cubePrint.arr[2]);
        }
    }

    public void moveUpL(String s){
        if(s.equalsIgnoreCase("u")){
            char[] temp = {cubePrint.arr[2][0][0],cubePrint.arr[2][0][1],cubePrint.arr[2][0][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][0][i] = cubePrint.arr[3][0][i];
                cubePrint.arr[3][0][i] = cubePrint.arr[4][0][i];
                cubePrint.arr[4][0][i] = cubePrint.arr[1][0][i];
                cubePrint.arr[1][0][i] = temp[i];
            }
            cubePrint.arr[0] = setFaceL(cubePrint.arr[0]);
        }
    }
    public void moveUpR(String s){
        if(s.equalsIgnoreCase("u'")){
            char[] temp = {cubePrint.arr[2][0][0],cubePrint.arr[2][0][1],cubePrint.arr[2][0][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][0][i] = cubePrint.arr[1][0][i];
                cubePrint.arr[1][0][i] = cubePrint.arr[4][0][i];
                cubePrint.arr[4][0][i] = cubePrint.arr[3][0][i];
                cubePrint.arr[3][0][i] = temp[i];
            }
            cubePrint.arr[0] = setFaceR(cubePrint.arr[0]);
        }
    }

    public void moveLeftL(String s){
        if(s.equalsIgnoreCase("l")){
            char[] temp = {cubePrint.arr[2][0][0],cubePrint.arr[2][1][0],cubePrint.arr[2][2][0]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][i][0] = cubePrint.arr[0][i][0];
                cubePrint.arr[0][i][0] = cubePrint.arr[4][i][2];
                cubePrint.arr[4][i][2] = cubePrint.arr[5][i][0];
                cubePrint.arr[5][i][0] = temp[i];
            }
            cubePrint.arr[1] = setFaceL(cubePrint.arr[1]);
        }
    }
    public void moveLeftR(String s){
        if(s.equalsIgnoreCase("l'")){
            char[] temp = {cubePrint.arr[2][0][0],cubePrint.arr[2][1][0],cubePrint.arr[2][2][0]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][i][0] = cubePrint.arr[5][i][0];
                cubePrint.arr[5][i][0] = cubePrint.arr[4][i][2];
                cubePrint.arr[4][i][2] = cubePrint.arr[0][i][0];
                cubePrint.arr[0][i][0] = temp[i];
            }
            cubePrint.arr[1] = setFaceR(cubePrint.arr[1]);
        }
    }

    public void moveRightL(String s){
        if(s.equalsIgnoreCase("r")){
            char[] temp = {cubePrint.arr[2][0][2],cubePrint.arr[2][1][2],cubePrint.arr[2][2][2]};

            for(int i = 0; i< 3; i++) {
                cubePrint.arr[2][i][2] = cubePrint.arr[5][i][2];
                cubePrint.arr[5][i][2] = cubePrint.arr[4][i][0];
                cubePrint.arr[4][i][0] = cubePrint.arr[0][i][2];
                cubePrint.arr[0][i][2] = temp[i];
            }
            cubePrint.arr[3] = setFaceL(cubePrint.arr[3]);
        }
    }
    public void moveRightR(String s){
        if(s.equalsIgnoreCase("r'")){
            char[] temp = {cubePrint.arr[2][0][2],cubePrint.arr[2][1][2],cubePrint.arr[2][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][i][2] = cubePrint.arr[0][i][2];
                cubePrint.arr[0][i][2] = cubePrint.arr[4][i][0];
                cubePrint.arr[4][i][0] = cubePrint.arr[5][i][2];
                cubePrint.arr[5][i][2] = temp[i];
            }
            cubePrint.arr[3] = setFaceR(cubePrint.arr[3]);
        }
    }

    public void moveBackL(String s){
        if(s.equalsIgnoreCase("b")){
            char[] temp = {cubePrint.arr[3][0][2],cubePrint.arr[3][1][2],cubePrint.arr[3][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[3][i][2] = cubePrint.arr[5][2][i];
                cubePrint.arr[5][2][i] = cubePrint.arr[1][i][0];
                cubePrint.arr[1][i][0] = cubePrint.arr[0][0][i];
                cubePrint.arr[0][0][i] = temp[i];
            }
            cubePrint.arr[4] = setFaceL(cubePrint.arr[4]);
        }
    }
    public void moveBackR(String s){
        if(s.equalsIgnoreCase("b'")){
            char[] temp = {cubePrint.arr[3][0][2],cubePrint.arr[3][1][2],cubePrint.arr[3][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[3][i][2] = cubePrint.arr[0][0][i];
                cubePrint.arr[0][0][i] = cubePrint.arr[1][i][0];
                cubePrint.arr[1][i][0] = cubePrint.arr[5][2][i];
                cubePrint.arr[5][2][i] = temp[i];
            }
            cubePrint.arr[4] = setFaceR(cubePrint.arr[4]);
        }
    }

    public void moveDownL(String s){
        if(s.equalsIgnoreCase("d")){
            char[] temp = {cubePrint.arr[2][2][0],cubePrint.arr[2][2][1],cubePrint.arr[2][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][2][i] = cubePrint.arr[1][2][i];
                cubePrint.arr[1][2][i] = cubePrint.arr[4][2][i];
                cubePrint.arr[4][2][i] = cubePrint.arr[3][2][i];
                cubePrint.arr[3][2][i] = temp[i];
            }
            cubePrint.arr[5] = setFaceL(cubePrint.arr[5]);
        }
    }
    public void moveDownR(String s){
        if(s.equalsIgnoreCase("d'")){
            char[] temp = {cubePrint.arr[2][2][0],cubePrint.arr[2][2][1],cubePrint.arr[2][2][2]};

            for(int i = 0; i< 3; i++){
                cubePrint.arr[2][2][i] = cubePrint.arr[3][2][i];
                cubePrint.arr[3][2][i] = cubePrint.arr[4][2][i];
                cubePrint.arr[4][2][i] = cubePrint.arr[1][2][i];
                cubePrint.arr[1][2][i] = temp[i];
            }
            cubePrint.arr[5] = setFaceR(cubePrint.arr[5]);
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
