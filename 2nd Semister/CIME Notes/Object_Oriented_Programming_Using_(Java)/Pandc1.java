// Inter thread communication : Producer & Consumer problem 

// Q is a class containing two parallel processes	
class Q {			
		int n;
		boolean flag = false;
    //PRODUCER
		synchronized void put( int n) {	
			if(flag) {								      	                      
			   try{  
                           wait( );}  
                           catch(InterruptedException e){}	
	
			          }								                              
													                                      
	                    this.n = n;								                                      
			    System.out.println( "Produce :" + n);			        
													                                      
			    flag = true;							                      
			    notify( );							
		    }
    //CONSUMER
	       synchronized int get( ) {		
			if(! flag) {								                          
			  try{  
                          wait( );}  
                          catch(InterruptedException e){}		
			           }								                              
													                                      
			System.out.println( "Consume :" + n);			        												                   
			                                                                              
			flag = false;							                      
			notify( );							                        	
	             return( n );						
		                  }
}


	class Producer implements Runnable  {	 
			 Q  q;
		 Producer ( Q q ) 	{  	
		 this.q =q;
		 new Thread (this).start ( ) ;		
		}

	   public void run( ) { 		 
		int i = 0;
		while (true ) 	
			q.put ( i++ );
		   }
		}

	class Consumer implements Runnable { 	
		Q q;
	   Consumer (Q q )	{ 	          
	   this.q  = q;
	   new Thread (this).start ( );
		}

	 public void run( ) {		
	 while (true) 
		q.get ( );
		}
	}

       class Pandc1  { 			
		public static void main( String s[ ] ) 
                 {
                Q q=new Q();
		new Producer(q) ;			
		new Consumer (q);			
		   }
		}