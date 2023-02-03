package com.teamabnormals.environmental.core.data.server.tags;

import com.teamabnormals.environmental.core.Environmental;
import com.teamabnormals.environmental.core.other.tags.EnvironmentalBiomeTags;
import com.teamabnormals.environmental.core.registry.EnvironmentalBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EnvironmentalBiomeTagsProvider extends BiomeTagsProvider {

	public EnvironmentalBiomeTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Environmental.MOD_ID, existingFileHelper);
	}

	@Override
	public void addTags() {
		this.tag(BiomeTags.IS_FOREST).add(EnvironmentalBiomes.BLOSSOM_WOODS.get(), EnvironmentalBiomes.BLOSSOM_VALLEYS.get());
		this.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(EnvironmentalBiomes.MARSH.get());
		this.tag(BiomeTags.HAS_SWAMP_HUT).add(EnvironmentalBiomes.MARSH.get());
		this.tag(BiomeTags.HAS_STRONGHOLD).add(EnvironmentalBiomes.MARSH.get(), EnvironmentalBiomes.BLOSSOM_WOODS.get(), EnvironmentalBiomes.BLOSSOM_VALLEYS.get());

		this.tag(EnvironmentalBiomeTags.HAS_HUSK).add(Biomes.DESERT);
		this.tag(EnvironmentalBiomeTags.HAS_STRAY).add(Biomes.SNOWY_PLAINS, Biomes.ICE_SPIKES);
	}
}