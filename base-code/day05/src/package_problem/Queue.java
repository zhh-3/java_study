package package_problem;

public class Queue {
    NodeType []queue = new NodeType[3];
    int self;

    public Queue(){
        self = 0;
        queue[0] = new NodeType(0,0,0,0);
        queue[1] = new NodeType(0,0,0,0);
        queue[2] = new NodeType(0,0,0,0);
    }

    public void push(NodeType e){
        queue[self] = new NodeType(e.i,e.w,e.v,e.ub,e.op);
        self = (self + 1)%3;
    }

    //找到最优先的先出去
    public NodeType pop(){
        NodeType e;
        if (queue[0].ub >= queue[1].ub && queue[0].ub >= queue[2].ub){
            self = 0;
        }
        else if (queue[1].ub >= queue[0].ub && queue[1].ub >= queue[2].ub){
            self = 1;
        }
        else self = 2;
        e = new NodeType(queue[self].i,queue[self].w,queue[self].v,queue[self].ub,queue[self].op);
        queue[self].ub = 0;
        queue[self].i = 0;
        return e;
    }

    //判断是否为空,true为空
    public boolean empty(){
        if (queue[0].ub==0&&queue[1].ub==0&&queue[2].ub==0){
            return true;
        }
        return false;
    }
}

