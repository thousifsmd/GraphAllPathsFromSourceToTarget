class AllPaths {
    
    List<List<Integer>> result = new LinkedList<>(new ArrayList<>());
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        if(graph.length == 0) return null;
        
        
        Queue<List<Integer>> queue = new LinkedList<>(new ArrayList<>());
        
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.offer(path);
        
        bfs(queue, graph);
        
        return result;
    }
    
    public void bfs(Queue<List<Integer>> queue, int[][] graph) {
        
        int size = queue.size();
        //System.out.println(size);
        int node;
        
        List<Integer> path = new ArrayList<>();
        
        for(int i=0; i<size; i++) {

            path = queue.poll();
            node = path.get(path.size()-1);
            
            //System.out.println("processing path: " + path);
            if(node == graph.length-1) {
                result.add(path);
                continue;
            }
            
            //System.out.println("Size of node: " + node + " - " + graph[node].length);
            
            for(int j=0; j<graph[node].length; j++) {
                
                List<Integer> tempPath = new ArrayList<>(path);
                
                if(!tempPath.contains(graph[node][j])) {
                    tempPath.add(graph[node][j]);
                    queue.offer(tempPath);
                    //System.out.println(tempPath);
                }
            }            
        }
        
        if(!queue.isEmpty()) {
            bfs(queue, graph);
        }
        
        
    }
}
