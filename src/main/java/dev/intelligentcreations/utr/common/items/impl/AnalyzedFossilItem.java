package dev.intelligentcreations.utr.common.items.impl;

import com.redgrapefruit.itemnbt3.DataClient;
import dev.intelligentcreations.utr.common.data.impl.AnalyzedFossilData;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class AnalyzedFossilItem extends Item {
    public AnalyzedFossilItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
        // Initial, needs further rework
        DataClient.use(AnalyzedFossilData::new, itemStack, (data) -> {
            int type = data.getType();
            switch (type) {
                case 0 -> tooltip.add(new TranslatableText("tooltip.utr.fossil_type.0").formatted(Formatting.AQUA));
                case 1 -> tooltip.add(new TranslatableText("tooltip.utr.fossil_type.1").formatted(Formatting.AQUA));
                case 2 -> tooltip.add(new TranslatableText("tooltip.utr.fossil_type.2").formatted(Formatting.AQUA));
                case 3 -> tooltip.add(new TranslatableText("tooltip.utr.fossil_type.3").formatted(Formatting.AQUA));
                case 4 -> tooltip.add(new TranslatableText("tooltip.utr.fossil_type.4").formatted(Formatting.AQUA));
                case 5 -> tooltip.add(new TranslatableText("tooltip.utr.fossil_type.5").formatted(Formatting.AQUA));
                case 6 -> tooltip.add(new TranslatableText("tooltip.utr.fossil_type.6").formatted(Formatting.AQUA));
                case 7 -> tooltip.add(new TranslatableText("tooltip.utr.fossil_type.7").formatted(Formatting.AQUA));
            }
        });
        tooltip.add(new TranslatableText("tooltip.utr.analyzed_fossil").formatted(Formatting.GOLD));
    }
}
