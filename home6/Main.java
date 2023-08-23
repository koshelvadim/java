package home6;



public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(3, 10);
        elevator.move(8);
        elevator.move(4);
        elevator.move(9);
        elevator.setCurrentFloor(4);
        elevator.move(10);

        Elevator elevator1 = new Elevator(5);
        elevator1.move(3);
        elevator1.move(6); // должна быть ошибка
    }

}
