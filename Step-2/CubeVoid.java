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
}
