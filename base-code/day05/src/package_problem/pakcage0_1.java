package package_problem;

public class pakcage0_1 {
    public static int n = 5;//物品数
    public static int w = 10;//背包容量
    public static int tw = 0,tv = 0;//当前背包已装重量和价值
    public static int maxv;//当前最大价值
    public static Cargo [] cargos = new Cargo[n+1];
    public static int x[] = new int[n+1];//存放最终解
    public static int op[] = new int[n+1];//存放临时解
    public static Queue qu = new Queue();

    public static void main(String[] args) {
        init();
        //动态规划法
        long a = System.currentTimeMillis();
        maxv = 0;
        System.out.print("采用动态规划法： 选择物品");
        Knap();
        output();
        long b = System.currentTimeMillis();
        System.out.println("耗时：" + (b - a) + "毫秒");

        //回溯法
        a = System.currentTimeMillis();
        maxv = 0;
        System.out.print("采用回溯法： 选择物品");
        Knapsack(1);
        output();
        b = System.currentTimeMillis();
        System.out.println("耗时：" + (b - a) + "毫秒");

        //分支限界法
        a = System.currentTimeMillis();
        maxv = 0;
        System.out.print("采用分枝限界法，选择物品");
        bfs();
        output();
        b = System.currentTimeMillis();
        System.out.println("耗时：" + (b - a) + "毫秒");
    }

    public static void init() {
        cargos[0] = new Cargo(0,0);
        cargos[1] = new Cargo(2,6);
        cargos[2] = new Cargo(2,3);
        cargos[3] = new Cargo(4,6);
        cargos[4] = new Cargo(6,5);
        cargos[5] = new Cargo(5,4);
    }

    public static void output() {
        for (int i = 1;i <= n;i++){
            if (x[i] == 1){
                System.out.print(i+" ");
            }
        }
        System.out.println("总价值为："+maxv);
    }

    //动态规划法
    public static void Knap() {
        int dp[][] = new int[n+1][w+1];
        //置边界条件
        for (int i = 0;i <= n;i++){
            dp[i][0] = 0;
        }
        for (int j = 0;j <= w;j++){
            dp[0][j] = 0;
        }

        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= w;j++){
                if (j < cargos[i].weight){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-cargos[i].weight]+cargos[i].value);
                }
            }
        }

        int i = n,r = w;
        while (i > 0){
            if (dp[i][r] != dp[i-1][r]){
                x[i] = 1;
                maxv += cargos[i].value;
                r = r-cargos[i].weight;
            }else {
                x[i] = 0;
            }
            i--;
        }
    }

    //回溯法
    public static void Knapsack(int i) {
        if (i > n){
            if (tv >= maxv){
                maxv = tv;
                for (int j = 1;j <= n;j++){
                    x[j] = op[j];
                }
            }
        }
        else {
            //左边以重量剪枝
            if (tw + cargos[i].weight <= w){
                op[i] = 1;
                tv += cargos[i].value;
                tw += cargos[i].weight;
                Knapsack(i+1);
                tv -= cargos[i].value;
                tw -= cargos[i].weight;
            }
            op[i] = 0;
            //右边以最优解限制
            if (bound(i+1,w-tw,tv) > maxv){
                Knapsack(i+1);
            }
        }
    }

    public static int bound(int i,int rw,int tv) {
        int ub = tv;
        while (i <= n && cargos[i].weight <= rw){
            rw -= cargos[i].weight;
            ub += cargos[i].value;
            i++;
        }
        if (i <= n){
            ub += cargos[i].value*rw/cargos[i].weight;
        }
        return ub;
    }

    //分支限界法
    public static void bfs() {
        int op[] = new int[n+1];
        NodeType e = new NodeType(0,0,0,bound(1,w,0),op);
        NodeType e1 = new NodeType(0,0,0,0);
        NodeType e2 = new NodeType(0,0,0,0);
        qu.push(e);
        while (!qu.empty()){
            e = qu.pop();
            if (e.w + cargos[e.i+1].weight <= w){
                e1.i = e.i + 1;
                e1.w = e.w + cargos[e1.i].weight;
                e1.v = e.v + cargos[e1.i].value;
                e1.ub = bound(e1.i,w-e1.w,e1.v) + e.v;
                for (int j = 1;j < e.op.length;j++){
                    e1.op[j] = e.op[j];
                }
                e1.op[e1.i] = 1;
                EnQueue(e1);
            }
            e2.i =e.i+1;
            e2.w=e.w; 
            e2.v=e.v;
            e2.ub = bound(e2.i+1,w-e2.w,e2.v) + e.v;
            for (int j=1;j<=n;j++) {
                e2.op[j]=e.op[j]; 	//复制解向量
            }
            e2.op[e2.i]=0;
            if (e2.ub >= maxv){
                EnQueue(e2);
            }
        }
    }

    public static void EnQueue(NodeType e) {
        if (e.i >= n){
            if (e.v >= maxv){
                maxv = e.v;
                for (int j = 1;j <= n;j++){
                    x[j] = e.op[j];
                }
            }
        } else {
            qu.push(e);
        }
    }
}

class Cargo{
    int value;
    int weight;
    public Cargo(int weight,int value){
        this.value = value;
        this.weight = weight;
    }
}

class NodeType{
    int i;//层次
    int w;//总重
    int v;//总价值
    int op[] = new int [6];
    double ub;//优先级

    public NodeType(){

    }

    public NodeType(int i,int w,int v,double ub,int[] op){
        this.i = i;
        this.ub = ub;
        this.v = v;
        this.w = w;
        for (int j = 0;j < op.length;j++){
            this.op[j] = op[j];
        }
    }

    public NodeType(int i,int w,int v,double ub){
        this.i = i;
        this.ub = ub;
        this.v = v;
        this.w = w;
    }
}

