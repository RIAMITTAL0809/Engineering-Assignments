/*Write a C++ program that creates an output file, writes information to it,
 closes the file and open it again as an input file and read the information from the file.*/
 
 #include<iostream>
 #include<fstream>
 using namespace  std;
 
 class file
 {
 	char name[50];
 	int roll,mem;
 	public :
 		void accept()
 		{	
 		ofstream fout;
 		fout.open("new.txt");
 				cout<<"\nENTER NAME\n";
 				ws(cin);
 				cin.getline(name,50);
 				fout<<name<<endl;
				 cout<<"\nENTER ROLL NO.\n";
 				cin>>roll;
				 fout<<roll<<endl;	 
				 fout.close();
		 }
		 
		 void read()
		 {
		 	ifstream fin;
		 	int r;
		 	char nm[100];
		 	fin.open("new.txt");
		 	fin.get(nm,100);
		 	fin>>r;
		 	cout<<"\nThis is to certify that Ms./Mr."<<nm<<" Roll number "<<r<<" has succesfully completed\nall his/her assignments in OBJECT ORIENTED PROGRAMMING LANGUAGE lab\n\n";
		    fin.close();
		 }
 };
 
 int main()
 {
 	file obj; 
 	obj.accept();
 	obj.read();
 	return 0;
 }
