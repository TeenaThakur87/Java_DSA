import java.util.Stack;

public class maxRectangular_Area {

    public static void maxArea(int arr[]){
        int max=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];

        //next smaller right
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //next smaller left
         s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        //current are= width: nsr[i]-nsl[i]-1
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            max=Math.max(max, currArea);
        }
        System.out.println("Maximum are in histogram = "+max);
    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,3,2};
        maxArea(arr);
    }
}
