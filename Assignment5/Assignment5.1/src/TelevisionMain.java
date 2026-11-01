class Television {

    private int channel;
    private boolean on;

    Television() {
        this.channel = 1;
        this.on = false;
    }

    void wakeUp() {
        this.on = true;
    }

    void watch() {
        if (on) {
            System.out.println("Watching channel " + channel);
            channel++;
            if (channel > 10) {
                channel = 1;
            }
        }
    }

    void sleep() {
        this.on = false;
    }
}

public class TelevisionMain {
    public static void main(String[] args) {
        Television tv = new Television();

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);
            tv.wakeUp();

            int shows;
            if (day == 1) {
                shows = 3;
            } else if (day == 2) {
                shows = 4;
            } else if (day % 2 == 1) {
                shows = 6;
            } else {
                shows = 4;
            }

            for (int i = 0; i < shows; i++) {
                tv.watch();
            }

            tv.sleep();
            System.out.println("Falling asleep");
        }
    }
}