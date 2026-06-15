class DosenT extends Karyawan {
    private double gaji;
    private int jsks;
    private double honor;
    public DosenT(String nama, String email, String nik, String password, boolean status, double gaji, int jsks, double honor) {
        super(nik, nama, email, password, status, User.DOSEN_TETAP);
        this.gaji = gaji;
        this.jsks = jsks;
        this.honor = honor;
    }
    @Override
    public double getGaji() {
        return gaji + (jsks * honor);
    }
}