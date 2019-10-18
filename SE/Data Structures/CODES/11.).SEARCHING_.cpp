#include<iostream>
#include<math.h>
using namespace std;
int a[100];
int size;
int element;
class search
{
 public:
 void linear();
int sentinel();
 void binary(int);
 int fibonacci();
int recursive(int,int,int);
 };
 
 void search::linear()
 {
 int i,flag=0;
 for(i=0;i<size;i++)
 {
 if(a[i]==element)
 flag=1;
 }
 if(flag==1)
 cout<<"\nstudent was present at the program"<<endl;
 else
 cout<<"\nstudent was absent\n";
 } 
 
 
int search::sentinel()
 {
 int i=0;
 a[size]=element;
 while(element!=a[i])
 {
 i=i+1;
 }
 if(i<size)
 cout<<"\nstudent was present at the program\n"; 
 else 
cout<<"\nstudent was absent\n";
 }
 
 
 void search::binary(int k)
 {
 int item=k;
 int first,last,mid;
	first=0;
	last=size-1;
	while(first<=last)
	{
		mid=(first+last)/2;
		if(a[mid]==item)
		{
			cout<<"\nstudent was present at the program\n ";
		//	cout<<"\nHis/Her Name Is Present At Position No : "<<mid+1<<" In The List";
			break;
		}
		else if(item>a[mid])
			first=mid+1;
		else if(item<a[mid])
			last=mid-1;
		else
			first=last+1;
	}
	if(first>last)
		cout<<"\nstudent was absent\n";
}
 
 
 int search:: recursive(int low,int high,int element)
 {
 int mid;
 if(low<=high)
 {
 mid=(low+high)/2;
 if(a[mid]==element)
 return mid;
 else if(element<a[mid])
 return recursive(low,mid-1,element);
 else
 return recursive(mid+1,high,element);
 }
 return -1;
 }
 
 
 
 int search::fibonacci()
 {  
    int fib2 = 0;  
    int fib1 = 1;  
    int fibM = fib2 + fib1;  
    while (fibM < size)
    {
        fib2 = fib1;
        fib1 = fibM;
        fibM  = fib2 + fib1;
    }
    int offset = -1;
     while (fibM > 1)
    {
        int i = min(offset+fib2, size-1);
         if (a[i] < element)
        {
            fibM  = fib1;
            fib1 = fib2;
            fib2 = fibM - fib1;
            offset = i;
        }
        else if (a[i] > element)
        {
            fibM  = fib2;
            fib1 = fib1 - fib2;
            fib2 = fibM - fib1;
        }
        else 
        return i;
    }
    if(fib1 && a[offset+1]==element)
    return offset+1;
    return -1;
} 
 
 
 
 int main()
 {
 search obj;
 int i,n;
 char ans,anss;
 cout<<"\nenter the total number of students that attended the training program\n";
 cin>>size;
 cout<<"\nenter the roll numbers of the students\n";
 for(i=0;i<size;i++)
 cin>>a[i];
 
 do
 {
 cout<<"\nenter the roll no.of the student you want to search\n";
 cin>>element;
 do
 {
 cout<<"\nenter 1 for linear search\nenter 2 for sentinel search\nenter 3 for binary search\nenter 4 for fibonacci search\n";
 cin>>n;
 switch(n)
 {
 case 1:{
 cout<<"\nusing linear search\n";
 obj.linear();
 break;
 }
 case 2:{
 cout<<"\nusing sentinel search\n";
 obj.sentinel();
 break;
 }
 case 3:{
 	int b;
 cout<<"\nwhich type of binary search do you want to try\npress 1 for non recursive \npress 2 for recursive\n";
 cin>>b;
 if(b==1)
 {
obj.binary(element);
}
else if(b==2)
{
	if(obj.recursive(0,size-1,element)!=-1)
	cout<<"\nstudent was present at the program\n";
	else
	cout<<"\nstudent was absent\n"; 
}
else
cout<<"\ninvalid choice\n";
 break;
 
 }
 case 4:{
 cout<<"\nusing fibonacci search\n";
if(obj.fibonacci()!=-1)
cout<<"\nstudent was present at the program\n";
else
cout<<"\nstudent was absent\n";

 break;
 }
 default:cout<<"\ninvalid choice ....try again....\n";
 }
 cout<<"\ndo you want to try a new type of searching algorithm?(y/n)\n";
 cin>>ans;
 }while(ans=='y' || ans=='Y');
 cout<<"\ndo you want to continue?(y/n)\n";
 cin>>anss;
 }while(anss=='y' || anss=='Y');
 }
 
 
 
