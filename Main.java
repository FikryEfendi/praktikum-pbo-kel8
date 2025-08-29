public class Main{
    public static void main(String[] args) {
        String nama = "Muhammad Fikry Efendi";
        final long NIM = 2407112294L;
        double[] ip = {3.86, 3.77};
        String alamat = "Jalan Naga Sakti Perum Griya Kenari Indah Blok H76";
        int umur = 19;
        char golonganDarah = 'B';
        byte ipByte = (byte) ip[0];

        System.out.println("Halo... Nama Saya "+ nama);
        System.out.println("NIM saya yaitu "+ NIM);
        System.out.println("Jika kamu ingin mengunjungi saya, bisa langsung kerumah saya di "+ alamat);
        System.out.println("Saat ini saya berusia "+ umur);
        System.out.println("Golongan darah saya yaitu "+ golonganDarah);
        System.out.println("IP Semester 1 saya "+ ip[0]);
        System.out.println("IP Semester 2 saya "+ ip[1]);
        System.out.println("IP Semester 1 dalam Byte "+ ipByte);
    }
}
