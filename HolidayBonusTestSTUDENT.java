import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestSTUDENT {

	private double[][] dataSet2 = {{1,2,9,4},{5},{8,2,3},{10,6,1,2}};
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		double[] result = HolidayBonus.calculateHolidayBonus(dataSet2, 5000,1000,2000);
		try {
			assertEquals(12000.0,result[0],.001);
			assertEquals(2000.0,result[1],.001);
			assertEquals(5000.0,result[2],.001);
		} catch(Exception e) {
			fail("This should not have causes an exception");
		}
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(31000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet2, 5000, 1000, 2000), 0.001);
	}

}
