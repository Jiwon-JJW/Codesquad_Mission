public class CubeVoid {

    public void directionL(int num, String[] arr){
            if(num >0){
                wordChangeL(arr,num);
            }

            if(num <0){
                num = num*-1;
                wordChangeR(arr,num);
            }
    }

    public void directionR(int num, String[] arr){
            if(num >0){
                wordChangeR(arr,num);
            }

            if(num <0){
                num = num*-1;
                wordChangeL(arr,num);
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
            String temp = arr[arr.length-1];
            for(int j = arr.length-1; j>0; j--){
                arr[j]= arr[j-1];
            }
            arr[0] = temp;
        }

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
