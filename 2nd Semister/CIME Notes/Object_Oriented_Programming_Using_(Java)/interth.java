class B implements Runnable
{ 
public void run()
{

synchronized(this)  //Synchronizing the object of B, this refers to ob
{
	System.out.println("newThread running and printing table of 5");
	for(int i=1; i<=10; i++)
	{
		System.out.println("5 x "+ i + " = " + (5*i));	  
	}
	    
	notify();	//notifying the main thread to continue its work    

}	//synchronized block ends
}	
}



class interth 
{
public static void main(String...ar) 
{
B ob = new B();
Thread t= new Thread(ob , "newThread");     //Calling Thread's constructor & passing the object
					    //of B class that  implemented  Runnable interface
					    //& the name of new thread.
t.start();
 
synchronized(ob)  //Synchronizing the object of B, ob
{         
try
{
        
        ob.wait();	//main thread stops its execution and waits until it is notify()
	System.out.println("main thread running and printing table of 6");
	for(int i=1; i<=10; i++)
	{
		System.out.println("6 x "+ i + " = " + (6*i));	  
	}	  
}
catch(InterruptedException e)
{
	System.out.println(e);
}
}	//synchronized block ends
    
}	
}