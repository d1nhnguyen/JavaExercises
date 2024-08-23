package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ThiSinh implements Serializable{
	private int maThiSinh;
	private String tenThiSinh;
	private Tinh queQuan;
	private Date ngaySinh;
	private Boolean gioiTinh;
	private float diemMon1;
	private float diemMon2;
	private float diemMon3;
	
	public ThiSinh(int maThiSinh, String tenThiSinh, Tinh queQuan, Date ngaySinh, Boolean gioiTinh, float diemMon1,
			float diemMon2, float diemMon3) {
		super();
		this.maThiSinh = maThiSinh;
		this.tenThiSinh = tenThiSinh;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diemMon1 = diemMon1;
		this.diemMon2 = diemMon2;
		this.diemMon3 = diemMon3;
	}

	/**
	 * @return the maThiSinh
	 */
	public int getMaThiSinh() {
		return maThiSinh;
	}

	/**
	 * @param maThiSinh the maThiSinh to set
	 */
	public void setMaThiSinh(int maThiSinh) {
		this.maThiSinh = maThiSinh;
	}

	/**
	 * @return the tenThiSinh
	 */
	public String getTenThiSinh() {
		return tenThiSinh;
	}

	/**
	 * @param tenThiSinh the tenThiSinh to set
	 */
	public void setTenThiSinh(String tenThiSinh) {
		this.tenThiSinh = tenThiSinh;
	}

	/**
	 * @return the queQuan
	 */
	public Tinh getQueQuan() {
		return queQuan;
	}

	/**
	 * @param queQuan the queQuan to set
	 */
	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}

	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}

	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	/**
	 * @return the gioiTinh
	 */
	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the diemMon1
	 */
	public float getDiemMon1() {
		return diemMon1;
	}

	/**
	 * @param diemMon1 the diemMon1 to set
	 */
	public void setDiemMon1(float diemMon1) {
		this.diemMon1 = diemMon1;
	}

	/**
	 * @return the diemMon2
	 */
	public float getDiemMon2() {
		return diemMon2;
	}

	/**
	 * @param diemMon2 the diemMon2 to set
	 */
	public void setDiemMon2(float diemMon2) {
		this.diemMon2 = diemMon2;
	}

	/**
	 * @return the diemMon3
	 */
	public float getDiemMon3() {
		return diemMon3;
	}

	/**
	 * @param diemMon3 the diemMon3 to set
	 */
	public void setDiemMon3(float diemMon3) {
		this.diemMon3 = diemMon3;
	}

	@Override
	public String toString() {
		return "ThiSinh [maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", queQuan=" + queQuan + ", ngaySinh="
				+ ngaySinh + ", gioiTinh=" + gioiTinh + ", diemMon1=" + diemMon1 + ", diemMon2=" + diemMon2
				+ ", diemMon3=" + diemMon3 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diemMon1, diemMon2, diemMon3, gioiTinh, maThiSinh, ngaySinh, queQuan, tenThiSinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThiSinh other = (ThiSinh) obj;
		return Float.floatToIntBits(diemMon1) == Float.floatToIntBits(other.diemMon1)
				&& Float.floatToIntBits(diemMon2) == Float.floatToIntBits(other.diemMon2)
				&& Float.floatToIntBits(diemMon3) == Float.floatToIntBits(other.diemMon3)
				&& Objects.equals(gioiTinh, other.gioiTinh) && maThiSinh == other.maThiSinh
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(queQuan, other.queQuan)
				&& Objects.equals(tenThiSinh, other.tenThiSinh);
	}

	
}
