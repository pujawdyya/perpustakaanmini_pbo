import java.util.ArrayList;

public class Student extends User {

    private int jumlahPinjam;
    private ArrayList<String> daftarPinjam;

    public Student(String nama, String nim) {
        super(nama, nim);
        jumlahPinjam = 0;
        daftarPinjam = new ArrayList<>();
    }

    public int getMaxPinjam() {
        int digit = Character.getNumericValue(nim.charAt(nim.length() - 1));

        if (digit >= 0 && digit <= 3) {
            return 2;
        } else if (digit >= 4 && digit <= 6) {
            return 3;
        } else {
            return 5;
        }
    }

    public int getJumlahPinjam() {
        return jumlahPinjam;
    }

    public void tambahPinjam(String judul) {
        jumlahPinjam++;
        daftarPinjam.add(judul.toLowerCase());
    }

    public void kurangPinjam(String judul) {
        jumlahPinjam--;
        daftarPinjam.remove(judul.toLowerCase());
    }

    public boolean cekPinjaman(String judul) {
        return daftarPinjam.contains(judul.toLowerCase());
    }

    public void tampilPinjaman() {
        System.out.println("Daftar Buku Dipinjam : " + daftarPinjam);
    }
}