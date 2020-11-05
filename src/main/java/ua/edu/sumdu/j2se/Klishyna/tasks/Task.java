package ua.edu.sumdu.j2se.Klishyna.tasks;

    public class Task {

        private String title;
        private int time;
        private int start;
        private int end;
        private int interval;
        private boolean active;
        private boolean repeated;

        /**
         * Конструювання неактивної задачі, яка
         * виконується у заданий час без повторення із заданою назвою
         *
         * @param title назва самої задачі
         * @param time час виконання
         */
        public Task(String title, int time) {
            this.title = title;
            this.time = time;
        }

        /**
         * Конструювання неактивної задачі, яка виконується у заданому проміжку часу
         *
         * @param title назва задачі
         * @param start початок проміжку часу
         * @param end кінець проміжку часу
         * @param interval інтервал часу
         */
        public Task(String title, int start, int end, int interval) {
            this.title = title;
            this.start = start;
            this.end = end;
            this.interval = interval;
            this.repeated = true;
        }

        /**
         * Зчитування назви задачі
         *
         * @return назва задачі
         */
        public String getTitle() {
            return this.title;
        }

        /**
         * Встановлення назви задачі
         *
         * @param title назва задачі
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * Зчитування стану задачі
         *
         * @return стан задачі
         */
        public boolean isActive() {
            return active;
        }

        /**
         * Встановлення стану задачі
         *
         * @param active стан задачі
         */
        public void setActive(boolean active) {
            this.active = active;
        }

        /**
         * Зчитування часу виконання задачі, що не повторюється
         * Зчитування часу початку, що повторюється
         *
         * @return час виконання
         */
        public int getTime() {
            if (repeated) {
                return start;
            } else {
                return time;
            }
        }

        /**
         * Зміна часу виконання задачі, що не повторюється
         * Задача, яка повторюється - має стати не повторюванованою задачею
         *
         * @param time час виконання
         */
        public void setTime(int time) {
            this.time = time;

            if (repeated) {
                this.repeated = false;
            }
        }

        /**
         * Зчитування часу виконання задач, що повторюються
         * Задача, яка не повторюється - має повернути час виконання задачі
         *
         * @return час виконання та початку задачі
         */
        public int getStartTime() {
            if (repeated) {
                return start;
            } else {
                return time;
            }
        }

        /**
         * Зчитування часу виконання задач, що повторюються
         * Задача, яка не повторюється - має повернути час виконання задачі
         *
         * @return час виконання та завершення задачі
         */
        public int getEndTime() {
            if (repeated) {
                return end;
            } else {
                return time;
            }
        }

        /**
         * Зчитування часу виконання задач, що повторюються
         * Задача,яка не повторюється метод має повертати 0
         *
         * @return інтервал часу
         */
        public int getRepeatInterval() {
            if (repeated) {
                return interval;
            } else {
                return 0;
            }
        }

        /**
         * Зміна часу виконання задач, що повторюються
         * Задача, яка не повторюється - має стати повторюваною
         *
         * @param start початок проміжку часу
         * @param end кінець проміжку часу
         * @param interval інтервал часу
         */
        public void setTime(int start, int end, int interval) {
            this.start = start;
            this.end = end;
            this.interval = interval;
            this.repeated = true;
        }

        /**
         * Перевірка повторюваності задачі
         *
         * @return повторюваність задачі
         */
        public boolean isRepeated() {
            return repeated;
        }

        /**
         * Знаходження наступного моменту виконання задачі
         *
         * @param current поточний час
         * @return час наступного виконання задачі
         */
        public int nextTimeAfter (int current) {
            //якщо задача активна
            if(active){
                //якщо дія повторяюється
                if(repeated){
                    //якщо поточний час більше кінця проміжутку - повертаємо 1
                    if (current > end){
                        return -1;
                    } else {
                        //повторення дії від початку до кінця проміжутку
                        for (int i = start; i <end; i += interval){
                            //якщо поточний час менше початку проміжутку,
                            if (current < i){
                                //повернути на початок проміжутку
                                return i;
                            }
                        }
                        return -1;
                    }

                } else {
                    //якщо час виконання більше поточного часу - повертає час наступного виконання задачі
                    if (time > current){
                        return time;
                    } else {
                        return -1;
                    }
                }
            } else {
                //задача не виконується
                return -1;
            }
        }

    }

