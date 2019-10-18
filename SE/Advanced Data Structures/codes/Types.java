import java.io.*;
import java.util.*;  		//stack ,queue  ,hash map  ,arraylist ,link list

public class Types
{
public void func()
{
Scanner sc=new Scanner(System.in);
			
		Stack<Integer> stk=new Stack<>();
 		PriorityQueue<Integer> que=new PriorityQueue<>();
		LinkedList<Integer> ll=new LinkedList<>();
		ArrayList<Integer> al=new ArrayList<>();
		HashMap<String, Integer> hm=new HashMap<>();
		
		char ans,y;
		int choice,ch;
		do{
		System.out.println("1.)Stack\n2.)Queue\n3.)Linked List\n4.)Array List\n5.)HashMap\n6.)Exit");
		choice=sc.nextInt();
		switch(choice)
		{
			case 1:
					System.out.println("-----Stack-----");
					do
					{
					
					System.out.println("1. Push\n2.Pop\n3.Display Top of the stack\n4.Exit");
					ch=sc.nextInt();
					switch(ch)
					{
					case 1:
							System.out.println("\nEnter total numbers you will enter : ");
							int count=sc.nextInt();
							for(int i=0;i<count;i++)
							{
							System.out.println("\nEnter Number: ");
							int num=sc.nextInt();
							stk.push(num);
							}
					break;
				
					case 2:
							System.out.println("Popping the top of the stack ");
							stk.pop();
					break;
				
					case 3:
							System.out.println("\nThe top of the stack is "+stk.peek());
					break;
				
					case 4:
					break;
				
					default:System.out.println("invalid entry...try again");
					}
					System.out.println("do you want to continue?(y/n)");
					ans=sc.next().charAt(0);
					}while(ans=='y' || ans=='Y');
			
			break;
			
			case 2:
					System.out.println("-----Queue-----");
					do
					{
					System.out.println("1. Enqueue\n2.Dequeue\n3.Display\n4.Exit");
					ch=sc.nextInt();
					switch(ch)
					{
					case 1:
							System.out.println("\nEnter total numbers you will enter : ");
							int count=sc.nextInt();
							for(int i=0;i<count;i++)
							{
							System.out.println("\nEnter Number: ");
							int num=sc.nextInt();
							que.add(num);
							}
							
					break;
					case 2:
							if(que.isEmpty())
							{
							System.out.println("que is empty");
							}
							else
							{
							System.out.println("removing the front element ");
							que.remove();
							}
					break;
					case 3:
							while(!que.isEmpty())
							{
							System.out.println(que.peek());
							que.remove();
							}
					break;
					case 4:
					break;
					default:System.out.println("invalid entry...try again");
					
					}
					System.out.println("do you want to continue?(y/n)");
					ans=sc.next().charAt(0);
					}while(ans=='y' || ans=='Y');
			
			break;
			
			case 3:
					System.out.println("-----Linked List-----");
				do
				{
					System.out.println("1. Insert\n2.Delete\n3.Display first and last element\n4.Exit");
					ch=sc.nextInt();
					switch(ch)
					{
					case 1:
							System.out.println("\nEnter total numbers you will enter : ");
							int count=sc.nextInt();
							for(int i=0;i<count;i++)
							{
							System.out.println("\nEnter Number: ");
							int num=sc.nextInt();
							ll.add(num);
							}
							
					break;
					case 2:
							System.out.println("removing an element");
							ll.remove();
							
					break;
					case 3:
							System.out.println("the first element is : "+ll.getFirst());
							System.out.println("the last element is : "+ll.getLast());
							
					break;
					case 4:
					break;
					default:
					}		
					System.out.println("do you want to continue?(y/n)");
					ans=sc.next().charAt(0);
					}while(ans=='y' || ans=='Y');
					
			break;
			
			
			case 4:
					System.out.println("-----Array List-----");
				System.out.println("10 added\n20added");
				al.add(new Integer(10));
				al.add(new Integer(20));
				System.out.println("Removed element  at index 0 from arrayList: "+al.remove(0));
				System.out.println("\nSize: "+al.size());		
					break;
			
			case 5:
					System.out.println("-----Hash Map-----");
					do{
						System.out.println("\nEnter Key");
					sc.next();
					String key=sc.nextLine();
					System.out.println("\nEnter Value: ");
					int value=sc.nextInt();
					hm.put(key, value);
					System.out.println("\nRecord Insserted");
					hm.put("roll",2464);
					hm.put("Div", 4);

					System.out.println("\nRemoved element (roll):"+hm.remove("roll"));

					System.out.println("\nSize: "+hm.size());
					System.out.println("\nHashcode Value for this map: "+hm.hashCode());

					System.out.println("do you want to continue?(y/n)");
					ans=sc.next().charAt(0);
					}while(ans=='y' || ans=='Y');
						
			break;
			case 6:break;
	
			default:System.out.println("invalid input...try again");
			
		}	
		System.out.println("another data structure?(y/n) : ");
		y=sc.next().charAt(0);
		
		}while(y=='y' || y=='Y');	
}

	public static void main(String args[]) throws IOException
	{
		Types obj=new Types();
		obj.func();
		
	}
}

/*
1.)Stack
2.)Queue
3.)Linked List
4.)Array List
5.)HashMap
6.)Exit
1
-----Stack-----
1. Push
2.Pop
3.Display Top of the stack
4.Exit
1

Enter total numbers you will enter : 
4

Enter Number: 
1

Enter Number: 
2

Enter Number: 
4

Enter Number: 
3
do you want to continue?(y/n)
y
1. Push
2.Pop
3.Display Top of the stack
4.Exit
2
Popping the top of the stack 
do you want to continue?(y/n)
y
1. Push
2.Pop
3.Display Top of the stack
4.Exit
3

The top of the stack is 4
do you want to continue?(y/n)
y
1. Push
2.Pop
3.Display Top of the stack
4.Exit
4
do you want to continue?(y/n)
n
another data structure?(y/n) : 
y
1.)Stack
2.)Queue
3.)Linked List
4.)Array List
5.)HashMap
6.)Exit
2
-----Queue-----
1. Enqueue
2.Dequeue
3.Display
4.Exit
1

Enter total numbers you will enter : 
4

Enter Number: 
7

Enter Number: 
6

Enter Number: 
5

Enter Number: 
4
do you want to continue?(y/n)
y
1. Enqueue
2.Dequeue
3.Display
4.Exit
2
removing the front element 
do you want to continue?(y/n)
y
1. Enqueue
2.Dequeue
3.Display
4.Exit
2
removing the front element 
do you want to continue?(y/n)
y
1. Enqueue
2.Dequeue
3.Display
4.Exit
3
6
7
do you want to continue?(y/n)
y
1. Enqueue
2.Dequeue
3.Display
4.Exit
1

Enter total numbers you will enter : 
2

Enter Number: 
1

Enter Number: 
2
do you want to continue?(y/n)
y
1. Enqueue
2.Dequeue
3.Display
4.Exit
3
1
2
do you want to continue?(y/n)
n
another data structure?(y/n) : 
y
1.)Stack
2.)Queue
3.)Linked List
4.)Array List
5.)HashMap
6.)Exit
3
-----Linked List-----
1. Insert
2.Delete
3.Display first and last element
4.Exit
1

Enter total numbers you will enter : 
5

Enter Number: 
1

Enter Number: 
6

Enter Number: 
5

Enter Number: 
2

Enter Number: 
4
do you want to continue?(y/n)
y
1. Insert
2.Delete
3.Display first and last element
4.Exit
2
removing an element
do you want to continue?(y/n)
y
1. Insert
2.Delete
3.Display first and last element
4.Exit
3
the first element is : 6
the last element is : 4
do you want to continue?(y/n)
y
1. Insert
2.Delete
3.Display first and last element
4.Exit
4
do you want to continue?(y/n)
n
another data structure?(y/n) : 
y
1.)Stack
2.)Queue
3.)Linked List
4.)Array List
5.)HashMap
6.)Exit
4
-----Array List-----
10 added
20added
Removed element  at index 0 from arrayList: 10

Size: 1
another data structure?(y/n) : 
y
1.)Stack
2.)Queue
3.)Linked List
4.)Array List
5.)HashMap
6.)Exit
5
-----Hash Map-----

Enter Key
1

Enter Value: 
6

Record Insserted

Removed element (roll):2464

Size: 2

Hashcode Value for this map: 68731
do you want to continue?(y/n)
y

Enter Key
33

Enter Value: 
65

Record Insserted

Removed element (roll):2464

Size: 2

Hashcode Value for this map: 68790
do you want to continue?(y/n)
n
another data structure?(y/n) : 
n

*/