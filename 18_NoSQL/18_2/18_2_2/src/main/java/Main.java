import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws InterruptedException {
            clientRedis();

    }
    
    private static void clientRedis() throws InterruptedException {
        //        Config config = new Config();
//        config
//                .useSingleServer()
//                .setAddress("redis://127.0.0.1:6379");
//        RedissonClient redisson = Redisson.create(config);
//
//        RMap map =  redisson.getMap("myMap");
//        map.put("a", 1);
//        map.put("b", 2);
//        map.put("c", 3);
//
//        //System.out.println(map.get("a"));
//        System.out.println(map.readAllKeySet());


        RedisStorage redisStorage = new RedisStorage();
        redisStorage.init();

        while (true) {

            int byUserOne = (int) (Math.random()*10);
            int byUserTwo = (int) (10 + Math.random()*10);

            for (int i=1; i<21; i++) {
                if (i == byUserOne || i == byUserTwo) {
                    System.out.println("Пользователь " + i + " оплатил платную услугу");
                } else {
                    redisStorage.logPageVisit(i);
                    redisStorage.deleteOldEntries(1);
                    //System.out.println(redisStorage.calculateUsersNumber());
                }
            }
            //redisStorage.listKeys();
            //System.out.println(redisStorage.calculateUsersNumber());
            Thread.sleep(1000);
        }
        //redisStorage.listKeys();
        //redisStorage.getOnlineUsers();
        //redisStorage.calculateUsersNumber();
    }
}
