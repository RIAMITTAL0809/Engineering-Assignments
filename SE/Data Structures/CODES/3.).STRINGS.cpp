#include<iostream>
#include<string.h>
using namespace std;
int i,h,j,n,len1,len2,count=0,oper;
char y;
char a[100],b[100],c[100],d[100];;

//length
int length()
{
len1=0,len2=0;
for(i=0;i<100;i++)
{
if(a[i]!='\0')
{
len1++;
}
}
cout<<"\nlength of the first string is \n"<<len1<<endl;
for(j=0;j<100;j++)
{
if(b[j]!='\0')
{
len2++;
}
}
cout<<"\nlength of the second string is \n"<<len2<<endl;
}


//reverse
int reverse()
{
j=0,h=0;
for(i=strlen(a)-1;i>=0;i--)
{
c[j]=a[i];
j++;
}
for(i=strlen(b)-1;i>=0;i--)
{
d[h]=b[i];
h++;
}
cout<<"\nfirst string in reverse is \n";
for(n=0;n<strlen(a);n++)
{
cout<<c[n];
}
cout<<"\nsecond string in reverse is \n";
for(n=0;n<strlen(b);n++)
{
cout<<d[n];
}
cout<<endl;
}



//compare
int compare()
{
i=0;
if(strlen(a)==strlen(b))
{
	for(i=0;i<strlen(a);i++)
	{
	if(a[i]==b[i])
	{
	count++;
	}
	}
	if(count==strlen(a))
	{
	cout<<"\nboth are same\n";
	}
	else
	{
	cout<<"\n both are different\n";
	
}
}
else
cout<<"\nboth are different\n";	
}


//copy
int copy()
{
i=0;
for(i=0;i<strlen(a);i++)
{
c[i]=a[i];
}
cout<<"\n the copy of first string is\n";
for(i=0;i<strlen(a);i++)
cout<<c[i];
for(i=0;i<strlen(b);i++)
{
d[i]=b[i];
}
cout<<"\n the copy of second string is\n";
for(i=0;i<strlen(b);i++)
cout<<d[i];
cout<<endl;
}


//concatenation
int concat()
{
j=0;
for(i=0;i<strlen(a)+strlen(b),j<strlen(b);i++)
{
if(a[i]=='\0')
{
a[i]=b[j];
}
else
continue;
j++;
}
cout<<"\n concatenated string is\n";
for(i=0;i<strlen(a)+strlen(b);i++)
cout<<a[i];
cout<<endl;
}


//palindrome
int palindrome()
{
j=0;
for(i=strlen(a)-1;i>=0;i--)
{
c[j]=a[i];
j++;
}
for(i=0;i<strlen(a)/2;i++)
{
if(a[i]==c[i] )
count++;
}
if(count==strlen(a)/2)
cout<<"\npalindrome\n";
else
cout<<"\nnot palindrome\n";
}

//substring
int substring()
{
int i,j,temp;
for(i=0;a[i]!='\0';i++)
{
	j=0;
	if(a[i]==b[j])
	{
		temp=i+1;
		while(a[i]==b[j])
		{
			i++;
			j++;
		}
		if(b[j]=='\0')
		{
			cout<<"\nsubstrings\n";
			break;
		}
		else
		{
			i=temp;
			temp=0;
		}
	}
}
if(temp==0)
{
	cout<<"\nnot substrings\n";
	
}
return 0;
}


//main
int main()
{ 
do
{
cout<<"enter the string\n";
cin>>a;
cout<<"enter the second string\n";
cin>>b;
cout<<"\nenter 1 for checking lengths \n";
cout<<"\nenter 2 for copying \n";
cout<<"\nenter 3 for comparing \n";
cout<<"\nenter 4 for reversing \n";
cout<<"\nenter 5 for checking palindrome \n";
cout<<"\nenter 6 for conactenation \n";
cout<<"\nenter 7 for checking if substring \n";
cout<<"\nenter 8 for checking all functions\n";
cin>>oper;
switch(oper)
{
	case 1:{	length();
	break;}
	case 2:	{	copy();
	break;}
	case 3:{	compare();
	break;}
	case 4:{	reverse();
	break;}
	case 5:{	palindrome();
	break;}
	case 6:{	concat();
	break;}
	case 7:{	substring();
	break;}
	case 8:{	length();
			copy();
			compare();
			reverse();
			palindrome();
			concat();
			substring();
	break;
	}
	default:cout<<"try again";
}
cout<<"\ndo you want to continue?(y/n)\n";
cin>>y;
}
while(y=='y'||y=='Y');
return 0;
}

/*

enter the string
riamittal
enter the second string
mittal

enter 1 for checking lengths

enter 2 for copying

enter 3 for comparing

enter 4 for reversing

enter 5 for checking palindrome

enter 6 for conactenation

enter 7 for checking if substring

enter 8 for checking all functions
8

length of the first string is
9

length of the second string is
6

 the copy of first string is
riamittal
 the copy of second string is
mittal

both are different

first string in reverse is
lattimair
second string in reverse is
lattim

not palindrome

 concatenated string is
riamittalmittal

substrings

do you want to continue?(y/n)
n

*/
