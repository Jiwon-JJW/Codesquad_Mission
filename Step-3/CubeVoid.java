import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CubeVoid {

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
        }
    }
    public void moveFrontR(String s){
        if(s.equalsIgnoreCase("f'")){
        }
    }

    public void moveUpL(String s){
        if(s.equalsIgnoreCase("u")){
        }
    }
    public void moveUpR(String s){
        if(s.equalsIgnoreCase("u'")){
        }
    }

    public void moveLeftL(String s){
        if(s.equalsIgnoreCase("l")){
        }
    }
    public void moveLeftR(String s){
        if(s.equalsIgnoreCase("l'")){
        }
    }

    public void moveRightL(String s){
        if(s.equalsIgnoreCase("r")){
        }
    }
    public void moveRightR(String s){
        if(s.equalsIgnoreCase("r'")){
        }
    }

    public void moveBackL(String s){
        if(s.equalsIgnoreCase("b")){
        }
    }
    public void moveBackR(String s){
        if(s.equalsIgnoreCase("b'")){
        }
    }

    public void moveDownL(String s){
        if(s.equalsIgnoreCase("d")){
        }
    }
    public void moveDownR(String s){
        if(s.equalsIgnoreCase("d'")){
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
