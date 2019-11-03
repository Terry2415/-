import java.util.*;
/*
    输入一个二维数组，0代表空，1代表经理，2代表程序员
    每隔一分钟，程序员相邻(上下左右)的经理会变成程序员
    问二维数组中的经理是否全部能变为程序员？
    如果能，返回分钟数；如果不能，返回-1
 */
public class Main {
    //保存输入的二维数组
    private static int[][] input_array;

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> input = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split(" ");
            input.add(new ArrayList(Arrays.asList(temp)));
        }

        input_array = get_input_array(input);

        int pre_manager_num = 1000; //每一次转换之前，数组中有多少个1
        int time =0;

        while (get_manager_num(input_array)<pre_manager_num && get_manager_num(input_array)>0){
            pre_manager_num = get_manager_num(input_array);
            input_array = manager2programmer_onetime(input_array);
            time++;
            print_Array(input_array);
        }

        if(get_manager_num(input_array)==0)
            System.out.println(time);
        else
            System.out.println(-1);
    }

    public static int[][] manager2programmer_onetime(int[][] array){
        int rows = array.length;
        int cols = array[0].length;
        int[][] array_copy = new int[rows][cols];

        for (int i=0;i<rows;i++) {
            for (int j = 0; j<cols; j++) {
                array_copy[i][j] = array[i][j];
            }
        }

        for (int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if(array[i][j]==2){
                    if(i-1>=0 && array[i-1][j]==1)
                        array_copy[i-1][j]=2;

                    if(i+1<rows && array[i+1][j]==1)
                        array_copy[i+1][j]=2;

                    if(j-1>=0 && array[i][j-1]==1)
                        array_copy[i][j-1]=2;

                    if(j+1<cols && array[i][j+1]==1)
                        array_copy[i][j+1]=2;
                }
            }
        }

        return array_copy;
    }

    public static int get_manager_num(int[][] array){
        int rows = array.length;
        int cols = array[0].length;
        int count=0;

        for (int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    public static int[][] get_input_array(ArrayList<ArrayList<String>> input){
        int rows = input.size();
        int cols = input.get(0).size();

        int[][] input_Array = new int[rows][cols];

        for (int i=0;i<rows;i++)
            for (int j=0;j<cols;j++){
                input_Array[i][j] = Integer.parseInt(input.get(i).get(j));
            }

        return input_Array;
    }

    public static void print_Array(int[][] array){
        int rows = array.length;
        int cols = array[0].length;

        System.out.println("打印数组如下");
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
