package file;

import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

//サポートされているエンコーディング
//https://docs.oracle.com/javase/jp/8/technotes/guides/intl/encoding.doc.html
public class FileReader {

	public static List<String> EUC(final String filePath){
		return reader(filePath, "EUC_JP");
	}

	public static List<String> SJIS(final String filePath){
		return reader(filePath, "windows-31j");
	}

	private static List<String> reader(final String filePath, final String charset){
		FileSystem fs = FileSystems.getDefault();
		try {
			List<String> list = Files.readAllLines(fs.getPath(filePath), Charset.forName(charset));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
