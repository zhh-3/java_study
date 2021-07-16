
function createGroup(name, x, y) {
    var group = new ht.Group();//组类型 实际上也是一个节点
    group.setExpanded(true);//设置展开组
    group.setName(name);//设置组的名字
    group.s({//设置组的样式style
        'group.title.background': 'rgba(14,36,117,0.80)',//组展开后的title背景颜色，仅对group.type为空的类型起作用
        'group.background': 'rgba(14,36,117,0.40)',//组展开后的背景颜色
        'group.title.align': 'center'//组展开后的title文字水平对齐方式，默认值为'left'，可设置为center和right
    });
    group.setPosition(x, y);//设置组的位置
    group.setImage('images/服务器.json');//设置拓扑上展现的图片信息，在GraphView拓扑图中图片一般以position为中心绘制
    dataModel.add(group);//将创建的组节点添加进数据容器中

    return group;
}

function createNode(image, parent, x, y) {
    var node = new ht.Node();//创建一个 Node 节点
    if (image) node.setImage(image);//设置节点的显示图片
    if (parent) node.setParent(parent);//设置节点的父亲
    if (x && y) node.setPosition(x, y);//设置节点的位置
    dataModel.add(node);//将节点添加进数据容器中

    return node;
}


