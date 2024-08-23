package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Tinh implements Serializable{
	private int maTinh;
	private String tenTinh;
	
	public Tinh(int maTinh, String tenTinh) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	/**
	 * @return the maTinh
	 */
	public int getMaTinh() {
		return maTinh;
	}

	/**
	 * @param maTinh the maTinh to set
	 */
	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	/**
	 * @return the tenTinh
	 */
	public String getTenTinh() {
		return tenTinh;
	}

	/**
	 * @param tenTinh the tenTinh to set
	 */
	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}
	
	@Override
	public String toString() {
		return this.tenTinh + "-" + this.maTinh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTinh, tenTinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tinh other = (Tinh) obj;
		return maTinh == other.maTinh && Objects.equals(tenTinh, other.tenTinh);
	}
	
	public static ArrayList<Tinh> getDSTinh(){
		String[] arrTinh = {
				"Hà Giang", 
				"Cao Bằng",
				"Lào Cai",
				"Sơn La",
				"Lai Châu",
				"Bắc Kạn",
				"Lạng Sơn",
				"Tuyên Quang",
				"Yên Bái",
				"Thái Nguyên",
				"Điện Biên",
				"Phú Thọ",
				"Vĩnh Phúc",
				"Bắc Giang",
				"Bắc Ninh",
				"Hà Nội",
				"Quảng Ninh",
				"Hải Dương",
				"Hải Phòng",
				"Hòa Bình",
				"Hưng Yên",
				"Hà Nam",
				"Thái Bình",
				"Nam Định",
				"Ninh Bình",
				"Thanh Hóa",
				"Nghệ An",
				"Hà Tĩnh",
				"Quảng Bình",
				"Quảng Trị",
				"Thừa Thiên Huế",
				"Đà Nẵng",
				"Quảng Nam",
				"Quảng Ngãi",
				"Kon Tum",
				"Gia Lai",
				"Bình Định",
				"Phú Yên",
				"Đắk Lắk",
				"Khánh Hòa",
				"Đắk Nông",
				"Lâm Đồng",
				"Ninh Thuận",
				"Bình Phước",
				"Tây Ninh",
				"Bình Dương",
				"Đồng Nai",
				"Bình Thuận",
				"Thành phố Hồ Chí Minh",
				"Long An",
				"Bà Rịa – Vũng Tàu",
				"Đồng Tháp",
				"An Giang",
				"Tiền Giang",
				"Vĩnh Long",
				"Bến Tre",
				"Cần Thơ",
				"Kiên Giang",
				"Trà Vinh",
				"Hậu Giang",
				"Sóc Trăng",
				"Bạc Liêu",
				"Cà Mau"};
		int i = 0;
		ArrayList<Tinh> result = new ArrayList<Tinh>();
		for (String string : arrTinh) {
			result.add(new Tinh(i, string));
			i++;
		}
		return result;
	}
	
	public static Tinh getTinhByID(int queQuan) {
		return Tinh.getDSTinh().get(queQuan);
	}

	public static Tinh getTinhByTen(String string) {
		ArrayList<Tinh> dsTinh = Tinh.getDSTinh();
		for (Tinh tinh : dsTinh) {
			if(tinh.getTenTinh().equals(string)) return tinh;
		}
		return null;
	}
}
