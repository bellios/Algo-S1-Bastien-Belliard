package chara.wizard.wand;

import java.lang.*;
public class Wand {
    private Core core;
    private Wood wood;
    private int size;
    private int flexibility;

    public Wand() {
        //43 wood & 16 core, size between 22-35 cm
        this.core = Core.values()[(int)(Math.random()*Core.values().length)];
        this.wood = Wood.values()[(int)(Math.random()*Wood.values().length)];
        this.size = ((int)(Math.random()*13))+22;
        this.flexibility = (int)(Math.random()*10);
    }

    public Core getCore() {
        return core;
    }

    public Wood getWood() {
        return wood;
    }

    public int getSize() {
        return size;
    }

    public int getFlexibility() {
        return flexibility;
    }

    @Override
    public String toString() {
        return "core : " + core + " | wood : " + wood +
                "\nsize : " + size +" cm | flexibility : " + flexibility;
    }
}
