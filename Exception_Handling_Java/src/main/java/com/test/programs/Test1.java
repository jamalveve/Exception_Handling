package com.test.programs;

public class Test1 {
	static {
  	  System.out.println("hello I am static");
  }
//	 18)
	  static int anyMethod()
	    {
	        try
	        {
	            return 10;
	        }
	        catch (Exception e) 
	        {
	            return 20;
	        }
	        finally
	        {
	            return 30;
	        }
	    }
	     
	  
	  static int anyMethod1()
	    {
	        int i = 1;
	         
	        try
	        {
	            i = i/0;//forst exception come here
	             
	            return ++i;
	        }
	        catch (Exception e) 
	        {
	        	System.out.println(e);
	            return ++i;//it will come here and I becomes 2
	        }
	        finally
	        {
	            return ++i;//then here 1+1 2+1 becomes 3
	        }
	    }
	  
	  
	  static void anyMethod2()
	    {
	        try
	        {
	            return;
	        }
	        catch (Exception e) 
	        {
	            return;
	        }
	        finally
	        {
	            System.out.println("finally Block");
	        }
	    }
	  static String anyMethod3()
	    {
	        String s = "ZERO";
	         
	        try
	        {
	            s = s + "ONE";
	             
	            return s; //here  s=ZERONE
	        }
	        catch (Exception e) 
	        {
	            s = s + "TWO";//it wont cometo catch
	             
	            return s;
	        }
	        finally
	        {
	            s = s + "THREE";
	             
	            return s;//here already s=ZEROONE+THREE=O.P:ZEROONETHREEs
	        }
	    }
	  //continiue from 22 
	  //https://javaconceptoftheday.com/java-exception-handling-quiz/
	     

	public static void main(String[] args) {
		
		System.out.println(anyMethod());
		System.out.println(anyMethod1());
		System.out.println(anyMethod2());//doubt
		System.out.println(anyMethod3());//doubt



		// TODO Auto-generated method stub
//        1)
		System.out.println("=======Example 1======");
		try {
			System.out.println("Try Block");
		}

//        System.out.println("-----");//There should not be any other statements in between try and catch blocks.

		catch (Exception e) {
			System.out.println("Catch Block");
		}

//        2)
		System.out.println("=======Example 2======");

		try {// even though tyr is nott throwing exception is is possibe to follow by catch
			System.out.println("Try Block");
		}

//        System.out.println("-----");//There should not be any other statements in between try and catch blocks.

		catch (Exception e) {
			System.out.println("Catch Block");
		}

//        3)
		System.out.println("=======Example 3======");


		int i = 1;

		try {
			i++;// here i is 1 and inc by 1,becomes 1+1=2
		} catch (Exception e) {
			i++;// since try have no exce[tion it wont work
		} finally {
			i++;// here i is 2 and inc by 1 so 2+1=3
		}

		System.out.println(i);

//  4)
		System.out.println("=======Example 4======");

		String str = "jam";

		try {
			str += "jam";
		} catch (Exception e) {
			str += "jam";
		} finally {
			str += "jam";
		}

		System.out.println(str);

//  5
		System.out.println("=======Example 5======");

		try {
			System.out.println(1);

			int imnteger = 100 / 0;

			System.out.println(2);
		} catch (Exception e) {
			System.out.println(3);
		}

//  6)between ctacha nd finally also there should not be any ther statement so try ctach finally all together forms a sigle unit
		System.out.println("=======Example 6======");

		try {
			System.out.println(1);
		} catch (Exception e) {
			System.out.println(2);
		}

//  System.out.println(3);

		finally {
			System.out.println(4);
		}

//	7)
		System.out.println("=======Example 7======");

		try {
			System.out.println(1);
		} catch (Exception e) {
			System.out.println(2);
		}

		finally {
			System.out.println(4);
		}

//	 8)
		System.out.println("=======Example 8======");

		System.out.println(1);

		try {
			System.out.println(2);

			int inrs = Integer.parseInt("ABC");// try to parse string to int not possible so ctach will ctach teh
												// exception

			System.out.println(3);
		} catch (Exception e) {
			System.out.println(4);
		}

		finally {
			System.out.println(5);
		}

		System.out.println(6);

//     9)
		System.out.println("=======Example 9======");

		try {
			System.out.println(1);

			int into = Integer.parseInt("ABC");

			System.out.println(2);
		} catch (NumberFormatException e) {
			System.out.println(3);
		} catch (Exception e) {
			System.out.println(4);
		}

//		10)
		System.out.println("=======Example 10======");

		System.out.println("example10");
		 try
	        {
	            String s = null;
	             
	            int length= s.length();
	        }
	        catch (Exception e) 
	        {
	            System.out.println(1);
	        }
//	        catch (NullPointerException e) //in the above example 9 first catch is child exceptin secod catch is parent exception->tht os possible but here this is not possibkr
	        {
	            System.out.println(2);//nreachable catch block for NullPointerException. 
	            
	            
	        }
	        
		 
//		 11)
			System.out.println("=======Example 11======");

		 String[] s = {"abc", "123", null, "xyz"};
         
	        for (int ints = 0; ints < 6; ints++)
	        {
	            try
	            {
	                int a = s[ints].length() + Integer.parseInt(s[ints]); 
	            }
	            catch (NumberFormatException e) 
	            {
	                System.out.println(1);
	            }
	            catch (NullPointerException e) 
	            {
	                System.out.println(2);
	            }
	            catch (ArrayIndexOutOfBoundsException e) 
	            {
	                System.out.println(3);
	            }
	        }
//	        12)
			System.out.println("=======Example 12======");

	        try
	        {
	            System.out.println("try Block");
	        }
	        finally
	        {
	            System.out.println("finally Block");
	        }
	        
//	        13)
			System.out.println("=======Example 13======");

	        try
	        {
//	        	int abc=100/0;
	            System.out.println("try Block");//this wont print bcz of exception here no cpompiler error but runtime will occur
	        }
	        finally
	        {
	            System.out.println("finally Block");
	        }
	        
	        
//	        14)
	        
//	        try
//	        {
//	            System.out.println("try Block");
//	        }//compiler error bcz->There should be either catch block or finally block along with try block.
//	
////	      15)
//	        try
//	        {
//	            System.out.println(1);
//	        }
//	        catch (Exception | NumberFormatException | NullPointerException e) 
//	        {
//	            System.out.println(2);
//	        }//kind of unreachable
//	
//	        
////		      16)
//		        try
//		        {
//		            System.out.println(1);
//		        }
//		        catch (NumberFormatException | NullPointerException |Exception e) 
//		        {
//		            System.out.println(2);
//		        }//kind of unreachable
//
////			      16)
//			        try
//			        {
//			            System.out.println(1);
//			        }
//			        catch ( NullPointerException |Exception e) 
//			        {
//			            System.out.println(2);
//			        }//kind of unreachable
////				      16)
//				        try
//				        {
//				            System.out.println(1);
//				        }
//				        catch ( NumberFormatException |Exception e) 
//				        {
//				            System.out.println(2);
//				        }//kind of unreachable
//				        
////				        16)
//				        )
//				        try
//				        {
//				            System.out.println(1);
//				        }
//				        catch ( ArithmeticException |NumberFormatException e) 
//				        {
//				            System.out.println(2);
//				        }//possible okay //ypu can pipe wit Exception bcz it is the parent class of all the excepion
//				        
//			
//		
//	        17 
			System.out.println("=======Example 17======");
	        try
	        {
//	            main(args);
	        }
	        catch (NumberFormatException | NullPointerException e) 
	        {
	        	System.out.println("reching 17");
	            System.out.println(1);
	        }
	        catch(Exception e) {
	        	System.out.println("reching 17");

	        	System.out.println(e);
	        }
	        catch ( Error e) 
	        {
	        	System.out.println("reching 17");

	            System.out.println(2);
	        }
		
	        
	
	
	}

}
