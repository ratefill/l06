package by.epam.l06.example;

public class EqualsOperator2
{
	public static void main(String[] args)
	{
		Fraction2 f1 = new Fraction2(1, 2);
		Fraction2 f2 = new Fraction2(1, 2);
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


class Fraction2
{
	private int numerator;
	private int denominator;

	public Fraction2()
	{
		numerator = denominator = 1;
	}

	public Fraction2(int num, int den)
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

	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (this == obj)
		{
			return true;
		}
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		Fraction2 frac = (Fraction2) obj;
		if (numerator != frac.numerator)
		{
			return false;
		}
		if (denominator != frac.denominator)
		{

			return false;
		}
		return true;
	}

	public int hashCode()
	{
		return numerator + 31 * denominator;
	}
}

