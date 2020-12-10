public class CubePrint {
    String[][][] arr = {
            {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}},
            {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}},
            {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}},
            {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}},
            {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}},
            {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}},
    };

    public void print2(){
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 1; i < arr.length - 1; i++) {
                for (int k = 0; k < 3; k++) {
                    System.out.printf("%2s", arr[i][1][k]);
                }
                System.out.printf("%6s", " ");
            }
            System.out.println();
        }
    }

    public void print1(int n){
        for (int j = 0; j < arr[0].length; j++) {
            for (int k = 0; k < arr[0][0].length; k++) {
                if (k == 0 || k == 4 || k == 7) {
                    System.out.printf("%18s", " ");
                }
                System.out.printf("%2s", arr[n][j][k]);
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
