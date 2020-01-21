package Ekart;
import java.util.*;
public class Shop {

	static class Product{
		int ID;
		String Name;
		int QuantityAvailable;
		double Price;
		Product(int ID, String Name, int Qty, double Price){
			this.ID = ID;
			this.Name = Name;
			this.QuantityAvailable = Qty;
			this.Price = Price;
		}		
	}

	static class Store{
		int ID;
		String Name;
		int QuantityAvailable;
		double Price;
		Map<Integer,Product> Items = new HashMap<Integer,Product>();
		void setDetails(Scanner sin) {
			
				while(true) {
					System.out.println("Enter ID of Item or -1 to exit : ");
					ID = sin.nextInt();
					if(ID == -1)
						break;
					System.out.println("Enter Name of Item : ");
					Name = sin.next();
					System.out.println("Enter Quantity Available : ");
					QuantityAvailable = sin.nextInt();
					System.out.println("Enter Price : ");
					Price = sin.nextDouble();
					Product Item = new Product(ID,Name,QuantityAvailable,Price);
					Items.put(ID, Item);
				}	
		}
		void viewStore() {
			for (Map.Entry<Integer,Product> cartItem : this.Items.entrySet()) {
				System.out.println("Item ID : "+cartItem.getValue().ID);
				System.out.println("Name : "+cartItem.getValue().Name);
				System.out.println("Price : "+cartItem.getValue().Price);
				System.out.println("Quantity Available : "+cartItem.getValue().QuantityAvailable);
			}
		}
	}
	
	static public class Customer extends Store{
		int ID;
		String UserName;
		Map<Integer,Integer> cart;
		int TotalCost;
		Customer(int ID, String UserName){
			this.ID = ID;
			this.UserName = UserName;
			this.cart = new HashMap<Integer, Integer>();
			TotalCost = 0;
		}
		
		void addToCart(int ID, int Qty, Store Store1) {
					if(Store1.Items.containsKey(ID)) {
						if((Store1.Items.get(ID).QuantityAvailable>Qty)) {
							(Store1.Items.get(ID)).QuantityAvailable = (Store1.Items.get(ID)).QuantityAvailable - Qty;
							this.TotalCost += Store1.Items.get(ID).Price * Qty;
							this.cart.put(ID, Qty);
							System.out.println("Added to cart successfully.");
						}
						else {
							System.out.println("The amount of Quantity is less then sepcified.");
						}
					}
					else {
						System.out.println("Item not present in the Store.");
					}
				}
		void ViewCart() {
			for (Map.Entry<Integer,Integer> cartItem : this.cart.entrySet()) {
				System.out.println("These are your Cart Details : ");
				System.out.println("Item ID : "+cartItem.getKey());
				System.out.println("Qty : "+cartItem.getValue());
			}
		}
		void RemoveItemCart(int ID, Store Store1) {
			if(this.cart.containsKey(ID)) {
				this.TotalCost -= Store1.Items.get(ID).Price * this.cart.get(ID);
				this.cart.remove(ID);
				System.out.println("Item Removed Successfully.");
			}
			else {
				System.out.println("Item not present in cart.");
			}
		}
	}
	
	
	static class Order{
		int OrderID;
		int CustomerId;
		ArrayList<Integer> ProductDetails;
		Random rand=new Random();
		Order(int ID, String UserName) {
			ProductDetails = new ArrayList<Integer>();
			CustomerId = ID;
			OrderID = rand.nextInt(1000);
		}
		void viewOrder(Store Store1, Customer Customer1) {
			System.out.println("OrderID : #"+this.OrderID);
			System.out.println("CustomerID : "+this.CustomerId);
			System.out.println("The Details of Items are as below :");
			for (Map.Entry<Integer,Integer> cartItem : Customer1.cart.entrySet()) {
				System.out.println("Product ID : "+Store1.Items.get(cartItem.getKey()).ID);
				System.out.println("Name : "+Store1.Items.get(cartItem.getKey()).Name);
				System.out.println("Price : "+Store1.Items.get(cartItem.getKey()).Price);
				System.out.println("Qty : "+cartItem.getValue());
				System.out.println("Total Cost : "+Customer1.TotalCost);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		int CID;
		String CUserName;
		
		int choice;
		
		int ID,Qty;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Shopkeeper -> ");
		Store Store1 = new Store();
		Store1.setDetails(input);
		
		System.out.println("Customer -> ");
		System.out.println("Enter Customer ID : ");
		CID = input.nextInt();
		System.out.println("Enter Username : ");
		CUserName = input.next();
		
		Customer Customer1 = new Customer(CID, CUserName);
		System.out.println("Hello "+CUserName);
		System.out.println("------------------------------");
		int remID;
		while(true) {
			System.out.println("Choose any of the below Operation : \n1.View Store\n2.Add Product to cart\n3.View Cart\n4.Remove from cart\n5.Place the order\n6.Cancel the order\n7.Logout");
			choice = input.nextInt();
			switch(choice) {
			case 1:
				System.out.println("------------------------------");
				System.out.println("The items in store are as below :");
				Store1.viewStore();
				System.out.println("------------------------------");
				break;
			case 2:
				System.out.println("------------------------------");
				System.out.println("Enter the details of item to be added to cart.");
				System.out.println("Enter ID :");
				ID = input.nextInt();
				System.out.println("Enter Quantity : ");
				Qty = input.nextInt();
				Customer1.addToCart(ID, Qty, Store1);
				System.out.println("------------------------------");
				break;
			case 3:
				System.out.println("------------------------------");
				Customer1.ViewCart();
				System.out.println("------------------------------");
				break;
			case 4:
				System.out.println("------------------------------");
				System.out.println("Enter the ID of Item to remove from cart : ");
				remID = input.nextInt();
				Customer1.RemoveItemCart(remID, Store1);
				System.out.println("------------------------------");
				break;
			case 5:
				System.out.println("------------------------------");
				Order Corder = new Order(Customer1.ID, Customer1.UserName);
				System.out.println("Here is the summary of the purchase : ");
				Corder.viewOrder(Store1,Customer1);
				System.out.println("------------------------------");
				System.exit(0);
				break;
			case 6:
				System.out.println("------------------------------");
				Customer1.cart.clear();
				System.out.println("Order Cancelled.");
				System.out.println("------------------------------");
				break;
			default:
				System.exit(0);
			}
		}
	}
}
