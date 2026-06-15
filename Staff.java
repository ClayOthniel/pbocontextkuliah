class Staff extends Karyawan {
    private double gaji;
    public Staff(String nama, String email, String nik, String password, boolean status, double gaji) {
        super(nik, nama, email, password, status, User.STAFF);
        this.gaji = gaji;
    }
    @Override
    public double getGaji() { return gaji; }
}
