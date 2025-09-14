import java.util.*;

class SanPham{
    private int maSP;
    private String tenSP;
    private String danhMuc;
    private double gia;
    private int soLuong;
    private String moTa;
    private double giamGia;

    public SanPham(int maSP,String tenSP,String danhMuc, double gia, int soLuong,String moTa, double giamGia){
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.danhMuc = danhMuc;
        this.gia = gia;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.giamGia = giamGia;
    }

    public int getMaSP(){
        return maSP;
    }
    public void setMaSP(int maSP){
        this.maSP = maSP;
    }

    public String getTenSP(){
        return tenSP;
    }
    public void setTenSP(String tenSP){
        this.tenSP = tenSP;
    }

    public String getDanhMuc(){
        return danhMuc;
    }
    public void setDanhMuc(String danhMuc){
        this.danhMuc = danhMuc;
    }
  
    public int getSoLuong(){
        return soLuong;
    }
    public void setSoLuong(int soLuong){
        this.soLuong = soLuong;
    }

    public double setGia(){
        return gia;
    }
    public void setGia(double gia){
        this.gia = gia;
    }

    public String setMoTa(){
        return moTa;
    }
    public void setMoTa(String moTa){
        this.moTa = moTa;
    }

    public double getGiamGia(){
        return giamGia;
    }
    public void setGiaGiam(double giamGia){
        this.giamGia = giamGia;
    }

    public double getGiaGiam(){
        return gia*(1-giamGia/100);
    }

    @Override
    public String toString(){
        return String.format("Mã: %d | %s | Danh mục: %s | Giá: %.2f | SL: %d | Giảm giá: %.0f%% | %s", maSP, tenSP, danhMuc, getGiaGiam(), soLuong, giamGia, moTa);
    }
}

public class QLSP{
    private List<SanPham> dsSanPham = new ArrayList<>();

    public QLSP(){
    dsSanPham.add(new SanPham(1,"Ao thun","Ao", 150000,20,"Ao thun baby tee nu", 0));
    dsSanPham.add(new SanPham(2,"Chan Vay chu A","Vay", 200000,22,"Chan vay đen chu A đen nu", 0));
    dsSanPham.add(new SanPham(3,"Quan tay","Quan",250000,33,"Quan tay cong so van phong nu", 0));
    }
    public void capNhatSanPham(int maSP,String tenSP,String danhMuc, double gia, int soLuong,String moTa){
        for(SanPham sp : dsSanPham){
            if (sp.getMaSP() == maSP){
                sp.setTenSP(tenSP);
                sp.setDanhMuc(danhMuc);
                sp.setGia(gia);
                sp.setSoLuong(soLuong);
                sp.setMoTa(moTa);
                System.out.println("Cap nhat thanh Cong !");
                return;
            }
        }
        System.out.println("Khong tim thay san pham!");
    }

    public void hienThiTheoGia(){
        dsSanPham.stream().sorted(Comparator.comparingDouble(SanPham::getGiaGiam)).forEach(System.out::println);
    }

    public void hienThiTheoDanhMuc(String danhMuc){
        dsSanPham.stream()
            .filter(sp -> sp.getDanhMuc().equalsIgnoreCase(danhMuc))
            .forEach(System.out::println);
    }

    public void tongGiaTriTheoDanhMuc(){
        List<String> danhMucDaTinh = new ArrayList<>();
        for (SanPham sp : dsSanPham){
            String dm = sp.getDanhMuc();

            if(!danhMucDaTinh.contains(dm)){
                double tong = 0;
                for (SanPham sp1 : dsSanPham){
                    if (sp1.getDanhMuc().equals(dm)){
                        tong += sp1.getGiaGiam()*sp1.getSoLuong();
                    }
                }
                System.out.println(dm + ": "+tong+ "VND");
                danhMucDaTinh.add(dm);
            }
        }
    }

    public void giamGiaSanPham(int maSP,double giamGia){
        for (SanPham sp : dsSanPham){
            if(sp.getMaSP() == maSP){
                sp.setGiaGiam(giamGia);
                System.out.println("Giam gia thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay!");
    }

    public void datHang(int maSP, int soLuong){
        for (SanPham sp : dsSanPham){
            if(sp.getMaSP() == maSP){
                if(soLuong <= sp.getSoLuong()){
                    double tongTien = sp.getGiaGiam()*soLuong;
                    sp.setSoLuong(sp.getSoLuong() - soLuong);
                    System.out.println("Đat hang thanh cong!");
                }else{
                    System.out.println("Khong đu so luong trong kho!");
                }
                return;
            }
        }
        System.out.println("Khong tim thay!");
    }

    public void hienThiTatCa(){
        dsSanPham.forEach(System.out::println);
    }

}