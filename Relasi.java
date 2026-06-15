class Relasi {
    private Mahasiswa mahasiswa;
    private MataKuliah mataKuliah;
    private String nilai;
    
    public Relasi(Mahasiswa mahasiswa, MataKuliah mataKuliah, String nilai) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilai = nilai;
    }
    public Mahasiswa getMahasiswa() { return mahasiswa; }
    public MataKuliah getMataKuliah() { return mataKuliah; }
    public String getNilai() { return nilai; }
}

