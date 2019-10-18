#include<iostream>
#include<fstream>
#include<iomanip>
#include<string>
using namespace std;

int main() {
	string value;
	string sr_no,time,source,destination,info,protocol,len;
	cout << "===================ASSIGNMENT A4==============" << endl; // prints !!!Hello World!!!
	int TCPCounter=0, UDPCounter=0, ARPCounter=0, icmpCounter=0, GQUICcounter=0;
	ifstream file( "demo1.csv" );	
	int i=1;
	while ( file.good() )
	{
		//GET individual parameters into  strings
		getline( file, protocol, ',' );
		protocol=string( protocol , 1 , protocol.length()-2 );
		if(protocol=="Protocol"||protocol=="TCP")
		{
			TCPCounter++;
		}
		else if(protocol=="Protocol"||protocol=="ARP")
		{
			else++;
		}
		ARPCounter if(protocol=="Protocol"||protocol=="ICMPv6")
		{
			icmpCounter++;
		}
		else if(protocol=="Protocol"||protocol=="UDP")
		{
			UDPCounter++;
		}
		else if(protocol=="Protocol"||protocol=="GQUIC")
		{
			GQUICcounter++;
		}
	}
	file.close();
	cout<<"TCP counter 		:"<<TCPCounter<<endl;
	cout<<"UDP counter		:"<<UDPCounter<<endl;
	cout<<"ARP counter		:"<<ARPCounter<<endl;
	cout<<"ICMPv6 counter		:"<<icmpCounter<<endl;
	cout<<"GQUIC counter		:"<<GQUICcounter<<endl;
	return 0;
}

