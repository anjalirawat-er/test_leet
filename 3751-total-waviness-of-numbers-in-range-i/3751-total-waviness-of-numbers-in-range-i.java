class Solution {
    public int totalWaviness(int num1, int num2) {
        if(num1 < 100 && num2 < 100) return 0;

        if(num1 < 100 && num2 >= 100){
            while(num1 < 100){
                num1++;
            }
        } 
        int n1 = num1;
        int n2 = num2;
        int ans = 0;

        while(n1 <= n2){

            int tempNum = n1;
            int count = 0;

            while(tempNum > 0){
                count++;
                tempNum /= 10;
            }

            int[] arr = new int[count];

            int n11 = n1;
            
            int j = arr.length-1;
            while(n11 >0){
                int temp = n11%10;
                arr[j] = temp;
                n11 = n11/10;
                j--;
            }

            for(int i=1;i<arr.length-1;i++){
                if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
                    ans++;
                }
                if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                    ans++;
                }
            }
            n1++;
        }

        return ans;

    }
}