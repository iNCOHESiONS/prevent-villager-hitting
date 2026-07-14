package io.github.incohesions.prevent_villager_hitting.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Villager.class)
public abstract class VillagerMixin extends Entity {

    public VillagerMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean isAttackable() {
        return false;
    }
}
