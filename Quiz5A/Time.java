package Quiz5A;

public class Time {
    private int hour;
    private int min;
    private int sec;

    public Time(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public Time() {
        hour = 15;
        min = 0;
        sec = 0;
    }

    public String toString() {
        return String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
    }

    public int dist(Time t) {
        return this.sec - t.sec ;
    }

    public static void main(String[] args) {
        Time a = new Time(15, 10, 30);
        Time b = new Time();
        System.out.println(a); // should print out: 15:10:30
        System.out.println(b); // should print out:
        System.out.println(a.dist(b)); // print the difference in seconds between the two timestamps
    }
}
