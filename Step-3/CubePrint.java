public class CubePrint {
    String[] w = {"W","W","W","W","W","W","W","W","W"};
    String[] o = {"O","O","O","O","O","O","O","O","O"};
    String[] b = {"B","B","B","B","B","B","B","B","B"};
    String[] r = {"R","R","R","R","R","R","R","R","R"};
    String[] g = {"G","G","G","G","G","G","G","G","G"};
    String[] y = {"Y","Y","Y","Y","Y","Y","Y","Y","Y"};

    public void firstPrint(int n){
        for(int i = n; i < n+3; i++){
            System.out.printf("%2s",w[i]);
        }
        System.out.printf("%6s"," ");

        for(int i = n; i < n+3; i++){
            System.out.printf("%2s",o[i]);
        }
        System.out.printf("%6s"," ");

        for(int i = n; i < n+3; i++){
            System.out.printf("%2s",g[i]);
        }
        System.out.printf("%6s"," ");

        for(int i = n; i < n+3; i++){
            System.out.printf("%2s",y[i]);
        }
        System.out.println();
    }

    public void blankPrint(String[] arr){
        for(int i = 1; i<= arr.length; i++){
            if(i-1 == 0 || i == 4 || i ==7){
                System.out.printf("%18s"," ");
            }
            System.out.printf("%2s",arr[i-1]);
            if(i%3 ==0){
                System.out.println();
            }
        }
    }

    public void printCube(){
        blankPrint(b);
        firstPrint(0);
        firstPrint(3);
        firstPrint(6);
        blankPrint(r);
    }
}
