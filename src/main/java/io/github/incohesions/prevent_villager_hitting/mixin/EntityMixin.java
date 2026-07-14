package io.github.incohesions.prevent_villager_hitting.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Inject(at = @At("RETURN"), method = "isAlliedTo(Lnet/minecraft/world/entity/Entity;)Z", cancellable = true)
    public void isAlliedTo(
        final @Nullable Entity other,
        final CallbackInfoReturnable<Boolean> cir
    ) {
        final var inst = (Entity) (Object) this;
        final var allied = (
            inst instanceof Villager && other instanceof Player || inst instanceof Player && other instanceof Villager
        );
        cir.setReturnValue(allied || cir.getReturnValue());
    }
}
