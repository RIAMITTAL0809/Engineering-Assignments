
#include<iostream>
using namespace std;
class except
{
public:
 int age()
{
int age1;
cout<<"\nenter your age\n";
cin>>age1;
		try
{
	if(age1<18 || age1>55)
	{
	throw age1;
	}
	else
	{
	cout<<"\nyour age is :"<<age1<<endl;
	}
}
	catch(int)
	{
	cout<<"\nexception :age is: "<<age1<<endl;
	}
}
double income1()
{
double income;
cout<<"\nenter your income:\n";
cin>>income;
try
{
if(income<50000 || income>100000)
throw income;
else
cout<<"\nyour income is :"<<income<<endl;
}
catch(double)
{
cout<<"\nexception: income is: "<<income<<endl;
}
}
void city1()
{
string city;
cout<<"\nenter the city:\n";
cin>>city;
try
{
if(city=="pune" || city=="chennai" || city=="bangalore" || city=="mumbai")
cout<<"\nyour city is : "<<city<<endl;
else
throw city;
}
catch(string)
{
cout<<"\nexception: your city is: "<<city<<endl;
}
}
int vehicle()
{
int num;
cout<<"\nenter the type of vehicle you have: 2 wheeler or 4 wheeler?\n";
cin>>num;
try
{
if(num==2)
throw num;
else if(num==4)
cout<<"\nyour vehicle is a "<<num<<" wheeler \n";
else
cout<<"\ninvalid choice....try again\n";
}
catch(int)
{
cout<<"\nexception : you have a 2 wheeler!!\n";
}
}
};


int main()
{
	int ch;
	char c;
except obj;
do
{
cout<<"\n1.age\n2.income\n3.city\n4.vehicle\n";
cin>>ch;
switch(ch)
{
case 1:obj.age();break;
case 2:obj.income1();break;
case 3:obj.city1();break;
case 4:obj.vehicle();break;
default:cout<<"\ninvalid choice...try again\n";
}
cout<<"\ndo you want to try again?(y/n)\n";
cin>>c;
}while(c=='y' || c=='Y');
return 0;
}

