package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

public class CoinList {
    private Coin[] coins;
    private int nCoins;
    private Game game;
    private Level level;
    private Random rand;

    public CoinList(Random rand, Game game, Level level) {
        this.game = game;
        this.level = level;
        coins = new Coin[game.getRoadLenght()];
        nCoins = 0;
    }

    public int getSize() {
        return coins.length;
    }

    public int getCounter() {
        return nCoins;
    }

    public void addCoin(Coin coin) {
        coins[nCoins] = coin;
        nCoins++;
    }

    public Coin getCoinInPosition(int x, int y) {
        for (int i = 0; i < nCoins; i++) {
            if (coins[i].isInPosition(x, y)) {
                return coins[i];
            }
        }
        return null;
    }

    public boolean isInPosition(int x, int y) {
        return this.getCoinInPosition(x, y) != null;
    }

    public String toString(int i) {
        return coins[i].toString();
    }
}
