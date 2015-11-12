package presentation.schteacherui;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.OptionPaneUI;

import com.sun.tracing.dtrace.ModuleName;

import businesslogicservice.schteacherblservice.SchTeacherBlService;

import presentation.mainui.MainFrameUI;
import presentation.schteacherui.Sch_ManageSelection.SubmitListener;
import presentation.uielements.MyButton;
import presentation.uielements.MyComboBox;
import utility.Constant;
import vo.FrameVO;
import vo.LessonAbstractVO;
import vo.ModuleVO;
import vo.TypeVO;

public class ModuleEditor extends JPanel {
	private JTextField moduleFiled;
	private JTextField moduleCredit1;
	private JTextField moduleCredit2;
	private JTextField typeCredit;
	private JTextField typeCredit2;
	private JTextField typeTerm;
	private JTextField typeTerm2;
	private JTextField typeNameFiled;
	private JTextField lessonCredit;
	private JTextField lessonCredit2;
	private JTextField lessonTerm1;
	private JTextField lessonTerm2;
	private JTextField lessonIdFiled;
	private JTextField lessonName;
	JComboBox moduleBox;
	MyComboBox<ModuleVO> myModuleBox;
	JComboBox compulosoryBox;
	MyComboBox<String> myCompulosoryBox;
	JComboBox lessonTypeBox;
	MyComboBox<LessonAbstractVO> myLessonBox;
	JComboBox lessonBox;
	MyComboBox<TypeVO> myLessonTypeBox;
	JComboBox moduleBox2;
	MyComboBox<ModuleVO> myModuleBox2;
	JComboBox typeBox;
	MyComboBox<TypeVO> myTypeBox;

	SchTeacherBlService schTeacher;
	FrameVO frame;
	LessonAbstractVO[] lessons;
	ModuleVO[] modules;
	TypeVO[] types;

	ArrayList<LessonAbstractVO> lessonList;
	ArrayList<ModuleVO> modulelist;
	ArrayList<TypeVO> typeList;
	ArrayList<LessonAbstractVO> newLessonList = new ArrayList<>();
	ArrayList<ModuleVO> newModulelist = new ArrayList<>();
	ArrayList<TypeVO> newTypeList = new ArrayList<>();

	class BoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			fillData();
		}
	}

	class AddModuleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ModuleVO newModuleVO = new ModuleVO(modulelist.size()+1, moduleFiled.getText(), 0, 0);
			modulelist.add(newModuleVO);
			newModulelist.add(newModuleVO);
			initialBox();
			moduleBox.setSelectedItem(newModuleVO);
			myModuleBox.setCell(newModuleVO);
			fillData();
		}
	}
	class AddTypeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			TypeVO type = new TypeVO(typeList.size()+1, 1, null, typeNameFiled.getText(), 1, 1,
					1, 1, 1);
			typeList.add(type);
			newTypeList.add(type);
			initialBox();
			typeBox.setSelectedItem(type);
			myTypeBox.setCell(type);
			fillData();
		}
	}

	class AddLessonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LessonAbstractVO lesson = new LessonAbstractVO(0,
					lessonName.getText(), 1, 1, 3, 1, 1, 1, null, null, 1);
			lessonList.add(lesson);
			newLessonList.add(lesson);
			initialBox();
			lessonBox.setSelectedItem(lesson);
			myLessonBox.setCell(lesson);
			fillData();
		}
	}

	class SaveLesson implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LessonAbstractVO selectedLesson = (LessonAbstractVO) lessonBox
					.getSelectedItem();
			final LessonAbstractVO lesson = new LessonAbstractVO(
					Integer.parseInt(lessonIdFiled.getText()),
					selectedLesson.getName(), Integer.parseInt(lessonCredit
							.getText()), Integer.parseInt(lessonCredit2
							.getText()), 0,
					((TypeVO) lessonTypeBox.getSelectedItem()).getType_Id(),
					Integer.parseInt(lessonTerm1.getText()),
					Integer.parseInt(lessonTerm2.getText()), null, null, 0);
			MainFrameUI.loadingPanel.setMessage("正在保存...");
			MainFrameUI.showWating();
			ModuleEditor.this.setVisible(false);
			if (newLessonList.contains((LessonAbstractVO) lessonBox
					.getSelectedItem())) {
				new Thread() {
					public void run() {
						try {
							if (schTeacher.addLesson(lesson)) {
								frame = schTeacher.showFrame();
								initialBox();
								fillData();
								JOptionPane.showMessageDialog(null, "保存成功");
							} else {
								JOptionPane.showMessageDialog(null, "保存失败");
							}
						} catch (RemoteException e) {
							MainFrameUI.showError();
							e.printStackTrace();
						}
						MainFrameUI.hideWating();
						ModuleEditor.this.setVisible(true);

					}
				}.start();
			} else {
				new Thread() {
					public void run() {
						try {
							if (schTeacher.modifyLesson(lesson)) {
								frame = schTeacher.showFrame();
								initialBox();
								fillData();
								JOptionPane.showMessageDialog(null, "保存成功");
							} else {
								JOptionPane.showMessageDialog(null, "保存失败");
							}
						} catch (RemoteException e) {
							MainFrameUI.showError();
							e.printStackTrace();
						}
						MainFrameUI.hideWating();
						ModuleEditor.this.setVisible(true);
					}
				}.start();
			}
		}
	}

	class SaveModuleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ModuleVO selectedModuleVO = (ModuleVO) moduleBox.getSelectedItem();
			final ModuleVO module = new ModuleVO(
					selectedModuleVO.getModule_Id(),
					selectedModuleVO.getName(), Integer.parseInt(moduleCredit1
							.getText()), Integer.parseInt(moduleCredit2
							.getText()));
			MainFrameUI.loadingPanel.setMessage("正在保存...");
			MainFrameUI.showWating();
			ModuleEditor.this.setVisible(false);

			if (newModulelist.contains((ModuleVO) moduleBox.getSelectedItem())) {
				new Thread() {
					public void run() {
						try {
							if (schTeacher.addModule(module)) {
								frame = schTeacher.showFrame();
								initialBox();
								fillData();
								JOptionPane.showMessageDialog(null, "保存成功");
							} else {
								JOptionPane.showMessageDialog(null, "保存失败");
							}
						} catch (RemoteException e) {
							MainFrameUI.showError();
							e.printStackTrace();
						}
						MainFrameUI.hideWating();
						ModuleEditor.this.setVisible(true);

					}
				}.start();
			} else {
				new Thread() {
					public void run() {
						try {
							if (schTeacher.modifyModule(module)) {
								frame = schTeacher.showFrame();
								initialBox();
								fillData();
								JOptionPane.showMessageDialog(null, "保存成功");
							} else {
								JOptionPane.showMessageDialog(null, "保存失败");
							}						} catch (RemoteException e) {
							MainFrameUI.showError();
							e.printStackTrace();
						}
						MainFrameUI.hideWating();
						ModuleEditor.this.setVisible(true);

					}
				}.start();
			}
		}
	}

	class SaveTypeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			TypeVO selectedType = (TypeVO) typeBox.getSelectedItem();
			final TypeVO type = new TypeVO(selectedType.getType_Id(),
					((ModuleVO)moduleBox2.getSelectedItem()).getModule_Id(), null, selectedType.getName(),
					compulosoryBox.getSelectedIndex() + 1,
					Integer.parseInt(typeTerm.getText()),
					Integer.parseInt(typeTerm2.getText()),
					Integer.parseInt(typeCredit.getText()),
					Integer.parseInt(typeCredit2.getText()));
			MainFrameUI.loadingPanel.setMessage("正在保存...");
			MainFrameUI.showWating();
			ModuleEditor.this.setVisible(false);

			if (newTypeList.contains((TypeVO) typeBox.getSelectedItem())) {
				new Thread() {
					public void run() {
						try {
							if (schTeacher.addType(type)) {
								
								frame = schTeacher.showFrame();
								initialBox();
								fillData();
								JOptionPane.showMessageDialog(null, "保存成功");
							} else {
								JOptionPane.showMessageDialog(null, "保存失败");
							}						} catch (RemoteException e) {
							MainFrameUI.showError();
							e.printStackTrace();
						}
						MainFrameUI.hideWating();
						ModuleEditor.this.setVisible(true);

					}
				}.start();
			} else {
				new Thread() {
					public void run() {
						try {
							if (schTeacher.modifyType(type)) {
								frame = schTeacher.showFrame();
								initialBox();
								fillData();
								JOptionPane.showMessageDialog(null, "保存成功");
							} else {
								JOptionPane.showMessageDialog(null, "保存失败");
							}
						} catch (RemoteException e) {
							MainFrameUI.showError();
							e.printStackTrace();
						}
						MainFrameUI.hideWating();
						ModuleEditor.this.setVisible(true);
						
					}
				}.start();
			}
		}
	}

	class DeleteModuleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			final int id = ((ModuleVO)moduleBox.getSelectedItem()).getModule_Id();
			MainFrameUI.loadingPanel.setMessage("正在删除...");
			ModuleEditor.this.setVisible(false);
			MainFrameUI.showWating();
			new Thread(){
				public void run(){
					try {
						if (schTeacher.deleteModule(id)){
							frame = schTeacher.showFrame();
							initialBox();
							fillData();
							JOptionPane.showMessageDialog(null, "删除成功");
						}else {
							JOptionPane.showMessageDialog(null, "删除失败");
						}
					} catch (RemoteException e) {
						MainFrameUI.showError();
						e.printStackTrace();
					}
					MainFrameUI.hideWating();
					ModuleEditor.this.setVisible(true);

				}
			}.start();
		}
		
	}
	class DeleteTypeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			final int id = ((TypeVO)typeBox.getSelectedItem()).getType_Id();
			MainFrameUI.loadingPanel.setMessage("正在删除...");
			ModuleEditor.this.setVisible(false);
			MainFrameUI.showWating();
			new Thread(){
				public void run(){
					try {
						if (schTeacher.deleteType(id)){
							frame = schTeacher.showFrame();
							initialBox();
							fillData();
							JOptionPane.showMessageDialog(null, "删除成功");
						}else {
							JOptionPane.showMessageDialog(null, "删除失败");
						}
					} catch (RemoteException e) {
						MainFrameUI.showError();
						e.printStackTrace();
					}
					MainFrameUI.hideWating();
					ModuleEditor.this.setVisible(true);

				}
			}.start();
		}
		
	}
	class DeleteLessonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			final int id = ((LessonAbstractVO)lessonBox.getSelectedItem()).getLes_Id_Ab();
			MainFrameUI.loadingPanel.setMessage("正在删除...");
			ModuleEditor.this.setVisible(false);
			MainFrameUI.showWating();
			new Thread(){
				public void run(){
					try {
						if (schTeacher.deleteLesson(id)){
							frame = schTeacher.showFrame();
							initialBox();
							fillData();
							JOptionPane.showMessageDialog(null, "删除成功");
						}else {
							JOptionPane.showMessageDialog(null, "删除失败");
						}
					} catch (RemoteException e) {
						MainFrameUI.showError();
						e.printStackTrace();
					}
					MainFrameUI.hideWating();
					ModuleEditor.this.setVisible(true);

				}
			}.start();
		}
		
	}
	public void fillData() {
		ModuleVO module = (ModuleVO) moduleBox.getSelectedItem();
		moduleCredit1.setText("" + module.getMin_credit());
		moduleCredit2.setText("" + module.getMax_credit());
		TypeVO type = (TypeVO) typeBox.getSelectedItem();
		moduleBox2.setSelectedItem(searchModule(type.getModule_Id()));
		myModuleBox2.setCell(searchModule(type.getModule_Id()));
		typeCredit.setText("" + type.getMin_credit());
		typeCredit2.setText("" + type.getMax_credit());
		compulosoryBox.setSelectedIndex(type.getCompulsory() - 1);
		myCompulosoryBox.setCell((String)compulosoryBox.getSelectedItem());
		typeTerm.setText("" + type.getTerm_start());
		typeTerm2.setText("" + type.getTerm_end());
		LessonAbstractVO lesson = (LessonAbstractVO) lessonBox
				.getSelectedItem();
		lessonIdFiled.setText(lesson.getLes_Id_AbString());
		lessonCredit.setText("" + lesson.getMin_credit());
		lessonCredit2.setText("" + lesson.getMax_credit());
		lessonTerm1.setText("" + lesson.getTerm_start());
		lessonTerm2.setText("" + lesson.getTerm_end());
		lessonTypeBox.setSelectedItem(searchType(lesson.getType_Id()));
		myLessonTypeBox.setCell(searchType(lesson.getType_Id()));
	}

	private TypeVO searchType(int typeId) {
		for (TypeVO type : typeList) {
			if (type.getType_Id() == typeId) {
				return type;
			}
		}
		return null;
	}

	private ModuleVO searchModule(int moduleId) {
		for (ModuleVO module : modulelist) {
			if (module.getModule_Id() == moduleId) {
				return module;
			}
		}
		return null;
	}

	public void initialBox() {
		lessonList = frame.getLessonList();
		modulelist = frame.getModuleList();
		typeList = frame.getTypeList();
		lessons = new LessonAbstractVO[lessonList.size()];
		for (int i = 0; i < lessonList.size(); i++) {
			lessons[i] = lessonList.get(i);
		}
		lessonBox.setModel(new DefaultComboBoxModel<>(lessons));
		modules = new ModuleVO[modulelist.size()];
		for (int i = 0; i < modulelist.size(); i++) {
			modules[i] = modulelist.get(i);
		}
		moduleBox.setModel(new DefaultComboBoxModel<>(modules));
		moduleBox2.setModel(new DefaultComboBoxModel<>(modules));

		types = new TypeVO[typeList.size()];
		for (int i = 0; i < typeList.size(); i++) {
			types[i] = typeList.get(i);
		}
		typeBox.setModel(new DefaultComboBoxModel<>(types));
		lessonTypeBox.setModel(new DefaultComboBoxModel<>(types));
		String[] compulsory = { "必修", "指选", "选修" };
		compulosoryBox.setModel(new DefaultComboBoxModel<>(compulsory));
		BoxListener boxListener = new BoxListener();
		moduleBox.addActionListener(boxListener);
		typeBox.addActionListener(boxListener);
		lessonBox.addActionListener(boxListener);
	}

	Sch_Frame father;
	
	public ModuleEditor(SchTeacherBlService schTeacher, FrameVO frame,
			Sch_Frame sch_Frame) {
		this.frame = frame;
		this.schTeacher = schTeacher;
		this.father = sch_Frame;
		setLayout(null);

		compulosoryBox = new JComboBox();
		myCompulosoryBox = new MyComboBox<>(compulosoryBox, new Rectangle(159, 208, 190, 21), "必修");
		add(myCompulosoryBox);

		lessonTypeBox = new JComboBox();
		myLessonTypeBox = new MyComboBox<>(lessonTypeBox, new Rectangle(460, 366, 184, 21), "请选择课程类别");
		add(myLessonTypeBox);

		lessonBox = new JComboBox();
		myLessonBox = new MyComboBox<>(lessonBox, new Rectangle(159, 286, 190, 21), "请选择课程");
		add(myLessonBox);

		moduleBox2 = new JComboBox();
		myModuleBox2= new MyComboBox<>(moduleBox2, new Rectangle(454, 127, 190, 21), "请选择模块");
		add(myModuleBox2);

		typeBox = new JComboBox();
		myTypeBox = new MyComboBox<>(typeBox, new Rectangle(157, 127, 192, 21), "请选择课程类别");
		add(myTypeBox);

		moduleBox = new JComboBox();
		myModuleBox= new MyComboBox<>(moduleBox, new Rectangle(155, 41, 194, 21), "请选择模块");
		add(myModuleBox);

		JLabel label = new JLabel("模块名称：");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label.setBounds(75, 36, 80, 28);
		add(label);

		MyButton btAddNewModule = new MyButton("新增");
		btAddNewModule.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btAddNewModule.setBounds(485, 41, 63, 23);
		add(btAddNewModule);

		moduleFiled = new JTextField();
		moduleFiled.setBounds(376, 42, 101, 21);
		add(moduleFiled);
		moduleFiled.setColumns(10);

		JLabel label_1 = new JLabel("学分要求：");
		label_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_1.setBounds(75, 81, 80, 28);
		add(label_1);

		moduleCredit1 = new JTextField();
		moduleCredit1.setBounds(159, 86, 42, 21);
		add(moduleCredit1);
		moduleCredit1.setColumns(10);

		moduleCredit2 = new JTextField();
		moduleCredit2.setColumns(10);
		moduleCredit2.setBounds(238, 86, 42, 21);
		add(moduleCredit2);

		JLabel label_2 = new JLabel("到");
		label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		label_2.setBounds(212, 81, 80, 28);
		add(label_2);

		JLabel label_4 = new JLabel("类别名称：");
		label_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_4.setBounds(75, 122, 80, 28);
		add(label_4);

		JLabel label_5 = new JLabel("所属模块：");
		label_5.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_5.setBounds(382, 121, 80, 28);
		add(label_5);

		JLabel label_6 = new JLabel("学分要求：");
		label_6.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_6.setBounds(75, 162, 80, 28);
		add(label_6);

		typeCredit = new JTextField();
		typeCredit.setColumns(10);
		typeCredit.setBounds(160, 167, 42, 21);
		add(typeCredit);

		JLabel labelTo = new JLabel("到");
		labelTo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		labelTo.setBounds(212, 162, 26, 28);
		add(labelTo);

		typeCredit2 = new JTextField();
		typeCredit2.setColumns(10);
		typeCredit2.setBounds(238, 167, 42, 21);
		add(typeCredit2);

		MyButton btSaveModule = new MyButton("保存");
		btSaveModule.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btSaveModule.setBounds(558, 41, 63, 23);
		add(btSaveModule);

		JLabel label_3 = new JLabel("建议学期：");
		label_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_3.setBounds(75, 241, 80, 28);
		add(label_3);

		typeTerm = new JTextField();
		typeTerm.setColumns(10);
		typeTerm.setBounds(160, 246, 42, 21);
		add(typeTerm);

		JLabel label_7 = new JLabel("到");
		label_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		label_7.setBounds(212, 241, 26, 28);
		add(label_7);

		typeTerm2 = new JTextField();
		typeTerm2.setColumns(10);
		typeTerm2.setBounds(238, 246, 42, 21);
		add(typeTerm2);

		MyButton btAddType = new MyButton("新增");
		btAddType.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btAddType.setBounds(485, 246, 63, 23);
		add(btAddType);

		MyButton btTypeSave = new MyButton("保存");
		btTypeSave.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btTypeSave.setBounds(555, 246, 63, 23);
		add(btTypeSave);

		typeNameFiled = new JTextField();
		typeNameFiled.setColumns(10);
		typeNameFiled.setBounds(376, 247, 101, 21);
		add(typeNameFiled);

		JLabel label_8 = new JLabel("课程名称：");
		label_8.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_8.setBounds(75, 281, 80, 28);
		add(label_8);

		JLabel label_9 = new JLabel("所属类别：");
		label_9.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_9.setBounds(382, 359, 80, 28);
		add(label_9);

		JLabel label_10 = new JLabel("课程性质：");
		label_10.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_10.setBounds(75, 202, 80, 28);
		add(label_10);

		JLabel label_11 = new JLabel("学分要求：");
		label_11.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_11.setBounds(75, 359, 80, 28);
		add(label_11);

		lessonCredit = new JTextField();
		lessonCredit.setColumns(10);
		lessonCredit.setBounds(160, 364, 42, 21);
		add(lessonCredit);

		JLabel label_12 = new JLabel("到");
		label_12.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		label_12.setBounds(212, 359, 26, 28);
		add(label_12);

		lessonCredit2 = new JTextField();
		lessonCredit2.setColumns(10);
		lessonCredit2.setBounds(238, 364, 42, 21);
		add(lessonCredit2);

		lessonTerm1 = new JTextField();
		lessonTerm1.setColumns(10);
		lessonTerm1.setBounds(160, 407, 42, 21);
		add(lessonTerm1);

		JLabel label_13 = new JLabel("建议学期：");
		label_13.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_13.setBounds(75, 399, 80, 28);
		add(label_13);

		JLabel label_14 = new JLabel("到");
		label_14.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		label_14.setBounds(212, 402, 26, 28);
		add(label_14);

		lessonTerm2 = new JTextField();
		lessonTerm2.setColumns(10);
		lessonTerm2.setBounds(238, 407, 42, 21);
		add(lessonTerm2);

		JLabel label_15 = new JLabel("课程号：");
		label_15.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		label_15.setBounds(75, 319, 80, 28);
		add(label_15);

		lessonIdFiled = new JTextField();
		lessonIdFiled.setColumns(10);
		lessonIdFiled.setBounds(159, 321, 101, 21);
		add(lessonIdFiled);

		lessonName = new JTextField();
		lessonName.setColumns(10);
		lessonName.setBounds(376, 406, 101, 21);
		add(lessonName);

		MyButton btAddLesson = new MyButton("新增");
		btAddLesson.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btAddLesson.setBounds(485, 405, 63, 23);
		add(btAddLesson);

		MyButton btSaveLesson = new MyButton("保存");
		btSaveLesson.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btSaveLesson.setBounds(555, 405, 63, 23);
		add(btSaveLesson);

		MyButton btDeleteModule = new MyButton("保存");
		btDeleteModule.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btDeleteModule.setText("删除");
		btDeleteModule.setBounds(633, 41, 63, 23);
		add(btDeleteModule);

		MyButton btDeleteType = new MyButton("保存");
		btDeleteType.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btDeleteType.setText("删除");
		btDeleteType.setBounds(630, 246, 63, 23);
		add(btDeleteType);

		MyButton btDeleteLesson = new MyButton("保存");
		btDeleteLesson.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		btDeleteLesson.setText("删除");
		btDeleteLesson.setBounds(630, 405, 63, 23);
		add(btDeleteLesson);
		
		MyButton myButton = new MyButton("新增");
		myButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		myButton.setText("查看框架");
		myButton.setBounds(75, 461, 101, 40);
		add(myButton);
		myButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ModuleEditor.this.setVisible(false);
				father.refresh();
				father.setVisible(true);
				
			}
		});
		try {
			frame = schTeacher.showFrame();
		} catch (RemoteException e) {
			MainFrameUI.showError();
			e.printStackTrace();
		}
		initialBox();
		fillData();
		int count = this.getComponentCount();
		for (int i = 0; i < count; i++) {
			getComponent(i).setFont(
					new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		}
		
		btAddLesson.addActionListener(new AddLessonListener());
		btAddType.addActionListener(new AddTypeListener());
		btAddNewModule.addActionListener(new AddModuleListener());
		btSaveModule.addActionListener(new SaveModuleListener());
		btTypeSave.addActionListener(new SaveTypeListener());
		btSaveLesson.addActionListener(new SaveLesson());
		btDeleteLesson.addActionListener(new DeleteLessonListener());
		btDeleteType.addActionListener(new DeleteTypeListener());
		btDeleteModule.addActionListener(new DeleteModuleListener());
	}
}
