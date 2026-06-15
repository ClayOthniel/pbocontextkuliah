class Mahasiswa extends UserInfo {
    private String nim;
    private int tahunMasuk;
    private int tahunLulus;

    public Mahasiswa(String nim, String nama, String email, boolean status, int tahunMasuk, int tahunLulus) {
        super(nama, email, User.MAHASISWA);
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
        this.tahunLulus = tahunLulus;
        this.status = status;
    }
    public String getNIM() { return nim; }
    public int getTahunMasuk() { return tahunMasuk; }
    public int getTahunLulus() { return tahunLulus; }
    public String getNama() { return nama;}
    public boolean getStatus() { return status; }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
}