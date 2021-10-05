package es.ucm.tp1.control;

public enum Level {
	//El 7 se cambia luego a 10
	TEST(10, 3, 8, 0.5, 0), EASY(30, 3, 8, 0.5, 0.5), HARD(100, 5, 6, 0.7, 0.3);

	private int length;

	private int width;

	private int visibility;

	private double coinFrequency;

	private double obstacleFrequency;

	private Level(int length, int width, int visibility, double obstacleFrequency, double coinFrequency) {
		this.length = length;
		this.width = width;
		this.visibility = visibility;
		this.obstacleFrequency = obstacleFrequency;
		this.coinFrequency = coinFrequency;
	}

	// TODO fill your code
	public double getCoinFrequency() {
		return coinFrequency;
	}

	public double getObstacleFrequency() {
		return obstacleFrequency;
	}

	public int getVisibility() {
		return visibility;
	}

	public int getRoadWidth() {
		return width;
	}

	public int getRoadLenght() {
		return length;
	}

	public static Level valueOfIgnoreCase(String inputString) {
		for (Level level : Level.values()) {
			if (level.name().equalsIgnoreCase(inputString)) {
				return level;
			}
		}
		return null;
	}

	public static String all(String separator) {
		StringBuilder buffer = new StringBuilder();
		int levelCount = 0;
		for (Level level : Level.values()) {
			if (levelCount > 0) {
				buffer.append(separator);
			}
			buffer.append(level.name());
			levelCount++;
		}
		return buffer.toString();
	}
}
