import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_courseSchedule {
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        indeg = new int[numCourses];
        for (int[] info: prerequisites) {
            // 记录当前的课程是哪几门课程的先导课程
            edges.get(info[1]).add(info[0]);
            // 当前课程需要几门先导课
            indeg[info[0]]++;
        }

        // 用队列记录值为0，也就是先导课程的下标
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while(!queue.isEmpty()) {
            visited++;
            int u = queue.poll();
            // 拿到以当前课程为先导课程的的所有课程，将其值减一，如果为0，
            // 说明该课程需要的先导课程已经学完，进入队列，以便计算以该课
            // 程为先导课程的其他课程
            for (int v: edges.get(u)) {
                indeg[v]--;
                if(indeg[v] == 0)
                    queue.offer(v);
            }
        }
        // 如果课程的先导课程能够学完，那么就会进入队列，继续其他课程的判断
        // 所以最后判断visited的数量，也就是有几门indeg为0，进入了队列的
        // 数量是否与numCourses相等即可
        return visited == numCourses;
    }
}
