package markerTest;

public class Lab {
    //Carnivore
    public void checkKind(Animal[] animals){
        for (int i =0; i< animals.length;i++){
            if(animals[i] instanceof Herbivore){
                System.out.println("초식동물입니다.");
            }else if(animals[i] instanceof Carnivore){
                System.out.println("육식동물입니다.");
            }else{
                System.out.println("잡식동물입니다.");
            };
        };
    };

    public static void main(String[] args) {
        Lab lab = new Lab();

        Animal[] animals = {
                new Bear(),
                new Dog(),
                new Cow(),
                new Tiger()
        };
        lab.checkKind(animals);
    };
};
