package graphs.problems;
import java.util.*;

/*
* A city is destroyed by a tornado and needs to be rebuilt.
* Conditions :
*   Every city must have a library or a road that can be repaired to a city that has a library.
*   Every road has a cost to repair, every library has a cost to build.
* Input :
*   Number of Cities -> n
*   Number of road connections possible -> m
*   Cost of building a library -> c_lib
*   Cost of repairing a road -> c_road
*   Undirected unweighted road connections that can be repaired(m).
*       Eg : if m = 5, n = 5
*               0 3     (0->3 & 3->0)
*               1 3     (1->3 & 3->1)
*               2 1     ...
*               0 4     ...
*               3 4     ...
*
* Return the minimum cost of rebuilding the city.
* */

public class RebuildCity {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
            for(int i=1;i<=n;i++){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(i, list);
            }

            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                ArrayList<Integer> list1 = hm.get(city_1);
                ArrayList<Integer> list2 = hm.get(city_2);
                if(list1 != list2){
                    list1.addAll(list2);
                    for (Integer integer : list2)
                        hm.put((int) integer, list1);
                }
            }
            long cost = 0;
            if(x<=y)
                cost = (long) n*x;
            else{
                for(ArrayList<Integer> list:hm.values()){
                    int size = list.size();
                    if(size>0){
                        cost += x;
                        cost += (size-1)*y;
                        list.clear();
                    }
                }
            }
            System.out.println(cost);
        }
    }
}
