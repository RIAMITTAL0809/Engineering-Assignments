/*
write a c++ program  to store a set of positive and negative numbers using link list.
write functions to 
1) insert numbers
2) delete node with negative numbers
3) create two more link lists using this list,one containing all positive numbers and the other containing all negatie numbers.
4) for the two lists that are sorted,merge these two lists into a third one that is sorted.
*/



#include<iostream>
using namespace std;

class Node
{
public:
int data;
Node *next,*temp,*New,*head,*curr,*prev,*var;
};

class Positive
{
	public : 
	int pos;
	Positive *Next,*Head,*temp1,*new1,*curr1;
};


class Negative
{
	public : 
	int neg;
	Negative *Next1,*Head1,*temp2,*new2,*curr2;
};

class link:public Node,public Positive,public Negative
{
public:


void create()
{
//Node node;
	head=temp=NULL;
	char choice;
	
	int flag=1;

	do
	{
		New=new Node;
		New->next=NULL;
		cout<<"\nenter the data:\n";
		cin>>New->data;
	if(flag==1)
	{
		head=New;
		temp=head;
		flag=0;
	}
	else
	{
		temp->next=New;
	//	temp=temp->next;		//added extra
		temp=New;
	}
	cout<<"\ndo you want to add a new member?(y/N)\n";
	cin>>choice;
	}
	while(choice=='Y' ||choice=='y');
}

void display()
{
	temp=head;
	while(temp!=NULL)
	{
		cout<<temp->data<<endl;
		temp=temp->next;
	}
}


void delete_negative()
{	
	temp=head;
	if(head->data<0)
	{
		if(head->next==NULL)
		{
			cout<<"\nthere is only one node in list which is being deleted...\nnow list is empty\n\n";
			//delete head;	//added extra;
		}
		temp=head;
		head=head->next;
		delete temp;
	}
	
	var=head;
	while(var!=NULL)
	{
	temp=head;
	prev=head;
	while(temp!=NULL)
	{
		if(temp->data<0)
		break;
		prev=temp;
		temp=temp->next;
		
	}
	if(temp==NULL)
	{
		cout<<"\nlist empty!!\n";
		break;
		
	}
	else
	{
		if(temp==head)
		head=temp->next;
		else
		prev->next=temp->next;
		delete temp;
		
	}
	var=var->next;
}
}
	
	


public:
void New_listp()
{
   temp=head;
	temp1=Head=NULL;
	int flag=1;
	while(temp!=NULL)
	{
		if(temp->data>=0)
		{
			new1=new Positive;
			new1->Next=NULL;
			new1->pos=temp->data;
		if(flag==1)
		{
			Head=new1;
			temp1=Head;
			flag=0;
		}
		else
		{
			temp1->Next=new1;
			temp1=new1;
		}	
		}

	temp=temp->next;
		
	}
}


void dispositive()
{
temp1=Head;
while(temp1!=NULL)
	{
		cout<<temp1->pos<<endl;
		temp1=temp1->Next;
	}
}

void New_listn()
{
   temp=head;
	temp2=Head1=NULL;
	int flag=1;
	while(temp!=NULL)
	{
		if(temp->data<0)
		{
			new2=new Negative;
			new2->Next1=NULL;
			new2->neg=temp->data;
		if(flag==1)
		{
			Head1=new2;
			temp2=Head1;
			flag=0;
		}
		else
		{
			temp2->Next1=new2;
			temp2=new2;
		}	
		}

	temp=temp->next;
		
	}
	
}

void disnegative()
{
temp2=Head1;
while(temp2!=NULL)
	{
		cout<<temp2->neg<<endl;
		temp2=temp2->Next1;
	}
}


void sort_positive()
{
int count=0,t;

while(temp1!=NULL)
{
count++;
temp1=temp1->Next;
}

temp1=Head;

while(temp1!=NULL)
{
curr1=Head;
	 while(curr1->Next!=NULL)
	{

		if(temp1->pos < curr1->pos)
		{
			t=temp1->pos;
			temp1->pos=curr1->pos;
			curr1->pos=t;
		}
		
		curr1=curr1->Next;
	}
temp1=temp1->Next;
}
}


void sort_negative()
{
int count=0,t;

while(temp2!=NULL)
{
count++;
temp2=temp2->Next1;
}

temp2=Head1;

while(temp2!=NULL)
{
curr2=Head1;
	 while(curr2->Next1!=NULL)
	{

		if(temp2->neg < curr2->neg)
		{
			t=temp2->neg;
			temp2->neg=curr2->neg;
			curr2->neg=t;
		}
		
		curr2=curr2->Next1;
	}
temp2=temp2->Next1;
}
}
};



int main()
{
link obj;
char ans;
int n;
obj.create();
cout<<"\nyour entered list is:\n";
obj.display();
do
{
	cout<<"\nenter 1 to display list after deletion of negative numbers\n";
	cout<<"\nenter 2 to create only positive number list\n";
	cout<<"\nenter 3 to create only negative number list\n";
	cout<<"\nenter 4 to display sorted positive list\n";
	cout<<"\nenter 5 to display sorted negative list\n";
	cin>>n;
	switch(n)
	{
		case 1:obj.delete_negative();cout<<"\n list after deleting negaive elements is:\n";obj.display();break;
		case 2:obj.New_listp();cout<<"\npositive number list is:\n";obj.dispositive();break;
		case 3:obj.New_listn();cout<<"\nNegative number list is:\n";obj.disnegative();break;
		case 4:obj.New_listp();obj.sort_positive();cout<<"\nthe sorted positive list is:\n";obj.dispositive();break;
		case 5:obj.New_listn();obj.sort_negative();cout<<"\nthe sorted negative list is:\n";obj.disnegative();break;
		default:cout<<"\ninvalid choice!!try again!!\n";
	}
	cout<<"\ndo you want to continue ?(y/n)\n";
	cin>>ans;
}while(ans=='y' || ans=='Y');
return 0;
}



/*
enter the data:
1

do you want to add a new member?(y/N)
y

enter the data:
-2

do you want to add a new member?(y/N)
y
enter the data:
-3
do you want to add a new member?(y/N)
y
enter the data:
4
do you want to add a new member?(y/N)
y
enter the data:
5
do you want to add a new member?(y/N)
y
enter the data:
-6
do you want to add a new member?(y/N)
y
enter the data:
-7
do you want to add a new member?(y/N)
y
enter the data:
8
do you want to add a new member?(y/N)
y
enter the data:
-9
do you want to add a new member?(y/N)
y
enter the data:
-10
do you want to add a new member?(y/N)
y
enter the data:
-11
do you want to add a new member?(y/N)
n
your entered list is:
1
-2
-3
4
5
-6
-7
8
-9
-10
-11

enter 1 to display list after deletion of negative numbers

enter 2 to create only positive number list

enter 3 to create only negative number list

enter 4 to display sorted positive list

enter 5 to display sorted negative list
2

positive number list is:
1
4
5
8

do you want to continue ?(y/n)
y

enter 1 to display list after deletion of negative numbers

enter 2 to create only positive number list

enter 3 to create only negative number list

enter 4 to display sorted positive list

enter 5 to display sorted negative list
3

Negative number list is:
-2
-3
-6
-7
-9
-10
-11

do you want to continue ?(y/n)
y

enter 1 to display list after deletion of negative numbers

enter 2 to create only positive number list

enter 3 to create only negative number list

enter 4 to display sorted positive list

enter 5 to display sorted negative list
4

the sorted positive list is:
1
4
5
8

do you want to continue ?(y/n)
y

enter 1 to display list after deletion of negative numbers

enter 2 to create only positive number list

enter 3 to create only negative number list

enter 4 to display sorted positive list

enter 5 to display sorted negative list
5

the sorted negative list is:
-11
-10
-9
-7
-6
-3
-2

do you want to continue ?(y/n)
y

enter 1 to display list after deletion of negative numbers

enter 2 to create only positive number list

enter 3 to create only negative number list

enter 4 to display sorted positive list

enter 5 to display sorted negative list
1

 list after deleting negaive elements is:
1
4
5
8

do you want to continue ?(y/n)
y

enter 1 to display list after deletion of negative numbers

enter 2 to create only positive number list

enter 3 to create only negative number list

enter 4 to display sorted positive list

enter 5 to display sorted negative list
2

positive number list is:
1
4
5
8

do you want to continue ?(y/n)
y

enter 1 to display list after deletion of negative numbers

enter 2 to create only positive number list

enter 3 to create only negative number list

enter 4 to display sorted positive list

enter 5 to display sorted negative list
3

Negative number list is:

do you want to continue ?(y/n)
y

enter 1 to display list after deletion of negative numbers

enter 2 to create only positive number list

enter 3 to create only negative number list

enter 4 to display sorted positive list

enter 5 to display sorted negative list
5

the sorted negative list is:

do you want to continue ?(y/n)
n
*/














