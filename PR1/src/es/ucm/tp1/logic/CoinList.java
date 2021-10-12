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

    public int isIn(int x, int y) {
        for (int i = 0; i < nCoins; i++) {
            if (coins[i].getX() == x && coins[i].getY() == y) {
                return i;
            }
        }
        return -1;
    }

    public Coin getCoinInPosition(int x, int y) {
        // for (int i = 0; i < nCoins; i++) {
        // if (coins[i].isInPosition(x, y)) {
        // return coins[i];
        // }
        // }
        // return null;
        // }
        int pos = isIn(x, y);
        if (pos != -1) {
            return coins[pos];
        }
        return null;
    }

    public void removeDeadCoins() {
        Coin aux;
        int pos;
        aux = getCoinInPosition(game.getPlayerX(), game.getPlayerY());
        pos = isIn(game.getPlayerX(), game.getPlayerY());
        if (aux != null) {
            for (int i = pos; i < nCoins - 1; i++) {
                coins[i] = coins[i + 1];
            }
            deadCoins[nDeadCoins] = aux;
            nDeadCoins++;
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
}
