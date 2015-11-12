package presentation.uielements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 * Mytable
 * 
 * @author luck
 *
 */
public class MyTable extends JTable{
	public MyTable(String[][] rowData,String[] tableHead){
		setModel(new DefaultTableModel(rowData, tableHead) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		setRowHeight(30);
		setGridColor(new Color(240, 240, 240));
		getColumnModel().setColumnMargin(2);
		setRowMargin(2);
		setOpaque(false);
		setBorder(null);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		setDefaultRenderer(Object.class, renderer);
		setBg();
		
	}
	public MyTable(String[][] rowData, String[] tableHead, final int i) {
		this(rowData, tableHead);
		setModel(new DefaultTableModel(rowData, tableHead) {
			public boolean isCellEditable(int row, int column) {
				if (column==i){
					return true;
				}
				return false;
			}
		});		
	}
	public void refresh(String[][] rowData,String[] tableHead){
		setModel(new DefaultTableModel(rowData, tableHead) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		setBg();
	}
	public void setBg(){
		int count = getModel().getColumnCount();
		for (int i = 0 ; i < count; i ++){
			getColumnModel().getColumn(i).setCellRenderer(dc);
		}
	}
	public void refresh(String[][] rowData, String[] tableHead, final int i) {
		setModel(new DefaultTableModel(rowData, tableHead) {
			public boolean isCellEditable(int row, int column) {
				if (column == i)
					return true;
				return false;
			}
		});
		setBg();
	}
	
	public static DefaultTableCellRenderer dc = new DefaultTableCellRenderer(){
		 public Component getTableCellRendererComponent(JTable table,  
		            Object value, boolean isSelected, boolean hasFocus,  
		            int row, int column) { 
			Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		     if(row%2 == 0)  
		    	 cell.setBackground(new Color(200,210,222));
		     else 
		    	 cell.setBackground(new Color(240,240,240));
		     if (isSelected){
		    	 
		    	 cell.setBackground(new Color(170,180,200));
		     }
		     setHorizontalAlignment(JLabel.CENTER);
		     return cell;  
		     
		 }  
		 
	};
}
