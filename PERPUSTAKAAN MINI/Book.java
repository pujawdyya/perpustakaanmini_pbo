public class Book {
    private String judul;
    private String penulis;
    private int stok;

    public Book(String judul, String penulis, int stok) {
        this.judul = judul;
        this.penulis = penulis;
        this.stok = stok;
    }

    public String getJudul() {
        return judul;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok() {
        stok--;
    }

    public void tambahStok() {
        stok++;
    }

    public void infoBuku() {
        System.out.println(judul + " | " + penulis + " | Stok: " + stok);
    }

    // Overloading
    public void infoBuku(String status) {
        System.out.println(judul + " | " + status);
    }
}