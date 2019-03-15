package pl.ksoai.entity.parser;

import org.junit.Assert;
import org.junit.Test;
import pl.ksoai.entity.enums.Material;

public class MaterialParserTest {

	@Test
	public void testParseStringToMaterialLeather() {
		String materialString = "leather";

		Material material = MaterialParser.parseStringToMaterial(materialString);

		Assert.assertEquals(Material.LEATHER, material);
	}

	@Test
	public void testParseStringToMaterialFur() {
		String materialString = "fUr";

		Material material = MaterialParser.parseStringToMaterial(materialString);

		Assert.assertEquals(Material.FUR, material);
	}

	@Test
	public void testParseStringToMaterialCotton() {
		String materialString = "cOtton";

		Material material = MaterialParser.parseStringToMaterial(materialString);

		Assert.assertEquals(Material.COTTON, material);
	}

	@Test
	public void testParseStringToMaterialLeatherWool() {
		String materialString = "wool";

		Material material = MaterialParser.parseStringToMaterial(materialString);

		Assert.assertEquals(Material.WOOL, material);
	}

	@Test
	public void testParseStringToMaterialLeatherPolyesters() {
		String materialString = "polyesters";

		Material material = MaterialParser.parseStringToMaterial(materialString);

		Assert.assertEquals(Material.POLYESTERS, material);
	}

	@Test
	public void testParseStringToMaterialLeatherOther() {
		String materialString = "Other";

		Material material = MaterialParser.parseStringToMaterial(materialString);

		Assert.assertEquals(Material.POLYESTERS, material);
	}
}
