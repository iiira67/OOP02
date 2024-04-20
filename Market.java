import java.util.LinkedList;
import java.util.Queue;

class Market implements QueueBehaviour, MarketBehaviour, Update {
    private Queue<Human> queue = new LinkedList<>();
    private int orderCount = 0;

    @Override
    public void update() {
        System.out.println("Обновление состояния магазина...");
    }

    @Override
    public void enterMarket(Human human) {
        System.out.println(human.getName() + " вошёл в магазин.");
    }

    @Override
    public void leaveMarket(Human human) {
        System.out.println(human.getName() + " покинул магазин.");
    }

    @Override
    public void enqueue(Human human) {
        queue.add(human);
        System.out.println(human.getName() + " встал в очередь.");
    }

    @Override
    public Human dequeue() {
        if (!queue.isEmpty()) {
            Human human = queue.poll();
            System.out.println(human.getName() + " обслужен.");
            return human;
        } else {
            System.out.println("В очереди никого нет.");
            return null;
        }
    }

    public void placeOrder(Human human) {
        orderCount++;
        System.out.println(human.getName() + " заказал. Номер заказа: " + orderCount);
    }

    public static void main(String[] args) {
        Market market = new Market();
        Human human1 = new Human("Анна");
        Human human2 = new Human("Владимир");
        market.enterMarket(human1);
        market.enqueue(human2);
        market.update();
        market.enterMarket(human2);
        market.enqueue(human2);
        market.placeOrder(human1);
        market.dequeue();
        market.dequeue();
        market.leaveMarket(human1);
        market.leaveMarket(human2);
    }

}
