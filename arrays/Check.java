public class Check{
    // private static void reversearray(int[] arr,int n,int k){
    //     for(int i=0;i<n;i+=k){
    //         int left=i;
    //         int right=Math.min(i+k-1,n-1);
    //     while(left<right){
    //         int temp=arr[left];
    //         arr[left]=arr[right];
    //         arr[right]=temp;
    //         left++;
    //         right--;

    //     }
    // }


        
    // }
    // public static void main(String[] args) {
    //     int[] arr={3,6,7,0,-7,3};
    //     int right=4;
    //     int n=arr.length;
    //     reversearray(arr,n,right);
    //     for(int num:arr){
    //         System.out.print(num+" ");
    //     }

    // }
    public static void main(String args[]){
        int[] arr={7,0,8,0,4,7,2,0,4};
        movezeros(arr);
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
    public static void movezeros(int[] arr){
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
            if(i!=j){
           int temp=arr[i];
           arr[i]=arr[j];
           arr[j]=temp;
            }

        
        
            j++;
        }
    }
        }

        
    }

    

