package anthea.secondhand_market.constant.consts;

/**
 * @author anthea
 * @date 2023/4/26 19:45
 */
public class RedisConstant {
    /**
     * lock 购买
     */
    public static final String REDIS_LOCK = "lock:goodsId";

    /**
     * 锁存活时间
     */
    public static final Integer LOCK_GOODS_LAST_TIME = 2;
}
