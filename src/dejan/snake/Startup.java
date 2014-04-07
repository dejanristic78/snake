package dejan.snake;


public class Startup {
    public static void main(String[] args) {
        
        System.out.println("qwer");
        Clock clock = new Clock();
        Thread clockThread = new Thread(clock);
        clockThread.start();
        
        Gui gui = new Gui();
        Thread guiThread = new Thread(gui);
        guiThread.run();
        //Gui.main(args);
    }
}
