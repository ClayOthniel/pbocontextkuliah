package pbocontextkuliah;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Mahasiswa> mahasiswaList = new ArrayList<>();
    static List<MataKuliah> mataKuliahList = new ArrayList<>();
    static List<Relasi> relasiList = new ArrayList<>();
    static List<Karyawan> karyawanList = new ArrayList<>();

    // Matkul dan Mahasiswa
    public static void tambahMatkul(String kode, String nama, int sks, boolean status) {
        mataKuliahList.add(new MataKuliah(kode, nama, sks, status));
        System.out.println("Mata kuliah berhasil ditambahkan.");
    }

    public static void editMatkul(String kode, boolean newStatus) {
        for (MataKuliah mk : mataKuliahList) {
            if (mk.getKode().equals(kode)) {
                mk.setStatus(newStatus); 
                System.out.println("Mata kuliah berhasil diubah.");
                return; 
            }
        }
        System.out.println("Mata kuliah tidak ditemukan.");
    }

    public static void tambahMahasiswa(String nim, String nama, String email, String password, int masuk, int lulus, boolean status) {
        mahasiswaList.add(new Mahasiswa(nim, nama, email, password, masuk, lulus, status));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }
    
    public static void editMahasiswa(String nim, boolean newStatus) {
        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.getNIM().equals(nim)) {
                mhs.setStatus(newStatus); 
                System.out.println("Mahasiswa berhasil diubah.");
                return; 
            }
        }
        System.out.println("Mahasiswa tidak ditemukan.");
    }
    
    public static void relasiMhsMk(String nim, String kode, String nilai) {
        Mahasiswa mahasiswa = null;
        MataKuliah mataKuliah = null;

        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.getNIM().equals(nim)) {
                mahasiswa = mhs;
                break;
            }
        }

        for (MataKuliah mk : mataKuliahList) {
            if (mk.getKode().equals(kode)) {
                mataKuliah = mk;
                break;
            }
        }

        if (mahasiswa == null || mataKuliah == null) {
            System.out.println("Gagal membuat relasi! Mahasiswa atau Mata Kuliah tidak ditemukan.");
            return;
        }

        relasiList.add(new Relasi(mahasiswa, mataKuliah, nilai));
        System.out.println("MK: " + mataKuliah.getNama() + " berhasil ditambahkan ke mahasiswa: " + mahasiswa.getNama());
    }
    
    public static void listByMatkul(String kode) {
        System.out.println("Daftar mahasiswa yang mengambil mata kuliah " + kode + ":");
        for (Relasi rel : relasiList) {
            if (rel.getMataKuliah().getKode().equals(kode)) {
                System.out.println("- " + rel.getMahasiswa().getNama() + " [Nilai: " + rel.getNilai() + "]");
            }
        }
    }
    
    public static void listByMahasiswa(String nim) {
        System.out.println("Daftar mata kuliah yang diambil mahasiswa " + nim + ":");
        for (Relasi rel : relasiList) {
            if (rel.getMahasiswa().getNIM().equals(nim)) {
                System.out.println("- " + rel.getMataKuliah().getNama() + " [Nilai: " + rel.getNilai() + "]");
            }
        }
    }

    public static void IPMhs(String nim) {
        double totalbobot = 0;
        int totalSks = 0;
        boolean found = false;
        for (Relasi r : relasiList) {
            if (r.getMahasiswa().getNIM().equals(nim)) {
                found = true;
                String nilai = r.getNilai();
                int sks = r.getMataKuliah().getSks();
                totalSks += sks;
                totalbobot += convertNilai(nilai) * sks;
            }
        }
        if (!found) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }
        double ip = totalbobot / totalSks;
        System.out.println("IP Mahasiswa " + nim + ": " + String.format("%.2f", ip));
    }
    private static double convertNilai(String nilai) {
        switch (nilai.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "E": return 0.0;
            default: return 0.0; 
        }
    }

    // Karyawan
    public static void tampilKaryawan() {
        System.out.println("\n--- DAFTAR KARYAWAN ---");
        for (Karyawan k : karyawanList) {
            System.out.println("NIK: " + k.getNik() + " | Nama: " + k.getNama() + " | Tipe: " + k.type + " | Status: " + (k.getStatus() ? "Aktif" : "Non-Aktif"));
        }
    }
    public static void tambahKaryawan(Karyawan k) {
        karyawanList.add(k);
        System.out.println("Karyawan berhasil didaftarkan!");
    }

    public static void editKaryawan(String nik, boolean status Baru) {
        for (Karyawan k : karyawanList) {
            if (k.getNik().equals(nik)) {
                k.setStatus(statusBaru);
                System.out.println("Status karyawan NIK " + nik + " berhasil diubah.");
                return;
            }
        }
        System.out.println("Karyawan tidak ditemukan.");
    }

    public static void deleteKaryawan(String nik) {
        for (int i = 0; i < karyawanList.size(); i++) {
            if (karyawanList.get(i).getNik().equals(nik)) {
                karyawanList.remove(i);
                System.out.println("Karyawan dengan NIK " + nik + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Karyawan tidak ditemukan.");
    }

    public static void hitungGajiKaryawan(String nik) {
        for (Karyawan k : karyawanList) {
            if (k.getNik().equals(nik)) {
                System.out.println("Gaji Karyawan " + k.getNama() + " (" + k.type + ") = Rp " + k.hitungGaji());
                return;
            }
        }
        System.out.println("Karyawan tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data Dummy
        tambahMatkul("MK001", "Pemrograman Berorientasi Objek", 3, true);
        mataKuliahList.add(new MataKuliah("MK01", "Algoritma", 4, true));
        mahasiswaList.add(new Mahasiswa("1125001", "Hans", "if2501@ithb.ac.id", "123", true, 2025, 2029));
        karyawanList.add(new DosenTetap("Sans", "Sans@ithb.ac.id", "UT123", true, "NIK1", 5000000, 12, 100000));
        

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Mata Kuliah");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Karyawan");
            System.out.println("4. Mahasiswa - Mata Kuliah");
            System.out.println("5. Hitung IP Mahasiswa");
            System.out.println("6. List berdasarkan Mata Kuliah");
            System.out.println("7. List berdasarkan Mahasiswa");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    System.out.println("\nMenu Mata Kuliah:");
                    System.out.println("1. Tambah Mata Kuliah");
                    System.out.println("2. Edit Mata Kuliah");
                    System.out.print("Pilih menu: ");
                    int menuMK = scanner.nextInt(); 
                    scanner.nextLine();
                    switch (menuMK) {
                        case 1:
                            System.out.print("Masukkan kode mata kuliah: ");
                            String kode = scanner.nextLine();
                            System.out.print("Masukkan nama mata kuliah: ");
                            String nama = scanner.nextLine();
                            System.out.print("Masukkan jumlah SKS mata kuliah: ");
                            int sks = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan status mata kuliah (true/false): ");
                            boolean status = Boolean.parseBoolean(scanner.nextLine());
                            tambahMatkul(kode, nama, sks, status);
                            break;

                        case 2:
                            System.out.print("Masukkan kode mata kuliah yang ingin diedit: ");
                            String editKode = scanner.nextLine();
                            System.out.print("Masukkan jumlah SKS baru mata kuliah: ");
                            int newSKS = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan status baru mata kuliah (true/false): ");
                            boolean newStatus = Boolean.parseBoolean(scanner.nextLine());
                            editMatkul(editKode, newSKS, newStatus);
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\nMenu Mahasiswa:");
                    System.out.println("1. Tambah Mahasiswa");
                    System.out.println("2. Edit Mahasiswa");
                    System.out.print("Pilih menu: ");
                    int menuMhs = scanner.nextInt(); 
                    scanner.nextLine();
                    switch (menuMhs) {
                        case 1:
                            System.out.print("Masukkan NIM mahasiswa: ");
                            String nim = scanner.nextLine();
                            System.out.print("Masukkan nama mahasiswa: ");
                            String nama = scanner.nextLine();
                            System.out.print("Masukkan email mahasiswa: ");
                            String email = scanner.nextLine();
                            System.out.print("Masukkan password mahasiswa: ");
                            String password = scanner.nextLine();
                            System.out.print("Masukkan status mahasiswa: true(aktif) / false(tidak): ");
                            boolean status = Boolean.parseBoolean(scanner.nextLine());
                            tambahMahasiswa(nim, nama, email, password, status);
                            break;

                        case 2:
                            System.out.print("Masukkan NIM mahasiswa yang ingin diedit: ");
                            String editNIM = scanner.nextLine();
                            System.out.print("Masukkan status baru mahasiswa: true(aktif) / false(tidak): ");
                            boolean newStatus = Boolean.parseBoolean(scanner.nextLine());
                            editMahasiswa(editNIM, newStatus);
                            break;
                    }
                    break;
                
                case 3:
                    System.out.println("\nMenu Karyawan:");
                    System.out.println("1. Tampilkan Karyawan");
                    System.out.println("2. Tambah Karyawan");
                    System.out.println("3. Edit Karyawan");
                    System.out.println("4. Hapus Karyawan");
                    System.out.println("5. Hitung Gaji Karyawan");
                    System.out.print("Pilih menu: ");
                    int menuKaryawan = scanner.nextInt(); 
                    scanner.nextLine();
                    switch (menuKaryawan) {
                        case 1:
                            tampilKaryawan();
                            break;
                        case 2:
                                System.out.print("Masukkan nama karyawan: ");
                                String namaKaryawan = scanner.nextLine();
                                System.out.print("Masukkan email karyawan: ");
                                String emailKaryawan = scanner.nextLine();
                                System.out.print("Masukkan password karyawan: ");
                                String passwordKaryawan = scanner.nextLine();
                                System.out.print("Masukkan tipe karyawan (DosenTetap/DosenHonorer/Staff): ");
                                String tipeKaryawan = scanner.nextLine();
                                System.out.print("Masukkan NIK karyawan: ");
                                String nikKaryawan = scanner.nextLine();
                                System.out.print("Masukkan gaji pokok karyawan: ");
                                double gajiPokok = scanner.nextDouble();
                                scanner.nextLine();
                                
                                Karyawan newKaryawan;
                                switch (tipeKaryawan) {
                                    case "DosenTetap":
                                        newKaryawan = new DosenTetap(namaKaryawan, emailKaryawan, passwordKaryawan, true, nikKaryawan, gajiPokok, 12, tunjangan);
                                        break;
                                    case "DosenHonorer":
                                        newKaryawan = new DosenHonorer(namaKaryawan, emailKaryawan, passwordKaryawan, true, nikKaryawan, gajiPokok, tunjangan);
                                        break;
                                    case "Staff":
                                        newKaryawan = new Staff(namaKaryawan, emailKaryawan, passwordKaryawan, true, nikKaryawan, gajiPokok);
                                        break;
                                    default:
                                        System.out.println("Tipe karyawan tidak valid");
                                        return;
                                }
                                
                                tambahKaryawan(newKaryawan);
                            break;
                        case 3:
                            System.out.print("Masukkan NIK karyawan yang ingin diedit: ");
                            String editNik = scanner.nextLine();
                            System.out.print("Masukkan status baru karyawan: true(aktif) / false(tidak): ");
                            boolean newStatusKaryawan = Boolean.parseBoolean(scanner.nextLine());
                            editKaryawan(editNik, newStatusKaryawan);
                            break;
                        case 4:
                            System.out.print("Masukkan NIK karyawan yang ingin dihapus: ");
                            String deleteNik = scanner.nextLine();
                            deleteKaryawan(deleteNik);
                            break;
                        case 5:
                            System.out.print("Masukkan NIK karyawan untuk menghitung gaji: ");
                            String nikGaji = scanner.nextLine();
                            hitungGajiKaryawan(nikGaji);
                            break;
                    }
                    break;

                case 4:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimInput = scanner.nextLine();
                    System.out.print("Masukkan kode mata kuliah: ");
                    String kodeInput = scanner.nextLine();
                    System.out.print("Masukkan nilai mahasiswa (misal: A/B/C): ");
                    String nilaiInput = scanner.nextLine();
                    
                    relasiMhsMk(nimInput, kodeInput, nilaiInput);
                    break;
                    
                case 5:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimIP = scanner.nextLine();
                    IPMhs(nimIP);
                    break;
                
                case 6:
                    System.out.print("Masukkan kode mata kuliah: ");
                    String kodeMK = scanner.nextLine();
                    listByMatkul(kodeMK);
                    break;
                
                case 7:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimMhs = scanner.nextLine();
                    listByMahasiswa(nimMhs);
                    break;

                case 8:
                    System.out.println("Keluar dari program.");
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}