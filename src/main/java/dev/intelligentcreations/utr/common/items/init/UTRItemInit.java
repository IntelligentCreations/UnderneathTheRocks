package dev.intelligentcreations.utr.common.items.init;

import dev.intelligentcreations.utr.common.items.impl.AnalyzedFossilItem;
import dev.intelligentcreations.utr.common.items.impl.AnalyzingReportItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static dev.intelligentcreations.utr.common.itemgroup.UTRItemGroupInit.MAIN;

public class UTRItemInit {
    public static final Item FOSSIL = new Item(new FabricItemSettings().group(MAIN));
    public static final Item BLANK_SHEET = new Item(new FabricItemSettings().group(MAIN));
    public static final AnalyzingReportItem ANALYZING_REPORT = new AnalyzingReportItem(new FabricItemSettings().group(MAIN));
    public static final AnalyzedFossilItem ANALYZED_FOSSIL = new AnalyzedFossilItem(new FabricItemSettings().group(MAIN));
}
