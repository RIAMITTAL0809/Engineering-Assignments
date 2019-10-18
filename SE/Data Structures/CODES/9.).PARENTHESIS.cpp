#include<iostream>
#include<stack>
using namespace std;

class parenthesis
{
public:
bool pairing(char a,char b)
{
	if(a=='('&&b==')')
	return true;
	if(a=='['&&b==']')
	return true;
	if(a=='{'&&b=='}')
	return true;
	else
	return false;
}

bool Balance(string exp)
{
	stack<char> s;
	int i;
	
	for(i=0;i<exp.length();i++)
	{
		if(exp[i]=='('||exp[i]=='['||exp[i]=='{')
			s.push(exp[i]);
			
		else if(exp[i]==')'||exp[i]==']'||exp[i]=='}')
		{
			if(s.empty()||!pairing(s.top(),exp[i]))
			return false;
			else
			s.pop();
		}
	}
	
	return s.empty()?true:false;
	
}
};


int main()
{
	parenthesis obj;
	char exp[100];
	char ch;
	do
	{
		cout<<"\nENTER THE EXPRESSION\n";
		cin>>exp;
		if(obj.Balance(exp)==false)
		cout<<"\nEXPRESSION ENTERED IS NOT BALANCED WITH RESPECT TO BRACES\n";
		else
		cout<<"\nEXPRESSION ENTERED IS BALANCED\n";
		cout<<"\ndo you want to continue?\n";
		cin>>ch;
		
	}while(ch=='y'|| ch=='Y');
	
}
