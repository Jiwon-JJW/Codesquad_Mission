public class CubeShuffle {
    CubePrint cubePrint = new CubePrint();

    long start;
    long end;

    public void inputCommand(String s,int i){
        moveUpL(s,i);
        moveUpR(s,i);

        moveLeftL(s,i);
        moveLeftR(s,i);

        moveFrontL(s,i);
        moveFrontR(s,i);

        moveRightL(s,i);
        moveRightR(s,i);

        moveBackL(s,i);
        moveBackR(s,i);

        moveDownL(s,i);
        moveDownR(s,i);

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

    public void moveFrontL(String s,int n){
        if(s.equalsIgnoreCase("f")) {
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[0][2][0], cubePrint.arr[0][2][1], cubePrint.arr[0][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[0][2][i] = cubePrint.arr[1][i][2];
                    cubePrint.arr[1][i][2] = cubePrint.arr[5][0][i];
                    cubePrint.arr[5][0][i] = cubePrint.arr[3][i][0];
                    cubePrint.arr[3][i][0] = temp[i];
                }
                cubePrint.arr[2] = setFaceL(cubePrint.arr[2]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }
    public void moveFrontR(String s,int n){
        if(s.equalsIgnoreCase("f'")){
            for (int j = 0; j < n; j++) {

                char[] temp = {cubePrint.arr[5][0][0],cubePrint.arr[5][0][1],cubePrint.arr[5][0][2]};
                for(int i = 0; i< 3; i++){
                    cubePrint.arr[5][0][i] = cubePrint.arr[1][i][2];
                    cubePrint.arr[1][i][2] = cubePrint.arr[0][2][i];
                    cubePrint.arr[0][2][i] = cubePrint.arr[3][i][0];
                    cubePrint.arr[3][i][0] = temp[i];
                }
                cubePrint.arr[2] = setFaceR(cubePrint.arr[2]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }

    public void moveUpL(String s,int n){
        if(s.equalsIgnoreCase("u")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[2][0][0], cubePrint.arr[2][0][1], cubePrint.arr[2][0][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[2][0][i] = cubePrint.arr[3][0][i];
                    cubePrint.arr[3][0][i] = cubePrint.arr[4][0][i];
                    cubePrint.arr[4][0][i] = cubePrint.arr[1][0][i];
                    cubePrint.arr[1][0][i] = temp[i];
                }
                cubePrint.arr[0] = setFaceL(cubePrint.arr[0]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }
    public void moveUpR(String s,int n){
        if(s.equalsIgnoreCase("u'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[2][0][0], cubePrint.arr[2][0][1], cubePrint.arr[2][0][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[2][0][i] = cubePrint.arr[1][0][i];
                    cubePrint.arr[1][0][i] = cubePrint.arr[4][0][i];
                    cubePrint.arr[4][0][i] = cubePrint.arr[3][0][i];
                    cubePrint.arr[3][0][i] = temp[i];
                }
                cubePrint.arr[0] = setFaceR(cubePrint.arr[0]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }

    public void moveLeftL(String s,int n){
        if(s.equalsIgnoreCase("l")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[2][0][0], cubePrint.arr[2][1][0], cubePrint.arr[2][2][0]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[2][i][0] = cubePrint.arr[0][i][0];
                    cubePrint.arr[0][i][0] = cubePrint.arr[4][i][2];
                    cubePrint.arr[4][i][2] = cubePrint.arr[5][i][0];
                    cubePrint.arr[5][i][0] = temp[i];
                }
                cubePrint.arr[1] = setFaceL(cubePrint.arr[1]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }
    public void moveLeftR(String s,int n){
        if(s.equalsIgnoreCase("l'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[2][0][0], cubePrint.arr[2][1][0], cubePrint.arr[2][2][0]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[2][i][0] = cubePrint.arr[5][i][0];
                    cubePrint.arr[5][i][0] = cubePrint.arr[4][i][2];
                    cubePrint.arr[4][i][2] = cubePrint.arr[0][i][0];
                    cubePrint.arr[0][i][0] = temp[i];
                }
                cubePrint.arr[1] = setFaceR(cubePrint.arr[1]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }

    public void moveRightL(String s,int n){
        if(s.equalsIgnoreCase("r")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[2][0][2], cubePrint.arr[2][1][2], cubePrint.arr[2][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[2][i][2] = cubePrint.arr[5][i][2];
                    cubePrint.arr[5][i][2] = cubePrint.arr[4][i][0];
                    cubePrint.arr[4][i][0] = cubePrint.arr[0][i][2];
                    cubePrint.arr[0][i][2] = temp[i];
                }
                cubePrint.arr[3] = setFaceL(cubePrint.arr[3]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }
    public void moveRightR(String s,int n){
        if(s.equalsIgnoreCase("r'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[2][0][2], cubePrint.arr[2][1][2], cubePrint.arr[2][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[2][i][2] = cubePrint.arr[0][i][2];
                    cubePrint.arr[0][i][2] = cubePrint.arr[4][i][0];
                    cubePrint.arr[4][i][0] = cubePrint.arr[5][i][2];
                    cubePrint.arr[5][i][2] = temp[i];
                }
                cubePrint.arr[3] = setFaceR(cubePrint.arr[3]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }

    public void moveBackL(String s, int n){
        if(s.equalsIgnoreCase("b")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[3][0][2], cubePrint.arr[3][1][2], cubePrint.arr[3][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[3][i][2] = cubePrint.arr[5][2][i];
                    cubePrint.arr[5][2][i] = cubePrint.arr[1][i][0];
                    cubePrint.arr[1][i][0] = cubePrint.arr[0][0][i];
                    cubePrint.arr[0][0][i] = temp[i];
                }
                cubePrint.arr[4] = setFaceL(cubePrint.arr[4]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }
    public void moveBackR(String s,int n){
        if(s.equalsIgnoreCase("b'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[3][0][2], cubePrint.arr[3][1][2], cubePrint.arr[3][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[3][i][2] = cubePrint.arr[0][0][i];
                    cubePrint.arr[0][0][i] = cubePrint.arr[1][i][0];
                    cubePrint.arr[1][i][0] = cubePrint.arr[5][2][i];
                    cubePrint.arr[5][2][i] = temp[i];
                }
                cubePrint.arr[4] = setFaceR(cubePrint.arr[4]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }

    public void moveDownL(String s,int n){
        if(s.equalsIgnoreCase("d")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[2][2][0], cubePrint.arr[2][2][1], cubePrint.arr[2][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[2][2][i] = cubePrint.arr[1][2][i];
                    cubePrint.arr[1][2][i] = cubePrint.arr[4][2][i];
                    cubePrint.arr[4][2][i] = cubePrint.arr[3][2][i];
                    cubePrint.arr[3][2][i] = temp[i];
                }
                cubePrint.arr[5] = setFaceL(cubePrint.arr[5]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }
    public void moveDownR(String s,int n){
        if(s.equalsIgnoreCase("d'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.arr[2][2][0], cubePrint.arr[2][2][1], cubePrint.arr[2][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.arr[2][2][i] = cubePrint.arr[3][2][i];
                    cubePrint.arr[3][2][i] = cubePrint.arr[4][2][i];
                    cubePrint.arr[4][2][i] = cubePrint.arr[1][2][i];
                    cubePrint.arr[1][2][i] = temp[i];
                }
                cubePrint.arr[5] = setFaceR(cubePrint.arr[5]);

                cubePrint.printCube();
                System.out.println("=========================================");
            }
        }
    }

    public void exit(String s){
        if(s.equalsIgnoreCase("q")){
            end = System.currentTimeMillis();

            System.out.println("=========================================");
            System.out.println("Bye~");
            System.out.printf("경과시간 : %02d : %02d \n",(end-start)/60000 , ((end-start)/1000)%60);
            System.out.println("조작 갯수: "+(CubeVoid.score-1));
            System.out.println("=========================================");
            System.exit(0);
            return;
        }
    }

}
