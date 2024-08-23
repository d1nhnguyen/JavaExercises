package model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private String luaChon;
	private String tenFile;
	
	public QLSVModel() {
		this.dsThiSinh = new ArrayList<>();
		this.luaChon = "";
		this.tenFile = "";
	}
	
	/**
	 * @return the tenFile
	 */
	public String getTenFile() {
		return tenFile;
	}

	/**
	 * @param tenFile the tenFile to set
	 */
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	/**
	 * @return the luaChon
	 */
	public String getLuaChon() {
		return luaChon;
	}

	/**
	 * @param luaChon the luaChon to set
	 */
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	/**
	 * @return the dsThiSinh
	 */
	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	/**
	 * @param dsThiSinh the dsThiSinh to set
	 */
	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	
	public void insert(ThiSinh thiSinh) {
		this.dsThiSinh.add(thiSinh);
	}
	
	public void delete(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
	}
	
	public void update(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
		this.dsThiSinh.add(thiSinh);
	}

	public boolean kiemTraTonTai(ThiSinh thiSinh) {
		for(ThiSinh ts: dsThiSinh) {
			if(thiSinh.getMaThiSinh() == ts.getMaThiSinh()) {
				return true;
			}
		}
		return false;
	}
	
	
}
