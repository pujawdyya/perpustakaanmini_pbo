import java.util.ArrayList;

public class Library {
    ArrayList<Book> daftarBuku = new ArrayList<>();

    public void tambahBuku(Book buku) {
        daftarBuku.add(buku);
    }

    public void tampilkanBuku() {
        for (Book b : daftarBuku) {
            b.infoBuku();
        }
    }

    public Book cariBuku(String judul) {
        for (Book b : daftarBuku) {
            if (b.getJudul().equalsIgnoreCase(judul)) {
                return b;
            }
        }
        return null;
    }
}