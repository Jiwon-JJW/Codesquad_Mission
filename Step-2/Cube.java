import java.util.Scanner;

public class Cube {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CubeVoid cubeVoid = new CubeVoid();

        cubeVoid.printCube();
        System.out.print("CUBE >");
        String command = scanner.next();
        cubeVoid.inputCommand(command);

    }
}
