package ddtflower;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* クラス名:procedureLogout
 * 概要:ログインの手続きを行うクラス。
 * 作成日:2016.10.20
 * 作成者:R.Shibata
 */
public class procedureLogin extends account {

	/* クラス名:init
	 * 概要:クラスの初期化関数。ログイン用のクラスの初期化関数をコールする。
	 * 引数:無し
	 * 戻り値:無し
	 * 作成日:2016.10.20
	 * 作成者:R.Shibata
	 */
	public void init(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException,
			SQLException, NoSuchAlgorithmException, LoginCheckException {
		//accountクラスのinit関数をコールする。
		super.init(request, response);
	}

	/* クラス名:job
	 * 概要:クラス特有の処理を行う関数。ログイン処理を行う。
	 * 引数:String $jsonString:JSON文字列
	 * 戻り値:無し
	 * 作成日:2016.10.20
	 * 作成者:R.Shibata
	 */
	public void job(String jsonString) {
		//ログインを実行する
		this.login(jsonString);
		//DBとの接続を閉じる
		this.disconnect();
	}

	/* クラス名:run
	 * 概要:クラスのinit、job関数をまとめて実行する。
	 * 引数:String $jsonString:JSON文字列
	 * 戻り値:無し
	 * 作成日:2016.10.20
	 * 作成者:R.Shibata
	 */
	public void run(String jsonString, HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, LoginCheckException {
		//初期化処理とクラス独自の処理をまとめて実行する
		this.init(request, response); //初期化関数
		this.job(jsonString); //クラス特有の処理を行う

	}
}
