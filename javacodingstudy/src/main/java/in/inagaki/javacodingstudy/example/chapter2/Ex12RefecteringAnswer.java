package in.inagaki.javacodingstudy.example.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * ファイルの管理に関する処理をおこなうクラスです。
 * 
 * @author inatus
 * @version 1.0
 * 
 */
public class Ex12RefecteringAnswer {

    private static final int FIRST_TOKEN = 0;
    private static final String PATH_SEPARATER = "\\";
    
    /**
     * ファイル名を保持するリスト
     */
    private List<String> fileNameList = new ArrayList<String>();

    /**
     * 指定されたパスのファイル名をファイルリストに追加します。
     * 
     * @param path
     *            ファイルリストに追加するファイルのパス
     * @return 正常に追加がおこなわれればtrue、そうでなければfalse
     */
    public boolean addFileName(String path) {
	return fileNameList.add(getFileName(path));
    }

    /**
     * 指定されたパスのファイル名がファイルリストに既に追加されているかを検査します。
     * 
     * @param path
     *            検査をおこなうファイルのパス
     * @return 既にファイルリストに存在すればtrue、そうでなければfalse
     */
    public boolean isFileNamePresent(String path) {
	return fileNameList.contains(getFileName(path));
    }

    /**
     * 指定されたパスのルートディレクトリ名を返します。
     * 
     * @param path
     *            ルートディレクトリ名を抽出するパス
     * @return ルートディレクトリ名
     */
    public String getRootDirectoryName(String path) {
	return path.split(PATH_SEPARATER)[FIRST_TOKEN];
    }

    /**
     * パスからファイル名を取得します。
     * 
     * @param path
     *            ファイル名を取得するパス
     * @return ファイル名
     */
    private String getFileName(String path) {
	String[] splittedPath = path.split(PATH_SEPARATER);
	int lastIndex = splittedPath.length - 1;
	String fileName = splittedPath[lastIndex];
	return fileName;
    }
}
