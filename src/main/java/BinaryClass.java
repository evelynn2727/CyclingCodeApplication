
public class BinaryClass {

    public String dividePolyn(long newMessage,long chosenPolym){

        String tempMess = newMessage + "";
        String tempChosenPolym = chosenPolym + "";

        int dividend = Integer.parseInt(tempMess,2);
        System.out.println("Dzielona liczba x_k*x_r: " + newMessage);

        int divisor = Integer.parseInt(tempChosenPolym,2);
        System.out.println("Przez wielomian: " + chosenPolym);

        String remainder="";
        if(divisor!=0)
        {
//            String quotient = Integer.toBinaryString((dividend/divisor));
            remainder = Integer.toBinaryString((dividend%divisor));
            int lengthReminder = remainder.length();
            if(lengthReminder==2){
                remainder=remainder+"0";
            } else if (lengthReminder==4){
              int  tempDividend =Integer.parseInt(remainder);
                String tempRemainder = Integer.toBinaryString((tempDividend%divisor));
                remainder=tempRemainder;
            }else if (lengthReminder==1){
                remainder+="00";
            }
//            System.out.println("Reszta z dzielenia wynosi -> R(x) = "+remainder);
            return remainder;
        }
        else
            System.out.println("Nie można dzielic przez 0!");
        return remainder;
    }

    public long createDataForBinaryMultiply(String messageString, long chosenPolyn)
    {
        long message = Long.parseLong(messageString);
        long binary1, binary2, multiply = 0;
        int digit, factor = 1;

        binary1 = message;
        binary2 = chosenPolyn;

        while (binary2 != 0)
        {
            digit = (int)(binary2 % 10);
            if (digit == 1)
            {
                binary1 = binary1 * factor;
                multiply = binaryproduct((int) binary1, (int) multiply);
            }
            else
            {
                binary1 = binary1 * factor;
            }
            binary2 = binary2 / 10;
            factor = 10;
        }
        return multiply;
    }

    static int binaryproduct(int binary1, int binary2) {
        int i = 0, remainder = 0;
        int[] sum = new int[20];
        int binary_prod_result = 0;

        while (binary1 != 0 || binary2 != 0) {
            sum[i++] = (binary1 % 10 + binary2 % 10 + remainder) % 2;
            remainder = (binary1 % 10 + binary2 % 10 + remainder) / 2;
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remainder != 0) {
            sum[i++] = remainder;
        }
        --i;
        while (i >= 0) {
            binary_prod_result = binary_prod_result * 10 + sum[i--];
        }
        return binary_prod_result;
    }
}
