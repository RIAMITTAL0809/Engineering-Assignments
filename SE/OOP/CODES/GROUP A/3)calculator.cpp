
#include<iostream>
using namespace std;

class calculator
{

	float a,b,result;
	public:

	void getdata(int x,int y)
	{
		a=x;
		b=y;
	}
	void add()
	{
		result=a+b;
		cout<<"\nAddition : "<<result;
	}

	void sub()
	{
		result=a-b;
		cout<<"\nSubtraction : "<<result;
	}
	void mul()
	{
		result=a*b;
		cout<<"\nMultiplication : "<<result;
	}
	void div()
	{
		if(b==0)
		cout<<"\nThe Answer Is Not Defined (As b=0)";
		else
		{
			result=a/b;
			cout<<"\nDivision : "<<result;
		}
	}

};


int main()
{       
	calculator obj;
	int a1,a2,i,choice;
	char ch;
	do
	{
		cout<<"\nEnter Two Numbers : ";
		cin>>a1>>a2;
		obj.getdata(a1,a2);
		cout<<"\n______--MENU--______";
		cout<<"\n1.Addition";
		cout<<"\n2.Subtraction";
		cout<<"\n3.Multiplication";
		cout<<"\n4.Division";
		cout<<"\n\nEnter Your Choice : ";
		cin>>choice;
		switch(choice)
		{
			case 1:
			{
				obj.add();
				break;
			}
			case 2:
			{
				obj.sub();
				break;
			}
			case 3:
			{
				obj.mul();
				break;
			}
			case 4:
			{
				obj.div();
				break;
			}
			default:cout<<"\nWrong Choice";
			}
		cout<<"\n\nDo You Want To Execute The Program Again (Yes=Y) OR (No=N) : ";
		cin>>ch;
	}
	while(ch=='y'||ch=='Y');
	cout<<"\n\n\n\nThank You";
	return 0;      }

