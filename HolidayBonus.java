/**
 * Holiday Bonus class to calculate holiday bonuses for stores
 * @author runya
 *
 */
public class HolidayBonus {
	
	/**
	 * HolidayBonus constructor
	 */
	public HolidayBonus() {
		
	}
	
	/**
	 * Creates an array looking the the ragged arrays data for each stores top and lowest selling stores
	 * @param data Ragged array containing dales data
	 * @param high Highest bonus value
	 * @param low Lowest bonus value
	 * @param other Regular bonus value
	 * @return An array of all the bonuses
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonuses = new double[data.length];
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > 0) {
					if (data[i][j] == data[TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j)][j]) {
						bonuses[i] += high;
					} else if (data[i][j] == data[TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j)][j]) {
						bonuses[i] += low;
					} else {
						bonuses[i] += other;
					}
				}
			}
		}
		
		return bonuses;
	}
	
	/**
	 * Sums the total for all the bonuses from the ragged array
	 * @param data Ragged array containing dales data
	 * @param high Highest bonus value
	 * @param low Lowest bonus value
	 * @param other Regular bonus value
	 * @return Total of all the bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double total = 0;
		double[] totalArr = HolidayBonus.calculateHolidayBonus(data, high, low, other);
		
		for (int i = 0; i < totalArr.length; i++) {
			total += totalArr[i];
		}
		
		return total;
	}
}
