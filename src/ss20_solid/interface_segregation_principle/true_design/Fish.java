package ss20_solid.interface_segregation_principle.true_design;

public class Fish implements IFish, IBird {
    @Override
    public void swim() {
        System.out.println("Code phương thức swim() của fish");
    }

    @Override
    public void fly() {

    }
}
