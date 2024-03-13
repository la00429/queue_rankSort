package co.edu.uptc.model;

import co.edu.uptc.structures.MyQueue;
import co.edu.uptc.structures.PriorittyQueue;

import java.util.ArrayList;
import java.util.Iterator;

public class DigitSort {

    private String[] sortQueueNumbers(String numberQueue) {
        int maxDigits = maxDigitsCount(numberQueue);
        PriorittyQueue<String> queue = new PriorittyQueue<String>(10);
        String[] numbers = numberQueue.split(",");
        String[] numbersAux = new String[numbers.length];
        if (!numberQueue.isEmpty()) {
            for (int i = 0; i < maxDigits; i++) {
                queue = assignedQueue(numbers, queue, i);
                numbers = assignedArray(numbersAux, numbers, queue);
            }
        }
        return numbers;
    }

    private PriorittyQueue<String> assignedQueue(String[] numbers, PriorittyQueue<String> queue, int i) {
        int count = 0;
        for (String number : numbers) {
            count++;
            int level = number.charAt(number.length() - 1 - i) - 48;
            queue.push(number, level);
        }
        return queue;
    }


    private String[] assignedArray(String[] numbersAux, String[] numbers, PriorittyQueue<String> queue) {
        for (int j = 0; j < numbers.length; j++)
            if (!queue.isEmpty()) {
                numbersAux[j] = queue.pull();
            }
        numbers = numbersAux;
        return numbers;
    }

    private int maxDigitsCount(String numberQueue) {
        String[] numbers = numberQueue.split(",");
        String maxNumber = new String();
        for (String number : numbers) {
            if (number.length() > maxNumber.length()) {
                maxNumber = number;
            }
        }
        return maxNumber.length();
    }

    public String[] showOrderNumbers(String numberQueue) {
        return sortQueueNumbers(numberQueue);
    }
}
