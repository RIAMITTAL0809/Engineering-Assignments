#include "iostream"
#include "vector"
#include "algorithm"
#include "string.h"
using namespace std;

bool sort_by_heuristic(pair<int,int> a, pair<int,int> b) {
    if(a.second < b.second) return true;
    else return false;
}

int main() {
    int n;
    cout<<"Enter the number of vertices of Graph: ";
    cin>>n;
    int graph[n+1][n+1];
    int heuristic[n+1];
    memset(graph,0,sizeof(graph));
    cout<<"Enter the edges:\n";
    int start, end;
    char ch;
    do {
        cin>>start>>end;
        graph[start][end]=1;
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

    int current=start;
    vector<pair<int,int> > open_list;
    vector<int> close_list;
    close_list.push_back(current);
    while(current != end) {
        for(int i=0;i<n;i++) {
            if(graph[current][i+1] == 1) {
                open_list.push_back(make_pair(i+1,heuristic[i+1]));
            }
        }
        
        sort(open_list.begin(),open_list.end(), sort_by_heuristic);
        // for(int i=0;i<queue.size();i++) cout<<queue[i].first<<" "<<queue[i].second<<"=="<<endl;
        if(open_list[0].second < heuristic[current]) {
            current=open_list[0].first;
            open_list.clear();
            close_list.push_back(current);
        } else {
            break;
        }
    }
    
    bool local_maxima=false;
    cout<<"\nTraced the path: ";
    for(int i=0;i<close_list.size();i++) {
        cout<<close_list[i]<<"->";
        if(i==close_list.size()-1 && close_list[i] != end) local_maxima=true; 
    }
    if(local_maxima) cout<<" and stuck on Local Maxima\n";
    else cout<<" and reached the Goal Node\n";
    

    return 0;
} 