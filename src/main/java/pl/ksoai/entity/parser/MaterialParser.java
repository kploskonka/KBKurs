package pl.ksoai.entity.parser;

import pl.ksoai.entity.enums.Material;

public class MaterialParser {

	public static Material parseStringToMaterial(String material) {
		if (material.equalsIgnoreCase("leather")) {
			return Material.LEATHER;
		}
		if (material.equalsIgnoreCase("fur")) {
			return Material.FUR;
		}
		if (material.equalsIgnoreCase("cotton")) {
			return Material.COTTON;
		}
		if (material.equalsIgnoreCase("wool")) {
			return Material.WOOL;
		}
		if (material.equalsIgnoreCase("polyesters")) {
			return Material.POLYESTERS;
		}
		return Material.POLYESTERS;
	}
}
