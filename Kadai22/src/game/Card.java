package game;

public class Card {
	/** 種類番号 ( スぺード、 1= ハート、 2= クラブ、 3= ダイヤ ) **/
	private int suit;
	/** 札番号 (1 13) */
	private int number;

	/**
		* 種類と札番号を指定するコンストラクタ
		* @param suit 種類 番号 (スぺード、 1= ハート、 2= クラブ、 3= ダイヤ)
		* @param number 札番号 (1~13)
		* **/
	public Card(int suit, int number) {
		this.suit = suit;
		this.number = number;
		//		assertTrue(suit >= 0 && suit <= 3);
		//		assertTrue(number >= 1 && number <= 13);
	}

	/**
	* カード番号を指定するコンストラクタ
	* カード番号は 1 から 52  13 × 4 種 =52 の番号
	* @param n カード番号（ 1~52)
	*/

	public Card(int n) {
		this((n - 1) / 13 + 1, (n - 1) % 13 + 1);
	}

	/**
	* トランプの種類番号を返す
	* @return 種類番号 (0~3)
	*/
	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	/**
	* トランプの札番号を返す
	* @return 札番号（ 1~13 )
	*/

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	/**
	* トランプの種類番号に対応する種類名文字列を返す
	* @return 種類番号に対応して次のような文字列を返す
	* 0= スぺード、 1= ハート、 2= クラブ、 3= ダイヤ
	*/
	public String getSuitString() {
		String[] name = { " スペード", " ハート", " クラブ", " ダイヤ" };
		return name[this.suit - 1];
	}

	/**
	* 札番号を 2 桁の文字列に直して返す
	* 札番号が 1 桁の 場合 は 、 " のように前に半角空白をひとつ付ける
	* 札番号が 10 の場合 は、 10" とする
	* 札番号 1, 11, 12, 13 は、 " A", " J", " Q", " K" とする
	*/

	public String numberString() {
		switch (this.number) {
		case 1:
			return " A";
		case 10:
			return "10";
		case 11:
			return " J";
		case 12:
			return " Q";
		case 13:
			return " K";
		default:
			return " " + String.valueOf(this.number);

		}
	}

	/**
	* トランプの種類番号と札番号からカード番号を計算して返す
	* @return カード番号 13 ×種類番号＋札番号
	*/
	public int seqNumber() {
		return (this.suit - 1) * 13 + this.number - 1;
	}

	/**
	* カードのスコアを返す
	* @return カードのスコア
	*/
	public int score() {
		int[] s = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
		return s[this.number - 1];
	}

	/**
	* トランプカードの内容を表す文字列を返す
	* @return 種類名と札番号からなる文字列
	*/
	public String toString() {
		return getSuitString() + numberString();
	}
}
