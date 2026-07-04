package com.dtrw.pbj.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.NetherPortalBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(NetherPortalBlock.class)
public class NetherPortalBlockMixin {

    @Redirect(

            method = "randomTick",
            slice = @Slice(

                    from = @At(

                            value = "FIELD",
                            target = "Lnet/minecraft/world/entity/EntityTypes;ZOMBIFIED_PIGLIN:Lnet/minecraft/world/entity/EntityType;"
                    )
            ),
            at = @At(

                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/EntityType;spawn(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/EntitySpawnReason;)Lnet/minecraft/world/entity/Entity;"
            ),
            require = 1
    )
    private Entity preventZombifiedPiglinPortalSpawn(EntityType<?> entityType, ServerLevel level, BlockPos pos, EntitySpawnReason spawnReason) {

        return null;
    }
}
