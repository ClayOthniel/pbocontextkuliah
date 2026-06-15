abstract class UserInfo {
    private String nama;
    private String email;
    private String password;
    private boolean status;
    private User role;

    public UserInfo(String nama, String email, User role) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public boolean getStatus() { return status; }
    public User getRole() { return role; }
    public void setStatus(boolean status) { this.status = status; }
}
