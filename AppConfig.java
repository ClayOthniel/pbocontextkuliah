import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConfig {

  // 1. Konfigurasi Database PostgreSQL
  // Ganti "nama_database_kamu" dengan nama database yang kamu buat di Navicat
  private static final String DB_URL = "jdbc:postgresql://localhost:5432/PrakPBOM";

  // 2. Kredensial Login
  // Default username PostgreSQL biasanya adalah "postgres"
  private static final String DB_USER = "postgres";

  // Ganti dengan password yang kamu atur saat menginstall PostgreSQL
  private static final String DB_PASSWORD = "123";

  /**
   * Method ini akan dipanggil oleh file DAO (seperti JurusanDAO)
   * setiap kali mereka butuh jalur komunikasi ke database.
   */
  public static Connection getConnection() throws SQLException {
    // DriverManager akan secara otomatis mencari driver PostgreSQL dan membuka
    // koneksi
    return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
  }
}