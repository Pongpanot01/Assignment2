import java.util.Scanner;

public class Assign {

    private static final double SILVER_DISCOUNT_THRESHOLD = 1000;
    private static final double GOLD_DISCOUNT_THRESHOLD = 1000;
    private static final double SILVER_DISCOUNT_RATE = 0.02;
    private static final double GOLD_DISCOUNT_RATE = 0.03;
    private static final double PLATINUM_DISCOUNT_RATE = 0.05;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // รับข้อมูลจากผู้ใช้
        String customerCategory = getCustomerCategory(input);
        if (customerCategory == null) {
            input.close();
            return;
        }

        double amount = getPurchaseAmount(input);
        if (amount < 0) {
            System.out.println("ยอดซื้อไม่สามารถเป็นค่าลบได้");
            input.close();
            return;
        }

        // คำนวณยอดเงินสุดท้ายหลังจากหักส่วนลด
        double finalPrice = calculateFinalPrice(customerCategory, amount);

        // แสดงผลลัพธ์
        System.out.printf("ยอดเงินที่ต้องชำระหลังหักส่วนลด: %.2f%n", finalPrice);

        input.close();
    }

    // เมธอดเพื่อรับประเภทลูกค้าจากผู้ใช้
    private static String getCustomerCategory(Scanner input) {
        System.out.print("ประเภทลูกค้า (silver/gold/platinum): ");
        String category = input.nextLine().trim().toLowerCase();
        
        if (isValidCategory(category)) {
            return category;
        } else {
            System.out.println("ประเภทลูกค้าไม่ถูกต้อง");
            return null;
        }
    }

    // เมธอดเพื่อรับยอดซื้อจากผู้ใช้
    private static double getPurchaseAmount(Scanner input) {
        System.out.print("ยอดซื้อ: ");
        if (input.hasNextDouble()) {
            return input.nextDouble();
        } else {
            System.out.println("กรุณาป้อนยอดซื้อเป็นตัวเลขที่ถูกต้อง");
            input.next(); // Clear invalid input
            return -1; // ใช้ค่าพิเศษเพื่อบ่งชี้ข้อผิดพลาด
        }
    }

    // เมธอดเพื่อตรวจสอบว่าประเภทลูกค้าเป็นค่าที่ถูกต้องหรือไม่
    private static boolean isValidCategory(String category) {
        return category.equals("silver") || category.equals("gold") || category.equals("platinum");
    }

    // เมธอดเพื่อคำนวณยอดเงินสุดท้ายหลังจากหักส่วนลด
    private static double calculateFinalPrice(String customerCategory, double amount) {
        double discountPercentage = getDiscountPercentage(customerCategory, amount);
        return amount - (amount * discountPercentage);
    }

    // เมธอดเพื่อคำนวณอัตราส่วนลดตามประเภทลูกค้าและยอดซื้อ
    private static double getDiscountPercentage(String customerCategory, double amount) {
        switch (customerCategory) {
            case "silver":
                return (amount > SILVER_DISCOUNT_THRESHOLD) ? SILVER_DISCOUNT_RATE : 0.0;
            case "gold":
                return (amount > GOLD_DISCOUNT_THRESHOLD) ? GOLD_DISCOUNT_RATE : 0.0;
            case "platinum":
                return PLATINUM_DISCOUNT_RATE;
            default:
                return 0.0;
        }
    }
}