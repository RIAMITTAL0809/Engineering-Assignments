
#include<iostream>
using namespace std;

typedef struct  Node
{
	 public:
	int prn ;
	char name[100];
	struct Node *next;
}node;

node *head;

typedef struct  Node1
{
	 public:
	int prn1 ;
	char name1[100];
	struct Node1 *next1;
}node1;

node1 *head1;


class list:public Node,public Node1
{
public:
node *temp,*New,*prev;

public :
	node create()
	{
	
	char choice;
	
	int val,flag=1;
	temp=NULL;

do
{
New =new node;
New->next=NULL;
cout<<"\nenter PRN number\n";
cin>>New->prn;
cout<<"\nenter name \n";
cin>>New->name;
if(flag==1)
{
head=New;
temp=head;
flag=0;
}
else
{
temp->next=New;
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
cout<<temp->prn<<"\t"<<temp->name<<endl;
temp=temp->next;
}
}

void insert_president()
{
New=new node;
cout<<"\nenter name of the president\n";
cin>>New->name;
cout<<"\nenter prn of president\n";
cin>>New->prn;
if(head==NULL)
{
head=New;
}
else
{
New->next=head;
head=New;
}
}


void insert_secretary()
{
New=new node;
cout<<"\nenter the name of the secretary\n";
cin>>New->name;
cout<<"\nenter the prn number of secretary\n";
cin>>New->prn;
if(head==NULL)
{
head=New;
}
else
{
temp=head;
while(temp->next!=NULL)
{
temp=temp->next;
}
temp->next=New;
New->next=NULL;
}
}

void insert_member(node *head)
{
int key;
New=new node;
New->next=NULL;
cout<<"\nenter the prn of new member\n";
cin>>New->prn;
cout<<"\nenter the name of new member\n";
cin>>New->name;
if(head==NULL)
{
 head=New;
}
else
cout<<"\nenter the prn after which you want to insert new member\n";
cin>>key;
temp=head;
do
{

if(temp->prn==key)
{
New->next=temp->next;
temp->next=New;
break;
}
else
{
temp=temp->next;
}
}while(temp!=NULL);
}

void delete_president()
{
	temp=head;
	head=head->next;
	delete temp;
	cout<<"\nPresident removed...\n";	
}

void delete_secretary()
{
	temp=head;
	while(temp->next->next!=NULL)
	temp=temp->next;
	delete temp->next;
	temp->next=NULL; 
	cout<<"\nsecretary removed...\n";
}

void delete_member()
{
	int key;
	prev=new node;
	temp=head;
	cout<<"\nenter the prn of member you want to remove\n";
	cin>>key;
	while(temp!=NULL)
	{
		if(temp->prn==key)
		break;
		prev=temp;
		temp=temp->next;
	}
	if(temp==NULL)
	cout<<"\nnode not found\n";
	else
	{
		if(temp==head)
		head=temp->next;
		else
		prev->next=temp->next;
		delete temp;
		cout<<"\nthe member is removed\n";
		
	}
}


void reverse_list(node *head)
{
	node *curr;
	curr=head;
	if(curr==NULL)
	return;
	
	reverse_list(curr->next);
	cout<<curr->prn<<"\t\t\t"<<curr->name<<endl;
}


int total_members()
{
	int count1=0;
	temp=head;
	while(temp!=NULL)
	{
		count1++;
		temp=temp->next;
	}
	cout<<"\ntotal member in the pinnacle club are:  "<<count1<<endl;
}


public:
node1 *temp1,*New1,*prev1;

public :
	node1 create1()
	{
	
	char choice1;
	
	int val1,flag1=1;
	temp1=NULL;

do
{
New1 =new node1;
New1->next1=NULL;
cout<<"\nenter PRN number\n";
cin>>New1->prn1;
cout<<"\nenter name \n";
cin>>New1->name1;
if(flag1==1)
{
head1=New1;
temp1=head1;
flag1=0;
}
else
{
temp1->next1=New1;
temp1=New1;
}
cout<<"\ndo you want to add a new member?(y/N)\n";
cin>>choice1;
}
while(choice1=='Y' ||choice1=='y');

}

void display1()
{
temp1=head1;
while(temp1!=NULL)
{
cout<<temp1->prn1<<"\t"<<temp1->name1<<endl;
temp1=temp1->next1;
}
}

void insert_president1()
{
New1=new node1;
cout<<"\nenter name of the president\n";
cin>>New1->name1;
cout<<"\nenter prn of president\n";
cin>>New1->prn1;
if(head1==NULL)
{
head1=New1;
}
else
{
New1->next1=head1;
head1=New1;
}
}


void insert_secretary1()
{
New1=new node1;
cout<<"\nenter the name of the secretary\n";
cin>>New1->name1;
cout<<"\nenter the prn number of secretary\n";
cin>>New1->prn1;
if(head1==NULL)
{
head1=New1;
}
else
{
temp1=head1;
while(temp1->next1!=NULL)
{
temp1=temp1->next1;
}
temp1->next1=New1;
New1->next1=NULL;
}
}

void insert_member1(node1 *head1)
{
int key1;
New1=new node1;
New1->next1=NULL;
cout<<"\nenter the prn of new member\n";
cin>>New1->prn1;
cout<<"\nenter the name of new member\n";
cin>>New1->name1;
if(head1==NULL)
{
 head1=New1;
}
else
cout<<"\nenter the prn after which you want to insert new member\n";
cin>>key1;
temp1=head1;
do
{

if(temp1->prn1==key1)
{
New1->next1=temp1->next1;
temp1->next1=New1;
break;
}
else
{
temp1=temp1->next1;

}
}while(temp1!=NULL);
}

void delete_president1()
{
	temp1=head1;
	head1=head1->next1;
	delete temp1;
	cout<<"\nPresident removed...\n";	
}

void delete_secretary1()
{
	temp1=head1;
	while(temp1->next1->next1!=NULL)
	temp1=temp1->next1;
	delete temp1->next1;
	temp1->next1=NULL;
	cout<<"\nsecretary removed...\n";
}

void delete_member1()
{
	int key1;
	prev1=new node1;
	temp1=head1;
	cout<<"\nenter the prn of member you want to remove\n";
	cin>>key1;
	while(temp1!=NULL)
	{
		if(temp1->prn1==key1)
		break;
		prev1=temp1;
		temp1=temp1->next1;
	}
	if(temp1==NULL)
	cout<<"\nnode not found\n";
	else
	{
		if(temp1==head1)
		head1=temp1->next1;
		else
		prev1->next1=temp1->next1;
		delete temp1;
		cout<<"\nthe member is removed\n";
		
	}
}

int total_members1()
{
	int count11=0;
	temp1=head1;
	while(temp1!=NULL)
	{
		count11++;
		temp1=temp1->next1;

	}
	cout<<"\ntotal member in the pinnacle club are:  "<<count11<<endl;
}


void reverse_list1(node1 *head1)
{
	node1 *curr1;
	curr1=head1;
	if(curr1==NULL)
	return;
	
	reverse_list1(curr1->next1);
	cout<<curr1->prn1<<"\t\t\t"<<curr1->name1<<endl;
}

/*
	void concat()
	{
	node *temp;
	temp=head;
	node1 *curr;
	curr=head1;
	while(temp->next!=NULL )
	{
		temp=temp->next;
	}
	temp->next=curr;
	}
*/

};


int main()
{
cout<<"\n\nWELCOME TO PINNACLE CLUB OF COMPUTER DEPARTMENT\n\n";
list obj;

int ans,ans1;
char a,a1,a2;
cout<<"\nenter the mebers of A division\n";
obj.create();
cout<<"\nenter members of B division\n";

obj.create1();
cout<<"\n\nedit division A\n\n";
do
{
cout<<"\npress 1 to make a new president\npress 2 to make a new secretary\npress 3 to add a new member in the list\npress 4 to delete president\npress 5 to delete secrertary\npress 6 to delete a member\n";
cout<<"press 7 to reverse the list\npress 8 to display total number of members\npress 9 to display student list\n";
cin>>ans;
switch(ans)
{
case 1:obj.insert_president();break;
case 2:obj.insert_secretary();break;
case 3:obj.insert_member(head);break;
case 4:obj.delete_president();break;
case 5:obj.delete_secretary();break;
case 6:obj.delete_member();break;
case 7:obj.reverse_list(head);break;
case 8:obj.total_members();break;
case 9:obj.display();break;
default :cout<<"\ntry again....invalid choice:\n";
}



cout<<"\ndo you want to continue?(y/n)\n";
cin>>a;
}while(a=='y' || a=='Y');


cout<<"\n\nedit division B\n\n";

do
{
cout<<"\npress 1 to make a new president\npress 2 to make a new secretary\npress 3 to add a new member in the list\npress 4 to delete president\npress 5 to delete secrertary\npress 6 to delete a member\n";
cout<<"press 7 to reverse the list\npress 8 to display total number of members\npress 9 to display student list\n";
cin>>ans1;
switch(ans1)
{
case 1:obj.insert_president1();break;
case 2:obj.insert_secretary1();break;
case 3:obj.insert_member1(head1);break;
case 4:obj.delete_president1();break;
case 5:obj.delete_secretary1();break;
case 6:obj.delete_member1();break;
case 7:obj.reverse_list1(head1);break;
case 8:obj.total_members1();break;
case 9:obj.display1();break;
default :cout<<"\ntry again....invalid choice:\n";
}


cout<<"\ndo you want to continue?(y/n)\n";
cin>>a1;
}while(a1=='y' || a1=='Y');

cout<<"\ndo you want to combine both the divisions?(y/n)\n";
cin>>a2;
if(a2=='y'|| a2=='Y')
{
//obj.concat();
obj.display();
obj.display1();
}
else
cout<<"\n\nTHANK YOU FOR VISITING THE PINNACLE CLUB OF COMPUTER DEPARTMENT!!\n";

return 0;
}

