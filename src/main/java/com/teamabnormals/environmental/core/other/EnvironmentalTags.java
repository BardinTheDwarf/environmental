package com.teamabnormals.environmental.core.other;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamabnormals.environmental.common.slabfish.SlabfishType;
import com.teamabnormals.environmental.core.Environmental;
import com.teamabnormals.environmental.core.registry.EnvironmentalSlabfishTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

//TODO: Seperate Tag classes & generate
public class EnvironmentalTags {
	public static class Blocks {
		public static final TagKey<Block> GRASS_LIKE = blockTag("grass_like");
	}

	public static class Items {
		public static final TagKey<Item> DUCK_FOOD = itemTag("duck_food");
		public static final TagKey<Item> DEER_FOOD = itemTag("deer_food");
		public static final TagKey<Item> DEER_TEMPT_ITEMS = itemTag("deer_tempt_items");

		public static final TagKey<Item> SLABFISH_SNACKS = itemTag("slabfish_snacks");
		public static final TagKey<Item> SLABFISH_FOOD = itemTag("slabfish_food");
		public static final TagKey<Item> SLABFISH_TAME_ITEMS = itemTag("slabfish_tame_items");
	}

	public static class EntityTypes {
		public static final TagKey<EntityType<?>> UNAFFECTED_BY_SERENITY = entityTypeTag("unaffected_by_serenity");
		public static final TagKey<EntityType<?>> SCARES_DEER = entityTypeTag("scares_deer");
		public static final TagKey<EntityType<?>> ALWAYS_SCARES_DEER = entityTypeTag("always_scares_deer");
	}

	public static class SlabfishTypes {
		public static final TagKey<SlabfishType> TRADEABLE = slabfishTag("tradeable");
		public static final TagKey<SlabfishType> TRANSLUCENT = slabfishTag("translucent");

		public static final TagKey<SlabfishType> COMMON = slabfishTag("rarity/common");
		public static final TagKey<SlabfishType> UNCOMMON = slabfishTag("rarity/uncommon");
		public static final TagKey<SlabfishType> RARE = slabfishTag("rarity/rare");
		public static final TagKey<SlabfishType> EPIC = slabfishTag("rarity/epic");
		public static final TagKey<SlabfishType> LEGENDARY = slabfishTag("rarity/legendary");
	}

	private static TagKey<Block> blockTag(String tagName) {
		return TagUtil.blockTag(Environmental.MOD_ID, tagName);
	}

	private static TagKey<Item> itemTag(String tagName) {
		return TagUtil.itemTag(Environmental.MOD_ID, tagName);
	}

	private static TagKey<EntityType<?>> entityTypeTag(String tagName) {
		return TagUtil.entityTypeTag(Environmental.MOD_ID, tagName);
	}

	public static TagKey<SlabfishType> slabfishTag(String name) {
		return TagKey.create(EnvironmentalSlabfishTypes.SLABFISH_TYPES_REGISTRY, new ResourceLocation(Environmental.MOD_ID, name));
	}
}