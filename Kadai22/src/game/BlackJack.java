package game;

import java.util.Scanner;

public class BlackJack {
	/** カードデッキ  **/
	private CardDeck deck;
	/** ディーラー  **/
	private Dealer dealer;
	/** プレイヤー  **/
	private Player player;
	static final String DEALER_ICON = "□";
	static final String PLAYER_ICON = "■";
	static final String BANNER = "\n■□■□■□■□■□ BlackJack ■□■□■□■□■□";
	static final int CARDS = 52;
	static final String Q_CONTINUE = "続けますか（ｙ/n）";
	static final int LIMIT = 17;
	static final String Q_DEAL = "さらにカードを引きますか(y/n)";
	static final String EVEN = "引き分け";
	static final String WIN = "あなたの勝ち";
	static final String LOSE = "ディーラーの勝ち";
	static final String ANIMATION_ICON = "□■";
	static final int TIMES = 20;
	static final int DELAY = 20;

	public BlackJack(String dname, String pname) {
		deck = new CardDeck(CARDS);
		dealer = new Dealer(dname, DEALER_ICON, deck);
		player = new Player(pname, PLAYER_ICON, deck);
	}

	/**
	* 初期化する
	*/
	public void initialize() {
		if (deck.size() < LIMIT) {
			deck.initialize();
		}
		dealer.initialize();
		player.initialize();

	}

	/** ゲームをプレイする **/
	public void play() {
		do {
			System.out.println(BANNER);
			initialize();
			dealer.over16();
			showHalf();
			deal();
			animation(TIMES, DELAY, ANIMATION_ICON);
			show();
			judge();
		} while (getString(Q_CONTINUE).equals("y"));
	}

	/**
	* ディーラーとプレイヤーの情報を表示する
	*/
	public void show() {
		System.out.println();
		System.out.println(dealer);
		System.out.println(player);
	}

	/**
	* ディーラーとプレイヤーの情報を表示する
	* ディーラーの情報は一部非公開とする。
	*/

	public void showHalf() {
		System.out.println();
		System.out.println(dealer.half());
		System.out.println(player);
	}

	/**
	* カードを配る
	*/

	public void deal() {
		while (player.score() < 21) {
			if (getString(Q_DEAL).equals("n")) {
				break;
			}
			player.addACard();
			showHalf();
		}
	}

	public void judge() {
		int d = dealer.score();
		int p = player.score();
		if (d == p || d > 21 && p > 21) {
			System.out.println(EVEN);
		} else if (d > 21 || (p <= 21 && 21 - d > 21 - p)) {
			System.out.println(WIN);
		} else {
			System.out.println(LOSE);
		}
	}

	/*
		* アイコンの表示をアニメーション表示する
		* @param times 回数
		* @param delay 遅延時間（ミリ秒）
		* @param icon アイコン
		*/
	public void animation(int times, int delay, String icon) {
		System.out.println();
		try {
			for (int i = 0; i < times; i++) {
				System.out.print(icon);
				Thread.sleep(delay);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	* 標準入力から文字列を取得する
	* @param message 表示メッセージ
	* @return 取得した文字列
	*/

	public String getString(String message) {
		System.out.print("[" + message + "]> ");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
}
