package net.chalkysmp.items;

import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public final class ModItems {
    private ModItems() {
    }

    private static final FoodProperties HASTE_TONIC_FOOD = new FoodProperties.Builder()
            .nutrition(0)
            .saturationModifier(0.0F)
            .alwaysEdible()
            .build();

    private static final Consumable HASTE_TONIC_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.HASTE, 60 * 20, 0),
                    1.0F
            ))
            .build();

    public static final Item HASTE_TONIC = register(
            "haste_tonic",
            Item::new,
            new Item.Properties()
                    .food(HASTE_TONIC_FOOD, HASTE_TONIC_CONSUMABLE)
                    .stacksTo(16)
    );

    private static <T extends Item> T register(
            String name,
            Function<Item.Properties, T> itemFactory,
            Item.Properties properties
    ) {
        Identifier id = Identifier.fromNamespaceAndPath(ChalkySmpItems.MOD_ID, name);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);

        T item = itemFactory.apply(properties.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
                .register(entries -> entries.accept(HASTE_TONIC));
    }
}
