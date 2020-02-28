package com.zcyfover.dsaa.graph.pojo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zcy-fover on 2016/9/4.
 * 图的邻接表实现
 */
public class GraphAdjacentList {
    private int maxVertex;                  //图中最多顶点个数
    private int numEdge;                    //当前边数
    private int numVertex;                  //当前顶点数
    private Vertex[] nodeTable = null;      //

    private Set<Vertex> vertexSet = new HashSet<>();
    private Map<Vertex, Vertex[]> adjacency = new HashMap<>();

    public GraphAdjacentList(){

    }

    public GraphAdjacentList(int size) {
        //构造函数：建立一个空的邻接表
        maxVertex = size;
        numVertex = 0;
        numEdge = 0;
        nodeTable = new Vertex[maxVertex]; //创建顶点表数组
        if (nodeTable == null) {
            System.out.println("GraphLink is failed to create");
            System.exit(1);
        }
        for (int i = 0; i < maxVertex; i++){
            nodeTable[i].setAdjacent(null);
        }
    }

    //销毁一个邻接表
    public void destroy(){
        for (int i = 0; i < numVertex; i++) {
            Edge p = nodeTable[i].getAdjacent();
            while (p != null) {
                nodeTable[i].setAdjacent(p.getLink());
                p = nodeTable[i].getAdjacent();
            }
        }
    }

    /**
     * 找出顶点vertex在图中的位置
     * @param vertex
     * @return
     */
    public int getVertexPos(int vertex){
        for (int i = 0; i < numVertex; i++){
            if (nodeTable[i].getKey() == vertex){
                return  i;
            }
        }
        return -1;
    }

    /**
     * 返回顶点i的值
     * @param i
     * @return
     */
    public int getValue(int i){
        return (i >= 0 && i < numVertex) ? nodeTable[i].getKey() : 0;
    }

    /**
     * 找出顶点位置为v第一个邻接顶点的位置
     * 如果找不到则返回-1
     * @param v
     * @return
     */
    public int getFirstAdjacentVertexPos(int v){
        if (v != -1){     //顶点存在，对应到边链表第一个边结点
            Edge p = nodeTable[v].getAdjacent();
            if (p != null){
                //存在，返回第一个邻接点
                return p.getDest();
            }
        }
        return -1;
    }

    /**
     * 给出顶点v的邻接顶点w的下一个邻接顶点的位置
     * 没有则返回-1
     * @param v
     * @param w
     * @return
     */
    public int getNextAdjacentVertexPos(int v, int w){
        if(v != -1){
            Edge p = nodeTable[v].getAdjacent();
            while (p != null && p.getDest() != w){
                p = p.getLink();
            }
            if (p != null && p.getLink() != null){
                return p.getLink().getDest();
            }
        }
        return -1;
    }

    public void printGraph(){
        for (int i = 0; i < numVertex; i++){
            System.out.print(getValue(i) + ": ");
            Edge edge = nodeTable[i].getAdjacent();
            while (edge != null){
                System.out.print(edge.getDest() + " -- ");
                edge = edge.getLink();
            }
            System.out.println();
        }
    }

    public Set<Vertex> getVertexSet() {
        return vertexSet;
    }

    public void setVertexSet(Set<Vertex> vertexSet) {
        this.vertexSet = vertexSet;
    }

    public Map<Vertex, Vertex[]> getAdjacency() {
        return adjacency;
    }

    public void setAdjacency(Map<Vertex, Vertex[]> adjacency) {
        this.adjacency = adjacency;
    }

    public int getMaxVertex() {
        return maxVertex;
    }

    public void setMaxVertex(int maxVertex) {
        this.maxVertex = maxVertex;
    }

    public int getNumEdge() {
        return numEdge;
    }

    public void setNumEdge(int numEdge) {
        this.numEdge = numEdge;
    }

    public int getNumVertex() {
        return numVertex;
    }

    public void setNumVertex(int numVertex) {
        this.numVertex = numVertex;
    }

    public Vertex[] getNodeTable() {
        return nodeTable;
    }

    public void setNodeTable(Vertex[] nodeTable) {
        this.nodeTable = nodeTable;
    }
}
