import java.util.Scanner;

public class Main {

 public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        long firstPolyn = 1011;
        long secondPolyn = 1101;
        long mainPolyn = 1000;

        String message = getMessage();
        String chosenPolynOption = selectChosenPoly();
        selectPolynomial(chosenPolynOption);

        BinaryClass binaryClass = new BinaryClass();

        long newMessage = binaryClass.createDataForBinaryMultiply(message,mainPolyn);

        String remainder = "";
        if(chosenPolynOption.equals("1")){
            remainder = binaryClass.dividePolyn(newMessage,firstPolyn);
        }else if (chosenPolynOption.equals("2")){
            remainder = binaryClass.dividePolyn(newMessage,secondPolyn);
        }

        System.out.println("\nZakodowana wiadomość to x_n = "+message+""+remainder);
        String changeBit = getChangeBit();
        String newMessageString = message+""+remainder;
        String changeMessage = changeBitInMessage(changeBit,newMessageString);

        System.out.println("Dekodowanie: ");
        long changeMessageLong = Integer.parseInt(changeMessage);
        String decodeMessage ="";
        if(chosenPolynOption.equals("1")){
            decodeMessage = binaryClass.dividePolyn(changeMessageLong, firstPolyn);
        }else if (chosenPolynOption.equals("2")){
            decodeMessage = binaryClass.dividePolyn(changeMessageLong, secondPolyn);
        }


        Matrix matrix = new Matrix();
        matrix.createHMatrix(chosenPolynOption);
        System.out.println("Bład występuje na pozycji: " + changeBit);
        System.out.println("\nPoprawna wiadomość: " + message+""+ decodeMessage);

        System.out.println("Naciśnij enter aby kontynuować...");
        try{System.in.read();}
        catch(Exception e){}
    }
    private static String changeBitInMessage(String changeBit, String message){
        String incorrectMessage;
        int changeBitInt = Integer.parseInt(changeBit)-1;
        String[] messageSplitTab = message.split("");

        String tempChosenBitString = messageSplitTab[changeBitInt];
        int chosenBitStringParseToInt = Integer.parseInt(tempChosenBitString);
        int newValueToChosenBit = (chosenBitStringParseToInt+1)%2;
        messageSplitTab[changeBitInt]=newValueToChosenBit +"";

        StringBuilder incorrectMessageNew = new StringBuilder(message);
        incorrectMessageNew.setCharAt(changeBitInt, messageSplitTab[changeBitInt].charAt(0));

        System.out.println("Wiadomość z błędem: " + incorrectMessageNew);

        incorrectMessage = incorrectMessageNew.toString();

        return incorrectMessage;
    }

    private static String getChangeBit(){
        System.out.println("Podaj numer bitu, który chcesz zmienić: ");
        String chosenBit = scan.nextLine();
        System.out.println("bit: " +chosenBit);
        return chosenBit;
    }

    private static String getMessage(){
        System.out.println("Podaj wartość wiadomości do zakodowania: ");
        String messageString = scan.nextLine();
        System.out.println("x_k = "+messageString);
        return messageString;
    }
    private static String selectChosenPoly(){
        String[] polynTab={"1 - x^3+x+1","2 - x^3+x^2+1"};
        System.out.println("Który wielomian G(x) chcesz użyć? \nPodaj numer wielomianu:");
        System.out.println(polynTab[0]);
        System.out.println(polynTab[1]);
        String chosenPolynString = scan.nextLine();
        return chosenPolynString;
    }
    private static void selectPolynomial(String chosenPolyn){
        String chosenPolynDisplay;
        String[] polynTabWithoutNumber={"G(x) = x^3+x+1","G(x) = x^3+x^2+1"};
        if(chosenPolyn.equals("1")){
            chosenPolynDisplay = polynTabWithoutNumber[0];
            System.out.println("Wybrany wielomian to: "+chosenPolynDisplay+" czyli 1011");
        }else if (chosenPolyn.equals("2")){
            chosenPolynDisplay = polynTabWithoutNumber[1];
            System.out.println("Wybrany wielomian to: "+chosenPolynDisplay+" czyli 1101");
        }
    }
}
