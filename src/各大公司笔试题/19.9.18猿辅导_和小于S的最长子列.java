import java.util.*;

public class Main {
    static int [][] dparray;
    static int [] a;
    static int n;
    static int s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        n = Integer.valueOf(temp[0]);
        s = Integer.valueOf(temp[1]);

        a = new int[n];
        dparray = new int[n][s+1];

        //保存输入
        temp = sc.nextLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Integer.valueOf(temp[i]);

        for(int i=n-1;i>=0;i--)
            dp(i,s);

        int max =0;
        for(int i=0; i<n;i++){
            max= Math.max(max, dparray[i][s]);
        }

        System.out.println(max);
    }

    public static int dp(int cur_i, int cur_s){
        if(cur_i == 0){
            if(a[0]>cur_s)
                dparray[0][cur_s] = 0;
            else
                dparray[0][cur_s] = 1;

            return  dparray[0][cur_s];
        }

        if(a[cur_i]>cur_s){
            dparray[cur_i][cur_s] = 0;
            return  dparray[cur_i][cur_s];
        }

        int remain = cur_s-a[cur_i];
        dparray[cur_i][cur_s] = dp(cur_i-1,remain)+1;

        return  dparray[cur_i][cur_s];
    }
}