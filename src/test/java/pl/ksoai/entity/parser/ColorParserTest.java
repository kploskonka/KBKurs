package pl.ksoai.entity.parser;

import org.junit.Assert;
import org.junit.Test;
import pl.ksoai.entity.enums.Color;

public class ColorParserTest {

	@Test
	public void testParseStringToColorBlack() {
		String colorString = "blAcK";

		Color color = ColorParser.parseStringToColor(colorString);

		Assert.assertEquals(Color.BLACK, color);
	}

	@Test
	public void testParseStringToColorWhite() {
		String colorString = "white";

		Color color = ColorParser.parseStringToColor(colorString);

		Assert.assertEquals(Color.WHITE, color);
	}

	@Test
	public void testParseStringToColorRed() {
		String colorString = "REd";

		Color color = ColorParser.parseStringToColor(colorString);

		Assert.assertEquals(Color.RED, color);
	}

	@Test
	public void testParseStringToColorGreen() {
		String colorString = "Green";

		Color color = ColorParser.parseStringToColor(colorString);

		Assert.assertEquals(Color.GREEN, color);
	}

	@Test
	public void testParseStringToColorYellow() {
		String colorString = "YELLOW";

		Color color = ColorParser.parseStringToColor(colorString);

		Assert.assertEquals(Color.YELLOW, color);
	}
	@Test
	public void testParseStringToColorOther() {
		String colorString = "Whatever";

		Color color = ColorParser.parseStringToColor(colorString);

		Assert.assertEquals(Color.WHITE, color);
	}
}
