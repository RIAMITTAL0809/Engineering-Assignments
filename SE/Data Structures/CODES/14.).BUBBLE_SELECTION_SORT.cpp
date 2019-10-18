/*Write C++ program to store first year percentage of students in array.
 Write function for sorting array of floating point numbers in ascending order using
a) Selection Sort
b) Bubble sort 
and display top five scores.
*/


#include<iostream>
using namespace std;
float a[100];
int size;
class sort
{
public:
	int accept();
	void bubble_sort();
	void selection_sort();
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

void sort::bubble_sort()
{
	int i,j;
	float temp;
	cout<<"\nBUBBLE SORTING \n";
	for(i=0;i<size;i++)
	{
		for(j=0;j<size-1;j++)
		{
			if(a[j+1]<a[j])
   			{
   				temp=a[j+1];
   				a[j+1]=a[j];
   				a[j]=temp;
			   }
		}
	}
}

void sort::selection_sort()
{
	int i,j;
	float temp;
	cout<<"\nSELECTION SORTING\n";
	for(i=0;i<size;i++)
	{
		for(j=0;j<size;j++)
		{
			if(a[i]<a[j])
			{
				temp=a[j];
				a[j]=a[i];
				a[i]=temp;
			}
		}
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
	char ch,choice,c;
	sort obj;
	do
	{	
	obj.accept();
	do
	{
		cout<<"\npress 1 for bubble sorting\npress 2 for selection sorting\npress 3 for displaying top five student's percentage\n";
		cin>>ch;
		switch(ch)
		{
			case '1':obj.bubble_sort();obj.display();break;
			case '2':obj.selection_sort();obj.display();break;
			case '3':obj.top_five();break;
			default:cout<<"\nsorry..try again";
			
		}
		cout<<"\ndo you want to try again?(y/n)\n";
		cin>>choice;
	}while(choice=='y'|| choice=='Y');
	cout<<"\ndo you want to enter new percentages?(y/n)\n";
	cin>>c;
}while(c=='y'|| c=='Y');
	return 0;
}
