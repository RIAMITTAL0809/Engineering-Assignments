#include<iostream>
using namespace std;
class ternary
{
    private:
        int a[20];
        int front , last, n, fp, sp , key;
    public:
        void accept();
        void acceptkey();
        void sort();
        void search();
};

void ternary::accept()
{
    cout<<"\nEnter the size of the array\n";
    cin>>n;
    cout<<"\nEnter the elements of the array\n";
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }
}

void ternary:: acceptkey()
{
    cout<<"\nEnter the element you want to search\n";
    cin>>key;
}

void ternary:: sort()
{
    int temp;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n-1;j++)
        {
            if(a[j]>a[j+1])
            {
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }
    }
}


void ternary:: search()
{
    int flag=0;
    front=0;
    last=n-1;
    for(int i=front;i<=last;i++)
    {
        fp=front+(last-front)/3;
        sp=last-(last-front)/3;
        if(key==a[fp])
        {   
            flag++;
            cout<<"\nThe element is present in the list\n;
            break;
        }
        if(key==a[sp])
        {   
            flag++;
            cout<<"\nThe element is present in the list\n";
            break;
        }
        if(key<a[fp])
        {
            last=fp-1;
            continue;
        }
        if(key>a[fp]&&key<a[sp])
        {
            front=fp+1;
            last=sp-1;
            continue;
        }
        if(key>a[sp])
        {
            front=sp+1;
            continue;
        }
    }
    if(flag==0)
    {
        cout<<"\nThe element is not present\n";
    }
}


int main()
{
    char k;
    ternary t;
    cout<<"\n\n\n----------TERNARY SEARCH----------\n\n\n";       
                t.accept();
    do
    {
        
        
                t.acceptkey();
                t.sort();
                t.search();
        cout<<"\ndo you want to continue?(y/n)\n";
        cin>>k;
    }while(k=='Y' || k=='y');   
}
s
