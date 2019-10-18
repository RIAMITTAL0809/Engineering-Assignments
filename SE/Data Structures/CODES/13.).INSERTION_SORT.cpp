/*Write C++ program to store second year percentage of students in array. 
Write function for sorting array of floating point numbers in ascending order using 
a) Insertion sort  and display top five scores.*/

#include<iostream>
using namespace std;
float a[100];
int size;
class sort
{
public:
	int accept();
	int insertion_sort();
	int display();
	void top_five();
};

int sort::accept()
{
	cout<<"\nenter the total number of second year students\n";
	cin>>size;
	cout<<"\nenter the percentage of students\n";
	for(int i=0;i<size;i++)
	{
		cin>>a[i];
	}
}

int sort::insertion_sort()
{
	int i,j;
	float element;
	cout<<"\nINSERTION SORT\n";
	for(i=0;i<size;i++)
	{
 		element=a[i];
		j=i;
		while((j>0) && (a[j-1]>element))
		{
			a[j]=a[j-1];
			j=j-1;
		}
		a[j]=element;
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
	int ch;
	char c;
	sort obj;
	obj.accept();
	do
	{
	cout<<"\npress 1 for insertion sort\npress 2 to display top five students\n";
	cin>>ch;
	switch(ch)
	{
	case 1:	obj.insertion_sort();obj.display();break;
	case 2: obj.top_five();break;
	default:cout<<"\ninvalid choice...try again..\n";
}
cout<<"\ndo you want to try again?(y/n)\n";
cin>>c;
}while(c=='y' || c=='Y');

	return 0;
}
