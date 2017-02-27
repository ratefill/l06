package by.epam.l06.example;

public class BookInspector
{
	public static void main(String[] args)
	{
		Book2 mybook2 = new Book2("Золушка", 2000, 19000);
		ProgrammerBook2 myprogrbook2 = new ProgrammerBook2("Java", 2006, 46000, "hight");
		mybook2.show();
		
		myprogrbook2.show();
		
		mybook2.testVirtualrun();
		myprogrbook2.testVirtualrun();
	}
}

class Book2
{
	private String title;
	private int yearPublished;
	private int price;
	
	public void testVirtual()
	{
		System.out.println("Book2-testVirtual");
	}

	public void testVirtualrun()
	{
		testVirtual();
	}	
	
	public Book2()
	{
	}

	public Book2(String title, int yearPublished, int price)
	{
		this.title = title;
		this.yearPublished = yearPublished;
		this.price = price;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getYearPublished()
	{
		return yearPublished;
	}

	public void setYearPublished(int yearPublished)
	{
		this.yearPublished = yearPublished;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public void show()
	{
		System.out.println("Название: " + title + " год издания: " + yearPublished + "цена: " + price);
	}
}

class ProgrammerBook2 extends Book2
{
	private String level;
	
	
	public void testVirtual()
	{
		System.out.println("ProgrammerBook2-testVirtual");
	}

	public ProgrammerBook2(String title, int yearPublished, int price, String level)
	{
		super(title, yearPublished, price);
		this.level = level;
	}

	public String getLevel()
	{
		return level;
	}

	public void show()
	{
		System.out.println("Название: " + getTitle() + " год издания: " + getYearPublished() + " цена: " + getPrice()
				+ " уровень: " + level);
	}
}
