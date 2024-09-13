import java.util.*;

class bs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        long exp = sc.nextLong();
        
        Arrays.sort(a);
        long max=a[n-1];
        for(int i=0;i<n;i++){
            exp-=max-a[i];
        }
        if(exp <= 0){
            System.out.println(max);
        }else{
            System.out.println(max+);
        }
    }
}
