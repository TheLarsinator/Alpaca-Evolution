package fiskfille.alpaca.common.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fiskfille.alpaca.AlpacaReflection;
import fiskfille.alpaca.client.file.ModOptions;
import fiskfille.alpaca.client.gui.GuiOverlay;
import fiskfille.alpaca.client.keybinds.AlpacaKeyBinds;
import fiskfille.alpaca.client.model.entity.ModelAlpaca;
import fiskfille.alpaca.client.model.entity.ModelAlpacaArmor;
import fiskfille.alpaca.client.model.entity.ModelAlpacaBase;
import fiskfille.alpaca.client.render.entity.RenderCorpse;
import fiskfille.alpaca.client.render.entity.RenderTongue;
import fiskfille.alpaca.common.entity.EntityCorpse;
import fiskfille.alpaca.common.entity.EntityTongue;
import fiskfille.alpaca.common.event.ClientEventHandler;

public class ClientProxy extends CommonProxy
{
	public static ModelAlpaca modelAlpaca = new ModelAlpaca();
    public static ModelAlpacaArmor modelAlpacaArmor = new ModelAlpacaArmor();

    public void preInit()
    {
        super.preInit();
        AlpacaKeyBinds.load();
        AlpacaReflection.client();

        clientEventHandler = new ClientEventHandler();
        registerEventHandler(clientEventHandler);
        registerEventHandler(new GuiOverlay(Minecraft.getMinecraft()));
        
        
        RenderingRegistry.registerEntityRenderingHandler(EntityCorpse.class, new RenderCorpse());
        RenderingRegistry.registerEntityRenderingHandler(EntityTongue.class, new RenderTongue());
    }

    public EntityPlayer getPlayer()
    {
        return Minecraft.getMinecraft().thePlayer;
    }

    public static ModelAlpacaBase getModelAlpaca(EntityPlayer player)
    {
        return modelAlpaca;
    }
}