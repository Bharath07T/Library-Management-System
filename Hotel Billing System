package Systems;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
class Restaurant
{
	private String name;
	private String address;
	private String contactNumber;
	private List<MenuItem> menu;
	public Restaurant(String n,String ad,String co)
	{
		this.name=n;
		this.address=ad;
		this.contactNumber=co;
		this.menu=new ArrayList<>();
		
	}
	public void addMenuItem(MenuItem item)
	{
		menu.add(item);
	}
	public List<MenuItem> getMenu()
	{
		return menu;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getContactNumber()
	{
		return this.contactNumber;
	}
	public void setContactNumber(String contactNumber)
	{
		this.contactNumber=contactNumber;
	}
}
class MenuItem
{
	private int itemId;
	private String name;
	private String description;
	private double price;
	public MenuItem(int it,String na,String de,double pr)
	{
		this.itemId=it;
		this.name=na;
		this.description=de;
		this.price=pr;
	}
	public String getDetails()
	{
		return "MenuItem[ItemId="+this.itemId+",Name="+this.name+",Description="+this.description+",Price="+this.price+"]";
	}
	public int getItemId()
	{
		return this.itemId;
	}
	public void setItemId(int itemId)
	{
		this.itemId=itemId;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public double getPrice()
	{
		return this.price;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
}
class CustomerI
{
	private int customerId;
	private String name;
	private String contactNumber;
	public CustomerI(int cu,String na,String co)
	{
		this.customerId=cu;
		this.name=na;
		this.contactNumber=co;
	}
	public String getDetails()
	{
		return "Customer[CustomerId="+this.customerId+",Name="+this.name+",ContactNumber="+this.contactNumber+"]";
	}
	public int getCustomerId()
	{
		return this.customerId;
	}
	public void setCustomerId(int customerId)
	{
		this.customerId=customerId;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getContactNumber()
	{
		return this.contactNumber;
	}
	public void setContactNumber(String contactNumber)
	{
		this.contactNumber=contactNumber;
	}
}
class Order
{
	private int orderId;
	private CustomerI customer;
	private List<MenuItem> items;
	private LocalDate orderDate;
	public Order(int or,CustomerI cu,LocalDate or1)
	{
		this.orderId=or;
		this.customer=cu;
		this.orderDate=or1;
		this.items=new ArrayList<>();
	}
	public void addItems(MenuItem item)
	{
		items.add(item);
	}
	public double CalculateTotal()
	{
		return items.stream().mapToDouble(MenuItem::getPrice).sum();
	}
	public int getOrderId()
	{
		return this.orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId=orderId;
	}
	public CustomerI getCustomer()
	{
		return this.customer;
	}
	public void setCustomer(CustomerI customer)
	{
		this.customer=customer;
	}
	public LocalDate getOrderDate()
	{
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate)
	{
		this.orderDate=orderDate;
	}
	public List<MenuItem> getItems()
	{
		return items;
	}
}
class Invoice
{
	private int invoiceId;
	private Order order;
	private double totalAmount;
	private LocalDate invoiceDate;
	public Invoice(int in,Order or)
	{
		this.invoiceId=in;
		this.order=or;
		this.totalAmount=order.CalculateTotal();
		this.invoiceDate=LocalDate.now();
	}
	public void generateInvoice()
	{
		System.out.println("-------Dansri Restaurant--------");
		System.out.println("----------Invoice---------");
		System.out.println("InvoiceId:"+invoiceId);
		System.out.println("Invoice Date:"+invoiceDate);
		System.out.println("Customer:"+order.getCustomer().getName());
		System.out.println("Order Details:");
		order.getItems().forEach(item->
		{
			System.out.println("- "+item.getName()+": $"+item.getPrice());
		});
		System.out.println("Total Amount: $"+totalAmount);
		System.out.println("---------------------------");
	}
	public int getInvoiceId()
	{
		return this.invoiceId;
	}
	public void setInvoiceId(int invoiceId)
	{
		this.invoiceId=invoiceId;
	}
	public Order getOrder()
	{
		return this.order;
	}
	public void setOrder(Order order)
	{
		this.order=order;
		this.totalAmount=order.CalculateTotal();
	}
	public double getTotalAmount()
	{
		return this.totalAmount;
	}
	public void setTotalAmount(double totalAmount)
	{
		this.totalAmount=totalAmount;
	}
	public LocalDate getInvoiceDate()
	{
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDate invoiceDate)
	{
		this.invoiceDate=invoiceDate;
	}
}
class Payment
{
	private int paymentId;
	private Invoice invoice;
	private String paymentMethod;
	private String paymentStatus;
	public Payment(int pa,Invoice in,String pm)
	{
		this.paymentId=pa;
		this.invoice=in;
		this.paymentMethod=pm;
	}
	public boolean processPayment()
	{
		if(paymentMethod.equalsIgnoreCase("Cash")||
		   paymentMethod.equalsIgnoreCase("Card")||
		   paymentMethod.equalsIgnoreCase("Online"))
         {
	         this.paymentStatus="Completed";
	         System.out.println("Payment processed Successfully");
	         return true;
         }
		else
		{
			System.out.println("Payment failed.Invalid payment method.");
			return false;
		}
	}
	public int getPaymentId()
	{
		return this.paymentId;
	}
	public void setPaymentId(int paymentId)
	{
		this.paymentId=paymentId;
	}
	public Invoice getInvoice()
	{
		return this.invoice;
	}
	public void setInvoice(Invoice invoice)
	{
		this.invoice=invoice;
	}
	public String getPaymentMethod()
	{
		return this.paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod)
	{
		this.paymentMethod=paymentMethod;
	}
	public String getPaymentStatus()
	{
		return this.paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus)
	{
		this.paymentStatus=paymentStatus;
	}
}
public class HotelBillingSystem {
    public static void main(String[] args) {
		Restaurant rs=new Restaurant("Dansri Restaurant","14/6b,Pattakarar Street,Pallapalayam","7548834499");
		MenuItem pizza=new MenuItem(1,"Pizza","Cheese Pizza",23.00);
		MenuItem burger=new MenuItem(1,"Burger","Ham Burger",10.00);
		MenuItem pasta=new MenuItem(1,"Pasta","Macaroni Pasta",45.00);
		rs.addMenuItem(pizza);
		rs.addMenuItem(burger);
		rs.addMenuItem(pasta);
		System.out.println("Menu");
		for(MenuItem item:rs.getMenu())
		{
			System.out.println("- "+item.getName()+": $"+item.getPrice());
		}
		CustomerI cs=new CustomerI(101,"Dansri","9788308970");
		Order or=new Order(201,cs,LocalDate.now());
		or.addItems(pizza);
		or.addItems(burger);
		System.out.println("\nOrder Details:");
		System.out.println("Customer: "+cs.getName());
		System.out.println("Items Ordered:");
		for(MenuItem item:or.getItems())
		{
			System.out.println("- "+item.getName()+": $"+item.getPrice());
		}
		System.out.println("Total Order Amount: $"+or.CalculateTotal());
		Invoice in=new Invoice(301,or);
		System.out.println("\nGenerated Invoice:");
		in.generateInvoice();
		Payment pa=new Payment(401,in,"card");
		pa.processPayment();
		System.out.println("Payment Status: "+pa.getPaymentStatus());
	}
}

