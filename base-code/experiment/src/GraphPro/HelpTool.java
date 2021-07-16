package GraphPro;

import java.io.BufferedReader;
import java.io.IOException;

public class HelpTool {
    public static void createVex(BufferedReader br,Vex vexs[]) throws IOException {
        int t = 0;
        String line;
        while ((line = br.readLine()) != null){
            int k = Integer.parseInt(line);
            String name = br.readLine();
            String information = br.readLine();
            vexs[t++] =new Vex(k,name,information);
        }
    }

    public static void createEin(BufferedReader br,int Eins[][]) throws IOException {
        int i,j,t;
        String line;
        while ((line = br.readLine()) != null){
            String arr[] = line.split(" ");
            i = Integer.parseInt(arr[0]);
            j = Integer.parseInt(arr[1]);
            t = Integer.parseInt(arr[2]);
            Eins[i][j] = t;
            Eins[j][i] = t;
        }
    }

    public static void DFS(int Eins[][],int flag[],int t) {

    }
}
