import java.util.Scanner;

public class TradeCommissions_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String city = input.nextLine();
        double sales = Double.parseDouble(input.nextLine());
        double percent = 0;


        switch(city){
            case "Sofia":
                if(sales >= 0 && sales <= 500){
                    percent = 0.05;
                }else if(sales > 500 && sales <= 1000){
                    percent = 0.07;
                }else if(sales > 1000 && sales <= 10000){
                    percent = 0.08;
                }else if(sales > 10000){
                    percent = 0.12;
                }else {
                    System.out.println("error");
                }
                break;
            case "Varna":
                if(sales >= 0 && sales <= 500){
                    percent = 0.045;
                }else if(sales > 500 && sales <= 1000){
                    percent = 0.075;
                }else if(sales > 1000 && sales <= 10000){
                    percent = 0.1;
                }else if(sales > 10000){
                    percent = 0.13;
                }else {
                    System.out.println("error");
                }
                break;
            case "Plovdiv":
                if(sales >= 0 && sales <= 500){
                    percent = 0.055;
                }else if(sales > 500 && sales <= 1000){
                    percent = 0.08;
                }else if(sales > 1000 && sales <= 10000){
                    percent = 0.12;
                }else if(sales > 10000){
                    percent = 0.145;
                }else {
                    System.out.println("error");
                }
                break;
            default:
                System.out.println("error");
                break;
        }
        double commission = sales * percent;
        if(commission > 0) {
            System.out.printf("%.2f", commission);
        }
    }
}
