#include<iostream>
using namespace std;

int n;

class data
{
public:
	long long int arr;
	char name[100];
};

class hashing
{
int v[10];
int chain[10];
string hash[10];
long long int tel[10];
public:
	data d[10];
	int accept(int);
	int display(int);
	int hashed();
	int display_hash();
	int search();
	int ascii(char *);
};

int hashing::accept(int i)
{
	cout<<"\nenter the name of client : ";
	ws(cin);
	cin.getline(d[i].name,100);
	cout<<"\nenter the adhaar number : ";
	cin>>d[i].arr;
}

int hashing::display(int i)
{
	cout<<d[i].name<<"\t"<<d[i].arr<<endl;
}

int hashing::ascii(char *p)
{
int sum=0;
	for(int i=0;p[i]!='\0';i++)
	{
		int val=int(p[i]);
		sum=sum+val;
	}
return sum;
}

int hashing::hashed()
{
int x;
for(int i=0;i<10;i++)
{
	v[i]=0;
	hash[i]="";
	chain[i]=-1;
}

int i=0,j=0;
							//chaining without replacement
while(j<n)
{
	int mod=ascii(d[j].name)%10;
	if(v[mod]!=1)
	{
	hash[mod]=d[j].name;
	tel[mod]=d[j].arr;
	v[mod]=1;
	x=mod;
	}
	else 
	{
		while(v[mod]!=0  )
		{
		if(mod==9)
		{
		mod=0;
		}
		else
		mod++;
		}
		hash[mod]=d[j].name;
		tel[mod]=d[j].arr;
		v[mod]=1;
		chain[x]=mod;
	}
	j++;
}
}

int hashing::display_hash()
{
cout<<"\nthe hashed function is\n";
for(int i=0;i<10;i++)
{
	if(hash[i]=="")
	cout<<i<<"\t----"<<"\t"<<chain[i]<<"\t----\t"<<endl;
else
	cout<<i<<"\t"<<hash[i]<<"\t"<<chain[i]<<"\t"<<tel[i]<<endl;
}
}

int hashing::search()
{
char nm[100];
int count=0;
cout<<"\nenter the name of the person to be searched : ";
ws(cin);
cin.getline(nm,100);
int val=ascii(nm)%10;
cout<<endl<<val<<endl;
int index;

if(hash[val]==nm)
{
index=val;
count=1;
}
else
{
	for(int i=0;i<10;i++)
	{
		if(hash[i]==nm)
		{
		index=i;
		count=1;
		}
		else
		continue;
	}
}
		if(count==1)
			cout<<"\n------FOUND DETAILS------\n"<<hash[index]<<"\t"<<tel[index];
		else
			cout<<"\n--------not found----------\n";

}


int main()
{
hashing obj;
char ch,c;
int ans;
	cout<<"\nenter the number of records : ";
	cin>>n;
	if(n>10)
		cout<<"\nyou can enter maximum 10 client details\n";
	else
	{
	do
	{
	cout<<"\n1.)ACCEPT\n2.)DISPLAY DETAILS\n3.)DISPLAY HASH TABLE\n4.)SEARCH FOR ADHAAR NUMBER\n5.)EXIT\n";
	cin>>ans;
	switch(ans)
	{
	case 1:{
		for(int i=0;i<n;i++)
		obj.accept(i);
		break;
		}
	case 2:{
		for(int i=0;i<n;i++)
		obj.display(i);
		break;
		}
	case 3:{
		obj.hashed();
		obj.display_hash();
		break;
		}
	case 4:{
		obj.search();
		break;
		}
	case 5:continue;
	default:	cout<<"\ninvalid entry...try again\n";
	}
	cout<<"\ndo you want to continue?(y/n)\n";
	cin>>c;
	}while(c=='y' || c=='Y');
	}
}

/*

enter the number of records : 5

1.)ACCEPT
2.)DISPLAY DETAILS
3.)DISPLAY HASH TABLE
4.)SEARCH FOR ADHAAR NUMBER
5.)EXIT
1

enter the name of client : ria

enter the adhaar number : 12345678999

enter the name of client : air

enter the adhaar number : 1234567899

enter the name of client : riya

enter the adhaar number : 26874683243  

enter the name of client : neev

enter the adhaar number : 66421315646

enter the name of client : even

enter the adhaar number : 63757251555

do you want to continue?(y/n)
y

1.)ACCEPT
2.)DISPLAY DETAILS
3.)DISPLAY HASH TABLE
4.)SEARCH FOR ADHAAR NUMBER
5.)EXIT
2
ria	12345678999
air	1234567899
riya	26874683243
neev	66421315646
even	63757251555

do you want to continue?(y/n)
y

1.)ACCEPT
2.)DISPLAY DETAILS
3.)DISPLAY HASH TABLE
4.)SEARCH FOR ADHAAR NUMBER
5.)EXIT
3

the hashed function is
0	neev	1	66421315646
1	even	-1	63757251555
2	----	-1	----	
3	----	-1	----	
4	----	-1	----	
5	----	-1	----	
6	ria	 7	12345678999
7	air	-1	1234567899
8	riya	-1	26874683243
9	----	-1	----	

do you want to continue?(y/n)
y

1.)ACCEPT
2.)DISPLAY DETAILS
3.)DISPLAY HASH TABLE
4.)SEARCH FOR ADHAAR NUMBER
5.)EXIT
4

enter the name of the person to be searched : air

6

------FOUND DETAILS------
air	1234567899
do you want to continue?(y/n)
y

1.)ACCEPT
2.)DISPLAY DETAILS
3.)DISPLAY HASH TABLE
4.)SEARCH FOR ADHAAR NUMBER
5.)EXIT
5
*/






