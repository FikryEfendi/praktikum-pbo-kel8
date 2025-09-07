import java.util.Scanner;
public class VolKubus 
{
    public static void main(String[] args) 
    {
        int s;
        int volume;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai sisi kubus: ");
        s = input.nextInt();
        
        volume = s * s * s;
        System.out.println("Volume kubus dengan sisi " + s + " adalah " + volume);
    }
}