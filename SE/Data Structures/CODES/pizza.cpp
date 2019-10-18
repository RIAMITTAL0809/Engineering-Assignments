/*Pizza parlor accepting maximum M orders. Orders are served in first come first served basis.
 Order once placed can not be cancelled. 
Write C++ program to simulate the system using circular queue using array*/

#include<iostream>
using namespace std;

struct queue
{
	int id[10];
	int front,rear;
}q;
int size;
class que
{
	public:
		int full();
		int empty();
		int enqueue(int);
		int deque();
		int display();	
};

int que::full()
{
	if(q.front==(q.rear+1)%size)
	return 1;
	else
	return 0;
}
int que::empty()
{
	if(q.rear==q.front==-1)
	return 1;
	else
	return 0;
}
int que::enqueue(int elem)
{
	if(full())
	cout<<"\nqueue is full\n";
	if(empty())
	{
		q.front=q.rear=0;
	}
	else
	{
		q.rear=(q.rear+1)%size;
	}
	q.id[q.rear]=elem;
}
int que::deque()
{
	int x=q.id[q.front];
	
	if(empty())
	cout<<"\nqueue is empty\n";
	if(q.rear==q.front)
	q.front=q.rear=-1;
	else
	{
		q.front=(q.front+1)%size;
	}
}
int que::display()
{
	
	if(empty())
	cout<<"\nno orders are placed\n";
	else
	{
	int i=q.front;
	while(i!=q.rear)
	{
		cout<<q.id[i]<<"\t";
		i=(i+1)%size;
	}
	cout<<q.id[i]<<endl;
}
}
int main()
{
	que obj;
	int id;
	cout<<"\nenter the number of elements \n";
	cin>>size;
	for(int i=0;i<size;i++)
	{
		cout<<"\n----new id---\n";
		cin>>id;
		obj.enqueue(id);
	}
	//obj.deque();
	obj.display();
}
