package ua.edu.sumdu.j2se.Klishyna.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTaskList {
    Task[] arrayTask = new Task[0];

    /**
     * Додавання елементів(задач) до масиву
     * @param task задача
     */
    public void add(Task task){
        List<Task> list = new ArrayList<>(Arrays.asList(arrayTask)); //перетворення масиву в список
        list.add(task);  //видалення задачі зі списку
        arrayTask = list.toArray(new Task[list.size()]); //перетворення назад

    }

    /**
     * Видалення повторюваних елементів(задач) з масиву та повертає істину(true)
     * якщо ні - false
     * @param task задача
     * @return повертання наявності задачі в масиві
     */
    public boolean remove(Task task){
        for (int i = 0; i < arrayTask.length; i++){ //перебирання значень
            if(arrayTask[i] == task){  //якщо індекс масиву дорівнює задачі, яку потрбно видалити
                List<Task> list = new ArrayList<>(Arrays.asList(arrayTask)); //перетворення масиву в список
                list.remove(task);  //видалення задачі зі списку
                arrayTask = list.toArray(new Task[list.size()]); //перетворення назад
                return true;
            }
        }
        return false;
    }

    /**
     * Повертає розмір(кіл-сть елементів) масиву
     * @return повертання кількості задач у масиві
     */
    public int size(){
        return arrayTask.length;
    }

    /**
     * Повертає задачу, яка знаходиться у вказаному місці в масиві
     * @param index індекс елемента масиву
     * @return повертання задачі
     */
    public Task getTask(int index){
       return arrayTask[index];
    }

    /**
     * Повертає задачі, які заплановані на виконання в певному проміжку часі
     * @param from початок вказаного проміжку часу
     * @param to закінчення вказаного проміжку часу
     * @return повертання підмножини задач
     */
    public ArrayTaskList incoming(int from, int to){
        //створення об'єкту
        ArrayTaskList resultIncoming = new ArrayTaskList();
        //перебір елементів в наборі елементів
        for (Task task : arrayTask){
            //якщо почаковий проміжок часу не дорівнює -1 та більше початкового вказаного часу(from)
            //а також початковий проміжок часу має бути меншим/дорівнювати кінцевоПму вказаному часу
            if((task.nextTimeAfter(from) != -1 && task.nextTimeAfter(from)>from)&& task.nextTimeAfter(from)<=to){
                //додати до задачу до списку
                resultIncoming.add(task);
            }
        }
        //повертає заплановоні задачі в вказаному проміжку часі
        return resultIncoming;
    }
}
