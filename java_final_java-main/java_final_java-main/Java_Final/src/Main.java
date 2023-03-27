import global.MyFileWriter;

import model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static global.Vars.allToys;
import static global.Vars.winsToys;

public class Main {

    public static void main(String[] args) {
        //Сначала создаем произвольные игрушки
        Toy cat = new Toy(1, "cat", 10, 20);
        Toy dog = new Toy(2, "dog", 3, 5);
        Toy bird = new Toy(3, "bird", 4, 10);
        Toy fish = new Toy(4, "fish", 10, 30);
        Toy hippopotamus = new Toy(5, "hippopotamus", 6, 20);
        Toy giraffe = new Toy(6, "giraffe", 5, 8);

        //добавляем созданные игрушки в список (в обычный непризовой) с новым весом
        addToListWithNewWeight(cat, 8);
        addToListWithNewWeight(dog, 15);
        addToListWithNewWeight(bird, 22);
        addToListWithNewWeight(fish, 7);
        addToListWithNewWeight(hippopotamus, 45);
        addToListWithNewWeight(giraffe, 68);

        //показываем что у нас в общем списке игрушек
        System.out.println("all toys: ");
        showNewList(allToys);

        //формируем список призовых игрушек
        List<Toy> addedWinners = selectToyByMinWeight(allToys, 25);
        winsToys.addAll(addedWinners);

        //отображаем призовые игрушки
        System.out.println("winners list: ");
        showNewList(winsToys);

        //выбираем призовую игрушку на выдачу из призового списка
        Toy givedWinner = selectRandomToy(winsToys);
        //удаляем выданную игрушку из списка к выдаче
        winsToys.remove(givedWinner);

        //отображаем инфо о призовой игрушке на выдачу
        System.out.println("winner for giving: " + givedWinner.info());

        //пишем инфо в текстовый файл
        MyFileWriter.writeToy(givedWinner);

    }

    private static List<Toy> selectToyByMinWeight(ArrayList<Toy> allToys, int minWeight) {
        List<Toy> result = new ArrayList<>();
        for (Toy currentToy : allToys) {
            if (currentToy.getWeight() <= minWeight) {
                result.add(currentToy);
            }
        }
        return result;
    }

    private static Toy selectRandomToy(ArrayList<Toy> winsToys) {
        Random rand = new Random();
        int winnerElement = rand.nextInt(winsToys.size());
        return winsToys.get(winnerElement);
    }

    private static void addToListWithNewWeight(Toy newToy, int newWeight) {
        newToy.setWeight(newWeight);
        allToys.add(newToy);
    }

    private static void showNewList(ArrayList<Toy> myList) {
        int winListSize = myList.size();
        for (int i = 0; i < winListSize; i++) {
            System.out.print("toy [" + i + "]: " + myList.get(i).getName() + ", ");
        }
        System.out.println("");
    }
}