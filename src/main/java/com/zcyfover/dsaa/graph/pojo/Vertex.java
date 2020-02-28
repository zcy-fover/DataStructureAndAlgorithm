package com.zcyfover.dsaa.graph.pojo;

/**
 * Created by zcy-fover on 2016/9/4.
 * 图-顶点的抽象实现
 */
public class Vertex {
    private int key;        //顶点编号
    private String info;    //顶点信息
    private Edge adjacent;  //和自己邻接顶点之间的那条边
    private Color color;    //抽象顶点的颜色,标记顶点的状态
    private Vertex path;    //用于其他的域或者方法，可作为父或者孩子顶点使用
    private int discover;   //开始处理时间
    private int finish;     //结束处理时间
    private int inDegree;   //节点的入度
    private int outDegree;  //出度
    private int dist;       //距离，使用于无权图

    public Vertex() {
    }

    public Vertex(String info) {
        this.color = Color.WHITE;
        this.info = info;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Edge getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(Edge adjacent) {
        this.adjacent = adjacent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vertex getPath() {
        return path;
    }

    public void setPath(Vertex path) {
        this.path = path;
    }

    public int getDiscover() {
        return discover;
    }

    public void setDiscover(int discover) {
        this.discover = discover;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public int getOutDegree() {
        return outDegree;
    }

    public void setOutDegree(int outDegree) {
        this.outDegree = outDegree;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (info == null) {
            if (other.info != null)
                return false;
        } else if (!info.equals(other.info))
            return false;
        return true;
    }
}
