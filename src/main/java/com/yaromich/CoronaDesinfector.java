package com.yaromich;


public class CoronaDesinfector {
    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room) {
        announcer.announce("Начинаем дезинфекцию...");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Можно вернуться...");
    }

    private void desinfect(Room room) {
        System.out.println("Дезинфекция...");
    }
}
