package pl.ksoai.entity.parser;

import org.junit.Assert;
import org.junit.Test;
import pl.ksoai.entity.enums.SkinType;

public class SkinParserTest {

	@Test
	public void testParseStringToSkinNatural() {
		String skinString = "natural";

		SkinType skinType = SkinParser.parseStringToSkin(skinString);

		Assert.assertEquals(SkinType.NATURAL, skinType);
	}

	@Test
	public void testParseStringToSkinArtificial() {
		String skinString = "Artificial";

		SkinType skinType = SkinParser.parseStringToSkin(skinString);

		Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
	}

	@Test
	public void testParseStringToSkinOther() {
		String skinString = "OtherSkinType";

		SkinType skinType = SkinParser.parseStringToSkin(skinString);

		Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
	}
}
