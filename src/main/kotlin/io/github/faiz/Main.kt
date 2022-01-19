package io.github.faiz

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.EntityType
import org.bukkit.entity.TNTPrimed
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import kotlin.random.Random

class Main:JavaPlugin(),Listener {

    override fun onEnable() {
        this.server.pluginManager.registerEvents(this,this)
    }

    @EventHandler
    fun onInterraction(e:PlayerInteractEvent){
        val p = e.player
        val mmaterial: Material = p.inventory.itemInMainHand.type
        val mitem = p.inventory.itemInMainHand
        val omaterial: Material = p.inventory.itemInOffHand.type
        val oitem = p.inventory.itemInOffHand
        if (e.action == Action.LEFT_CLICK_AIR || e.action == Action.LEFT_CLICK_BLOCK && mmaterial == Material.COBBLESTONE){
            if(p.isSneaking){
                if (mitem.amount >= 20){
                    mitem.amount = mitem.amount-20
                val r = rand(0,100)
                if (r == 0){
                    p.inventory.addItem(ItemStack(Material.DIAMOND,1))
                    p.sendMessage("§l§b1%의 확률로 다이아몬드가 나왔습니다!")
                }else if (r == 1){
                    p.inventory.addItem(ItemStack(Material.ENDER_PEARL,1))
                    p.sendMessage("§l§b1%의 확률로 엔더진주가 나왔습니다!")
                }else if (r in 2..3){
                    p.inventory.addItem(ItemStack(Material.IRON_INGOT,3))
                    p.sendMessage("§l§b2%의 확률로 철 3개가 나왔습니다!")
                }else if (r in 4..6){
                    p.inventory.addItem(ItemStack(Material.IRON_INGOT,1))
                    p.sendMessage("§l§b3%의 확률로 철 1개가 나왔습니다!")
                }else if (r in 7.. 16){
                    p.inventory.addItem(ItemStack(Material.BONE,3))
                    p.sendMessage("§l§b10%의 확률로 뼈 3개가 나왔습니다!")
                }else if (r in 17 .. 19){
                    val x = p.location.x
                    val y = p.location.y
                    val z = p.location.z
                    val tnt:TNTPrimed = p.world.spawnEntity(Location(p.world,x,y,z), EntityType.PRIMED_TNT) as TNTPrimed
                    tnt.fuseTicks = 10
                    p.sendMessage("§l§b3%의 확률로 TNT가 나왔습니다!")
                }else if (r in 20 .. 34){
                    p.inventory.addItem(ItemStack(Material.COBBLESTONE,10))
                    p.sendMessage("§l§b15%의 확률로 조약돌 10개가 나왔습니다!")
                }else if(r in 35 .. 49){
                    p.inventory.addItem(ItemStack(Material.COBBLESTONE,20))
                    p.sendMessage("§l§b15%확률로 조약돌 20개가 나왔습니다!")
                }else{
                    p.sendMessage("§l§b50%의 확률로 꽝이 나왔습니다!")
                }
            }}
        }else if (e.action == Action.LEFT_CLICK_AIR || e.action == Action.LEFT_CLICK_BLOCK && omaterial == Material.COBBLESTONE){
            if(p.isSneaking){
                if (oitem.amount >= 20){
                    oitem.amount = oitem.amount-20
                    val r = rand(0,100)
                    if (r == 0){
                        p.inventory.addItem(ItemStack(Material.DIAMOND,1))
                        p.sendMessage("§l§b1%의 확률로 다이아몬드가 나왔습니다!")
                    }else if (r == 1){
                        p.inventory.addItem(ItemStack(Material.ENDER_PEARL,1))
                        p.sendMessage("§l§b1%의 확률로 엔더진주가 나왔습니다!")
                    }else if (r in 2..3){
                        p.inventory.addItem(ItemStack(Material.IRON_INGOT,3))
                        p.sendMessage("§l§b2%의 확률로 철 3개가 나왔습니다!")
                    }else if (r in 4..6){
                        p.inventory.addItem(ItemStack(Material.IRON_INGOT,1))
                        p.sendMessage("§l§b3%의 확률로 철 1개가 나왔습니다!")
                    }else if (r in 7.. 16){
                        p.inventory.addItem(ItemStack(Material.BONE,3))
                        p.sendMessage("§l§b10%의 확률로 뼈 3개가 나왔습니다!")
                    }else if (r in 17 .. 19){
                        val x = p.location.x
                        val y = p.location.y
                        val z = p.location.z
                        val tnt:TNTPrimed = p.world.spawnEntity(Location(p.world,x,y,z), EntityType.PRIMED_TNT) as TNTPrimed
                        tnt.fuseTicks = 10
                        p.sendMessage("§l§b3%의 확률로 TNT가 나왔습니다!")
                    }else if (r in 20 .. 34){
                        p.inventory.addItem(ItemStack(Material.COBBLESTONE,10))
                        p.sendMessage("§l§b15%의 확률로 조약돌 10개가 나왔습니다!")
                    }else if(r in 35 .. 49){
                        p.inventory.addItem(ItemStack(Material.COBBLESTONE,20))
                        p.sendMessage("§l§b15%확률로 조약돌 20개가 나왔습니다!")
                    }else{
                        p.sendMessage("§l§b50%의 확률로 꽝이 나왔습니다!")
                    }
                }}
        }
    }

    private fun rand(from: Int, to: Int) : Int {
        return Random.nextInt(to - from) + from
    }

}