package cha;

import java.util.Scanner;

public class qipan {
	
	static int tile = 1;
	
	public static void main(String args[]) {
		int size,k;
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入棋盘大小：2^");
		k = scanner.nextInt();
		size = (int) Math.pow(2, k);
		int board[][] = new int [10][10];
		int x,y;//特殊方格的位置
		System.out.println("特殊方格位置（左上角为（0,0））");
		System.out.print("横坐标：");
		y = scanner.nextInt();
		System.out.print("纵坐标：");
		x = scanner.nextInt();
		board[x][y] = 0;
		tileboard(0, 0, x, y, size,board);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	//递归方法
	public static void tileboard(int tr,int tc,int dr,int dc,int size,int board[][]) {
		if (size == 1) {//递归出口
			return ;
		}
		int t = tile++;
		int s = size/2;
		//处理左上角棋盘
		if (dr < tr + s && dc < tc + s) {
			tileboard(tr, tc, dr, dc, s,board);	//特殊方格在此方阵中
		}
		else {								//不在此方阵
			board[tr + s -1][tc + s - 1] = t;
			tileboard(tr, tc, tr + s - 1, tc + s -1, s,board);
		}
		//处理右上角
		if (dr < tr + s && dc >= tc + s) {
			tileboard(tr, tc + s, dr, dc, s,board);	//特殊方格在此方阵中
		}
		else {									//不在此方阵
			board[tr + s -1][tc + s] = t;
			tileboard(tr, tc + s, tr + s - 1, tc + s, s,board);
		}
		//处理左下角
		if (dr >= tr + s && dc < tc + s) {
			tileboard(tr + s, tc, dr, dc, s,board);	//特殊方格在此方阵中
		}
		else {								//不在此方阵
			board[tr + s][tc + s - 1] = t;
			tileboard(tr + s, tc, tr + s, tc + s -1, s,board);
		}
		//处理右下角
		if (dr >= tr + s && dc >= tc + s) {
			tileboard(tr + s, tc + s, dr, dc, s,board);	//特殊方格在此方阵中
		}
		else {								//不在此方阵
			board[tr + s][tc + s] = t;
			tileboard(tr + s, tc + s, tr + s, tc + s, s,board);
		}
		
	}
}
