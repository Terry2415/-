import java.util.*;

public class Main {
    static int[][] files_patch;
    static int dp_timearray[];
    static int dp_maxremainarray[];
    static int max_remain;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        files_patch = new int [n][2];
        dp_timearray = new int [n];
        dp_maxremainarray = new int[n];

        for(int i=0;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            files_patch[i][0] = Integer.valueOf(temp[0]);
            files_patch[i][1] = Integer.valueOf(temp[1]);
        }

        dp_timearray[0]= files_patch[0][0]+files_patch[0][1];

        dp_maxremainarray[0] = files_patch[0][1];
        max_remain = dp_maxremainarray[0];

        dp_time();
        dp_maxremain();

        System.out.println(dp_timearray[n-1]+" "+max_remain);
    }

    public static void dp_time(){
        for(int i=1;i<n;i++)
            dp_timearray[i] = Math.max(dp_timearray[i-1],files_patch[i][0])+files_patch[i][1];
    }

    public static void dp_maxremain(){
        for(int i=1;i<n;i++){
            dp_maxremainarray[i] = dp_maxremainarray[i-1]+files_patch[i][1]+
                    files_patch[i-1][0]-files_patch[i][0];

            max_remain= Math.max(max_remain,dp_maxremainarray[i]);
        }
    }
}