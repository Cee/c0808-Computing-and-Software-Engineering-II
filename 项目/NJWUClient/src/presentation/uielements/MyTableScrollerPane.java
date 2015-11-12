package presentation.uielements;

import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 * 我的ScrollerPane
 * @author luck
 *
 */
public class MyTableScrollerPane extends JScrollPane{
	public MyTableScrollerPane(JTable table){
		setViewportView(table);
		setBorder(null);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
}
