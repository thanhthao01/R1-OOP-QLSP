import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QLSP ql = new QLSP();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== QUAN LY SAN PHAM =====");
            System.out.println("1. Xem danh sach san pham");
            System.out.println("2. Cap nhat san pham");
            System.out.println("3. Hien thi theo gia");
            System.out.println("4. Hien thi theo danh muc");
            System.out.println("5. Tong gia tri ton kho theo danh muc");
            System.out.println("6. Giam gia san pham");
            System.out.println("7. Đat hang");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            int chon = sc.nextInt();
            sc.nextLine();

             switch (chon) {
                case 1:
                    ql.hienThiTatCa();
                    break;
                case 2:
                    System.out.print("Nhap ma SP: ");
                    int ma = sc.nextInt();
                    System.out.print("Nhap ten SP moi: ");
                    String tenSP = sc.nextLine();
                    System.out.print("Nhap danh muc moi: ");
                    String danhMuc = sc.nextLine();
                    System.out.print("Nhap so luong moi: ");
                    int soLuong = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhap gia moi: ");
                    double gia = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Nhap mo ta moi: ");
                    String moTa = sc.nextLine();
                    ql.capNhatSanPham(ma,tenSP,danhMuc,gia,soLuong,moTa);
                    break;
                case 3:
                    ql.hienThiTheoGia();
                    break;
                case 4:
                    System.out.print("Nhap danh muc: ");
                    String dm = sc.nextLine();
                    ql.hienThiTheoDanhMuc(dm);
                    break;
                case 5:
                    ql.tongGiaTriTheoDanhMuc();
                    break;
                case 6:
                    System.out.print("Nhap ma SP: ");
                    int maGiam = sc.nextInt();
                    System.out.print("Nhap % giam gia: ");
                    double giam = sc.nextDouble();
                    ql.giamGiaSanPham(maGiam, giam);
                    break;
                case 7:
                    System.out.print("Nhap ma SP: ");
                    int maDH = sc.nextInt();
                    System.out.print("Nhap so luong: ");
                    int sl = sc.nextInt();
                    ql.datHang(maDH, sl);
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Chon sai, vui long thu lai!");
            }
        }
    }
}
