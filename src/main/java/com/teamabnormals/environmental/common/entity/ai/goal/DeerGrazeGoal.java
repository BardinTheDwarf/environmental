package com.teamabnormals.environmental.common.entity.ai.goal;

import com.teamabnormals.environmental.common.entity.animal.deer.AbstractDeer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.EnumSet;

public class DeerGrazeGoal extends Goal {
	private final AbstractDeer deer;
	private final Level level;
	private int grazeTime;

	public DeerGrazeGoal(AbstractDeer deerIn) {
		this.deer = deerIn;
		this.level = deerIn.getLevel();
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
	}

	@Override
	public boolean canUse() {
		BlockPos blockpos = this.deer.blockPosition().below();
		return this.deer.getRandom().nextInt(350) == 0 && this.level.getBlockState(blockpos).is(Blocks.GRASS_BLOCK);
	}

	@Override
	public void start() {
		this.grazeTime = this.adjustedTickDelay(40 + this.deer.getRandom().nextInt(100));
		this.deer.setTargetNeckAngle(130);
		this.deer.getNavigation().stop();
	}

	@Override
	public void stop() {
		this.deer.resetTargetNeckAngle();
	}

	@Override
	public boolean canContinueToUse() {
		BlockPos blockpos = this.deer.blockPosition().below();
		return this.grazeTime > 0 && this.level.getBlockState(blockpos).is(Blocks.GRASS_BLOCK);
	}

	@Override
	public void tick() {
		--this.grazeTime;
	}
}