import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.valueOf(sc.nextLine());
        char[] temp = sc.nextLine().toCharArray();
        int [] res = new int[n];

        List <Integer> wc_location = new ArrayList<Integer>();

        for (int i=0;i<temp.length;i++){
            if(temp[i]=='O')
                wc_location.add(i);
        }

        for(int i=0;i<n;i++){
            if(temp[i]=='O'){
                res[i]=0;
                continue;
            }

            int min_dis = n;
            int c_dis = n;
            for(int j=0;j<wc_location.size();j++){
                c_dis = Math.abs(i-wc_location.get(j));
                min_dis = Math.min(min_dis,c_dis);
            }

            res[i] = min_dis;
        }
        print_Array(res);
    }

    public static void print_Array(int[] array){
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }
}