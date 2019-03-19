// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-->0) {//注意while处理多个case
            int n=sc.nextInt();
            ArrayList<Integer>[] G=new ArrayList[n+1];
            for(int i=0;i<=n;i++){
                G[i]=new ArrayList<Integer>();
            }
            for(int i=0;i<n-1;i++){
                int u=sc.nextInt();
                int v=sc.nextInt();
                G[u].add(v);
                G[v].add(u);
            }
            int[] Hmax=new int[1];
            ArrayList<Integer> list1=new ArrayList<>();
            deal(G,list1,Hmax,1,1,1);
            ArrayList<Integer> list2=new ArrayList<>();
            deal(G,list2,Hmax,list1.get(0),1,list1.get(0));
            System.out.println(Hmax[0]-1);

        }
    }
    static void deal(ArrayList<Integer>[] G,ArrayList<Integer> list,int[] Hmax,int cur,int h,int pre){
        if(h>Hmax[0]){
            Hmax[0]=h;
            list.clear();
            list.add(cur);
        }else if(h==Hmax[0]){
            list.add(cur);
        }
        for(int x:G[cur]){
            if(x==pre) continue;
            deal(G,list,Hmax,x,h+1,cur);
        }
    }
}