import java.util.Scanner;

public class MetricConverter_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double value = Double.parseDouble(input.nextLine());
        String inputMeasure = input.nextLine();
        String outputMeasure = input.nextLine();
        double result = 0;

        if(inputMeasure.equals("m")){
            if(outputMeasure.equals("cm")){
                result = value * 100;
            }else if (outputMeasure.equals("mm")){
                result = value * 1000;
            }
        } else if (inputMeasure.equals("cm")){
            if (outputMeasure.equals("m")){
                result = value / 100;
            } else if (outputMeasure.equals("mm")){
                result = value * 10;
            }
        } else if (inputMeasure.equals("mm")){
            if (outputMeasure.equals("cm")){
                result = value / 10;
            } else if (outputMeasure.equals("m")){
                result = value / 1000;
            }
        }
        System.out.printf("%.3f", result);
    }
}
