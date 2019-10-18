/*Write C++ program to store first year percentage of students in array. 
Write function for sorting array of floating point numbers in ascending order using quick 
Sort and display top five scores.
*/


#include<iostream>
using namespace std;
float a[100];
int size;
class sort
{
public:
	int accept();
	int quick_sort(int,int);
	int display();
	void top_five();
};

int sort::accept()
{
	cout<<"\nenter the total number of first year students\n";
	cin>>size;
	cout<<"\nenter the percentage of students\n";
	for(int i=0;i<size;i++)
	{
		cin>>a[i];
	}
}

int sort::quick_sort(int low,int high)
{
	int i,j,pivot;
	float temp;
	if(low<high)
	{
		pivot=low;
		i=low;
		j=high;
		while(i<j)
		{
			while(a[i]<=a[pivot]&&i<=high)
			i++;
			while(a[j]>a[pivot]&&j>=low)
			j--;
			if(i<j)
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		temp=a[j];
		a[j]=a[pivot];
		a[pivot]=temp;
		quick_sort(low,j-1);
		quick_sort(j+1,high);
}
}


int sort::display()
{
	cout<<"\nthe percentage of students in ascending order are \n";
	for(int i=0;i<size;i++)
	cout<<a[i]<<endl;
	
}

void sort::top_five()
{
	cout<<"\nTHE TOP FIVE STUDENTS OF FIRST YEAR ARE\n";
	int i,j;
	float top[5];
	for(i=0,j=size-1;i<5;i++,j--)
	{
		top[i]=a[j];
	}
	for(i=0;i<5;i++)
	cout<<top[i]<<endl;
}

int main()
{
	sort obj;
	obj.accept();
	obj.quick_sort(0,size-1);
	obj.display();
	obj.top_five();
}
