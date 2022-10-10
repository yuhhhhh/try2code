import java.util.concurrent.*;

public class TokenBucket {
    /**
     * capacity: 桶的容量
     * period: 添加令牌间隔
     * amount: 每次添加数量
     * bucket: 桶
     * period/amount: 流速
     */
    private int capacity;
    private int period;
    private int amount;

    BlockingQueue<String> bucket;

    public TokenBucket(int capacity, int period, int amount) {
        this.period = period;
        this.amount = amount;
        this.capacity = capacity;
    }

    /**
     * 初始化令牌桶，手动进行初始化，否则在第一次tryAcquire操作时初始化
     */
    public void init() {
        bucket = new ArrayBlockingQueue<>(capacity);
        scheduledAddToken();
    }

    /**
     * 获取令牌
     * @return
     * 返回true表示获取成功，false表示失败
     */
    public boolean tryAcquire() {
        if (bucket == null) init();
        return bucket.poll() != null;
    }

    /**
     * 添加令牌
     */
    private void addToken() {
        for (int i = 0; i < amount; i++) {
            bucket.offer("token");
        }
    }

    /**
     * 定时进行添加令牌
     */
    private void scheduledAddToken() {
        Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(this::addToken, 0, period, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        int period = 10, capacity = 10, amount = 5;
        TokenBucket bucket = new TokenBucket(capacity, period, amount);
        bucket.init();
        for (int i = 0; i < 100; i++) {
            String s = "第" + i + "次";
            if (bucket.tryAcquire()) {
                System.out.println(s + "拿取成功");
            } else {
                System.out.println(s + "拿取失败");
            }
            Thread.sleep(1000);
        }
    }
}
