package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener{
	public QLSVView qlsvView;
	
	public QLSVController(QLSVView qlsvView) {
		this.qlsvView = qlsvView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Add")) {
			this.qlsvView.resetForm();		
			this.qlsvView.model.setLuaChon("Add");
		}
		else if(actionCommand.equals("Save")) {
			this.qlsvView.themSinhVien();
		}
		
		else if(actionCommand.equals("Update")) {
			this.qlsvView.hienThiThongTinThiSinh();
		}
		
		else if(actionCommand.equals("Delete")) {
			this.qlsvView.xoa();
		}
		
		else if(actionCommand.equals("Cancel")) {
			this.qlsvView.resetForm();
		}
		
		else if(actionCommand.equals("Find")) {
			this.qlsvView.thucHienTim();
		}
		
		else if(actionCommand.equals("Cancel find")) {
			this.qlsvView.resetDuLieu();
		}
		
		else if(actionCommand.equals("About")) {
			this.qlsvView.hienThiAbout();
		}
		
		else if(actionCommand.equals("Exit")) {
			this.qlsvView.thoatKhoiChuongTrinh();
		}
		
		else if(actionCommand.equals("Save file")) {
			this.qlsvView.save();
		}
		
		else if(actionCommand.equals("Open")) {
			this.qlsvView.open();
		}
	}

}
