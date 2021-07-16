package cha;

public class ru {
	//≤Â»Î≈≈–Ú
public static void insert(int a[]) {
	int i,j=1,t;
	for(;j<a.length;j++) 
	{
		t=a[j];
		i=j-1;
		while(i>=0&&a[i]>t)
		{
			a[i+1]=a[i];
			i--;
		}
		a[i+1]=t;
	}
	for(i=0;i<a.length;i++)
		System.out.print(a[i]+" ");   
}

public static void main(String args[]) {
	int a[] = {31,41,59,26,41,58};
	int i,j=1,t;
	insert(a);
}
 
}
