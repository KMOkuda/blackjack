package game;

import java.util.ArrayList;

public class Player {
	/** カードデッキ（山札） **/
	protected CardDeck deck;
	/** プレイヤーの手札  **/
	protected ArrayList<Card> hand;
	/** プレイヤーの名前  **/
	protected String name;
	/** プレイヤーのアイコン  **/
	protected String icon;

	/*
	* コンストラクタ
	* @param name プレイヤーの名前
	* @param icon プレイヤーのアイコン
	* @param deck カードデッキ
	*/

	public Player(String name, String icon, CardDeck deck) {
		this.name = name;
		this.icon = icon;
		this.deck = deck;
	}

	/** 手札を初期化する **/
	public void initialize() {
		hand = new ArrayList<Card>();
		for (int i = 0; i < 2; i++) {
			hand.add(deck.next());
		}
	}

	public void addACard() {
		hand.add(deck.next());
	}

	public int score() {
		int sum = 0;
		for (Card card : hand) {
			sum += card.score();
		}

		return sum;
	}

	/*
	* プレイヤー情報の文字列を取得する
	* @return プレイヤー情報
	*/
	public String toString() {
		StringBuilder sbuf = new StringBuilder();

		sbuf.append(icon);
		sbuf.append(name);
		sbuf.append("\t");
		sbuf.append("[");

		int num = score();

		String str = num < 10 ? " " + num : "" + num;
		sbuf.append(str);
		sbuf.append("]");

		cardStr(sbuf);

		return sbuf.toString();
	}

	/*
	* 手札の一覧を文字列で取得する
	* @param sbuf
	*/

	void cardStr(StringBuilder sbuf) {

		for (Card hd : hand) {

			sbuf.append("\t");
			sbuf.append(hd);
		}
	}
}
