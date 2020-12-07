import java.util.Scanner;

public class Cube {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CubeVoid cubeVoid= new CubeVoid();


        System.out.print("> ");

        String word = scanner.next();
        int num = scanner.nextInt();
        String direction = scanner.next();

        String[] wordArr = word.split("");

        if(direction.equalsIgnoreCase("l")){
            cubeVoid.directionL(num, wordArr);
        }
        if(direction.equalsIgnoreCase("r")){
            cubeVoid.directionR(num, wordArr);
        }
    }
}
