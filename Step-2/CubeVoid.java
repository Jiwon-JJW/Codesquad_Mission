public class CubeVoid {
    String[] cube = {"R","R","W","G","C","W","G","B","B"};

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
        }
        if(s.equalsIgnoreCase("u'")){
            cubeMoveRight(0);
            printCube();
        }
        if(s.equalsIgnoreCase("r")){ // 가장 오른쪽 줄을 위로 한 칸
            cubeMoveUp(2);
            printCube();
        }
        if(s.equalsIgnoreCase("r'")){
            cubeMoveDown(2);
            printCube();
        }
        if(s.equalsIgnoreCase("l")){
            cubeMoveDown(0);
            printCube();
        }
        if(s.equalsIgnoreCase("l'")){ // 가장 왼쪽 줄을 위로 한 칸
            cubeMoveUp(0);
            printCube();
        }
        if(s.equalsIgnoreCase("b")){
            cubeMoveRight(6);
        }
        if(s.equalsIgnoreCase("b'")){
            cubeMoveLeft(6);
        }
        if(s.equalsIgnoreCase("q")){
            System.out.println("Bye~");
            System.exit(0);
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
