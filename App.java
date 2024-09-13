public class App {
    public static void main(String[] args) throws Exception {
        Member platinum = new Platinum("Murdock", 1000);
        System.out.println("Platinum info: ");
        platinum.display();

        Member gold = new Gold("Matt", 1650);
        System.out.println("Gold info: ");
        gold.display();

        Member silver = new Silver("Wilson", 1200);
        System.out.println("Silver info: ");
        silver.display();
    }
}

