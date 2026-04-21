public class User {
    protected String nama;
    protected String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public void infoUser() {
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
    }
}