package utils;

public class FormatDate {

    public String getFormatDay(String day) {
        int dayInt = Integer.parseInt(day);
        switch (dayInt) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9: {
                return String.format("0%s", day);
            }
        }

        return day;
    }

    public String getFormatMonth(String month) {
        int monthInt = Integer.parseInt(month);
        switch (monthInt) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9: {
                return String.format("0%s", month);
            }
        }

        return month;
    }

}

