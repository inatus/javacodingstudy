package in.inagaki.javacodingstudy.exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Exercise {

    public boolean createFile(String fileName, String text) throws Exception {
	File file = new File("output/exercise/" + fileName);
	boolean isFileCreated = file.createNewFile();
	if (isFileCreated) {
	    Writer writer = new FileWriter(file);
	    writer.write(text);
	    writer.flush();
	    return true;
	} else {

	    // ファイル名から拡張子を切り分ける
	    int point = fileName.lastIndexOf(".");
	    String fileNameWithoutExtension = null;
	    String extensionWithDot = null;
	    if (point == -1) { // 拡張子がない場合
		fileNameWithoutExtension = fileName;
		extensionWithDot = "";
	    } else { // 拡張子がある場合
		fileNameWithoutExtension = fileName.substring(0, point);
		extensionWithDot = fileName.substring(point);
	    }

	    // 連番を付加してファイルを作成
	    for (int i = 1; i < Integer.MAX_VALUE; i++) {
		String newFileName = "output/exercise/"
			+ fileNameWithoutExtension + "_" + i + extensionWithDot;
		File newFile = new File(newFileName);
		boolean isNewFileCreated = newFile.createNewFile();
		if (isNewFileCreated) {
		    Writer writer = new FileWriter(newFile);
		    writer.write(text);
		    writer.flush();
		    return true;
		}
	    }
	}
	return false;
    }

    /**
     * プログラム実行用ドライバ 修正不要
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {
	File directory = new File("output/exercise");
	directory.mkdirs();
	Exercise obj = new Exercise();
	obj.createFile("sample.txt", "Sample Text");
    }

}
