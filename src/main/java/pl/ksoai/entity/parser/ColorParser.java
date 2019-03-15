package pl.ksoai.entity.parser;

import pl.ksoai.entity.enums.Color;

public class ColorParser {

	public static Color parseStringToColor(String color) {
		if (color.equalsIgnoreCase("black")) {
			return Color.BLACK;
		}
		if (color.equalsIgnoreCase("white")) {
			return Color.WHITE;
		}
		if (color.equalsIgnoreCase("red")) {
			return Color.RED;
		}
		if (color.equalsIgnoreCase("green")) {
			return Color.GREEN;
		}
		if (color.equalsIgnoreCase("blue")) {
			return Color.BLUE;
		}
		if (color.equalsIgnoreCase("yellow")) {
			return Color.YELLOW;
		}
		return Color.WHITE;
	}
}
