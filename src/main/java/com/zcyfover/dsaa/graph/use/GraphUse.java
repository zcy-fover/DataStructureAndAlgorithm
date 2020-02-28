package com.zcyfover.dsaa.graph.use;

import com.zcyfover.dsaa.graph.pojo.Color;
import com.zcyfover.dsaa.graph.pojo.Const;
import com.zcyfover.dsaa.graph.pojo.GraphAdjacentList;
import com.zcyfover.dsaa.graph.pojo.Vertex;

import java.util.*;

/**
 * Created by zcy-fover on 2016/9/4.
 * 拓扑排序是针对有向无圈图的顶点的一种排序，使得如果存在一条从Vi到Vj的路径，那么在排序中Vj就出现在Vi的后面
 */
public class GraphUse {
    /**
     * 将所有入度为0的顶点放入一个队列，然后从队列的头部开始出对，将该顶点邻接的所有定点的入度都减一，如果
     * 有顶点的入度为0了，则继续放入队列，循环执行直到最后一个顶点被处理
     * @param graph
     */
    public void topologySort(GraphAdjacentList graph) {
        Queue<Vertex> queue = new ArrayDeque<>();
        Map<Vertex, Vertex[]> edgeMap = graph.getAdjacency();
        int counter = 0;
        graph.getVertexSet().stream().filter(v -> v.getInDegree() == 0).forEach(queue::offer);
        while (!queue.isEmpty()){
            Vertex v = queue.poll();
            System.out.print(v.getInfo());
            ++counter;
            for (Vertex w: edgeMap.get(v)) {
                w.setInDegree(w.getInDegree() - 1);
                if (w.getInDegree() == 0){
                    queue.add(w);
                }
            }
        }
        if (counter != graph.getVertexSet().size()){
            System.out.println("存在回路，无法构成拓扑排序");
        }
    }

    public Vertex[] topologicalSort(GraphAdjacentList graph) {
        Set<Vertex> vertexSet = graph.getVertexSet();
        if (vertexSet.size() < 2) {
            return vertexSet.toArray(new Vertex[0]);
        }

        LinkedList<Vertex> sortedList = new LinkedList<Vertex>();
        TimeRecorder recorder = new TimeRecorder();

        vertexSet.stream().filter(vertex -> vertex.getColor() == Color.WHITE).forEach(vertex -> {
            visitVertex(graph, vertex, recorder, sortedList);
        });

        return sortedList.toArray(new Vertex[0]);
    }

    /**
     * 广度优先搜索，是按照层次遍历图，从一个源顶点开始，先找出所有距离源顶点最近的顶点，再找距离较大的下一层
     * 类似于树的层序遍历
     * @param graph
     */
    public void breadthFirstSearchUnWeighted(GraphAdjacentList graph, Vertex source){
        Set<Vertex> vertexSet = graph.getVertexSet();
        Queue<Vertex> queue = new ArrayDeque<>();
        Map<Vertex, Vertex[]> map = graph.getAdjacency();//获取某一顶点的邻接顶点

        for (Vertex v: vertexSet){
            v.setDist(Const.INFINITY);
        }

        source.setDist(0);
        queue.offer(source);
        while (!queue.isEmpty()){
            Vertex v = queue.poll();
            System.out.print(v.getInfo() + "--");
            for (Vertex w : map.get(v)){    //寻找邻接的顶点，将其距离设置为源顶点加1，然后将其全部放入队列
                if (w.getDist() == Const.INFINITY){ //下次循环时，有被处理过的定点的距离都被改变了不是Const.INFINITY了
                    w.setDist(v.getDist() + 1); //保证每一个顶点只被处理一次
                    queue.offer(w);
                }
            }
        }

    }

    /**
     * 深度优先搜索(Depth First Search)
     */
    public void visitVertex(GraphAdjacentList graph, Vertex vertex,
                                   TimeRecorder recorder, LinkedList<Vertex> sortedList) {
        recorder.time += 1;
        vertex.setColor(Color.GRAY);
        vertex.setDiscover(recorder.time);

        Map<Vertex, Vertex[]> edgeMap = graph.getAdjacency();
        Vertex[] adjacencys = edgeMap.get(vertex);
        if (adjacencys != null && adjacencys.length > 0) {
            for (Vertex adjacency : adjacencys) {
                if (adjacency.getColor() == Color.WHITE) {
                    adjacency.setPath(vertex);
                    visitVertex(graph, adjacency, recorder, sortedList);
                }
            }
        }

        recorder.time += 1;
        vertex.setColor(Color.BLACK);
        vertex.setFinish(recorder.time);
        sortedList.addLast(vertex);
    }

    public void dijkstra(GraphAdjacentList graph, Vertex source){

        Set<Vertex> vertexSet = graph.getVertexSet();   //获取图中所有的顶点
        Map<Vertex, Vertex[]> map = graph.getAdjacency();   //根据当前顶点获取所有的邻接顶点

        //首先将所有的顶点的距离设置为无限大，并将其状态设置为未处理
        for (Vertex v:vertexSet) {
            v.setDist(Const.INFINITY);
            v.setColor(Color.WHITE);    //白色表示未处理
        }
    }

    /**
     * 获取该顶点的路径信息
     * @param v
     */
    public void printPath(Vertex v){
        if (v.getPath() != null){
            printPath(v.getPath());
            System.out.print("->");
        }
        System.out.print(v.getInfo());
    }

    class TimeRecorder {
        private int time = 0;

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
