/*
Queues are frequently used in computer programming, and a typical example is the creation
of a job queue by an operating system. If the operating system does not use priorities, then
the jobs are processed in the order they enter the system. Write C++ program for simulating
*/

#include<iostream>
using namespace std;

struct queue
{
	int job[100];
	int rear,front;
	
}q;

int num;

class que
{
	q.front=q.rear=-1;
	public:
		int accept(int);
		int display();
		int full();
		int empty();

};

int que::full()
{
	if(q.rear==num-1)
	return 1;
	else
	return 0;
}
int que::empty()
{
	if(q.front==q.rear==-1)
	return 1;
	else
	return 0;
}
int que::accept(int elem)
{
	if(full())
	{
		cout<<"\nqueue is full\n";
	}
	else if(q.rear==-1)
	{
		q.front++;
		q.job[++q.rear]=elem;
	}
	else
	{
		q.job[++q.rear]=elem;
	}
}
int main()
{
	que obj;
	int id;
	cout<<"\nenter number of job ids \n";
	cin>>num;
	for(int i=0;i<num;i++)
	{
		cout<<"\n-----new id----\n";
		cin>>id;
		obj.accept(id);
	}
}

