package by.epam.l06.example;



public class EqualsOperator
{
	public static void main(String[] args)
	{
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 2);
		if (f1.equals(f2))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		System.out.println(f1.hashCode());
		System.out.println(f2.hashCode());
	}
}

class Fraction
{
	private int numerator;
	private int denominator;

	public Fraction()
	{
		numerator = denominator = 1;
	}

	public Fraction(int num, int den)
	{
		numerator = num;
		denominator = den;
	}

	public int getNumerator()
	{
		return numerator;
	}

	public void setNumerator(int numerator)
	{
		this.numerator = numerator;
	}

	public int getDenominator()
	{
		return denominator;
	}

	public void setDenominator(int denominator)
	{
		this.denominator = denominator;
	}
}

