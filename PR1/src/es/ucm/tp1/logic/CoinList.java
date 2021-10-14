package es.ucm.tp1.logic;

public class CoinList {
    private Coin[] coins;
    private Coin[] deadCoins;
    private int nCoins;
    private Game game;
    private int nDeadCoins;

    public CoinList(Game game) {
        this.game = game;
        coins = new Coin[game.getRoadLenght()];
        nCoins = 0;
        deadCoins = new Coin[game.getRoadLenght()];
        nDeadCoins = 0;
    }

    public Coin getCoinInPosition(int x, int y) {
        for (int i = 0; i < nCoins; i++) {
            if (coins[i].isInPosition(x, y)) {
                return coins[i];
            }
        }
        return null;
    }

    public void removeDeadCoins() {
        if (this.isInPosition(game.getPlayerX(), game.getPlayerY())) {
            boolean move = false;
            for (int i = 0; i < nCoins; i++) {
                if (coins[i].isInPosition(game.getPlayerX(), game.getPlayerY())) {
                    coins[i] = null;
                    move = true;
                } else if (move) {
                    coins[i - 1] = coins[i];
                }
            }
            nCoins--;
        }
    }

    public boolean isInPosition(int x, int y) {
        return this.getCoinInPosition(x, y) != null;
    }

    public int getCoinsCounter() {
        return nCoins;
    }

    public int getDeadCoinsCounter() {
        return nDeadCoins;
    }

    public void addCoin(Coin coin) {
        coins[nCoins] = coin;
        nCoins++;
    }

    public void resetList() {
        Coin[] newCoins;
        int newSize = getDeadCoinsCounter() + getCoinsCounter();
        newCoins = new Coin[game.getRoadLenght()];
        int pos = 0;
        for (int i = 0; i < getCoinsCounter(); i++) {
            newCoins[pos] = coins[i];
            coins[pos] = null;
            pos++;
        }
        for (int i = 0; i < getDeadCoinsCounter(); i++) {
            newCoins[pos] = deadCoins[i];
            deadCoins[i] = null;
            coins[pos] = null;
            pos++;
        }
        for (int i = 0; i < pos; i++) {
            this.coins[i] = newCoins[i];
        }
    }
}
