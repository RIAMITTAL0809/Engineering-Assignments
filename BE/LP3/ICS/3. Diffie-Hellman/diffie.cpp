#include<iostream>
using namespace std;
long long int power(int a, int b, int mod)
{
	long long int t;
	if(b==1)
	return a;
	t=power(a,b/2,mod);
	if(b%2==0)
	return (t*t)%mod;
	else
	return (((t*t)%mod)*a)%mod;
}
long int calculateKey(int a, int x, int n)
{
	return power(a,x,n);
}
int main()
{
	int p,g,x,a,y,b;
	
	cout<<"\nEnter the value of p: ";
	cin>>p;
	cout<<"\nEnter the value of g: ";
	cin>>g;
	cout<<"\nEnter the value of x for Alice : ";
	cin>>x;
	a=power(g,x,p);
	cout<<"\nEnter the value of y for Bob : ";
	cin>>y;
	b=power(g,y,p);
	cout<<"\n\nkey for Alice is "<<power(b,x,p);
	cout<<"\n\nkey for Bob is "<<power(a,y,p);

}
