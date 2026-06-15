abstract class Karyawan extends UserInfo {
    private String nik;

    public Karyawan(String nik, String nama, String email, String password, boolean status, enum User role) {
        super(nama, email, password, status, role);
        this.nik = nik;
    }
    public String getNik() { return nik; }
    public abstract double getGaji();
}