package presentation.adminui;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import utility.CurrentState;

/**
 * 重写AbstractTableModel类
 * 达到对表格内容进行修改时可以及时做出反应
 * 以减少界面监听的压力和简洁性
 * 并且具有简易的备份和恢复的功能
 * @author Xc
 *
 */
public class MyModifyTableModel extends AbstractTableModel {

	Object[][] contents;
	Object[] title;

	Object[][] copyOfContents;
	int lastSelectRow = -1;

	boolean[] editList;
	
	/**
	 * 初始化表格
	 * @param contents 表格内初始的内容
	 * @param title 表头
	 */
	
	public MyModifyTableModel(Object[][] contents, Object[] title) {
		this.contents = contents;
		this.title = title;
		initCopy();
	}

	/**
	 * 仅使用表头构建一个空的表格
	 * @param title 表头
	 */
	public MyModifyTableModel(Object[] title) {
		this.title = title;
		contents = new Object[0][title.length];
		initCopy();
	}
	
	@Override
	public int getRowCount() {
		return contents.length;
	}

	@Override
	public int getColumnCount() {
		return title.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return contents[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		// if (contents.length <= rowIndex) {
		// String[][] oldContents = contents;
		// contents = new String[rowIndex * 2][title.length];
		// setContents(oldContents);
		// }
		contents[row][column] = aValue;
		editList[row] = RowEdited(row);
		
		
		if (column >= 2) {
			CurrentState.clog("row: " + row + " column "+column + "setted");

			if (editList[row]) {
				contents[row][0] = Admin_Modify.CANCEL;
				contents[row][1] = Admin_Modify.SUBMIT;
			} else {
				contents[row][0] = "";
				contents[row][1] = "";
			}
			fireTableCellUpdated(row, column);
			fireTableCellUpdated(row, 0);
			fireTableCellUpdated(row, 1);
			
		}
		
	}

	/**
	 * 替换表格内容
	 * @param newContents
	 */
	public void replaceContents(Object[][] newContents) {
		this.contents = newContents;
		initCopy();
		super.fireTableChanged(new TableModelEvent(this));

	}
	
	@Override
	public String getColumnName(int column) {
		return title[column].toString();
	}

	/**
	 * 设置表头
	 * @param title
	 */
	public void setTitle(Object[] title) {
		for (int i = 0; i < this.title.length; ++i) {
			this.title[i] = title[i];
		}
	}
	
	/**
	 * 控制表格的可编辑的部分
	 */
	public boolean isCellEditable(int row, int column) {
		return (column >= 3 && column <= 5);
	}

	/**
	 * (外部调用)返回行是否已经被编辑
	 * 该方法仅调用缓存中的值
	 * @param lastSelectRow
	 * @return 该行是否已经被编辑
	 */
	public boolean isRowEdited(int lastSelectRow) {
		CurrentState.clog(editList.length);
		return editList[lastSelectRow];
	}

	/**
	 * (内部调用)返回行是否已经被编辑
	 * 并且更新缓存中的值
	 * 该方法仅在某行内容有变化时会被调用
	 * @param lastSelectRow
	 * @return 该行是否已经被编辑
	 */
	private boolean RowEdited(int lastSelectRow) {
		boolean flag = true;
		for (int i = 2; i < title.length; ++i) {
			flag &= !isCellEdited(lastSelectRow, i);
		}
		return !flag;
	}

	/**
	 * （与设计无关）
	 * 用于拷贝一个二维数组
	 * @param old
	 * @return 
	 */
	private Object[][] cloneArray(Object[][] old) {
		if (old.length >= 1) {
			Object[][] newArray = new Object[old.length][old[0].length];
			for (int i = 0; i < old.length; ++i) {
				for (int j = 0; j < old[0].length; ++j) {
					newArray[i][j] = old[i][j];
				}
			}
			return newArray;

		} else
			return (new Object[0][title.length]);
	}

	/**
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return 该单元格是否被用户修改
	 */
	private boolean isCellEdited(int rowIndex, int columnIndex) {
		if (copyOfContents[rowIndex][columnIndex] == null) {
			return contents[rowIndex][columnIndex] == null;
		} else if (contents[rowIndex][columnIndex] == null) {
			return copyOfContents[rowIndex][columnIndex] == null;
		} else {
			return !copyOfContents[rowIndex][columnIndex]
					.equals(contents[rowIndex][columnIndex]);
		}
	}

	/**
	 * 当表格被更新时调用
	 */
	private void initCopy() {
		copyOfContents = cloneArray(this.contents);
		editList = new boolean[contents.length];
		for (int i = 0; i < contents.length; ++i) {
			editList[i] = false;
		}
		
		
		CurrentState.clog(editList.length);
		
		lastSelectRow = -1;
	}

	/**
	 * 取消对选定行的更改，取代之以备份中的数据
	 * @param row
	 */
	public void cancelRow(int row) {
		if (isRowEdited(row)) {
			for (int i = 2; i < title.length; ++i) {
				contents[row][i] = copyOfContents[row][i];
			}
			contents[row][0] = "";
			contents[row][1] = "";
			fireTableCellUpdated(row, 0);
			fireTableCellUpdated(row, 1);
		}
	}

	/**
	 * 将所有的现有更改提交，即将现有内容拷贝至备份区
	 * 
	 */
	public void submitAll() {
		copyOfContents = cloneArray(this.contents);
		editList = new boolean[contents.length];
		for (int i = 0; i < contents.length; ++i) {
			editList[i] = false;
		}
	}

}
