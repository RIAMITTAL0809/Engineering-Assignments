#include<iostream>
using namespace std;
int a[100][100],b[100][100],i,j,k,sum[100][100],s[100][100],product[100][100],addA=0,addB=0,g=0,h=0,p=0,q=0,n,o;
	

int accept()
{
cout<<"\nenter matrix  a elements\n";
for(i=0;i<n;i++)
{
	for(j=0;j<o;j++)
{
		cin>>a[i][j];
}
}
cout<<"\nenter matrix b elements\n";
for(i=0;i<n;i++)
{
	for(j=0;j<o;j++)
{
		cin>>b[i][j];
}
}	
}


	int display()
{
cout<<"the entered matrix A is ";
for(i=0;i<n;i++)
{     
cout<<endl;
	for(j=0;j<o;j++)
{
		cout<<a[i][j]<<"\t";
}
}
cout<<endl;
cout<<"the entered matrix B is ";
for(i=0;i<n;i++)
{   cout<<endl;
	for(j=0;j<o;j++)
{
		cout<<b[i][j]<<"\t";
}
}	
}


	int add()
{
for(i=0;i<n;i++)
{
	for(j=0;j<o;j++)
{
		sum[i][j]=0;
}
}
for(i=0;i<n;i++)
{
	for(j=0;j<o;j++)
{
		sum[i][j]=a[i][j]+b[i][j];
}
}
cout<<endl<<"the addition matrix is"<<endl;

for(i=0;i<n;i++)
{
cout<<endl;
	for(j=0;j<o;j++)
{
		cout<<sum[i][j]<<"\t";
		
}
cout<<"\t";
}
}


	int sub()
{
for(i=0;i<n;i++)
{
	for(j=0;j<o;j++)
{
		s[i][j]=0;
}
}
for(i=0;i<n;i++)
{
	for(j=0;j<o;j++)
{
		s[i][j]=a[i][j]-b[i][j];
}
}
cout<<endl;
cout<<"the subtraction matrix is"<<endl;

for(i=0;i<n;i++)
{
cout<<endl;
	for(j=0;j<o;j++)
{
		cout<<s[i][j]<<"\t";
		
}
cout<<"\t";
}
}


	int multiply()
{
for(i=0;i<n;i++)
{
	for(j=0;j<o;j++)
{
 	product[i][j]=0;
	for(k=0;k<n;k++)
	{
		product[i][j]=product[i][j]+(a[i][k]*b[k][j]);
	}
}
}
cout<<endl<<"the product matrix is";

for(i=0;i<n;i++)
{
cout<<endl;
	for(j=0;j<n;j++)
{
		cout<<product[i][j]<<"\t";
		
}
cout<<"\t";
}
}

	int diag()
{
for(i=0;i<n;i++)
{
	for(j=0;j<o;j++)
{ 
		if(i==j)
		addA=addA+a[i][j];
}
}
cout<<endl<<"the sum of diagonal elements of matrix  A is "<<addA;
for(i=0;i<n;i++)
{
	for(j=0;j<o;j++)
{ 
		if(i==j)
		addB=addB+b[i][j];
}
}
cout<<endl<<"the sum of diagonal elements of matrix  A is "<<addB;
}



	int transpose()
{
cout<<endl<<"the transpose of entered matrix A is ";
for(i=0;i<o;i++)
{     
cout<<endl;
	for(j=0;j<n;j++)
{
		cout<<a[j][i]<<"\t";
}
}
cout<<endl;
cout<<endl<<"the transpose of entered matrix B is ";
for(i=0;i<o;i++)
{   cout<<endl;
	for(j=0;j<n;j++)
{
		cout<<b[j][i]<<"\t";
}
}	
}


	int uppert()
{
    int flag=0;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<o;j++)
        {
            if(i>j&&a[i][j]!=0)
            {
                flag=1;
                break;
            }
        }
    }
    if(flag==1)
        cout<<"\nmatrix a is not an upper triangular matrix ";
    else
        cout<<"\nmatrix a is an upper triangular matrix ";
		
		int flag1=-1;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<o;j++)
        {
            if(i>j&&b[i][j]!=0)
            {
                flag1=1;
                break;
            }
        }
    }
    if(flag1==1)
        cout<<"\nmatrix b is not an upper triangular matrix ";
    else
        cout<<"\nmatrix b is an upper triangular matrix ";

}


	
	int main()
	{ 
	char ans;
	cout<<"\nenter no. of rows\n";
cin>>n;
cout<<"\nenter no.of columns equal to number of rows\n";
cin>>o;

	accept();
	
	do
	{
display();
int num;

cout<<endl<<"press 1 to add";
cout<<endl<<"press 2 to subtract ";
cout<<endl<<"press 3 to multiply";
cout<<endl<<"press 4 to add diagonal elements ";
cout<<endl<<"press 5 to display transpose ";
cout<<endl<<"press 6 to display upper triangular or not ";
cout<<"\npress 7 to do everything\n";
cin>>num;
switch(num)
{

case 1:	add();
break;
case 2:	sub();
break;
case 3:	multiply();
break;
case 4:	diag();
break;
case 5:	transpose();
break;
case 6:	uppert();
break;
case 7:add();
sub();
multiply();
diag();
transpose();
uppert();
break;
default:cout<<"try again";
}
cout<<"\ndo you want to continue?(y/n)\n";
cin>>ans;
}
while(ans=='y' || ans=='Y');
	return 0;
	}
