package io.github.faiz

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.TNTPrimed
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import kotlin.random.Random

class Main:JavaPlugin(),Listener {

    override fun onEnable() {
        this.server.pluginManager.registerEvents(this,this)
    }

    @EventHandler
    fun onInterraction(e:PlayerInteractEvent){
        val p = e.player
        if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK){
            if (p.itemOnCursor == ItemStack(Material.COBBLESTONE,20)){
                p.inventory.remove(ItemStack(Material.COBBLESTONE,1))
                val r = rand(0,100)
                if (r == 0){
                    p.inventory.addItem(ItemStack(Material.DIAMOND,1))
                    p.sendMessage("§l§b1%의 확률로 다이아몬드가 나왔습니다!")
                }else if (r == 1){
                    p.inventory.addItem(ItemStack(Material.ENDER_PEARL,1))
                    p.sendMessage("§l§b1%의 확률로 엔더진주가 나왔습니다!")
                }else if (r == 2){
                    p.inventory.addItem(ItemStack(Material.IRON_INGOT,3))
                    p.sendMessage("§l§b1%의 확률로 철 3개가 나왔습니다!")
                }else if (r in 3..5){
                    p.inventory.addItem(ItemStack(Material.IRON_INGOT,1))
                    p.sendMessage("§l§b3%의 확률로 철 1개가 나왔습니다!")
                }else if (r in 6 .. 10){
                    p.inventory.addItem(ItemStack(Material.BONE,3))
                    p.sendMessage("§l§b4%의 확률로 뼈 3개가 나왔습니다!")
                }else if (r in 11 .. 16){
                    val x = p.location.x
                    val y = p.location.y
                    val z = p.location.z
                    var tnt:TNTPrimed = p.world.spawnEntity(Location(x,y,z), EntityType.PRIMED_TNT)
                    p.sendMessage("§l§b5%의 확률로 TNT가 나왔습니다!")
                }else if (r in 17 .. 26){
                    p.inventory.addItem(ItemStack(Material.COBBLESTONE),10)
                    p.sendMessage("§l§b10%의 확률로 조약돌 10개가 나왔습니다!")
                }else{
                    p.sendMessage("§l§b75%의 확률로 꽝이 나왔습니다!")
                }
            }
        }
    }

    private fun rand(from: Int, to: Int) : Int {
        return Random.nextInt(to - from) + from
    }

}