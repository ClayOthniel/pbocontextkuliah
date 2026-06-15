class DosenH extends Karyawan {
    private double honor;
    private int jsks;
    public DosenH(String nama, String email, String nik, String password, boolean status, double honor, int jsks) {
        super(nik, nama, email, password, status, User.DOSEN_HONORER);
        this.honor = honor;
        this.jsks = jsks;
    }
    @Override
    public double getGaji() {
        return honor * jsks;
    }
}
