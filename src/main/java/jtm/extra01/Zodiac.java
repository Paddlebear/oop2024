package jtm.extra01;

public class Zodiac {

	/**
	 * Determine the sign of the zodiac, use day and month.
	 * 
	 * @param day
	 * @param month
	 * @return zodiac
	 */
	public static String getZodiac(int day, int month) {
		String zodiac = null;
		// TODO #1: Implement method which return zodiac sign names
		// As method parameter - day and month;
		// Look at wikipedia:
		// https://en.wikipedia.org/wiki/Zodiac#Table_of_dates
		// Tropical zodiac, to get appropriate date ranges for signs
		switch (month)
            {
				default:
                    zodiac = null;
                case 1:
                    if (day < 19)
                    {
                        zodiac = "Capricorn";
                    }
                    zodiac = "Aquarius";
                case 2:
                    if (day <= 18)
                    {
                        zodiac = "Aquarius";
                    }
                    zodiac = "Pisces";
                case 3:
                    if (day <= 20)
                    {
                        zodiac = "Pisces";
                    }
                    zodiac = "Aries";
                case 4:
                    if (day <= 19)
                    {
                        zodiac = "Aries";
                    }
                    zodiac = "Taurus";
                case 5:
                    if (day <= 20)
                    {
						zodiac = "Taurus";
                    }
                    zodiac = "Gemini";
                case 6:
                    if (day <= 20)
                    {
                        zodiac = "Gemini";
                    }
                    zodiac = "Cancer";
                case 7:
                    if (day <= 22)
                    {
                        zodiac = "Cancer";
                    }
                    zodiac = "Leo";
                case 8:
                    if (day <= 22)
                    {
                        zodiac = "Leo";
                    }
                    zodiac = "Virgo";
                case 9:
                    if (day <= 22)
                    {
                        zodiac = "Virgo";
                    }
                    zodiac = "Libra";
                case 10:
                    if (day <= 22)
                    {
                        zodiac = "Libra";
                    }
                    zodiac = "Scorpio";
                case 11:
                    if (day <= 21)
                    {
                        zodiac = "Scorpio";
                    }
					zodiac = "Sagittarius";
                case 12:
                    if (day <= 21)
                    {
                        zodiac = "Sagittarius";
                    }
                    zodiac = "Capricorn";
            }

		return zodiac;
	}

	public static void main(String[] args) {
		// HINT: you can use main method to test your getZodiac method with
		// different parameters
		System.out.println(getZodiac(1, 1));
	}

}
