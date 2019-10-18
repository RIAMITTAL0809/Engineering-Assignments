/*Write a function template selection Sort. Write a program that inputs, sorts and outputs an 
integer array and a float array.*/

#include<iostream>
using namespace std;
template<class T>
class Sorting
{
public:
T sort();
};


template<class T>
T Sorting <T>::sort()
{
T size;
T arr[100];
T temp;
int i,j;

cout<<"\nenter the size of array\n";
cin>>size;
cout<<"\nenter the array elements\n";
for( i=0;i<size;i++)
{
cin>>arr[i];
}
for(i=0;i<size;i++)
{
	for( j=0;j<size;j++)
	{
		if(arr[i]<arr[j])
		{
		temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
		}
	}
}
cout<<endl;
for(i=0;i<size;i++)
{
cout<<arr[i]<<endl;
}
}

int main()
{
Sorting<int> obj;
cout<<"\ninteger array sorting\n";
obj.sort();
Sorting<float> ob;
cout<<"\nfloat array sorting\n";
ob.sort();
return 0;
}



