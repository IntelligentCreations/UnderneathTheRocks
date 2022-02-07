package dev.intelligentcreations.utr.client.screen.impl;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.intelligentcreations.utr.common.screenhandlers.impl.AnalyzerScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AnalyzerScreen extends HandledScreen<AnalyzerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("utr", "textures/gui/analyzer.png");

    public AnalyzerScreen(AnalyzerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        int l;
        if (this.handler.getProgress() <= 0) {
            l = 0;
        } else {
            l = (this.handler).getProgress() + 100;
        }
        this.drawTexture(matrices, x + 76, y + 41, 176, 0, l / 100, 4);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
