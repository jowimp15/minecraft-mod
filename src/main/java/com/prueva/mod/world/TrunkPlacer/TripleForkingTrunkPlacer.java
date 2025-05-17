package com.prueva.mod.world.TrunkPlacer;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;

public class TripleForkingTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<TripleForkingTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillTrunkPlacerFields(instance).apply(instance, TripleForkingTrunkPlacer::new)
    );

    public TripleForkingTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return TrunkPlacerType.FORKING_TRUNK_PLACER; // Puedes elegir otro tipo si prefieres
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config
    ) {
        setToDirt(world, replacer, random, startPos.down(), config);
        List<FoliagePlacer.TreeNode> list = Lists.newArrayList();

        // Direcciones aleatorias para las tres bifurcaciones
        Direction direction1 = Direction.Type.HORIZONTAL.random(random);
        Direction direction2 = Direction.Type.HORIZONTAL.random(random);
        Direction direction3 = Direction.Type.HORIZONTAL.random(random);

        int i = height - random.nextInt(4) - 1;
        int j = 3 - random.nextInt(3);
        int k = startPos.getX();
        int l = startPos.getZ();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        OptionalInt optionalInt = OptionalInt.empty();

        // Creación del tronco principal
        for (int m = 0; m < height; m++) {
            int n = startPos.getY() + m;
            if (m >= i && j > 0) {
                k += direction1.getOffsetX();
                l += direction1.getOffsetZ();
                j--;
            }

            if (this.getAndSetState(world, replacer, random, mutable.set(k, n, l), config)) {
                optionalInt = OptionalInt.of(n + 1);
            }
        }

        if (optionalInt.isPresent()) {
            list.add(new FoliagePlacer.TreeNode(new BlockPos(k, optionalInt.getAsInt(), l), 1, false));
        }

        // Creación de la segunda bifurcación
        int nx = i - random.nextInt(2) - 1;
        int o = 1 + random.nextInt(3);
        optionalInt = OptionalInt.empty();

        for (int p = nx; p < height && o > 0; o--) {
            if (p >= 1) {
                int q = startPos.getY() + p;
                k += direction2.getOffsetX();
                l += direction2.getOffsetZ();
                if (this.getAndSetState(world, replacer, random, mutable.set(k, q, l), config)) {
                    optionalInt = OptionalInt.of(q + 1);
                }
            }

            p++;
        }

        if (optionalInt.isPresent()) {
            list.add(new FoliagePlacer.TreeNode(new BlockPos(k, optionalInt.getAsInt(), l), 0, false));
        }

        // Creación de la tercera bifurcación
        int m1 = i - random.nextInt(2) - 1;
        int p2 = 1 + random.nextInt(3);
        optionalInt = OptionalInt.empty();

        for (int p = m1; p < height && p2 > 0; p2--) {
            if (p >= 1) {
                int q = startPos.getY() + p;
                k += direction3.getOffsetX();
                l += direction3.getOffsetZ();
                if (this.getAndSetState(world, replacer, random, mutable.set(k, q, l), config)) {
                    optionalInt = OptionalInt.of(q + 1);
                }
            }

            p++;
        }

        if (optionalInt.isPresent()) {
            list.add(new FoliagePlacer.TreeNode(new BlockPos(k, optionalInt.getAsInt(), l), 0, false));
        }

        return list;
    }
}

