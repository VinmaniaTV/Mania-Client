package net.minecraft.realms;

import com.google.common.util.concurrent.ListenableFuture;
import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Proxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Session;
import net.minecraft.world.GameType;

public class Realms {
   public static boolean isTouchScreen() {
      return Minecraft.func_71410_x().field_71474_y.field_85185_A;
   }

   public static Proxy getProxy() {
      return Minecraft.func_71410_x().func_110437_J();
   }

   public static String sessionId() {
      Session session = Minecraft.func_71410_x().func_110432_I();
      return session == null ? null : session.func_111286_b();
   }

   public static String userName() {
      Session session = Minecraft.func_71410_x().func_110432_I();
      return session == null ? null : session.func_111285_a();
   }

   public static long currentTimeMillis() {
      return Minecraft.func_71386_F();
   }

   public static String getSessionId() {
      return Minecraft.func_71410_x().func_110432_I().func_111286_b();
   }

   public static String getUUID() {
      return Minecraft.func_71410_x().func_110432_I().func_148255_b();
   }

   public static String getName() {
      return Minecraft.func_71410_x().func_110432_I().func_111285_a();
   }

   public static String uuidToName(String p_uuidToName_0_) {
      return Minecraft.func_71410_x().func_152347_ac().fillProfileProperties(new GameProfile(UUIDTypeAdapter.fromString(p_uuidToName_0_), (String)null), false).getName();
   }

   public static void setScreen(RealmsScreen p_setScreen_0_) {
      Minecraft.func_71410_x().func_147108_a(p_setScreen_0_.getProxy());
   }

   public static String getGameDirectoryPath() {
      return Minecraft.func_71410_x().field_71412_D.getAbsolutePath();
   }

   public static int survivalId() {
      return GameType.SURVIVAL.func_77148_a();
   }

   public static int creativeId() {
      return GameType.CREATIVE.func_77148_a();
   }

   public static int adventureId() {
      return GameType.ADVENTURE.func_77148_a();
   }

   public static int spectatorId() {
      return GameType.SPECTATOR.func_77148_a();
   }

   public static void setConnectedToRealms(boolean p_setConnectedToRealms_0_) {
      Minecraft.func_71410_x().func_181537_a(p_setConnectedToRealms_0_);
   }

   public static ListenableFuture<Object> downloadResourcePack(String p_downloadResourcePack_0_, String p_downloadResourcePack_1_) {
      return Minecraft.func_71410_x().func_110438_M().func_180601_a(p_downloadResourcePack_0_, p_downloadResourcePack_1_);
   }

   public static void clearResourcePack() {
      Minecraft.func_71410_x().func_110438_M().func_148529_f();
   }

   public static boolean getRealmsNotificationsEnabled() {
      return Minecraft.func_71410_x().field_71474_y.func_74308_b(GameSettings.Options.REALMS_NOTIFICATIONS);
   }

   public static boolean inTitleScreen() {
      return Minecraft.func_71410_x().field_71462_r != null && Minecraft.func_71410_x().field_71462_r instanceof GuiMainMenu;
   }

   public static void deletePlayerTag(File p_deletePlayerTag_0_) {
      if (p_deletePlayerTag_0_.exists()) {
         try {
            NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(p_deletePlayerTag_0_));
            NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("Data");
            nbttagcompound1.func_82580_o("Player");
            CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(p_deletePlayerTag_0_));
         } catch (Exception exception) {
            exception.printStackTrace();
         }
      }

   }
}
