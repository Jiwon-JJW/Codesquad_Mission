public class CubeVoid {

    public void directionL(String direction, int num){
        if(direction.equalsIgnoreCase("l")){
            if(num >0){

            }

            if(num <0){

            }
        }
    }

    public void directionR(String direction, int num){
        if(direction.equalsIgnoreCase("r")){
            if(num >0){

            }

            if(num <0){

            }
        }
    }

    public void wordChangeL(String[] arr,int num){
        for(int i = 0; i < num; i++){
            String temp = arr[0];
            for(int j =1; j < arr.length; j++){
                arr[j-1] = arr[j];
            }
            arr[arr.length-1]= temp;
        }

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }

    public void wordChangeR(String[] arr, int num){
        for(int i = 0; i< num;i++){
            String temp = arr[0];
            for(int j = 0; j< arr.length; j++){
                if(j == arr.length-1){
                   arr[arr.length-1] = temp;
                   break;
                }
                arr[j]= arr[j+1];
            }
        }

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
