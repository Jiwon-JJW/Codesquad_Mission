public class CubeShuffle {
    CubePrint cubePrint = new CubePrint();

    long start;
    long end;

    public void shuffle(){
        moveUpL("u",(int)(Math.random()*10)+1);
        moveUpR("u'",(int)(Math.random()*10)+1);

        moveLeftL("l",(int)(Math.random()*10)+1);
        moveLeftR("l'",(int)(Math.random()*10)+1);

        moveFrontL("f",(int)(Math.random()*10)+1);
        moveFrontR("f'",(int)(Math.random()*10)+1);

        moveRightL("r",(int)(Math.random()*10)+1);
        moveRightR("r'",(int)(Math.random()*10)+1);

        moveBackL("b",(int)(Math.random()*10)+1);
        moveBackR("b'",(int)(Math.random()*10)+1);

        moveDownL("d",(int)(Math.random()*10)+1);
        moveDownR("d'",(int)(Math.random()*10)+1);

        cubePrint.printCube();
    }

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

        cubePrint.printCube();
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
                char[] temp = {cubePrint.cube[0][2][0], cubePrint.cube[0][2][1], cubePrint.cube[0][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[0][2][i] = cubePrint.cube[1][i][2];
                    cubePrint.cube[1][i][2] = cubePrint.cube[5][0][i];
                    cubePrint.cube[5][0][i] = cubePrint.cube[3][i][0];
                    cubePrint.cube[3][i][0] = temp[i];
                }
                cubePrint.cube[2] = setFaceL(cubePrint.cube[2]);

            }
        }
    }
    public void moveFrontR(String s,int n){
        if(s.equalsIgnoreCase("f'")){
            for (int j = 0; j < n; j++) {

                char[] temp = {cubePrint.cube[5][0][0],cubePrint.cube[5][0][1],cubePrint.cube[5][0][2]};
                for(int i = 0; i< 3; i++){
                    cubePrint.cube[5][0][i] = cubePrint.cube[1][i][2];
                    cubePrint.cube[1][i][2] = cubePrint.cube[0][2][i];
                    cubePrint.cube[0][2][i] = cubePrint.cube[3][i][0];
                    cubePrint.cube[3][i][0] = temp[i];
                }
                cubePrint.cube[2] = setFaceR(cubePrint.cube[2]);

            }
        }
    }

    public void moveUpL(String s,int n){
        if(s.equalsIgnoreCase("u")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[2][0][0], cubePrint.cube[2][0][1], cubePrint.cube[2][0][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[2][0][i] = cubePrint.cube[3][0][i];
                    cubePrint.cube[3][0][i] = cubePrint.cube[4][0][i];
                    cubePrint.cube[4][0][i] = cubePrint.cube[1][0][i];
                    cubePrint.cube[1][0][i] = temp[i];
                }
                cubePrint.cube[0] = setFaceL(cubePrint.cube[0]);

            }
        }
    }
    public void moveUpR(String s,int n){
        if(s.equalsIgnoreCase("u'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[2][0][0], cubePrint.cube[2][0][1], cubePrint.cube[2][0][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[2][0][i] = cubePrint.cube[1][0][i];
                    cubePrint.cube[1][0][i] = cubePrint.cube[4][0][i];
                    cubePrint.cube[4][0][i] = cubePrint.cube[3][0][i];
                    cubePrint.cube[3][0][i] = temp[i];
                }
                cubePrint.cube[0] = setFaceR(cubePrint.cube[0]);

            }
        }
    }

    public void moveLeftL(String s,int n){
        if(s.equalsIgnoreCase("l")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[2][0][0], cubePrint.cube[2][1][0], cubePrint.cube[2][2][0]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[2][i][0] = cubePrint.cube[0][i][0];
                    cubePrint.cube[0][i][0] = cubePrint.cube[4][i][2];
                    cubePrint.cube[4][i][2] = cubePrint.cube[5][i][0];
                    cubePrint.cube[5][i][0] = temp[i];
                }
                cubePrint.cube[1] = setFaceL(cubePrint.cube[1]);

            }
        }
    }
    public void moveLeftR(String s,int n){
        if(s.equalsIgnoreCase("l'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[2][0][0], cubePrint.cube[2][1][0], cubePrint.cube[2][2][0]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[2][i][0] = cubePrint.cube[5][i][0];
                    cubePrint.cube[5][i][0] = cubePrint.cube[4][i][2];
                    cubePrint.cube[4][i][2] = cubePrint.cube[0][i][0];
                    cubePrint.cube[0][i][0] = temp[i];
                }
                cubePrint.cube[1] = setFaceR(cubePrint.cube[1]);

            }
        }
    }

    public void moveRightL(String s,int n){
        if(s.equalsIgnoreCase("r")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[2][0][2], cubePrint.cube[2][1][2], cubePrint.cube[2][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[2][i][2] = cubePrint.cube[5][i][2];
                    cubePrint.cube[5][i][2] = cubePrint.cube[4][i][0];
                    cubePrint.cube[4][i][0] = cubePrint.cube[0][i][2];
                    cubePrint.cube[0][i][2] = temp[i];
                }
                cubePrint.cube[3] = setFaceL(cubePrint.cube[3]);

            }
        }
    }
    public void moveRightR(String s,int n){
        if(s.equalsIgnoreCase("r'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[2][0][2], cubePrint.cube[2][1][2], cubePrint.cube[2][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[2][i][2] = cubePrint.cube[0][i][2];
                    cubePrint.cube[0][i][2] = cubePrint.cube[4][i][0];
                    cubePrint.cube[4][i][0] = cubePrint.cube[5][i][2];
                    cubePrint.cube[5][i][2] = temp[i];
                }
                cubePrint.cube[3] = setFaceR(cubePrint.cube[3]);

            }
        }
    }

    public void moveBackL(String s, int n){
        if(s.equalsIgnoreCase("b")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[3][0][2], cubePrint.cube[3][1][2], cubePrint.cube[3][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[3][i][2] = cubePrint.cube[5][2][i];
                    cubePrint.cube[5][2][i] = cubePrint.cube[1][i][0];
                    cubePrint.cube[1][i][0] = cubePrint.cube[0][0][i];
                    cubePrint.cube[0][0][i] = temp[i];
                }
                cubePrint.cube[4] = setFaceL(cubePrint.cube[4]);

            }
        }
    }
    public void moveBackR(String s,int n){
        if(s.equalsIgnoreCase("b'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[3][0][2], cubePrint.cube[3][1][2], cubePrint.cube[3][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[3][i][2] = cubePrint.cube[0][0][i];
                    cubePrint.cube[0][0][i] = cubePrint.cube[1][i][0];
                    cubePrint.cube[1][i][0] = cubePrint.cube[5][2][i];
                    cubePrint.cube[5][2][i] = temp[i];
                }
                cubePrint.cube[4] = setFaceR(cubePrint.cube[4]);

            }
        }
    }

    public void moveDownL(String s,int n){
        if(s.equalsIgnoreCase("d")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[2][2][0], cubePrint.cube[2][2][1], cubePrint.cube[2][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[2][2][i] = cubePrint.cube[1][2][i];
                    cubePrint.cube[1][2][i] = cubePrint.cube[4][2][i];
                    cubePrint.cube[4][2][i] = cubePrint.cube[3][2][i];
                    cubePrint.cube[3][2][i] = temp[i];
                }
                cubePrint.cube[5] = setFaceL(cubePrint.cube[5]);

            }
        }
    }
    public void moveDownR(String s,int n){
        if(s.equalsIgnoreCase("d'")){
            for (int j = 0; j < n; j++) {
                char[] temp = {cubePrint.cube[2][2][0], cubePrint.cube[2][2][1], cubePrint.cube[2][2][2]};

                for (int i = 0; i < 3; i++) {
                    cubePrint.cube[2][2][i] = cubePrint.cube[3][2][i];
                    cubePrint.cube[3][2][i] = cubePrint.cube[4][2][i];
                    cubePrint.cube[4][2][i] = cubePrint.cube[1][2][i];
                    cubePrint.cube[1][2][i] = temp[i];
                }
                cubePrint.cube[5] = setFaceR(cubePrint.cube[5]);

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
