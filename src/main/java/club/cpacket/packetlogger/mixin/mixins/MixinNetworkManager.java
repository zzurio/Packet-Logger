package club.cpacket.packetlogger.mixin.mixins;

import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void onPacketSend(Packet<?> packet, CallbackInfo ci) {
        //ChatUtil.sendMessage("\\u00a77[\\u00a7cPacket-Logger\\u00a77] [SENT]" + packet.getClass().getSimpleName());
        System.out.println("[Packet-Logger] -> SENT " + packet.getClass().getSimpleName());
    }

    @Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
    public void onPacketReceive(ChannelHandlerContext chc, Packet<?> packet, CallbackInfo info) {
        //ChatUtil.sendMessage("\\u00a77[\\u00a7cPacket-Logger\\u00a77] [RECEIVED]" + packet.getClass().getSimpleName());
        //System.out.println("[Packet-Logger] -> RECEIVED " + packet.getClass().getSimpleName());
    }
}
