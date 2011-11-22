public class ChangingMoney {
	private int[][] c;
	private int[] money;

	public ChangingMoney(int... money) {
		this.money = money;
	}

	public int calculateNumberPossibilities(int amount) {
		c = new int[amount + 1][money.length];
		for (int i = 0; i < money.length; i++) {
			for (int j = 1; j <= amount; j++) {
				c[j][i] = getPossibilities(j - money[i], i) + getPossibilities(j, i - 1);
			}
		}
		return c[amount][money.length - 1];
	}

	private int getPossibilities(int amount, int i) {
		if (amount < 0)
			return 0;
		if (amount == 0)
			return 1;
		if (i == -1)
			return 0;
		return c[amount][i];
	}

	public static void main(String[] args) {
		ChangingMoney euro = new ChangingMoney(1, 2, 5, 10, 20, 50, 100);
		ChangingMoney dollar = new ChangingMoney(1, 5, 10, 25);
		System.out.println("There are "+ euro.calculateNumberPossibilities(100) + " possibilities to change one euro.");
		System.out.println("There are "+ dollar.calculateNumberPossibilities(100) + " possibilities to change one dollar.");
	}
}
