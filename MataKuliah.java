class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private boolean status;

    public MataKuliah(String kode, String nama, int sks, boolean status) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.status = status;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getSks() { return sks; }
    public boolean getStatus() { return status; }

    public void setStatus(boolean status) {
        this.status = status;
    }
}