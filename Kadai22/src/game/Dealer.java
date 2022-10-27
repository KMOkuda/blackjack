package game;

public class Dealer extends Player {

	/**
	* コンストラクタ
	* @param name ディーラーの名前
	* @param icon ディーラーのアイコン
	* @param deck カードデッキ
	* **/

	public Dealer(String name, String icon, CardDeck deck) {
		super(name, icon, deck);
	}

	/*
	* スコアが 16 以下なら （スコアが１６を超えるまで） 手札にカードを追加する
	*/
	public void over16() {
		while (score() <= 16) {
			addACard();
		}
	}

	/**
	* ディーラー情報の文字列を取得する。
	* 手札の 1 枚目は公開するが、 2 枚目以降は公開しない。
	* @return ディーラー情報
	*/

	public String half(){
		StringBuilder sb = new StringBuilder();

		sb.append(icon);
		sb.append(name);
		sb.append("\t[??]\t");
		halfStr(sb);
		sb.append("******");
		return sb.toString();
	}

	/**
	* 1 枚目の手札を文字列で取得する
	* @param sbuf
	*/

	void halfStr(StringBuilder sbuf) {
		Card c = hand.get(0);
		sbuf.append(c);
		sbuf.append("\t");
	}
}