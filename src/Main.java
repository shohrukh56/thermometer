import java.util.*;
public class Main {
    static int battery=100;


    static int getTemp() {
        System.out.println("Please enter input within 5 seconds");
        int input = -50;
        Scanner scan = new Scanner(System.in);
        if(scan.hasNextInt()){
            input= scan.nextInt();}
        else{
            System.out.println("This is not a valid temperature");}
        return input;
    }


    static void displayTemp(int input) {
        battery-=5;
        System.out.println("your temperature is: "+ input);
    }

    static  boolean checkTemp(int temperature) {
        if(temperature>-40 && temperature<50 ) {
            return true;
        }else{
            System.out.println("Error occurred, temperature not in range");
        }
        return false;
    }

    static  boolean selfCheck() {
        if(battery>0){
            int temp= getTemp();
            //if temp is not within range,restart program
            if(!checkTemp(temp)){
                selfCheck();
            }
            displayTemp( temp);
            return false;
        }
        else{
            System.out.println("Battery low charge battery");
            System.exit(0);
        }
        return true;
    }

    public static void main(String[] args)
    {

        final Timer timer = new Timer();
// Note that timer has been declared final, to allow use in anon. class below
        timer.schedule( new TimerTask()
                        {
                            public void run()
                            {
                                System.out.println("5 Seconds past please enter temperature");
                                selfCheck();
                            }
                        }, 5000, 5000 //Note the second argument for repetition
        );
    }

}
