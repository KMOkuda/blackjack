package game;


import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	/** セットするカード枚数 **/
	private int max;
	/** カードデッキ（山札） **/
	private ArrayList<Card> deck;
	/**
	* セットするカード枚数を指定して生成する
	* @param max セットするカード枚数
	*/
	public CardDeck(int max){
		this.max = max;
		initialize();
	}

	/**
	* カードデッキを初期化する
	* カードデッキに カード を max 枚セットし、シャッフルする
	* （ヒント）シャッフルには、 Collections クラスの shuffle メソッドを使用する
	*/
	public void initialize(){

		deck = new ArrayList<Card>();
		for(int i = 1; i <= max; i++) {
			deck.add(new Card(i));
		}
		Collections.shuffle(this.deck);
	}
	/**
	* 残りのカード枚数を返す
	* @return 残りのカード枚数
	*/
	public int size() {
		return deck.size();
	}

	public Card next() {
		if(size() == 0) {
			return null;
		}else {
			Card nextCard = this.deck.get(0);
			this.deck.remove(0);
			return nextCard;
		}
	}
}
