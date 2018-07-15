package naturix.basemod;

import org.apache.logging.log4j.Logger;

import naturix.basemod.proxy.CommonProxy;
import naturix.basemod.registry.ModBlocks;
import naturix.basemod.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = BaseMod.MODID, name = BaseMod.NAME, version = BaseMod.VERSION)
public class BaseMod {

	public static final String MODID = "basemod";
	public static final String NAME = "Base Mod";
	public static final String VERSION = "1.12.2.0";

	@Mod.Instance(MODID)
	public static BaseMod instance;
    public static Logger logger;
    
	@SidedProxy(clientSide = "naturix.basemod.proxy.ClientProxy", serverSide = "naturix.basemod.proxy.ServerProxy")
    public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(NAME + " is loading!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
	public static final CreativeTabs TAB = new CreativeTabs("BaseCreativeTab")
    {

        @Override
		@SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Items.DIAMOND);
        }
		
    };
    
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> event) {
    		ModItems.register(event.getRegistry());
    		ModBlocks.registerItemBlocks(event.getRegistry());
    	}
    	@SubscribeEvent
    	public static void registerItems(ModelRegistryEvent event) {
    		ModItems.registerModels();
    		ModBlocks.registerModels();
    	}
    	@SubscribeEvent
    	public static void registerBlocks(RegistryEvent.Register<Block> event) {
    		ModBlocks.register(event.getRegistry());
    	}
    }
}
