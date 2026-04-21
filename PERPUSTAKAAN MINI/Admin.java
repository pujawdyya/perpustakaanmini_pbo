public class Admin extends User {

    public Admin(String nama, String nim) {
        super(nama, nim);
    }

    public void tambahBuku(Library lib, Book buku) {
        lib.tambahBuku(buku);
    }
}