/*In Second year Computer Engineering class of M students, set A of students play cricket and 
set B of students play badminton. Write C/C++ program to find and display
Set of students who play either cricket or  badminton or both
iiSet of students who play both cricket and badminton 
iii.Set of students who play only cricket 
iv.Set of students who play only badminton 
v.Number of students who play neither cricket nor badminton
*/

#include<iostream>
using namespace std;


class sets
{
int cric[100],badmin[100],inter[100],uni[200],ocric[100],obadmin[100],neith[100];
int numc,i,j,k,numb,total;
int cnt=0,ctt=0;
int count=0;
int flag=0,flag1=0;
int ct=0,c=0;
public:
	
	
int accept()
{
cout<<"\nenter total number of students in class:\n";
cin>>total;
cout<<"\n enter total number who play cricket\n";
cin>>numc;
cout<<"\n enter the roll numbers of students who play cricket\n";
for(i=0;i<numc;i++)
{
cin>>cric[i];
}
cout<<"\n enter total number who play badminton\n";
cin>>numb;
 cout<<"\n enter the roll numbers of students who play badminton\n";
for(j=0;j<numb;j++)
{
cin>>badmin[j];
}
}

int intersect();
int Union();
int onlycric();
int onlybadmin();
int neither();
};


int sets::intersect()
{
	
	cout<<"\nthe students playing both cricket and badminton are:\n{";
	for(i=0;i<numb;i++)
	{
		for(j=0;j<numc;j++) 
		{
			if(cric[j]==badmin[i])
			{
			flag=1;
			break;
			}
		} 
		if(flag==1)
		{
			inter[count]=badmin[i];
			count++; 
		}
		flag=0;
	}
	for(i=0;i<count;i++)
	cout<<inter[i]<<",";
	cout<<"}"<<endl;
	
}


int sets::Union()
{
	
	for(i=0;i<numc;i++)
	{
	uni[cnt]=cric[i];
	cnt++;
	}
	for(i=0;i<numb;i++)
	{
		for(j=0;j<numc;j++)
		{
			if(cric[j]==badmin[i])
			{
				flag=1;
				break;
			}
					
		}
		if(flag==0)
		{
			uni[cnt]=badmin[i];
			cnt++;
		}
		flag=0;
	}
	cout<<"\nthe students playing either cricket or badminton are:\n{";
	for(i=0;i<cnt;i++)
	cout<<uni[i]<<",";
	cout<<"}"<<endl;
}



int sets::onlycric()
{
	cout<<"\nthe students playing only cricket are:\n{";
	for(i=0;i<cnt;i++)
	{
		for(j=0;j<numb;j++)
		{
			if(badmin[j]==uni[i])
			{
			flag=1;
			break;
			}
		}
		if(flag==0)
		{
			ocric[ct]=uni[i];
			ct++;
		}
	  flag=0;
	}
	for(i=0;i<ct;i++)
	cout<<ocric[i]<<",";
	cout<<"}"<<endl;
}


int sets::onlybadmin()
{
	cout<<"\nthe students playing only badminton are:\n{";
	for(i=0;i<cnt;i++)
	{
		for(j=0;j<numc;j++)
		{
			if(cric[j]==uni[i])
			{
			flag1=1;
			break;
			}
		}
		if(flag1==0)
		{
			obadmin[ctt]=uni[i];
			ctt++;
		}
	  flag1=0;
	}
	for(i=0;i<ctt;i++)
	cout<<obadmin[i]<<",";
	cout<<"}"<<endl;
}

int sets::neither()
{
	cout<<"\nthe students not playing any game are:\n{";
	for(i=1;i<=total;i++)
	{
		for(j=0;j<cnt;j++)
		{
			if(uni[j]==i)
			{
				flag1=1;
				break;
			}
			
		}
		if(flag1==0)
		{
			neith[c]=i;
			c++;
		}
		flag1=0;
	}
	for(i=0;i<c;i++)
	cout<<neith[i]<<",";
	cout<<"}"<<endl;
	
}
 int main()
 {   
 char ans;
 int choice;
 
		 sets obj;
		 obj.accept();
 do
 {
		 cout<<"\nenter 1 for getting students playing both cricket and badminton\n";
		 cout<<"enter 2 for getting students playing either cricket or badminton\n";
		 cout<<"enter 3 for getting students playing only cricket\n";
		 cout<<"enter 4 for getting students palying only badminton\n";
		 cout<<"enter 5 for getting students not playing any game\n";
		 cin>>choice;
		 switch(choice)
		 {
		 	case 1: obj.intersect();break;
		 	case 2: obj.Union();break;
		 	case 3: obj.onlycric();break;
		 	case 4: obj.onlybadmin();break;
		 	case 5: obj.neither();break;
		 	default:cout<<"\ninvalid choice..\\n..please try again\n";
				 
		 }
		 	
		 cout<<"\ndo you want to continue(y/n)\n";
		 cin>>ans;
	}
		 while(ans=='Y' || ans=='y');
		 return 0;
 }


/*


enter total number of students in class:
10

 enter total number who play cricket
4

 enter the roll numbers of students who play cricket
1
6
3
9

 enter total number who play badminton
3

 enter the roll numbers of students who play badminton
1
3
2

enter 1 for getting students playing both cricket and badminton
enter 2 for getting students playing either cricket or badminton
enter 3 for getting students playing only cricket
enter 4 for getting students palying only badminton
enter 5 for getting students not playing any game
enter 6 for getting all the sets
6

the students playing both cricket and badminton are:
{1,3,}

the students playing either cricket or badminton are:
{1,6,3,9,2,}

the students playing only cricket are:
{6,9,}

the students playing only badminton are:
{2,}

the students not playing any game are:
{4,5,7,8,10,}

do you want to continue(y/n)n

*/
