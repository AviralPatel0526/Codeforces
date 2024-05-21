import java.util.*;
import java.lang.*;
import java.io.*;

public class D_Ingenuity_2 {
    public static class Pair {
        char dir;
        char device;
        public Pair(char dir, char device) {
            this.dir = dir;
            this.device = device;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n = sc.nextInt();
            String s = sc.next();
            if(n%2 != 0){
                System.out.println("NO");
            }else{
            Stack<Pair> ns = new Stack<>();
            Stack<Pair> ew = new Stack<>();
            int a[]=new int[4];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'N') {
                    handleDirection(ns, sb, 'N');
                    a[0]++;
                } else if (ch == 'S') {
                    handleDirection(ns, sb, 'S');
                    a[1]++;
                } else if (ch == 'E') {
                    handleDirection(ew, sb, 'E');
                    a[2]++;
                } else if (ch == 'W') {
                    handleDirection(ew, sb, 'W');
                    a[3]++;
                }
            }
            if(ns.isEmpty() && ew.isEmpty()){
                if(a[0] == a[1] && a[2] == a[3]){
                    if(a[0]+a[1]+a[2]+a[3] == 2){
                        System.out.println("NO");
                    }else{
                       if(!sb.toString().contains("H")){
                        int ni=s.indexOf('N');
                        int si=s.indexOf('S');
                        int ei=s.indexOf('E');
                        int wi=s.indexOf('W');
                        if(ni >= 0){
                            sb.replace(ni,ni+1,"H");
                            sb.replace(si,si+1,"H");
                        }else{
                            sb.replace(ei,ei+1,"H");
                            sb.replace(wi,wi+1,"H");
                        }

                       }
                       System.out.println(sb.toString());
                    }
                }else{
                    System.out.println(sb.toString());
                }

            }else{
                System.out.println("NO");
            }
            }
            

        }
    }

    private static void handleDirection(Stack<Pair> stack, StringBuilder sb, char direction) {
        if (stack.isEmpty()) {
            stack.add(new Pair(direction, 'R'));
            sb.append('R');
        } else {
            Pair top = stack.peek();
            if (top.dir == direction) {
                char nextDevice = top.device == 'R' ? 'H' : 'R';
                sb.append(nextDevice);
            } else {
                sb.append(stack.peek().device);
            }
            stack.pop();
        }
    }
}
