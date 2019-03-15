package pl.ksoai.entity.parser;

import pl.ksoai.entity.enums.SkinType;

public class SkinParser {

	public static SkinType parseStringToSkin(String type) {
		if (type.equalsIgnoreCase("natural")) {
			return SkinType.NATURAL;
		}
		if (type.equalsIgnoreCase("artificial")) {
			return SkinType.ARTIFICIAL;
		}

		return SkinType.ARTIFICIAL;
	}
}
