package com.minecraftabnormals.environmental.core.mixin;

import com.minecraftabnormals.environmental.core.registry.EnvironmentalItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

	@Shadow
	@Final
	protected float[] armorDropChances;

	protected MobEntityMixin(EntityType<? extends LivingEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Inject(method = "populateDefaultEquipmentSlots", at = @At("TAIL"))
	private void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty, CallbackInfo info) {
		int difficultyChance = difficulty.getDifficulty().getId() + 1;
		if (this.getCommandSenderWorld() instanceof ServerWorld) {
			ServerWorld world = (ServerWorld) this.getCommandSenderWorld();
			boolean isStronghold = world.structureFeatureManager().getStructureAt(this.blockPosition(), true, Structure.STRONGHOLD).isValid();
			boolean isMineshaft = world.structureFeatureManager().getStructureAt(this.blockPosition(), true, Structure.MINESHAFT).isValid();
			if ((isStronghold || isMineshaft) && Math.random() < difficultyChance * 0.01F) {
				this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(EnvironmentalItems.HEALER_POUCH.get()));
				this.armorDropChances[EquipmentSlotType.CHEST.getIndex()] = 1.0F;
			}
		}
	}
}
