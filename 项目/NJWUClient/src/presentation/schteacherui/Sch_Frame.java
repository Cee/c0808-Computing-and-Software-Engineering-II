package presentation.schteacherui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import presentation.mainui.MainFrameUI;
import presentation.uielements.MyButton;
import vo.FrameVO;
import vo.LessonAbstractVO;
import vo.ModuleVO;
import vo.TypeVO;
import businesslogicservice.schteacherblservice.SchTeacherBlService;
import dataservice.plandataservice.LessonAbDataService;

public class Sch_Frame extends JPanel {
	
	String hideHeadCss = " style=\"width:67px;height:1px\"";
	String thCss = " style=\"background-color:#b6a3d0;width:67px;height:40px;text-align:center\"";
	String tcCss = " style=\"background-color:#dbf0f5;text-align:center\"";
	String twCss = " style=\"background-color:#e9f6f9;text-align:center\"";
	String tLeftCss_1 = " style=\"background-color:#f8d5e1;text-align:center\"";
	String tLeftCss_2 = " style=\"background-color:#fcecf2;text-align:center\"";
	boolean isOdd = true;
	boolean oddLine = true;
	LessonAbDataService lessonAbDataService;
	SchTeacherBlService schTeacher;
	ModuleEditor moduleEditor;
	FrameVO frame;
	String createHeadByWidth(int width){
		return  " style=\"background-color:#b6a3d0;width:"+width+"px;height:40px;text-align:center\"";
		
	}
	JLabel tHead;
	public Sch_Frame(SchTeacherBlService schTeacher, ModuleEditor moduleEditor) {
		this.schTeacher = schTeacher;
		this.moduleEditor = moduleEditor;
		setBounds(201, 128, 820, 495);
		setOpaque(false);
		setLayout(null);
		
		JLabel tableTop = new JLabel();
		tableTop.setVerticalAlignment(SwingConstants.TOP);
		tableTop.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tableTop.setBounds(0, 31, 820, 30);
		tableTop.setOpaque(false);
		
		tHead = new JLabel();
		tHead.setVerticalAlignment(SwingConstants.TOP);
		tHead.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		tHead.setBounds(0, 31, 820, 458);
		tHead.setOpaque(false);
		//add(tHead);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		scrollPane.setBounds(6, 26, 827, 400);
		scrollPane.setViewportView(tHead);
		scrollPane.setPreferredSize(new Dimension(827,458));
		scrollPane.updateUI();
		scrollPane.setVisible(true);
		scrollPane.requestFocus();
		add(scrollPane);
		
		MyButton btEdit = new MyButton("编辑课程类别");
		btEdit.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		btEdit.setText("编辑");
		btEdit.setBounds(340, 463, 84, 23);
		add(btEdit);
		
		final JLabel headLable = new JLabel();
		headLable.setText(createTableHead());
		headLable.setBounds(6, 30, 808, 51);
		add(headLable,0);
		btEdit.addActionListener(new EditListener());
		new Thread(){
			public void run(){
				refresh();
			}
		}.start();
	
	}
	public void refresh(){
		tHead.setVisible(false);
		MainFrameUI.loadingPanel.setMessage("正在获取框架信息...");
		MainFrameUI.showWating();
		tHead.setText(createTableText());
		MainFrameUI.hideWating();
		tHead.setVisible(true);
	}
	class EditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			moduleEditor = new ModuleEditor(schTeacher,frame,Sch_Frame.this);
			moduleEditor.setBounds(201, 128, 851, 539);
			MainFrameUI.userMainUI.add(moduleEditor,0);
			Sch_Frame.this.setVisible(false);
		}
		
	}
	String createTd(int rowSpan,String content){
		if (oddLine){
			   return  "<td "+tcCss+"rowspan=\""+rowSpan+"\" align=\"center\" valign=\"middle\">"+content+"</td>";
		} else {
			   return  "<td "+twCss+"rowspan=\""+rowSpan+"\" align=\"center\" valign=\"middle\">"+content+"</td>";
		}
		
	}
	String createLeftSide(int rowSpan,String content){
		if (isOdd){
			   return  "<td "+tLeftCss_1+"rowspan=\""+rowSpan+"\" align=\"center\" valign=\"middle\">"+content+"</td>";
		} else {
			   return  "<td "+tLeftCss_2+"rowspan=\""+rowSpan+"\" align=\"center\" valign=\"middle\">"+content+"</td>";
		}
		
	}
	
	String createTableHead(){
		String headString = new String();
		//table head 这里的宽度没调！！！
		headString += "<HTML>" + "<tr>" + "<th"
				+ createHeadByWidth(74) +">课程模块<br>(学分)</th>" + "<th" + createHeadByWidth(67)
				+ ">课程<br>性质</th>" + "<th" + thCss + ">序列</th>" + "<th" + createHeadByWidth(78)
				+ ">课程类别<br>(学分)</th>" + "<th" + createHeadByWidth(192) + ">课程名称(部分)</th>"
				+ "<th" + thCss + ">建议学分</th>" + "<th" + thCss + ">开设学期</th>"
				+ "</tr>";
		return headString;
	}
	
	String createTableText() {
		String s = new String();
		// table content
		s += "<HTML>" + "<table contenteditable=\"true\">" + "<tr>" + "<th"
				+ thCss + ">课程模块<br>(学分)</th>" + "<th" + thCss
				+ ">课程<br>性质</th>" + "<th" + thCss + ">序列</th>" + "<th" + thCss
				+ ">课程类别<br>(学分)</th>" + "<th" + thCss + ">课程名称(部分)</th>"
				+ "<th" + thCss + ">建议学分</th>" + "<th" + thCss + ">开设学期</th>"
				+ "</tr>";
		try {
			frame = schTeacher.showFrame();
			ArrayList<ModuleVO> moduleList = frame.getModuleList();
			ArrayList<TypeVO> typeList = frame.getTypeList();
			ArrayList<LessonAbstractVO> lessonList = frame.getLessonList();
			int[] moduleRowSpan = new int[moduleList.size()];
			int[] typeRowSpan = new int[typeList.size()];
			for (int k = 0; k < lessonList.size(); k++){
				LessonAbstractVO lesson = lessonList.get(k);
				if (lesson.getType_Id()!=1){
					for (int i = 0; i <typeList.size();i++){
						if (typeList.get(i).getType_Id()==lesson.getType_Id()){
							typeRowSpan[i]++;
							break;
						}
					}		
				}
			}
			for (int i = 0 ; i < typeRowSpan.length; i ++){
 				if (typeRowSpan[i]==0){
					typeRowSpan[i] = 1;
				}
			}
			for (int i = 0 ; i < typeRowSpan.length; i++){
				for (int j = 0 ; j < moduleList.size(); j++){
					if (typeList.get(i).getModule_Id()==moduleList.get(j).getModule_Id()){
						moduleRowSpan[j] = moduleRowSpan[j] + typeRowSpan[i];
						break;
					}
				}
			}
			for (ModuleVO vo : moduleList) {
				boolean hasType=false;
				int moduleIndex = moduleList.indexOf(vo);
				s+="<tr>";
				s+=createLeftSide(moduleRowSpan[moduleIndex], ((char)(vo.getModule_Id()-1+'A'))+"  "+vo.getName()+"<br>"+vo.getCredit());
				isOdd = isOdd ? false : true;
				for (TypeVO typeVO : typeList) {
			
					if (typeVO.getModule_Id() == vo.getModule_Id()) {
						if (!hasType){
							hasType=true;
						} else {
							s+="<tr>";
						}
						int typeIndex = typeList.indexOf(typeVO);
						s+=createTd(typeRowSpan[typeIndex],typeVO.getCompulsoryString());
						s+=createTd(typeRowSpan[typeIndex], typeVO.getType_Id()+"");
						s+=createTd(typeRowSpan[typeIndex], typeVO.getName());
						boolean hasLesson = false;
						for (LessonAbstractVO lesson : lessonList) {
							if (lesson.getType_Id() != 1 && lesson.getType_Id() == typeVO.getType_Id()) {
								if (!hasLesson){
									hasLesson=true;
								}else {
									s+="<tr>";
								}
								s+=createTd(1, lesson.getName());
								s+=createTd(1, lesson.getCredit());
								s+=createTd(1, lesson.getTerm_start()+"~"+lesson.getTerm_end());
								s+="</tr>";
							}
						}
						if (!hasLesson){
							s+=createTd(1, "&nbsp");
							if (typeVO.getCredit().equals("0")){
								s+=createTd(1, "&nbsp");	
							} else {
								s+=createTd(1, typeVO.getCredit());	
							}
							
							s+=createTd(1, typeVO.getTerm_start()+"~"+typeVO.getTerm_end());
							s+="</tr>";
							
						}
						
					}
					oddLine = oddLine ? false : true;
				}
				oddLine = oddLine ? false : true;

			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// table ends
		s += "</table>" + "</HTML>";

		System.out.println(s);
		return s;

	}
}
