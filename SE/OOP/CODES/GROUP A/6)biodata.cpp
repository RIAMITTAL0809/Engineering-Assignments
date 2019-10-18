
#include<iostream>
using namespace std;

//class 1
class personal_record
{
	char name[100],address[100];
	float height;
	int age;
	long long int mob_no;
	public:
 	int accept1();
	int display1();
};


//class 2
class professional_record
{
	char gr[7];
	char depart[100],project[100];
	long long int emp_no;
	public:
	int accept2();
	int display2();
};


//class3
class academic_record
{
	char degree[100],clg_name[100];
	float per1,per2;
	public:
	int accept3();
	int display3();
};


// class 4
class biodata:public personal_record,public professional_record ,public academic_record
{ 
	public:
	int display();
};


int biodata::display()
{
	cout<<"\n\n\t\tWELCOME TO STUDENT PROFILE SYSTEM\n\n";
	cout<<"\n\t\t\t\tSTUDENT BIODATA\t\t\t\n\n\n";
}


int personal_record::accept1()
{ 
	cout<<"\nENTER YOUR NAME\n";
	cin.getline(name,100);
	cout<<"\nENTER YOUR AGE\n";
	cin>>age;
	cout<<"\nENTER YOUR HEIGHT\n";
	cin>>height;
	cout<<"\nENTER YOUR MOBILE NUMBER\n";
	cin>>mob_no;
	cout<<"\nENTER YOUR ADDRESS\n";
	ws(cin);
	cin.getline(address,100);
}

int personal_record::display1()
{
	cout<<"\nNAME : "<<name;
	cout<<"\nAGE : "<<age;
	cout<<"\nHEIGHT : "<<height;
	cout<<"\nMOBILE NUMBER : "<<mob_no;
	cout<<"\nADDRESS : "<<address;
}


int professional_record::accept2()
{
	cout<<"\nENTER YOUR EMPLOYEE NUMBER\n";
	cin>>emp_no;
	cout<<"\nENTER YOUR 7 DIGIT GR.NO.\n";
	cin>>gr;
	cout<<"\nDEPARTMENT NAME\n";
	ws(cin);
	cin.getline(depart,100);
	cout<<"\nPROJECT NAME\n";
	ws(cin);
	cin.getline(project,100);
}

int professional_record::display2()
{
	cout<<" \nEMPLOYEE NUMBER : "<<emp_no;
	cout<<"\nG.R NUMBER : "<<gr;
	cout<<" \nDEPARTMENT NAME : "<<depart;
	cout<<"\nPROJECT NAME : "<<project;
}


int academic_record::accept3()
{
	cout<<"\nENTER DEGREE NAME\n";
	ws(cin);
	cin.getline(degree,100);
	cout<<"\nENTER 10TH PERCENTAGE\n";
	cin>>per1;
	cout<<"\nENTER 12TH PERCENTAGE\n";
	cin>>per2;
	cout<<"\nENTER COLLEGE NAME\n";
	ws(cin);
	cin.getline(clg_name,100);
}

int academic_record::display3()
{
	cout<<"\nDEGREE : "<<degree;
	cout<<"\n10TH PERCENTAGE : "<<per1;
	cout<<"\n12TH PERCENTAGE : "<<per2;
	cout<<"\nCOLLEGE NAME : "<<clg_name<<endl;
}


//main
int main()
{
	biodata obj3;
	obj3.accept1();
	obj3.accept2();
	obj3.accept3();
	cout<<"\n------------------------------------------------------------------------";
	obj3.display();
	cout<<"------------------------------------------------------------------------";
	obj3.display1();
	cout<<"\n------------------------------------------------------------------------";
	obj3.display2();
	cout<<"\n------------------------------------------------------------------------";
	obj3.display3();
	cout<<"\n------------------------------------------------------------------------";
	cout<<"\n\n\nTHANK YOU FOR VISITING STUDENT PROFILE\n\n";
	return 0;
}


