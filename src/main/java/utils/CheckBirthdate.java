package utils;

public class CheckBirthdate {

    public String isBirthdateYearCorrect(int year) {
            return Integer.toString(year);
    }

    public String isBirthdateDayCorrect(int day) {
            switch (day) {
                case 1, 2, 3, 4, 5, 6, 7, 8, 9: {
                    return String.format("0%s", day);
                }
            }

            return Integer.toString(day);
        }

    public String isBirthdateMonthCorrect(int month) {
            switch (month) {
                case 1, 2, 3, 4, 5, 6, 7, 8, 9: {
                    return String.format("0%s", month);
                }
            }

            return Integer.toString(month);
    }

    public boolean isValidDate(int day, int month, int year) {
        if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900 && year <= 275760) {
            return true;
        }
        System.out.println("---Incorrect date!---");
        return false;
    }
    }
