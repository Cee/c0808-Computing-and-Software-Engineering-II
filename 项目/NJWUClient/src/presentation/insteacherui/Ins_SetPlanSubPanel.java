package presentation.insteacherui;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import presentation.uielements.MyComboBox;
import vo.LessonAbstractVO;
import vo.ModuleVO;
import vo.TypeVO;
import businesslogicservice.insteacherblservice.InsTeacherBlService;

public class Ins_SetPlanSubPanel extends JPanel {
	private final static int UPDATE = 0;
	private final static int ADD = 1;
	private int operationType = 0;
	private JTextField idField;
	private JTextField nameFiled;
	InsTeacherBlService insTeacher;
	JComboBox<ModuleVO> moduleBox;
	JComboBox<TypeVO> typeBox;
	JComboBox<String> termBox1;
	JComboBox<String> termBox2;
	JComboBox<String> creditBox;
	JComboBox<String> creditBox2;
	private ArrayList<ModuleVO> moduleList = new ArrayList<>();
	private ArrayList<TypeVO> typeList = new ArrayList<>();
	ModuleVO[] modules;
	Ins_SetPlanPanel father;
	TypeVO[] types;
	String[] term;
	String[] credit;

	class ReturnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Ins_SetPlanSubPanel.this.setVisible(false);
			father.refresh();
			father.setVisible(true);

		}
	}

	class SubmitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int les_id = -1;
			try {
				les_id = Integer.parseInt(idField.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "课程号必须为数字");
			}
			String les_name = nameFiled.getText();
			int typeId = ((TypeVO) typeBox.getSelectedItem()).getType_Id();
			int min_credit = creditBox.getSelectedIndex() + 1;
			int max_credit = creditBox.getSelectedIndex() + 1;
			if (max_credit < min_credit) {
				JOptionPane.showMessageDialog(null, "最大学分不能小于最小学分");
				return;
			}
			int term_start = termBox1.getSelectedIndex() + 1;
			int term_end = termBox2.getSelectedIndex() + 1;
			if (term_end < term_start) {
				JOptionPane.showMessageDialog(null, "学期设置出现错误-.-");
				return;
			}
			LessonAbstractVO vo = new LessonAbstractVO(les_id, les_name,
					min_credit, max_credit, 0, typeId, term_start, term_end,
					null, null, 0);
			if (operationType == ADD) {
				try {
					if (insTeacher.addLesson(vo)) {
						JOptionPane.showMessageDialog(null, "添加成功");
					} else {
						JOptionPane.showMessageDialog(null, "添加失败，已经存在该课程号的课程");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (RemoteException e1) {
					MainFrameUI.showError();
					e1.printStackTrace();
				}
			} else {
				try {
					if (!insTeacher.modifyPlan(vo)) {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
					JOptionPane.showMessageDialog(null, "修改成功");
				} catch (RemoteException e1) {
					MainFrameUI.showError();
					e1.printStackTrace();
				}
			}
		}
	}

	public void setComBoxContent() {
		term = new String[] { "1", "2", "3", "4", "5", "6", "7", "8" };
		credit = new String[] { "1", "2", "3", "4", "5" };
		try {
			Iterator<ModuleVO> modules = insTeacher.getAllModules();
			while (modules.hasNext()) {
				moduleList.add(modules.next());
			}
			this.modules = new ModuleVO[moduleList.size()];
			for (int i = 0; i < moduleList.size(); i++) {
				this.modules[i] = moduleList.get(i);
			}
			Iterator<TypeVO> types = insTeacher.getAllTypes();
			while (types.hasNext()) {
				typeList.add(types.next());
			}
		} catch (RemoteException e) {
			MainFrameUI.showError();
			e.printStackTrace();
		}
	}

	class BoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setTypeBox();
			typeComboBox.setCell(types[0]);
		}
	}

	public void setTypeBox() {
		ModuleVO moduleVO;
		if (moduleBox == null) {
			moduleVO = moduleList.get(0);
		} else {
			moduleVO = (ModuleVO) moduleBox.getSelectedItem();
		}
		ArrayList<TypeVO> temp = new ArrayList<>();
		for (TypeVO type : typeList) {
			if (type.getModule_Id() == moduleVO.getModule_Id()) {
				temp.add(type);
			}
		}
		types = new TypeVO[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			types[i] = temp.get(i);
		}
		typeBox.setModel(new DefaultComboBoxModel<TypeVO>(types));
	}
	MyComboBox<TypeVO> typeComboBox;
	public Ins_SetPlanSubPanel(Ins_SetPlanPanel father,
			InsTeacherBlService insTeacher, LessonAbstractVO lesson) {
		this.father = father;
		this.insTeacher = insTeacher;
		setLayout(null);
		setComBoxContent();
		JLabel lblxxx = new JLabel("课程编号：");
		lblxxx.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblxxx.setBounds(183, 35, 150, 37);
		add(lblxxx);

		JLabel label = new JLabel("课程名称：");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label.setBounds(183, 87, 68, 31);
		add(label);

		JLabel label_2 = new JLabel("课程学分：");
		label_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label_2.setBounds(183, 128, 68, 31);
		add(label_2);

		nameFiled = new JTextField();
		nameFiled.setBounds(248, 87, 229, 31);
		add(nameFiled);
		nameFiled.setColumns(10);

		MyButton btSave = new MyButton("保存");
		btSave.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btSave.setBounds(183, 345, 90, 30);
		btSave.addActionListener(new SubmitListener());
		add(btSave);

		MyButton btReturn = new MyButton("返回");
		btReturn.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btReturn.setBounds(307, 345, 90, 30);
		btReturn.addActionListener(new ReturnListener());
		add(btReturn);

		JLabel label_3 = new JLabel("课程模块：");
		label_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label_3.setBounds(183, 176, 68, 31);
		add(label_3);

		moduleBox = new JComboBox(modules);
		MyComboBox<ModuleVO> moduleComboBox = new MyComboBox<>(moduleBox, new Rectangle(248, 176, 158, 27), "请选择模块");
//		moduleBox.setBounds(248, 176, 158, 27);
		add(moduleComboBox);

		JLabel label_4 = new JLabel("课程分类：");
		label_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		label_4.setBounds(183, 232, 68, 31);
		add(label_4);

		typeBox = new JComboBox();
		setTypeBox();
		typeComboBox = new MyComboBox<>(typeBox, new Rectangle(248, 232, 158, 27), "请选择类型");
//		typeBox.setBounds(248, 232, 158, 27);
		add(typeComboBox);

		JLabel label_1 = new JLabel("开设学期:");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_1.setBounds(183, 292, 68, 31);
		add(label_1);

		termBox1 = new JComboBox(term);
		MyComboBox<String> termComboBox_1 = new MyComboBox<>(termBox1, new Rectangle(248, 292, 49, 27), "1");
//		termBox1.setBounds(248, 292, 49, 27);
		add(termComboBox_1);

		termBox2 = new JComboBox(term);
		MyComboBox<String> termComboBox_2 = new MyComboBox<>(termBox2, new Rectangle(338, 292, 49, 27), "1");
//		termBox2.setBounds(338, 292, 49, 27);
		add(termComboBox_2);

		JLabel label_5 = new JLabel("到");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_5.setBounds(307, 292, 68, 31);
		add(label_5);

		creditBox = new JComboBox(credit);
		MyComboBox<String> creditComboBox_1 = new MyComboBox<>(creditBox, new Rectangle(248, 128, 49, 27), "1");
//		creditBox.setBounds(248, 128, 49, 27);
		add(creditComboBox_1);

		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(248, 35, 229, 31);
		add(idField);

		JLabel label_6 = new JLabel("到");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_6.setBounds(307, 128, 68, 31);
		add(label_6);

		creditBox2 = new JComboBox(credit);
		MyComboBox<String> creditComboBox_2 = new MyComboBox<>(creditBox2, new Rectangle(338, 128, 49, 27), "1");
//		creditBox2.setBounds(338, 128, 49, 27);
		add(creditComboBox_2);

		moduleBox.addActionListener(new BoxListener());
		if (lesson != null) {
			operationType = UPDATE;
			idField.setText(lesson.getLes_Id_AbString());
			nameFiled.setText(lesson.getName());
			creditBox.setSelectedIndex(lesson.getMin_credit()-1);
			creditComboBox_1.setCell(lesson.getMin_credit()+"");
			creditBox2.setSelectedIndex(lesson.getMax_credit()-1);
			creditComboBox_2.setCell(lesson.getMax_credit()+"");
			termComboBox_1.setCell(lesson.getTerm_start()+"");
			termComboBox_2.setCell(lesson.getTerm_end()+"");
			
			for (ModuleVO module : modules) {
				if (lesson.getModule_Id() == module.getModule_Id()) {
					moduleBox.setSelectedItem(module);
					moduleComboBox.setCell(module);
				}
			}
			setTypeBox();
			for (TypeVO type : types) {
				if (type.getType_Id() == lesson.getType_Id()) {
					typeBox.setSelectedItem(type);
					typeComboBox.setCell(type);
				}
			}
			termBox1.setSelectedIndex(lesson.getTerm_start() - 1);
			termBox2.setSelectedIndex(lesson.getTerm_end() - 1);
		} else {
			operationType = ADD;
		}
		int count = getComponentCount();
		for (int i = 0; i < count; i++) {
			getComponent(i).setFont(
					new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		}
	}
}
