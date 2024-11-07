public class oa {
    static int f(int i,int t,int a[]){
        if(i == a.length){
            if(t==0){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<a.length;k++){
            max=Math.max(max,a[k]);
            int x=f(k+1,t-1,a);
            if(x != Integer.MAX_VALUE){
                min=Math.min(min,max+x);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int a[]={1,5,9,3,20,15};
        System.out.println(f(0,2,a));
    }
}
