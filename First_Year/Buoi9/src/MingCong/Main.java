package MingCong;

public class Main {
    public static void main(String[] args) {
        SanPham SP = new SanPham("", 0, 0);
        SanPhamKhuyenMai SPKM = new SanPhamKhuyenMai("", 0, 0);
        
        SP.nhapTT();
        System.out.println(SP.toString());
        System.out.println("Tong gia tri: " + SPKM.tong());
        
    }
}