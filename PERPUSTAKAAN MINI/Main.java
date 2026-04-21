import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Library lib = new Library();
        Transaction tr = new Transaction();
        Admin admin = new Admin("Petugas", "001");

        admin.tambahBuku(lib, new Book("Algoritma", "Andi", 3));
        admin.tambahBuku(lib, new Book("OOP Java", "Budi", 2));
        admin.tambahBuku(lib, new Book("Database", "Zahra", 4));
        admin.tambahBuku(lib, new Book("Pemrograman", "Santoso", 1));

        System.out.println("=== REGISTRASI MEMBER ===");
        System.out.print("Nama : ");
        String nama = input.nextLine();

        System.out.print("NIM  : ");
        String nim = input.nextLine();

        Student mhs = new Student(nama, nim);

        int pilih;

        do {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Lihat Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Info Member");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1 -> lib.tampilkanBuku();

                case 2 -> {
                    if (mhs.getJumlahPinjam() < mhs.getMaxPinjam()) {

                        System.out.print("Masukkan Judul Buku : ");
                        String judul = input.nextLine();

                        Book buku = lib.cariBuku(judul);

                        if (buku != null && buku.getStok() > 0) {
                            buku.kurangiStok();
                            mhs.tambahPinjam(judul);

                            System.out.println("Buku berhasil dipinjam.");
                            System.out.println("Batas pinjam 7 hari.");
                        } else {
                            System.out.println("Buku tidak tersedia.");
                        }

                    } else {
                        System.out.println("Melebihi batas maksimal pinjam.");
                    }
                }

                case 3 -> {
                    System.out.print("Masukkan Judul Buku : ");
                    String judul2 = input.nextLine();

                    if (mhs.cekPinjaman(judul2)) {

                        Book buku2 = lib.cariBuku(judul2);

                        if (buku2 != null) {
                            buku2.tambahStok();
                            mhs.kurangPinjam(judul2);

                            System.out.print("Telat berapa hari? ");
                            int telat = input.nextInt();
                            input.nextLine();

                            if (telat > 0) {
                                int denda = tr.hitungDenda(telat);
                                System.out.println("Denda : Rp " + denda);
                            } else {
                                System.out.println("Tidak ada denda.");
                            }

                            System.out.println("Buku berhasil dikembalikan.");
                        }

                    } else {
                        System.out.println("Anda tidak meminjam buku tersebut.");
                    }
                }

                case 4 -> {
                    mhs.infoUser();
                    System.out.println("Max Pinjam   : " + mhs.getMaxPinjam());
                    System.out.println("Sedang Pinjam: " + mhs.getJumlahPinjam());
                    mhs.tampilPinjaman();
                }

                case 0 -> System.out.println("Terima kasih.");

                default -> System.out.println("Pilihan tidak valid.");
            }

        } while (pilih != 0);

        input.close();
    }
}