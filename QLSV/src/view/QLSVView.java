package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import controller.QLSVController;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class QLSVView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public QLSVModel model;
	public JTable table;
	public JTextField textFieldID;
	public JTextField findID;
	public JTextField textFieldHoTen;
	public JTextField textFieldNgaySinh;
	public JTextField textFieldMon1;
	public JTextField textFieldMon2;
	public JTextField textFieldMon3;
	public ButtonGroup buttonGroup;
	public JComboBox queQuanBox;
	public JRadioButton radioButtonNam;
	public JRadioButton radioButtonNu;
	public JComboBox findQueQuan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 650);
		setLocationRelativeTo(null);
		
		setTitle("Quản lý sinh viên");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		QLSVController qlsvController = new QLSVController(this);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(qlsvController);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save file");
		menuSave.addActionListener(qlsvController);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(qlsvController);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);
		
		JMenu mnNewMenu = new JMenu("About");
		menuBar.add(mnNewMenu);
		
		JMenuItem aboutMeMenu = new JMenuItem("About this project");
		aboutMeMenu.setActionCommand("About");
		aboutMeMenu.addActionListener(qlsvController);
		aboutMeMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(aboutMeMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quê quán");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 33, 102, 32);
		contentPane.add(lblNewLabel);
		
		findQueQuan = new JComboBox();
		findQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		findQueQuan.addItem("--Lựa Chọn--");
		for (Tinh tinh : listTinh) {
			findQueQuan.addItem(tinh.getTenTinh());
		}
		findQueQuan.setBounds(110, 37, 204, 32);
		contentPane.add(findQueQuan);
		
		JLabel lblM = new JLabel("Mã sinh viên");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblM.setBounds(352, 32, 110, 35);
		contentPane.add(lblM);
		
		JButton buttonTim = new JButton("Find");
		buttonTim.addActionListener(qlsvController);
		buttonTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonTim.setBounds(636, 34, 85, 31);
		contentPane.add(buttonTim);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(10, 75, 811, 2);
		contentPane.add(separator_1);
		
		JLabel lblDanhSch = new JLabel("Danh sách sinh viên");
		lblDanhSch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDanhSch.setBounds(10, 96, 204, 32);
		contentPane.add(lblDanhSch);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 sinh vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3"
			}
		));		
		table.setBounds(10, 138, 811, 416);
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 138, 811, 152);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(scrollPane);
		
		JLabel lblThngTinSinh = new JLabel("Thông tin sinh viên");
		lblThngTinSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThngTinSinh.setBounds(10, 296, 204, 32);
		contentPane.add(lblThngTinSinh);
		
		JLabel lblM_1 = new JLabel("Mã sinh viên");
		lblM_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblM_1.setBounds(10, 328, 110, 35);
		contentPane.add(lblM_1);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(131, 335, 183, 29);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		findID = new JTextField();
		findID.setColumns(10);
		findID.setBounds(472, 36, 154, 29);
		contentPane.add(findID);
		
		JLabel textfieldHoTen = new JLabel("Họ và tên");
		textfieldHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textfieldHoTen.setBounds(10, 373, 110, 35);
		contentPane.add(textfieldHoTen);
		
		textFieldHoTen = new JTextField();
		textFieldHoTen.setColumns(10);
		textFieldHoTen.setBounds(131, 380, 183, 29);
		contentPane.add(textFieldHoTen);
		
		JLabel lblM_1_2 = new JLabel("Quê quán");
		lblM_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblM_1_2.setBounds(10, 427, 110, 35);
		contentPane.add(lblM_1_2);
		
		queQuanBox = new JComboBox();
		queQuanBox.setBounds(131, 430, 183, 32);
		queQuanBox.addItem("");
		for (Tinh tinh : listTinh) {
			queQuanBox.addItem(tinh.getTenTinh());
		}
		contentPane.add(queQuanBox);
		
		JLabel labelNgaySinh = new JLabel("Ngày sinh");
		labelNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNgaySinh.setBounds(10, 472, 110, 35);
		contentPane.add(labelNgaySinh);
		
		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(131, 479, 183, 29);
		contentPane.add(textFieldNgaySinh);
		
		JLabel lblM_1_1 = new JLabel("Giới tính:");
		lblM_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblM_1_1.setBounds(390, 328, 110, 35);
		contentPane.add(lblM_1_1);
		
		radioButtonNam = new JRadioButton("Nam");
		radioButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButtonNam.setBounds(506, 335, 74, 21);
		contentPane.add(radioButtonNam);
		
		radioButtonNu = new JRadioButton("Nữ");
		radioButtonNu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButtonNu.setBounds(626, 335, 68, 21);
		contentPane.add(radioButtonNu);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonNam);
		buttonGroup.add(radioButtonNu);
		
		JLabel lblM_1_3 = new JLabel("Điểm môn 1");
		lblM_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblM_1_3.setBounds(390, 372, 110, 35);
		contentPane.add(lblM_1_3);
		
		textFieldMon1 = new JTextField();
		textFieldMon1.setColumns(10);
		textFieldMon1.setBounds(511, 379, 183, 29);
		contentPane.add(textFieldMon1);
		
		JLabel lblM_1_4 = new JLabel("Điểm môn 2");
		lblM_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblM_1_4.setBounds(390, 426, 110, 35);
		contentPane.add(lblM_1_4);
		
		textFieldMon2 = new JTextField();
		textFieldMon2.setColumns(10);
		textFieldMon2.setBounds(511, 433, 183, 29);
		contentPane.add(textFieldMon2);
		
		JLabel lblM_1_5 = new JLabel("Điểm môn 3");
		lblM_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblM_1_5.setBounds(390, 471, 110, 35);
		contentPane.add(lblM_1_5);
		
		textFieldMon3 = new JTextField();
		textFieldMon3.setColumns(10);
		textFieldMon3.setBounds(511, 478, 183, 29);
		contentPane.add(textFieldMon3);
		
		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addButton.setBounds(10, 536, 116, 32);
		addButton.addActionListener(qlsvController);
		contentPane.add(addButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteButton.setBounds(167, 536, 123, 32);
		deleteButton.addActionListener(qlsvController);
		contentPane.add(deleteButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateButton.setBounds(335, 536, 123, 32);
		updateButton.addActionListener(qlsvController);
		contentPane.add(updateButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		saveButton.setBounds(514, 536, 123, 32);
		saveButton.addActionListener(qlsvController);
		contentPane.add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelButton.setBounds(691, 536, 130, 32);
		cancelButton.addActionListener(qlsvController);
		contentPane.add(cancelButton);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setBounds(10, 517, 811, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBackground(Color.BLACK);
		separator_2_1.setBounds(10, 296, 811, 2);
		contentPane.add(separator_2_1);
		
		JButton buttonHuy = new JButton("Cancel");
		buttonHuy.setActionCommand("Cancel find");
		buttonHuy.addActionListener(qlsvController);
		buttonHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonHuy.setBounds(726, 34, 95, 31);
		contentPane.add(buttonHuy);
		this.setVisible(true);
	}

	public void resetForm() {
		this.textFieldID.setText("");
		this.textFieldHoTen.setText("");
		this.textFieldMon1.setText("");
		this.textFieldMon2.setText("");
		this.textFieldMon3.setText("");
		this.textFieldNgaySinh.setText("");
		this.queQuanBox.setSelectedIndex(-1);
		this.buttonGroup.clearSelection();
	}
	
	public void themThiSinh(ThiSinh thiSinh) {
			DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
			tableModel.addRow(new Object[] {
					thiSinh.getMaThiSinh() + "",
					thiSinh.getTenThiSinh() + "",
					thiSinh.getQueQuan().getTenTinh(),
					thiSinh.getNgaySinh().getDate()+"/"+(thiSinh.getNgaySinh().getMonth()+1)+"/"+(thiSinh.getNgaySinh().getYear() + 1900),
					thiSinh.getGioiTinh() ? "Nữ" : "Nam",
					thiSinh.getDiemMon1() + "",
					thiSinh.getDiemMon2() + "",
					thiSinh.getDiemMon3() + ""
			}
			);
	}


	public void themSinhVien() {
		int maThiSinh = Integer.valueOf(this.textFieldID.getText());
		String tenThiSinh = this.textFieldHoTen.getText();
		Tinh queQuan = Tinh.getTinhByID(this.queQuanBox.getSelectedIndex() - 1);
		Date ngaySinh = new Date(this.textFieldNgaySinh.getText());
		String chonGioiTinh = this.buttonGroup.getSelection() + "";
		boolean gioiTinh = this.radioButtonNu.isSelected();
		float diemMon1 = Float.valueOf(this.textFieldMon1.getText());
		float diemMon2 = Float.valueOf(this.textFieldMon2.getText());
		float diemMon3 = Float.valueOf(this.textFieldMon3.getText());
		
		ThiSinh thiSinh = new ThiSinh(maThiSinh, tenThiSinh, queQuan, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		if(!this.model.kiemTraTonTai(thiSinh)) {
			this.model.insert(thiSinh);
			this.themThiSinh(thiSinh);
		}
		else {
			this.model.update(thiSinh);
			int soLuongDong = table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = table.getValueAt(i, 0)+"";
				if(id.equals(thiSinh.getMaThiSinh()+"")) {
					table.setValueAt(thiSinh.getMaThiSinh() + "", i , 0);
					table.setValueAt(thiSinh.getTenThiSinh() + "", i , 1);
					table.setValueAt(thiSinh.getQueQuan().getTenTinh(), i , 2);
					table.setValueAt(thiSinh.getNgaySinh().getDate()+"/"+(thiSinh.getNgaySinh().getMonth()+1)+"/"+(thiSinh.getNgaySinh().getYear() + 1900), i , 3);
					table.setValueAt(thiSinh.getGioiTinh() ? "Nữ" : "Nam", i , 4);
					table.setValueAt(thiSinh.getDiemMon1() + "", i , 5);
					table.setValueAt(thiSinh.getDiemMon2() + "", i , 6);
					table.setValueAt(thiSinh.getDiemMon3() + "", i , 7);
				}
			}
		}
	}

	public void hienThiThongTinThiSinh() {
		ThiSinh ts = this.getThiSinh();
		
		this.textFieldID.setText(ts.getMaThiSinh()+"");
		this.textFieldHoTen.setText(ts.getTenThiSinh());
		this.queQuanBox.setSelectedItem(ts.getQueQuan().getTenTinh());
		if(ts.getGioiTinh()) this.radioButtonNam.setSelected(true);
		else this.radioButtonNu.setSelected(true);
		this.textFieldNgaySinh.setText(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear() + 1900));
		this.textFieldMon1.setText(ts.getDiemMon1()+"");
		this.textFieldMon2.setText(ts.getDiemMon2()+"");
		this.textFieldMon3.setText(ts.getDiemMon3()+"");
	}

	public void xoa() {
		DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
		int rowIndex = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa thí sinh không?");
		if(luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = this.getThiSinh();
			this.model.delete(ts);
			tableModel.removeRow(rowIndex);	
		}
	}
	
	public ThiSinh getThiSinh() {
		DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
		int rowIndex = this.table.getSelectedRow();
		while(true) {
			String luaChon = JOptionPane.showInputDialog(this, "Vui lòng chọn thí sinh cần update!");
			rowIndex = Integer.valueOf(luaChon);
			if(rowIndex != -1) break;
		}
		
		int maThiSinh = Integer.valueOf(tableModel.getValueAt(rowIndex, 0)+"");
		String tenThiSinh = tableModel.getValueAt(rowIndex, 1)+"";
		Tinh tinh = Tinh.getTinhByTen(tableModel.getValueAt(rowIndex, 2)+"");
		Date ngaySinh = new Date(tableModel.getValueAt(rowIndex, 3)+"");
		String chonGioiTinh = tableModel.getValueAt(rowIndex, 4)+"";
		boolean gioiTinh = chonGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(tableModel.getValueAt(rowIndex, 5)+"");
		float diemMon2 = Float.valueOf(tableModel.getValueAt(rowIndex, 6)+"");
		float diemMon3 = Float.valueOf(tableModel.getValueAt(rowIndex, 7)+"");
		return (new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3));
	}

	public void thucHienTim() {
		this.resetDuLieu();
		int queQuan = this.findQueQuan.getSelectedIndex() - 1;
		
		DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
		int soLuongDong = table.getRowCount();
		Set<Integer> idCanXoa = new TreeSet<Integer>();
		if(queQuan >= 0) {
			Tinh tinh = Tinh.getTinhByID(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = table.getValueAt(i, 2)+"";
				if(!tenTinh.equals(tinh.getTenTinh())) {
					idCanXoa.add(Integer.valueOf(table.getValueAt(i, 0)+""));
				}
			}
		}
		
		String maThiSinh = this.findID.getText();
		if(maThiSinh.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = table.getValueAt(i, 0)+"";
				if(!id.equals(maThiSinh)) {
					idCanXoa.add(Integer.valueOf(table.getValueAt(i, 0)+""));
				}
			}
		}
		
		for (Integer integer : idCanXoa) {
			int nRows = table.getRowCount();
			for (int i = 0; i < nRows; i++) {
				String id = table.getValueAt(i, 0)+"";
				if(id.equals(integer+"")) {
					tableModel.removeRow(i);
					break;
				}
			}
		}
	}
	
	
	public void resetDuLieu() {
		DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
		while(table.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
		for (ThiSinh thiSinh : this.model.getDsThiSinh()) {
			this.themThiSinh(thiSinh);
		}
	}
	
	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý sinh viên 1.0");
	}
	
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát khỏi chương trình?");
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void saveFile(String tenFile) {
		this.model.setTenFile(tenFile);
		try {
			FileOutputStream fos = new FileOutputStream(tenFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save() {
		
		if(this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		}
		else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}
	
	public void openFile(File file) {
		ArrayList<ThiSinh> dsThiSinh =  new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject()) != null) {
				dsThiSinh.add(ts);
			}
			
			ois.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
		this.model.setDsThiSinh(dsThiSinh);
	}
	
	public void open() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			resetDuLieu();
		}
	}
}
