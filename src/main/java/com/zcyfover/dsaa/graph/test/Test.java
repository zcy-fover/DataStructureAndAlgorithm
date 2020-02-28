package com.zcyfover.dsaa.graph.test;

import com.zcyfover.dsaa.graph.pojo.GraphAdjacentList;
import com.zcyfover.dsaa.graph.pojo.Vertex;
import com.zcyfover.dsaa.graph.use.GraphUse;

import java.util.Map;
import java.util.Set;

/**
 * Created by zcy-fover on 2016/9/22.
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        //test.topologicalSortTest();
        //test.topologySortTest();
        test.breadthFirstSearchUnWeightedTest();
    }

    public void breadthFirstSearchUnWeightedTest(){
        GraphUse use = new GraphUse();
        GraphAdjacentList graph = testGraph();
        use.breadthFirstSearchUnWeighted(graph, (Vertex)graph.getVertexSet().toArray()[1]);
    }

    public void topologySortTest(){
        GraphUse use = new GraphUse();
        use.topologySort(testGraph());
    }

    public void topologicalSortTest(){
        GraphUse use = new GraphUse();
        Vertex[] sortedVertex = use.topologicalSort(testGraph());
        printVertex(sortedVertex);
    }

    public GraphAdjacentList testGraph(){

        GraphAdjacentList graph = new GraphAdjacentList();
        Set<Vertex> vertexSet = graph.getVertexSet();
        Map<Vertex, Vertex[]> edgeMap = graph.getAdjacency();

        Vertex oneVertex = new Vertex("1");
        Vertex twoVertex = new Vertex("2");
        Vertex threeVertex = new Vertex("3");
        Vertex fourVertex = new Vertex("4");
        Vertex fiveVertex = new Vertex("5");
        Vertex sixVertex = new Vertex("6");
        Vertex sevenVertex = new Vertex("7");

        oneVertex.setInDegree(0);
        twoVertex.setInDegree(1);
        threeVertex.setInDegree(2);
        fourVertex.setInDegree(3);
        fiveVertex.setInDegree(1);
        sixVertex.setInDegree(3);
        sevenVertex.setInDegree(2);

        vertexSet.add(oneVertex);
        vertexSet.add(twoVertex);
        vertexSet.add(threeVertex);
        vertexSet.add(fourVertex);
        vertexSet.add(fiveVertex);
        vertexSet.add(sixVertex);
        vertexSet.add(sevenVertex);

        edgeMap.put(oneVertex, new Vertex[] { twoVertex, threeVertex, fourVertex });
        edgeMap.put(twoVertex, new Vertex[] { fourVertex, fiveVertex });
        edgeMap.put(threeVertex, new Vertex[] { sixVertex });
        edgeMap.put(fourVertex, new Vertex[] { threeVertex, sixVertex, sevenVertex });
        edgeMap.put(fiveVertex, new Vertex[] { fourVertex, sevenVertex });
        edgeMap.put(sixVertex, new Vertex[]{ });
        edgeMap.put(sevenVertex, new Vertex[]{ sixVertex });

        return graph;
    }

    public void printVertex(Vertex[] Vertexs) {
        for (Vertex vertex : Vertexs) {
            System.out.println(vertex.getInfo() + "  discover time:"
                    + vertex.getDiscover() + "  finish time:"
                    + vertex.getFinish());
        }
    }
}
