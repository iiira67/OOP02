interface QueueBehaviour {
    void enqueue(Human human);
    Human dequeue();
}

interface MarketBehaviour {
    void enterMarket(Human human);
    void leaveMarket(Human human);
}

interface Update {
    void update();
}
