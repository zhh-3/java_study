package GraphPro;

class Vex {
    int num;
    String name;
    String information;

    public Vex(int n,String name,String information){
        num = n;
        this.name = name;
        this.information = information;
    }
}

class help{
    int pre;//前一个点在flag中的下标
    int flag;//标记

    public help(){
        this.pre = -1;
        this.flag = 0;
    }
}


