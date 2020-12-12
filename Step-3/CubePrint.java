public class CubePrint {

    public void print2(){
        for (int j = 0; j < CubeShuffle.cube[0].length; j++) {
            for (int i = 1; i < CubeShuffle.cube.length - 1; i++) {
                for (int k = 0; k < 3; k++) {
                    System.out.printf("%2s", CubeShuffle.cube[i][j][k]);
                }
                System.out.printf("%6s", " ");
            }
            System.out.println();
        }
    }

    public void print1(int n){
        for (int j = 0; j < CubeShuffle.cube[0].length; j++) {
            for (int k = 0; k < CubeShuffle.cube[0][0].length; k++) {
                if (k == 0 || k == 4 || k == 7) {
                    System.out.printf("%18s", " ");
                }
                System.out.printf("%2s", CubeShuffle.cube[n][j][k]);
            }
            System.out.println();
        }
    }

    public void printCube(){
        print1(0);
        print2();
        print1(5);
    }
}
