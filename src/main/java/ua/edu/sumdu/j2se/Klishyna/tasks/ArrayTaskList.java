package ua.edu.sumdu.j2se.Klishyna.tasks;

public class ArrayTaskList {
    int index; //індекс масиву
    Task[] arrayTask = new Task[index];  //масив з задачами

    /**
     * Додавання елементів(задач) до масиву
     * @param task задача
     */
    public void add(Task task){
           //створення масиву на основі існуючого з +1 осередком
            System.arraycopy(arrayTask,0,arrayTask,0,arrayTask.length + 1);
            arrayTask[arrayTask.length - 1] = task;
    }

    /**
     * Видалення повторюваних елементів(задач) з масиву та повертає істину(true)
     * якщо ні - false
     * @param task задача
     * @return повертання наявності задачі в масиві
     */
    public boolean remove(Task task){
        int size = arrayTask.length; //розмір масиву
        for (int i = 0; i < size; i++) { //перебирання значень
            if(arrayTask[i] == task){   //пошук однакової задачі
                //створення масиву -1 ячейкою
                //замінити всі значення масиву на 0
                    Task[] arrayTaskRemove = new Task[arrayTask.length-1];
                    System.arraycopy(arrayTask,0,arrayTaskRemove,0,i);

                if(arrayTask.length-1 != i){   //якзо значення(задачі) не однакові
                    //додати неоднакові задачі
                    System.arraycopy(arrayTask,i+1,arrayTaskRemove,i,arrayTask.length-(i+1));
                }
                //присвоєння значень
                arrayTask = arrayTaskRemove;
                return true;  //істина, якщо є повторювана задача
            }
        }
       return false; //якщо не має повторюваної задачі
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
            //якщо почаковий проміжок часу задачі не дорівнює -1 та більше початкового вказаного часу(from)
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
