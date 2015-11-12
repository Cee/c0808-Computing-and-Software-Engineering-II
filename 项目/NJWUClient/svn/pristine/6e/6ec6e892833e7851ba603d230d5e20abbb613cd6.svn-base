import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class TestWrite {
	public static void writeExcel(OutputStream os) throws IOException, RowsExceededException, WriteException{
		WritableWorkbook wwb = Workbook.createWorkbook(os);
		WritableSheet ws = wwb.createSheet("TestSheet", 0);
		Label labelC = new Label(0, 0, "我爱徐慧！");
		ws.addCell(labelC);
		wwb.write();
		wwb.close();
		
	}
	public static void main(String[] args){
		File file = new File("test.xls");
		try {
			file.createNewFile();
			writeExcel(new FileOutputStream(file));
		} catch (IOException | WriteException e) {
			e.printStackTrace();
		}
		
	}
}
