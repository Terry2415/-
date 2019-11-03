import java.util.*;

public class Main {
    static int [] dparray_weight; //每个结点 U 到子树中某结点 V 的最大边权和
    static int [][] tree_edge; //记录边的权值
    static int n;  //结点个数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        tree_edge = new int[n][n];
        dparray_weight = new int[n];

        init_tree_edge(); //初始化边矩阵，自己到自己为0，其余为int的最大值
        //保存输入的边
        for(int i=1;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            int u = Integer.valueOf(temp[0])-1;
            int v=  Integer.valueOf(temp[1])-1;
            tree_edge[u][v] = Integer.valueOf(temp[2]);
        }

        dp_weight(0);

        for(int i=0;i<n;i++)
            System.out.print(dparray_weight[i]+" ");
    }

    public static int dp_weight(int index){
        if( isleaf(index) ){
            dparray_weight[index]=0;
            return  dparray_weight[index];
        }

        for(int j=0;j<n;j++)
            if( j!=index && tree_edge[index][j] != Integer.MAX_VALUE ) //index到j有一条边
                dparray_weight[index]=Math.max(dparray_weight[index], dp_weight(j)+ tree_edge[index][j]);

        return  dparray_weight[index];
    }

    public static boolean isleaf(int index){ //结点下标为index的结点是不是叶子结点
        boolean flag =true;
        for(int j=0;j<n;j++)
            if( tree_edge[index][j] != Integer.MAX_VALUE && index!=j){
                flag = false;
                break;
            }
        return flag;
    }

    public static void init_tree_edge(){
        for(int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                if(i==j)
                    tree_edge[i][j]=0;
                else
                    tree_edge[i][j]=  Integer.MAX_VALUE;
    }

    public static void print_array(){
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++)
                System.out.print(tree_edge[i][j]+" ");
            System.out.println();
        }
    }
}