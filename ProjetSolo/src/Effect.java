public class Effect {
    private Type type;
    private Float power;
    private int turn;

    public Effect(Type type, Float power, int turn) {
        this.type = type;
        this.power = power;
        this.turn = turn;
    }
    public Effect(Effect effect) {
        this.type = effect.getType();
        this.power = effect.getPower();
        this.turn = effect.getTurn();
    }
    public void decreaseTime(){
        this.turn--;
    }

    public Type getType() {
        return type;
    }

    public Float getPower() {
        return power;
    }

    public int getTurn() {
        return turn;
    }
}
