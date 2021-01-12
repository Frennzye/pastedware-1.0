package me.travis.wurstplus.wurstplustwo.hacks.dev;

import com.mojang.authlib.GameProfile;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import net.minecraft.client.entity.EntityOtherPlayerMP;

import java.util.UUID;

public class WurstplusFakePlayer extends WurstplusHack {
    
    public WurstplusFakePlayer() {
        super(WurstplusCategory.WURSTPLUS_BETA);

		this.name        = "Fake Player";
		this.tag         = "FakePlayer";
		this.description = "hahahaaha what a noob its in beta ahahahahaha";
    }

    private EntityOtherPlayerMP fake_player;

    @Override
    protected void enable() {
        
        fake_player = new EntityOtherPlayerMP(mc.world, new GameProfile(UUID.fromString("27444872-8901-4e50-a917-d5c5e1946392"), "Frennzy"));
        fake_player.copyLocationAndAnglesFrom(mc.player);
        fake_player.rotationYawHead = mc.player.rotationYawHead;
        mc.world.addEntityToWorld(-100, fake_player);

    }

    @Override
    protected void disable() {
        try {
            mc.world.removeEntity(fake_player);
        } catch (Exception ignored) {}
    }

}
