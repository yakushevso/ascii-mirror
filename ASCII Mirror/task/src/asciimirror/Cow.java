package asciimirror;

public class Cow extends Animal{
    @Override
    public void printAnimal() {
        System.out.print("""
                                    _______\s
                                   < hello >
                                    -------\s
                            ^__^   /       \s
                    _______/(oo)  /        \s
                /\\/(       /(__)           \s
                   | w----||               \s
                   ||     ||               \s""");
    }
}
