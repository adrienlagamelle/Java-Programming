import java.util.Scanner;
/**
 * A program that process book order and keep tracks of their information
 * Assignment 4
 * Student No. 201640422
 * @author lagamelle
 *
 */

public class BookOrder 
{	
	// Initialize the instance variables
	private String dept, courseNo, ISBN, title, authorName, publisher, yearPub, edNo;
	private double price, classSize;
	private String priority, state;
	
	/**
	 * Constructs a bookOrder object with the following parameter
	 * @param course
	 * @param ISBN
	 * @param authorName
	 * @param publisher
	 * @param yearPub
	 * @param edNo
	 * @param price
	 * @param classSize
	 * @param priority
	 * @param state
	 */
	public BookOrder( String dept, String courseNo, String ISBN, String title, String authorName, String publisher, String yearPub, String edNo, double price, double classSize, String priority, String state)
	{
		this.setDept(dept);
		this.setCourseNo(courseNo);
		this.setISBN(ISBN);
		this.setTitle(title);
		this.setAuthorName(authorName);
		this.setPublisher(publisher);
		this.setYearPub(yearPub);
		this.setEdNo(edNo);
		this.setPrice(price);
		this.setClassSize(classSize);
		this.setPriority(priority);
		this.setState(state);
		
	}
	
	/** Gets the department detail
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/** Set the department 
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	/** GEts the course number
	 * @return the courseNo
	 */
	public String getCourseNo() {
		return courseNo;
	}
	/** Sets the course number for the department
	 * @param courseNo the courseNo to set
	 */
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	/////////////////////////////////////////////////////////////////

	/**
	 * Gets the ISBN for the book
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}
	/**Sets the ISBN of the book
	 * @param ISBN the ISBN to set
	 */
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	/** Gets the title of the book
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/** Sets the title of the book
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the yearPub
	 */
	public String getYearPub() {
		return yearPub;
	}
	/**
	 * @param yearPub the yearPub to set
	 */
	public void setYearPub(String yearPub) {
		this.yearPub = yearPub;
	}

	/**
	 * @return the edNo
	 */
	public String getEdNo() {
		return edNo;
	}
	/**
	 * @param edNo the edNo to set
	 */
	public void setEdNo(String edNo) {
		this.edNo = edNo;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the classSize
	 */
	public double getClassSize() {
		return classSize;
	}
	/**
	 * @param classSize the classSize to set
	 */
	public void setClassSize(double classSize) {
		this.classSize = classSize;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/////////////////////////////////////////////////
	// A method to output the information

	public void tostring() {
		System.out.println("Department: " + this.dept);
		System.out.println("Course Number : " + this.courseNo);
		System.out.println("ISBN : " + this.ISBN);
		System.out.println("Title : " + this.title);
		System.out.println("Author name : " + this.authorName);
		System.out.println("Publisher : " + this.publisher);
		System.out.println("Year of publication : " + this.yearPub);
		System.out.println("Edition Number : " + this.edNo);
		System.out.println("Price : " + this.price);
		System.out.println("Estimated class size : " + this.classSize);
		System.out.println("Priority : " + this.priority);
		System.out.println("State : " + this.state);	
	}

	// A method to determine the number of books to be ordered
	public int numToOrder() {
		double x = 9999;
		if (this.priority.equals("required")) {
			if (this.state.equals("used"))
				x = 0.60 * this.classSize;
			else 
				x = 0.85 * this.classSize;}
		
		if (this.priority.equals("recommended")) {
			if (this.state.equals("used"))
				x = 0.25 * this.classSize;
			else
				x = 0.40 * this.classSize;}
		
		return (int) x;

	}
	
	// A main method to test the class
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// Create a one-dimensional (1-D) array of 100 BookOrder objects.
		BookOrder[] books = new BookOrder[100];
		
		System.out.print("Enter the number of book orders to be added: ");
		int N = in.nextInt();
		
		// Fills the array of objects with N elements
		for (int i = 0; i < N; i++) {
			
			// Prompt the user for information
			System.out.println("Complete the following information for Book " + (i+1));
			System.out.print("Enter the Course Department: " );
			String dept = in.next();
			System.out.print("Enter the Course number: ");
			String courseNo = in.next();
			System.out.print("Enter the ISBN- 19 digits: ");
			String ISBN = in.next();
			while (ISBN.length() != 19) {
				System.out.print("Enter a valid ISBN- 19 digits: ");
				ISBN = in.next(); }
			System.out.print("Enter the book title: ");
			String title = in.next();
			System.out.print("Enter the Author Name(last name only): ");
			String authorName = in.next();
			System.out.print("Enter the Publisher name: ");
			String publisher = in.next();
			System.out.print("Enter the Year of Publication: ");
			String yearPub = in.next();
			System.out.print("Enter the Edition number: ");
			String edNo = in.next();
			System.out.print("Enter the book price: ");
			double price = in.nextDouble();
			System.out.print("Enter the estimated class size: ");
			double classSize = in.nextDouble();
			System.out.print("Enter the book priority- enter 'recommended' or 'required' only: ");
			String priority = in.next();
			System.out.print("Enter the book state- enter 'new' or 'used' only: ");
			String state = in.next();
			System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
			
			// Create the BookOrder object
			books[i] = new BookOrder(dept, courseNo, ISBN, title, authorName, publisher, yearPub, edNo, price, classSize, priority, state);
			
		}
		// Display the book orders entered with information
		for (int i = 0; i < N; i++) {
			System.out.println(">>>>>> BOOK "+ (i+1) + " <<<<<<<<");
			books[i].tostring();
			
		//  Determine and display the number of books to be ordered and
		// the amount of markup per book
			System.out.println("The number of books to be ordered: " + books[i].numToOrder());
			double markup;
			if (books[i].getPrice() < 100)
				 markup = 0.25 * books[i].getPrice();
			else
				markup = 0.20  * books[i].getPrice();
			System.out.println("Markup for the book: " + markup);
			System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
			
		}
		System.out.println();
		// Output the course which have required texts that were previously used
		System.out.println("Courses which have required texts that have been previously used: ");
		for (int i = 0; i < N; i++) {
			if (books[i].getPriority().equals("required") && books[i].getState().equals("used")) 
				System.out.println((i+1) + ") "+ books[i].getDept() + " "+ books[i].getCourseNo());
			}
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
		System.out.println();
		
		// Output information for COMP courses only
		System.out.println(" >>> INFORMATION FOR COMPUTER SCIENCE COURSES ONLY <<< ");
		for (int i = 0; i < N; i++) {
			if (books[i].dept.equals("COMP")) {
				System.out.println("Department: " + books[i].getDept());
				System.out.println("Course Number : " + books[i].getCourseNo());
				System.out.println("ISBN : " + books[i].getISBN());
				System.out.println("Title : " + books[i].getTitle());
				System.out.println("Author name : " + books[i].getAuthorName());
				System.out.println("Year of publication : " + books[i].getYearPub());
				System.out.println("Edition Number : " + books[i].getEdNo());
				System.out.println("Price : " + books[i].getPrice());
				System.out.println();
			}
		}
		
		// Find books based on publisher name
		boolean cont = true;
		while (cont == true) {
			System.out.print("Enter a publisher name to be searched for:");
			String publisher = in.next();
			for (int i = 0; i < N; i++) {
				if (books[i].publisher.equals(publisher)) {
					System.out.println("ISBN : " + books[i].getISBN());
					System.out.println("Title : " + books[i].getTitle());
					System.out.println("Author name : " + books[i].getAuthorName());
					System.out.println("Year of publication : " + books[i].getYearPub());
					System.out.println("Edition Number : " + books[i].getEdNo());
					System.out.println("Price : " + books[i].getPrice());
					System.out.println("Book orders: " + books[i].numToOrder());
					System.out.println();
				}
			}
			System.out.print("Continue ? true or false :");
			cont = in.nextBoolean();
		}
		
	}
	
}