
package dateparser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class DateParser {

  public static List<String> dates1;
  public static List<String> dates2;
  public static List<String> dates3;
  public static List<String> dates4;
  public static String ocr;
  public static String[] ocrSplitted;
  
  

    public static void main(String[] args) {
        
    
        dates1 = new ArrayList();
        dates1.add("1/1/11");
        dates1.add("01/01/11");
        dates1.add("01/01/2011");
        dates1.add("01/1/2011");
        dates1.add("1/11/2011");
        dates1.add("1/11/11");
        dates1.add("11/1/18");
        
        dates2 = new ArrayList();
        dates2.add("1.1.11");
        dates2.add("01.01.11");
        dates2.add("01.01.2011");
        dates2.add("01.1.2011");
        dates2.add("1.11.2011");
        dates2.add("1.11.11");
        dates2.add("11.1.18");
        
        dates3 = new ArrayList();
        dates3.add("1-1-11");
        dates3.add("01-01-11");
        dates3.add("01-01-2011");
        dates3.add("01-1-2011");
        dates3.add("1-11-2011");
        dates3.add("1-11-11");
        dates3.add("11-1-18");
        
        dates4 = new ArrayList();
        dates4.add("1/ene/11");
        dates4.add("01/feb/11");
        dates4.add("01/mar/2011");
        dates4.add("01/abr/2011");
        dates4.add("1/may/2011");
        dates4.add("1/jun/11");
        dates4.add("11/jul/18");
        dates4.add("01/ago/2011");
        dates4.add("1/sep/2011");
        dates4.add("1/oct/11");
        dates4.add("11/nov/18");
        dates4.add("11/dec/18");
 
        //regex para barra
         String regex1 = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
         //regex para .
         String regex2 = "^[0-3]?[0-9]\\.[0-3]?[0-9]\\.(?:[0-9]{2})?[0-9]{2}$";
         //regex para guion
         String regex3 = "^[0-3]?[0-9]-[0-3]?[0-9]-(?:[0-9]{2})?[0-9]{2}$";
         //String para meses con texto como en corte ingles, con barra
         //String regex4 = "^[0-3]?[0-9]-[0-3]?[0-9]-(?:[0-9]{2})?[0-9]{2}$";
         //String regex4 = "^[0-3]?[0-9]-\b(?:Jan(?:uary)?|Feb(?:ruary)?|Dec(?:ember)?)(?:[0-9]{2})?[0-9]{2}$";
         String regex4 = "^[0-3]?[0-9]/[a-zA-Z]+/(?:[0-9]{2})?[0-9]{2}$";
         
         List<String> regexs = new ArrayList<>();
         regexs.add(regex1);
         regexs.add(regex2);
         regexs.add(regex3);
         regexs.add(regex4);
         
         ocr = "C RTEINGLES S.A N1.F A 2e0178961D6m 50c:H4rme*lla 112,2go09.Mednd. n cnla en e Reg s ro MefsanO de A4adno"
                 + "T.677 Gral 61 S. oe L de S H 8085 F 182 D CUMENTO DE VENTA 1371YG9XAD0Q1 1T7XT040ZG "
                 + "Vendedor T.T EmpCant Operac Fech Hora EdP1Zn T 65834152 9 0010721 00635091 13-12-2010  10:27 018800 00"
                 + "CODIGO DE CONTROL: 9015318CA1 Descripci n Cantidad ImPorte CUIDADO CULITO BEBE 2 C 16.80 "
                 + "Precio unitari0 8,40 Oferta 2#UNID50XERVP . Oferta:2aUNID50%ERYP 25.00% -4.20 TOTAL COMPRA 12.80 T.ECI CARGO EN CUENTA 12,60 "
                 + "************5142022 05-02 10:27 AUT:991027 A INCLUID0 Oetalle desglos0 tip0 impuesto: Base Cuota Total"
                 + " (C) IMP 21,00% 10,41 2.19 12,60( N. TOTAL DE ARTtCUL0S: 2 )";
         
         ocrSplitted = ocr.split(" ");
 
         for(String s: regexs){
             check(s);
         }
        
        /*
        check2(regex1, dates1);
        check2(regex2, dates2);
        check2(regex3, dates3);
        check2(regex4, dates4); */
          
    } 
    
    public static void check(String regex){
             Pattern pattern = Pattern.compile(regex);
               for(String s : ocrSplitted){  
                  Matcher matcher = pattern.matcher(s);
                  if(matcher.matches()){
                    System.out.println(s +" : "+ matcher.matches());
                  }
               }
               System.out.println("\n");
      }
    
       public static void check2(String regex, List<String> dates ){
             Pattern pattern = Pattern.compile(regex);
               for(String date : dates){  
                  Matcher matcher = pattern.matcher(date);
                  System.out.println(date +" : "+ matcher.matches());
               }
               System.out.println("\n");
      }
}
    

