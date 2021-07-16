package GraphPro;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static HelpTool ht;
    public static int n;
    public static int m = 1;
    public static Vex vexs[];
    public static int Eins [][];
    public static String str1 = "F:\\IDEA\\IdeaProjects\\base-code\\experiment\\src\\GraphPro\\Vex.txt";
    public static String str2 = "F:\\IDEA\\IdeaProjects\\base-code\\experiment\\src\\GraphPro\\Edge.txt";
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int k = 1;
        while (k != 0){
            System.out.println("**********欢迎进入景区信息管理系统*************");
            System.out.println("请选择功能：");
            System.out.println("1. 创 建 图      2.查询景点");
            System.out.println("3.旅游景点导航   4.搜索最短路径");
            System.out.println("5.铺设电路规划   0.退出");
            System.out.println("*********************************************");
            System.out.print("选择：");
            k = scanner.nextInt();
            switch (k){
                case 1:
                    Cgraph();
                    break;
                case 2:
                    find();
                    break;
                case 3:
                    guide();
                    break;
                case 4:
                    FindShortPath();
                    break;
                case 5:
                    DesignPath();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("输入异常");

            }
        }
        System.out.println("感谢使用景区信息系统，期待您的下次使用");
    }

    //1.创建图
    public static void Cgraph() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(str1));
        BufferedReader br1 = new BufferedReader(new FileReader(str2));

        n =Integer.parseInt(br.readLine());
        vexs= new Vex[n];
        Eins = new int[n][n];
        //生成顶点数组
        int t = 0;
        String line;
        while ((line = br.readLine()) != null){
            int k = Integer.parseInt(line);
            String name = br.readLine();
            String information = br.readLine();
            vexs[t++] =new Vex(k,name,information);
        }
        //生成边数组
        int i,j;
        while ((line = br1.readLine()) != null){
            String arr[] = line.split(" ");
            i = Integer.parseInt(arr[0]);
            j = Integer.parseInt(arr[1]);
            t = Integer.parseInt(arr[2]);
            Eins[i][j] = t;
            Eins[j][i] = t;
        }

        br.close();
        br1.close();

        System.out.println("***** 创建景区景点图 *****");
        System.out.println("顶点数目："+n);
        System.out.println("***** 顶点 *****");
        for (i = 0;i < n;i++){
            System.out.println(vexs[i].num+"-"+vexs[i].name);
        }
        System.out.println("***** 边 *****");
        for (i = 0;i < n;i++){
            for (j = i;j < n;j++){
                if (Eins[i][j] != 0){
                    System.out.println("<v"+i+",v"+j+"> "+Eins[i][j]);
                }
            }
        }

    }

    //2.查询景点信息
    public static void find() {
        System.out.println("***** 查询景点信息 *****");
        for (int i = 0;i < n;i++){
            System.out.println(vexs[i].num+"-"+vexs[i].name);
        }
        System.out.print("情输入想要查询的景点编号：");
        int t = scanner.nextInt();
        System.out.println(vexs[t].name);
        System.out.println(vexs[t].information);
        System.out.println("***** 周边景区 *****");
        for (int j = 0;j < n;j++){
            if (Eins[t][j] != 0){
                System.out.println(vexs[t].name+"->"+vexs[j].name+" "+Eins[t][j]);
            }
        }
    }

    //3.旅游景点导航
    public static void guide() {
        int flag[] = new int[n];
        int nums[] = new int[n];
        System.out.println("***** 旅游景点导航 *****");
        for (int i = 0;i < n;i++){
            System.out.println(vexs[i].num+"-"+vexs[i].name);
            flag[i] = 0;
        }
        System.out.print("情输入起点景区编号：");
        int t = scanner.nextInt();
        System.out.println("导航路线为：");
        flag[t] = 1;
        int k = 0;
        nums[k++] = t;
        DFS(t,k,flag,nums);
    }

    public static void DFS(int t,int k,int flag[],int nums[]) {
        if (k == n){
            System.out.print("线路"+m+": ");
            for (int i = 0;i < n-1;i++){
                System.out.print(vexs[nums[i]].name+"->");
            }
            System.out.println(vexs[nums[n-1]].name);
            m++;
            return;
        }else {
            for (int j = 0;j < n;j++){
                if (Eins[t][j] != 0 && flag[j] == 0){
                    flag[j] = 1;
                    nums[k] = j;
                    DFS(j,k+1,flag,nums);
                    flag[j] = 0;
                    nums[k] = 0;
                }
            }
        }
    }

    //4.搜索最短路径
    public static void FindShortPath() {
        help flag[] = new help[n];
        int weight[] = new int[n];
        System.out.println("***** 搜索最短路径 *****");
        for (int i = 0;i < n;i++){
            flag[i] = new help();
            System.out.println(vexs[i].num+"-"+vexs[i].name);
        }
        System.out.print("情输入起点景区编号：");
        int start = scanner.nextInt();
        System.out.print("输入终点：");
        int end = scanner.nextInt();
        flag[start].flag = 1;
        weight[start] = 0;

        for(int k = 1;k < n;k++){
            int min = 100000;
            int t = -1;
            int p = -1;
            for (int i = 0;i < n;i++){
                if (flag[i].flag != 0){
                    for (int j = 0;j < n;j++){
                        if (flag[j].flag ==0 && Eins[i][j] != 0 && weight[i] + Eins[i][j] < min ){
                            min = Eins[i][j] + weight[i];
                            p = i;
                            t = j;
                        }
                    }
                }
            }
            flag[t].pre = p;
            flag[t].flag = 1;
            weight[t] = min;
        }

        int r = n-1;
        int arr[] = new int[n];

        int p = end;
        while (flag[p].pre != -1){
            arr[r--] = p;
            p = flag[p].pre;
        }
        arr[r] = start;
        System.out.print("最短路径为：");
        for (;r < n-1;r++){
            System.out.print(vexs[arr[r]].name+"->");
        }
        System.out.println(vexs[arr[r]].name);
        System.out.println("最短距离为： "+weight[end]);
    }

    //5.铺设电路规划
    public static void DesignPath() {
        System.out.println("***** 铺设电路规划 *****");
        help flag[] = new help[n];
        for (int i=0;i<n;i++){
            flag[i] = new help();
        }
        flag[0].flag = 1;
        flag[0].pre = -1;
        for (int k = 1;k < n ;k++){
            int min = 10000;
            int t = -1;
            int p = -1;
            for (int i = 0;i < n;i++){
                if (flag[i].flag != 0){
                    for (int j = 0;j < n;j++){
                        if (flag[j].flag ==0 && Eins[i][j] != 0 && Eins[i][j] < min ){
                            min = Eins[i][j];
                            p = i;
                            t = j;
                        }
                    }
                }
            }
            flag[t].flag = 1;
            flag[t].pre = p;
        }

        int s =0;
        System.out.println("在以下两个景点之间铺设电路：");
        for (int i = n-1;i > 0;i--){
            System.out.println(vexs[flag[i].pre].name+" - "+vexs[i].name+"  "+Eins[flag[i].pre][i]+"m");
            s += Eins[flag[i].pre][i];
        }
        System.out.println("铺设的总长度为： "+s);
    }

}
