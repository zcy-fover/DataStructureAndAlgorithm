package com.zcyfover.dsaa.graph.pojo;

/**
 * Created by zcy-fover on 2016/9/4.
 * 图-变得抽象实现
 */
public class Edge {
    private int dest = 0;           //邻接顶点
    private int cost = 0;           //权值
    private String edgeInfo = null; //边的信息
    private Edge link = null;       //与这个顶点相关的所有边在邻接表中的下一条边

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getEdgeInfo() {
        return edgeInfo;
    }

    public void setEdgeInfo(String edgeInfo) {
        this.edgeInfo = edgeInfo;
    }

    public Edge getLink() {
        return link;
    }

    public void setLink(Edge link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (dest != edge.dest) return false;
        if (cost != edge.cost) return false;
        if (!edgeInfo.equals(edge.edgeInfo)) return false;
        return link.equals(edge.link);
    }

    @Override
    public int hashCode() {
        int result = dest;
        result = 31 * result + cost;
        result = 31 * result + edgeInfo.hashCode();
        result = 31 * result + link.hashCode();
        return result;
    }
}
