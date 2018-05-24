package base;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

public class Common {

	public static final String IMAGE_PATH = "picture/";

	/**
	 * 文字列型からdate型に変換
	 * @param date
	 * @return
	 */
	public static Date dateConversion(String date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    // Date型変換
	    Date formatDate = null;
	    try {
			formatDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDate;

	}

	public static Date dateTimeConversion(String date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    // Date型変換
	    Date formatDate = null;
	    try {
			formatDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDate;

	}

	/**
	 * ﾊﾟｽﾜｰﾄﾞを暗号化する
	 * @param password
	 * @return
	 */
	public static String encryption(String password) {

		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = null;
		try {                                                                      //↓文字コードも指定できる。
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));   //getBytesメソッドは、対象の文字列をバイト・シーケンスにエンコード化して、結果をByte型の配列として返すメソッド
		} catch (NoSuchAlgorithmException e) {
			// 自動生成された catch ブロック
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		return result;
	}

    /**
     * ファイルの名前を取得する
     * @param part
     * @return
     */
	public static String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }


}

