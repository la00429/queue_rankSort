package co.edu.uptc.presenter;

import co.edu.uptc.model.DigitSort;
import co.edu.uptc.persistence.LoadNumber;
import co.edu.uptc.view.View;

public class Presenter {

    private DigitSort queue;
    private View view;

    private LoadNumber loadNumber;

    private final String MENU = "_______DigitSort______\n" +
            "1.Order sort queue\n" + "0.Salir\n";

    public Presenter() {
        queue = new DigitSort();
        loadNumber = new LoadNumber();
        view = new View();
    }

    public void showOrder(){
        String[] numbersList= loadNumber.readTxt("data/listNumber.txt").toArray(new String[0]);
        String [] numbersOrder = queue.showOrderNumbers(String.join(",",numbersList));
        for (String number : numbersOrder){
            view.showMessage(number);
        }
    }

    public void run() {
        int option = mostrarMenu();
        switch (option) {
            case 1:
                showSortNumbers();
                break;
            case 0:
                view.showMessage("Finnish");
                System.exit(0);
                break;
            default:
                view.showMessage("Invalid option, try again.");
                break;
        }
        do {
            run();
        } while (option != 4);
    }

    public int mostrarMenu() {
        int option = 0;
        try {
            option = Integer.parseInt(view.readData(MENU));
        } catch (NumberFormatException e) {
            view.showMessage("Input valid option.");
        }
        return option;
    }

    private void showSortNumbers() {
        String[] listNumbers = queue.showOrderNumbers(inputNumbers());
        for(String number : listNumbers) {
            view.showMessage(number);
        }
    }

    private String inputNumbers() {
        String numbersList = new String();
        try {
            String number = view.readData("Input number");
            int countNumber = number.length();
            String listNumber = number;
            int validation = Integer.parseInt(view.readData("continue(1)-finish(0)"));
            while (validation == 1) {
                String numberNext = view.readData("Input number");
                if (number.length() == numberNext.length()) {
                    listNumber = listNumber + "," + numberNext;
                } else {
                    view.readData("Can only input number with same count number digits: " + countNumber);
                }
                validation = Integer.parseInt(view.readData("continue(1)-finish(1)"));
            }


        } catch (NumberFormatException e) {
            view.showMessage("Input only numbers");

        }
        return numbersList;
    }




}
