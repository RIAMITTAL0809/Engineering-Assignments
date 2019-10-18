#include<iostream>
#define size 10
using namespace std;
static int item;

class Pizza
{
int q[10],front,rear,count,i;
public:
Pizza();
int o_full();
int o_empty();
void add();
void delete_();
void display();
};
Pizza::Pizza()
{
front=-1;
rear=-1;
i=0;
}
int Pizza::o_full()
{
if(front==(rear+1)%size)
return 1;
else
return 0;
}
int Pizza::o_empty()
{
if(front==-1)
return 1;
else
return 0;
}


void Pizza::add()
{
	int id;
if(o_full())
cout<<"\nMaximum orders reached";
else
{
if(o_empty())
front=rear=0;
else
rear=(rear+1)%size;
q[rear]=i;
i++;
cout<<"\nenter the order ID:\n";
cin>>id;
cout<<"\nYour order is placed";
cout<<"\nyour order number is "<<i-1;
}
}
void Pizza::delete_()
{
if(o_empty())
cout<<"\nCurrently No Orders Are Placed";
else
{
i=q[front];
if(front==rear)
front=rear=-1;
else
front=(front+1)%size;
cout<<"\n Bon Appetit!!! ";
}
}
void Pizza::display()
{
if(o_empty())
{
cout<<"\nCurrently No Orders Are Placed";
}
else
{
cout<<"\nOrders : ";
i=front;
while(i!=rear)
{
cout<<q[i]<<"\t";
i=(i+1)%size;
}
cout<<q[i];
}
}
int main()
{
int choice;
char ch;
Pizza obj;
cout<<"\n\n---------------WELCOME TO PIZZA PARLOUR----------------\n\n\n";
 	cout<<"\n\n----------MENU----------  \n\n";
 	cout<<"\n\tID\t\t\tPIZZA NAME\n\n";
 	cout<<"\n\t1\t\t\tVEG.PIZZA";
 	cout<<"\n\t2\t\t\tVEG.PANEER PIZZA";
 	cout<<"\n\t3\t\t\tPEPPY PANEER PIZZA";
 	cout<<"\n\t4\t\t\tFARMHOUSE PIZZA";
 	cout<<"\n\t5\t\t\tSMOKIES FIVE PIZZA";
 	cout<<"\n\t6\t\t\tCOUNTRY SPECIAL PIZZA";
 	cout<<"\n\t7\t\t\tHAPPY HAPPY PIZZA\n\n";
 	cout<<"\nmaximum number of orders that can be placed are "<<size<<endl<<endl;
do
{
	
cout<<"Enter your choice \n1.Place the Order \n2.Serve the Order\n3.Display the Orders \n";
cin>>choice;
switch(choice)
{
case 1: item=0;
obj.add();
break;
case 2: obj.delete_();
break;
case 3: obj.display();
break;
default:
cout<<"\nWrong Choice";
break;
}
cout<<"\n\nDo you want to Continue...?(y/n) ";
cin>>ch;
}while(ch=='y'||ch=='Y');
return 0;
}
