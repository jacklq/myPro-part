package LQdemo;
//基本原理：

/**
 * // 迪杰斯特拉算法是一种贪心算法。
 * //   首先建立一个集合，初始化只有一个顶点。每次将当前集合的所有顶点（初始只有一个顶点）看成一个整体，
 * //   找到集合外与集合距离最近的顶点，将其加入集合并检查是否修改路径距离（比较在集合内源点到达目标点中各个路径的距离，取最小值）
 * //   以此类推，直到将所有点都加入集合中。得到的就是源点到达各顶点最短距离。时间复杂度为 O(n^2)。
 * //  1-从初始weight矩阵中找到start对应的行，找到最近的一个点如x，以x为转折点，更新start点对应到各点的距离,设x点已经被访问了
 * //   2-再从被更新的weight矩阵中start对应的行中的没被访问的最近的点y，以y为转折点，更新start点对应到各点的距离,设y点已经被访问了
 * //    3-重复1和2过程共n-1次，n为总的点数
 */

//  变量解释：
//      1、采用图的邻接矩阵存储结构；
//      2、辅助数组visited[n] ：表示当前顶点的最短路径是否求出，1表示求出；
//      3、辅助数组path[n] ：记录路径，字符串类型；
//      4、返回结果shortPath[n]

//
//step
//    1:变量定义及初始化
//    2：加入n-1个顶点，for循环
//        3：找到最近的且没被找过的，获取坐标和值
//        4：更新最短路径和坐标
//        5： 以k为中间点，修正从start到未访问各点的距离，更新weight矩阵的值
public class Dijkstra {
    public static final int M = 10000; // 代表正无穷

    //案例演示
    public static int[] dijkstra(int[][] weight, int start) {
        // 接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
        // 返回一个int[] 数组，表示从start到它的最短路径长度
        int n = weight.length; // 顶点个数
        int[] shortPath = new int[n]; // 保存start到其他各点的最短路径
        int[] visited = new int[n]; // 标记当前该顶点的最短路径是否已经求出,1表示已求出
        String[] path = new String[n]; // 保存start到其他各点最短路径的字符串表示
        for (int i = 0; i < n; i++)
            path[i] = start + "-->" + i;


        // 初始化，第一个顶点已经求出
        shortPath[start] = 0;
        visited[start] = 1;

        for (int count = 1; count < n; count++) { // 要加入n-1个顶点
            int k = -1; // 选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {/*找到最近的且没被找过的*/
                if (visited[i] == 0 && weight[start][i] < dmin) {
                    dmin = weight[start][i];
                    k = i;
                }
            }

            // 将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;
            visited[k] = 1;

            // 以k为中间点，修正从start到未访问各点的距离
            for (int i = 0; i < n; i++) {
                //如果 '起始点到当前点距离' + '当前点到某点距离' < '起始点到某点距离', 则更新
                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i] = path[k] + "-->" + i;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短路径为：" + path[i]);
        }
        System.out.println("=====================================");
        return shortPath;
    }

    public static void main(String[] args) {
        // 二维数组每一行分别是 A、B、C、D、E 各点到其余点的距离,
        // A -> A 距离为0, 常量M 为正无穷
        int[][] weight1 = {
                {0, 4, M, 2, M},
                {4, 0, 4, 1, M},
                {M, 4, 0, 1, 3},
                {2, 1, 1, 0, 7},
                {M, M, 3, 7, 0}
        };

        int start = 0;

        int[] shortPath = dijkstra(weight1, start);

        for (int i = 0; i < shortPath.length; i++)
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + shortPath[i]);
    }
}