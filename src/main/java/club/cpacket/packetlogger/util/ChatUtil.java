package club.cpacket.packetlogger.util;

import net.minecraft.util.text.TextComponentString;

public class ChatUtil implements IMinecraft {

    public static void sendMessage(String message) {
        if (mc.ingameGUI == null || mc.ingameGUI.getChatGUI() == null) return;
        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(message));
    }
}
