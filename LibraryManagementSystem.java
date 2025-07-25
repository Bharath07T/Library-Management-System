package Systems;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.*;
class Book{
	private int bookId;
	private String title;
	private String author;
	private int stock;
	
	public Book(int bookId,String title,String author,int stock) {
		this.bookId=bookId;
		this.title=title;
		this.author=author;
		this.stock=stock;
	}
	
	public void setBookId(int bookId) {
		this.bookId=bookId;
	}
	public int getBookId() {
		return this.bookId;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	public String getTitle() {
		return this.title;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	public String getAuthor() {
		return this.author;
	}
	
	public void setStock(int stock) {
		this.stock=stock;
	}
	public int getStock() {
		return this.stock;
	}
	
	public String toString() {
		return "BookDetails[BookId:"+this.bookId+",Book-Title:"+this.title+",Author:"+this.author+",Stock-Available:"+this.stock+"]";
	}
	
	public void borrowBook() {
		this.stock--;
	}
	
	public void returnBook() {
		this.stock++;
	}
}
class Member{
	private int memberId;
	private String name;
	
	public Member(int memId,String na) {
		this.memberId=memId;
		this.name=na;
	}
	
	public void setMemberId(int memberId) {
		this.memberId=memberId;
	}
	public int getMemberId() {
		return this.memberId;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "MemberShip-Details[MemberId:"+this.memberId+",Name:"+this.name+"]";
	}
}

class FineCalculator{
	private double finePerDay=2.00;
	
	public double calculateFine(int lateDays) {
		return (this.finePerDay*lateDays);
	}	
}

class Library{
	private List<Book> books;
	private List<Member> members;
	private LocalDate BorrowDate;
	private FineCalculator finecalculator;
	
	Map<Integer,LocalDate> bookIssuesDate=new HashMap<>();
	
	public Library() {
		this.books=new ArrayList<>();
		this.members=new ArrayList<>();
		this.BorrowDate=LocalDate.now();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void addMember(Member member) {
		members.add(member);
	}
	
	public Book findBook(int bookId) {
		for(Book book:books) {
			if(book.getBookId()==bookId) return book;
		}
		return null;
	}
	
	public Member findMember(int memberId) {
		for(Member mem:members) {
			if(mem.getMemberId()==memberId) return mem;
		}
		return null;
	}
	
	public void borrowBook(int bookId,int memberId) {
		Book book=findBook(bookId);
		if(book!=null && book.getStock()!=0) {
			book.borrowBook();
			bookIssuesDate.put(bookId, LocalDate.now());
			System.out.println("Book is borrowed Successfully!Book borrowed on "+BorrowDate+"(Please return the book not more than 14 days)");
		}else {
			System.out.println("Book is not available");
		}
	}
	
	public void returnBook(int bookId) {
		Book book=findBook(bookId);
		if(book!=null) {
			book.returnBook();
			LocalDate issueDate=bookIssuesDate.get(bookId);
			LocalDate returnDate=LocalDate.now();
			long daysBetween=ChronoUnit.DAYS.between(issueDate, returnDate);
			long daysLate=daysBetween>14?daysBetween-14:0;
			
			if(daysLate>0) {
				double fine=finecalculator.calculateFine((int) daysLate);
				System.out.println("Book returned late by " + daysLate + " day(s). Fine: Rs. " + fine);
			}else {
				System.out.println("Book returned on Time.");
			}
		}
	}
	
	public Book displayBooks() {
		for(Book book:books) {
			System.out.println(book);
		}
		return null;
	}
	
	public Member displayMembers() {
		for(Member member:members) {
			System.out.println(member);
		}
		return null;
	}
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
    	Library library=new Library();
    	Scanner sc = new Scanner(System.in);
    	library.addBook(new Book(101,"The FireWall","James Goshling",24));
    	library.addBook(new Book(102,"The Dragon Warrior","Shang sui",1));
    	library.addMember(new Member(1,"Dansri"));
    	library.addMember(new Member(2,"Bharath"));
    	
    	while(true) {
    		System.out.println("---Library Management System---");
    		System.out.println("1.Display Books");
    		System.out.println("2.Display Members");
    		System.out.println("3.Borrow Book(s)");
    		System.out.println("4.Return Book(s)");
    		System.out.println("5.Exit");
    		
    		int choice=sc.nextInt();
    		
    		switch(choice) {
    		  case 1:{
    			  library.displayBooks();
    			  break;
    		  }
    		  case 2:{
    			  library.displayMembers();
    			  break;
    		  }
    		  case 3:{
    			  System.out.println("Enter BookId:");
    			  int bookid=sc.nextInt();
    			  System.out.println("Enter MemberId:");
    			  int memberid=sc.nextInt();
    			  library.borrowBook(bookid, memberid);
    			  break;
    		  }
    		  case 4:{
    			  System.out.println("Enter BookId:");
    			  int bookid=sc.nextInt();
    			  library.returnBook(bookid);
    			  break;
    		  }
    		  case 5:{
    			  System.out.println("Logged Out...");
    			  sc.close();
    			  break;
    		  }
    		  default:{
    			  System.out.println("Entered a wrong Choice");
    		  }
    		}
    	}
    }
}
