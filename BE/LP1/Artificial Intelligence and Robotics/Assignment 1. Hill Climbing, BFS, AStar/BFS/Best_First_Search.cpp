#include "iostream"
#include "map"
#include "deque"
#include "algorithm"
#include "string.h"
using namespace std;

class Node {
    public:
    int vertex;
    int parent;
    int value;
    
};

bool sort_by_value(Node a, Node b) {
    if(a.value < b.value) return true;
    else return false;
}

int main() {
    int n;
    cout<<"Enter the number of vertices of Graph: ";
    cin>>n;
    int graph[n+1][n+1];
    int heuristic[n+1];
    memset(graph,0,sizeof(graph));
    cout<<"Enter the edges (start, end, cost):\n";
    int start, end, cost;
    char ch;
    do {
        cin>>start>>end>>cost;
        graph[start][end]=cost;
        // graph[end][start]=1;
        // cout<<"More vertices to enter ? (y/n):";
        // cin>>ch;
    } while(start != 0 && end != 0);

    // for(int i=0;i<n;i++) {for(int j=0;j<n;j++) cout<<graph[i+1][j+1]<<" "; cout<<endl;}

    cout<<"Enter the Start node and the Goal Node: ";
    cin>>start>>end;

    cout<<"Enter Heuristic value of each node: ";
    for(int i=0;i<n;i++) {
        cin>>heuristic[i+1];
    }

    int current=start,parent;
    map<int,int> closed_list;
    deque<Node> open_list;
    Node node;
    node.vertex=current;
    node.parent=current;
    node.value=heuristic[current];
    open_list.push_back(node);
    // closed_list[current]=current;
    while(current!=end) {
        sort(open_list.begin(),open_list.end(),sort_by_value);
        node = open_list.front();
        open_list.pop_front();
        current=node.vertex;
        parent=node.parent;
        for(int i=1;i<=n;i++) {
            if(graph[current][i] != 0 && !closed_list[i]) {
                node.vertex=i;
                node.parent=current;
                node.value=heuristic[i];
                open_list.push_back(node);
            }
        }
        closed_list[current]=parent;
    }
    cout<<"\nTraced the path: ";
    int total_cost=0;
    while(current != start) {
        cout<<current<<"<-";
        total_cost += graph[closed_list[current]][current];
        current=closed_list[current];
    }
    cout<<current;
    cout<<" with total cost="<<total_cost<<endl;

    


    return 0;
} 