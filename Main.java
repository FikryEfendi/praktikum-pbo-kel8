public class Main{
    public static void main(String[] args) {
        String nama = "Muhammad Nabil Alfathan";
        final long NIM = 2407126577L;
        double[] ip = {3.45, 3.56};
        String alamat = "Jalan Arengka";
        int umur = 19;
        char golonganDarah = 'O';
        byte[] ipByte = { (byte) ip[0], (byte) ip[1] };
        boolean betul = true ;


        System.out.println("\n===========================================================================");
        System.out.println("Perkenalkan Nama Saya "+ nama);
        System.out.println("Dengan NIM "+ NIM);
        System.out.println("Saya beralamat kan di "+ alamat);
        System.out.println("Kini saya berusia "+ umur);
        System.out.println("Golongan darah saya yaitu "+ golonganDarah);
        System.out.print("IP Semester 1 saya "+ ip[0]);
        System.out.println(" dan IP Semester 2 saya "+ ip[1]);
        System.out.print("IP Semester 1 dalam Byte "+ ipByte[0]);
        System.out.println(" dan IP Semester 2 dalam Byte "+ ipByte[1]);
        System.out.println("Now I am a student, and that is "+ betul);
        System.out.println("=============================================================================");

    }
}
