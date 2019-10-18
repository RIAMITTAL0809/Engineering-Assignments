#include<iostream>
using namespace std;
int main()
{
	
	int i,j,k,pos,saddle,flag,row,col;
	cout<<"\nenter the row size of array\n";
	cin>>row;
	cout<<"\nenter the column size of the array\n";
	cin>>col;
	int a[row][col];
	cout<<"\nenter the matrix elements\n";
	for(i=0;i<row;i++)
        for(j=0;j<col;j++)
 				cin>>a[i][j];
  cout<<"\nyou entered this matrix";
 	for(i=0;i<row;i++)
 	{
	 cout<<endl;
        for(j=0;j<col;j++)
					  cout<<a[i][j]<<"\t";
	}
	cout<<endl;
	
	
	for(i=0;i<row;i++)
	{
		flag=1;
		saddle=a[i][0];
		pos=0;
	for(j=1;j<col;j++) 
	{
		if(a[i][j]<saddle)
		{
		saddle=a[i][j];
		pos=j;
		}
	}
	for(k=0;k<row;k++)
	{
		if(a[k][pos]>saddle)
		{
		flag=0;
		break;
		}
	}
	if(flag==1)
		cout<<"The saddle point of row "<<i+1<<" is "<<saddle<<endl;
    
	}
if(flag==0)
cout<<"\nsaddle point does not exist\n";

	return 0;	
}
