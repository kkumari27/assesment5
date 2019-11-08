package com.main;
import java.util.*;

import dao.ProductDao;
import model.Product;

public class Main {

	
	 static Scanner scan = new Scanner(System.in);
	 static ProductDao products = new ProductDao();
	 static List<Product> product= new ArrayList<>();
	 
	 public static void main(String[] args) {
		 
		
		 System.out.printf("%70s\n","Welcome to the  Product Inventory Management");
		
		 int option=-1;
		 do {
	    	  System.out.println("\n\n Select  options.....\n");
	    	 
			  System.out.println("Press 1 to Add Product");
		      System.out.println("Press 2 to View Products");
		      System.out.println("Press 3 to Update Product");
		      System.out.println("Press 4 to Delete Product");
			  System.out.println("Press 5 to Exit");
			  
			  option= scan.nextInt();
			  
			  switch(option) {
			  
			  case 1:
				  
				    System.out.println("Enter Product Name:");
				    String name=scan.next();
				    System.out.println("Enter Description: ");
					String description=scan.next();
					System.out.println("Enter Price: ");
					int price=scan.nextInt();
					System.out.println("Enter Quantity: ");
					int quantity=scan.nextInt();
					Product p= new Product(name,description,price,quantity);
					products.create(p);
					break;
				  
			  case 2:
				  List<Product> product =products.findAll();
				     
				     System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				      System.out.println("ID   Name       Price         Description             Quantity \n");
				      for(Product itr:product) {
				    	  System.out.printf("%1s %7s  %12s %18s %25s  \n",itr.getId(),itr.getName(),itr.getPrice(),itr.getDescription(),itr.getQuantity());
				    	  
				      }
				      break;
			      
			  case 3:
				  System.out.println("Enter id");
					int uid=scan.nextInt();
					System.out.println("Enter updated name");
					String uname=scan.next();
					System.out.println("Enter updated Price");
					int uprice=scan.nextInt();
					System.out.println("Enter updated quantity");
					int uquantity=scan.nextInt();
					System.out.println("Enter updated Description");
					String udesc=scan.next();
					Product ps=products.update(uid,uname,udesc, uprice, uquantity); 
					break;
			  case 4:
				  System.out.println("Enter the Id of the element you want to delete ");
					int did=scan.nextInt();
					products.delete(did);
					break;
				    
			  case 5:
				  option=-1;
				  System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				  System.out.printf("%70s\n","Exiting the Inventory Manager");
				  System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				  break;
				  
			 
				  
			  default:
				  System.out.println("Enter a Valid Choice");
			  }
			  
	      }while(option!=-1);
	 }
	  
}
