import java.util.LinkedList;
class AnimalCollection {
    private LinkedList<String> animalNames;

    public AnimalCollection() {
        this.animalNames = new LinkedList<>();
    }

    public void addAnimal(String name) {
        animalNames.addFirst(name);
    }

    public String removeAnimal() {
        if (!animalNames.isEmpty()) {
            return animalNames.removeLast();
        } else {
            return null;
        }
    }

    public void displayAnimalNames() {
        System.out.println("Названия животных в коллекции:");
        for (String name : animalNames) {
            System.out.println(name);
        }
    }
}