public class Klubbesar 
{
    public static void main(String[] args)
    {
        System.out.println("#######################################################################################################################");
        System.out.println("-------------------------------------------DATA KLUB SEPAKBOLA BESAR DI DUNIA------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        Klubbola klubbola1 = new Klubbola("Real Madrid","Madrid", 130,1902 );
        klubbola1.tampilkanTim("UNO DOS TRES HALA MADRID!!!");
       
        Klubbola klubbola2 = new Klubbola("Barcelona","Barcelona", 1899 ); // tanpa pake trophy
        klubbola2.tampilkanTim();
      
        Klubbola klubbola3 = new Klubbola("Manchester United","Manchester", 66,1878 );
        klubbola3.tampilkanTim();

    } 
}
