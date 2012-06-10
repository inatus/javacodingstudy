package in.inagaki.javacodingstudy.example.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Ex12Refectering {
    List<String> fileNameList = new ArrayList<String>();

    public boolean addFileName(String path) {
	String[] tmp = path.split("\\");
	String fileName = tmp[tmp.length - 1];
	return fileNameList.add(fileName);
    }

    public boolean isFileNamePresent(String path) {
	String[] tmp = path.split("\\");
	String fileName = tmp[tmp.length - 1];
	return fileNameList.contains(fileName);
    }

    public String getRootDirectoryName(String path) {
	return path.split("\\")[0];
    }

}
