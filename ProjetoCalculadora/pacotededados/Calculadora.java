package pacotededados;

import javax.swing.JOptionPane;

public class Calculadora {

    //ATRIBUTOS:
    private String N1 = "";
    private int base1 = 10;
    private int base2 = 2;

    //METODOS:
    public String getN1() {
        return N1;
    }

    public void setN1(String N1) throws Exception {
       // if(N1==null || N1=="") throw new Exception("Favor informar um valor para conversão!");
        this.N1 = N1;
    }

    public int getBase1() {
        return base1;
    }

    public int getBase2() {
        return base2;
    }

    public void setBase1(int base1){
        this.base1 = base1;
    }

    public void setBase2(int base2){
        this.base2 = base2;
    }

    public String mudarBase() throws Exception {
      //  if (N1 == null || N1=="") throw new Exception("Informar um numero diferente de 0!");
    
        //CONVERSÃO DE DECIMAL  PARA {BINARIO,HEXADECIMAL E OCTAL}
        String resto = "";
        // char[] vetor = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String tabHex = "0123456789ABCDEF";
        String bin = "";
        //int hexa=0;

        if (base1 == 10) {

            while (Integer.parseInt(N1) > 0) {

                if (base2 == 16) {               //DECIMAL P./HEXADECIMAL
                    // resto = vetor[Integer.parseInt(N1) % base2] + resto;
                    resto = tabHex.substring((Integer.parseInt(N1) % base2), (Integer.parseInt(N1) % base2) + 1) + resto;
                } else {
                    resto = Integer.parseInt(N1) % base2 + resto;
                }
                N1 = "" + (Integer.parseInt(N1) / base2);
            }
            return resto;   //RETURN DECIMAL PARA OUTRAS BASES

            //CONVERSAO BINARIO PARA {DECIMAL,HEXADECIMAL E OCTAL}
        } else if (base1 == 2) {

            int aux = 0;
            int num = 0;
            //   String bin = "";

            if (base2 == 10) {          //BINARIO P./DECIMAL
                while (Integer.parseInt(N1) > 0) {

                    num = (int) (Math.pow(2, aux) * (Integer.parseInt(N1) % 10) + num);

                    aux++;
                    N1 = "" + (Integer.parseInt(N1) / 10);

                }
                resto = "" + num;
            } else if (base2 == 16) {       //BINARIO P./HEXADECIMAL

                while (Integer.parseInt(N1) > 0) {
                    bin = String.valueOf(Integer.parseInt(N1) % 10000);
                    resto = Integer.toString(Integer.parseInt(bin, 2), 16) + resto;
                    N1 = "" + Integer.parseInt(N1) / 10000;
                }

            } else if (base2 == 8) {        //BINARIO P./OCTAL

                while (Integer.parseInt(N1) > 0) {
                    bin = String.valueOf(Integer.parseInt(N1) % 1000);
                    resto = Integer.toString(Integer.parseInt(bin, 2), 8) + resto;
                    N1 = "" + Integer.parseInt(N1) / 1000;
                }
            }
            return resto;   //RETURN CONVERSÃO BINARIO P.OUTRAS BASES

            //HEXADECIMAL PARA {DECIMAL,BINARIO E OCTAL}        
        } else if (base1 == 16) {

            if (base2 == 10) {
                //FEITO NA UNHA 
                /*  for (int j = 0; j < N1.length(); j++) {
                    for (int i = 0; i < (vetor.length-1);i++) {
                        if (N1.charAt(N1.length()-j-1) == vetor[i]) {
                        
                         hexa = hexa + (int) (i* Math.pow(16, j));
                        }
                    }
                }
                 resto = ""+hexa;*/
                //USANDO METODO
                resto = Integer.toString(Integer.parseInt(N1, 16), 10);
            } else if (base2 == 2) {

                resto = Integer.toString(Integer.parseInt(N1, 16), 2);

            } else if (base2 == 8) {
                resto = Integer.toString(Integer.parseInt(N1, 16), 8);
            }
            return resto;
        } else if (base1 == 8) {
            if(base2==10){
                resto = Integer.toString(Integer.parseInt(N1,8),10);
            }else if(base2==2){
                resto = Integer.toString(Integer.parseInt(N1,8),2);
            }else if(base2==16){
                resto = Integer.toString(Integer.parseInt(N1,8),16);
            }

        }
      return resto;
    }
}
