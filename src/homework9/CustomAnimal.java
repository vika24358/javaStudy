package homework9;

public class CustomAnimal extends Animal{
    String sound;

    public CustomAnimal (String sound) {
        this.sound = sound;
    }

    @Override
    public String makeSound(){
        return sound;
    }
}
