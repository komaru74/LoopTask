package loopfinder;

import java.util.ArrayList;
import java.util.Arrays;

public class LoopFinder {
    private int[] ceils;
    /**
     * хранит значения, полученные после шагов
     */
    private ArrayList<int[]> memory = new ArrayList<>();
    private int iteration, loopStartIteration, loopLength;

    /**
     * @param ceils - массив ячеек
     * @return кол-во шагов до конца
     */
    public int findLoop(int ... ceils) {
        reset();
        this.ceils = ceils;
        memory.add(ceils.clone());
        iteration();
        while (true) {
            loopStartIteration = findLoopStartIndex();
            if(loopStartIteration > 0) break;
            else memory.add(ceils.clone());
            iteration();
        }
        loopLength = iteration - loopStartIteration;
        return iteration;
    }

    public int getIteration(){
        return iteration;
    }

    public int getLoopLength(){
        return loopLength;
    }

    public int getLoopStartIteration(){
        return loopStartIteration;
    }

    /**
     * Сброс памяти и кол-ва шагов
     */
    private void reset(){
        memory.clear();
        iteration = 0;
    }

    private int findLoopStartIndex() {
        for (int i = 0, len = memory.size(); i < len; i++)
            if (Arrays.equals(memory.get(i), ceils)) return i;
        return -1;
    }

    /**
     * распределяет максимальное число по ячейкам
     */
    private void iteration() {
        iteration++;
        int index = getCeilMaxValueIndex();
        int value = ceils[index];
        ceils[index] = 0;
        int av = (int) Math.ceil((float) value / ceils.length);
        while (value > 0) {
            index++;
            ceils[index & ceils.length - 1] += value > av ? av : value;
            value -= av;
        }
    }

    /**
     * @return индекс первого максимального значения в ячейках
     */
    private int getCeilMaxValueIndex() {
        int maxI = 0;
        for (int i = 1; i < ceils.length; i++)
            if (ceils[i] > ceils[maxI]) maxI = i;
        return maxI;
    }
}
