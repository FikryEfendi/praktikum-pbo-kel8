public class Main{
    public static void main(String[] args) {
        String[] nama = {"Muhammad Fikry Efendi","Muhammad Nabil Alfathan"};
        final long[] NIM = {2407112294L, 2407126577L};
        double[] ip = {3.86, 3.77, 3.45, 3.56};
        String[] alamat = {"Jalan Naga Sakti Perum Griya Kenari Indah Blok H76", "Jalan Arengka"};
        int[] umur = {19, 19};
        char[] golonganDarah = {'B', 'O'};
        byte[] ipByte = {(byte) ip[0], (byte) ip[1], (byte) ip[2], (byte) ip[3]};

        System.out.println("=======================================================================================");
        System.out.println("Biodata Mahasiswa");
        System.out.println("Halo... Nama Saya "+ nama[0]);
        System.out.println("NIM saya yaitu "+ NIM[0]);
        System.out.println("Jika kamu ingin mengunjungi saya, bisa langsung kerumah saya di "+ alamat[0]);
        System.out.println("Saat ini saya berusia "+ umur[0]);
        System.out.println("Golongan darah saya yaitu "+ golonganDarah[0]);
        System.out.println("IP Semester 1 saya "+ ip[0]);
        System.out.println("IP Semester 2 saya "+ ip[1]);
        System.out.println("IP Semester 1 dalam Byte "+ ipByte[0]);
        System.out.println("=======================================================================================");


        System.out.println("\n=======================================================================================");
        System.out.println("Halo... Nama Saya "+ nama[1]);
        System.out.println("NIM saya yaitu "+ NIM[1]);
        System.out.println("Jika kamu ingin mengunjungi saya, bisa langsung kerumah saya di "+ alamat[1]);
        System.out.println("Saat ini saya berusia "+ umur[1]);
        System.out.println("Golongan darah saya yaitu "+ golonganDarah[1]);
        System.out.println("IP Semester 1 saya "+ ip[2]);
        System.out.println("IP Semester 2 saya "+ ip[3]);
        System.out.println("IP Semester 1 dalam Byte "+ ipByte[2]);
        System.out.println("=======================================================================================");

    }
}
