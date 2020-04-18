

public class Matrix {
    int[] polynTabBit={1011,1101};
    String[] tab= new String[10];
    byte[] gMatrixInt=new byte[10];

//    public void createGMatrix() {
//        String chosenOption = "2";
//
//        if (chosenOption=="1"){
//            tab = new String[]{"1011000","0101100","0010110","0001011"};
//        }else if (chosenOption=="2"){
//            tab = new String[]{"1101000","0110100","0011010","0001101"};
//        }
//
//        System.out.println("Tablica G(x):");
//        for (String s:tab
//             ) {
//            System.out.println(s);
//        }
//    }
//
//    public void createGPrimMatrix(){
//        String chosenOption = "2";
//
//        if (chosenOption=="1"){
//            tab = new String[]{"1000101","0100111","0010110","0001011"};
//        }else if (chosenOption=="2"){
//            tab = new String[]{"1000110","0100011","0010111","0001101"};
//        }
//
//        System.out.println("Tablica G'(x):");
//        for (String s:tab
//        ) {
//            System.out.println(s);
//        }
//    }

    public void createHMatrix(String chosenOption){

        if (chosenOption.equals("1")){
            tab = new String[]{"1110100","0111010","1101001"};
        }else if (chosenOption.equals("2")){
            tab = new String[]{"1011100","1110010","0111001"};
        }

        System.out.println("\nTablica H'(x):");
        for (String s:tab
        ) {
            System.out.println(s);
        }
    }
}
