import loopfinder.LoopFinder;

import java.util.ArrayList;
import java.util.Arrays;

public class LoopTask {

    static public void main(String args[]) throws Exception {
        LoopFinder loopFinder = new LoopFinder();
        long time = System.currentTimeMillis();
        loopFinder.findLoop(0, 2, 7, 0);
        System.out.printf("Время: %d мс.", System.currentTimeMillis() - time);
        System.out.printf("Нашли цикл за %d шагов, длинна: %d\n", loopFinder.getIteration(), loopFinder.getLoopLength());

        time = System.currentTimeMillis();
        loopFinder.findLoop(0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11);
        System.out.printf("Время: %d мс.", System.currentTimeMillis() - time);
        System.out.printf("Нашли цикл за %d шагов, длинна: %d\n", loopFinder.getIteration(), loopFinder.getLoopLength());

    }
}
