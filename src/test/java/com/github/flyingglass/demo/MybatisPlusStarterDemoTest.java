package com.github.flyingglass.demo;

import com.baomidou.mybatisplus.core.toolkit.Sequence;
import orestes.bloomfilter.BloomFilter;
import orestes.bloomfilter.FilterBuilder;
import orestes.bloomfilter.redis.BloomFilterRedis;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.data.keyvalue.core.IdentifierGenerator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: fly
 * Created date: 2019/12/25 17:38
 */
@DirtiesContext
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
public class MybatisPlusStarterDemoTest {

    private void Sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    @Test
    void a00_snakeflow() {
        int size = 10000;


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                50, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()
//                new ArrayBlockingQueue<Runnable>(20000)
        );

        Sequence sequence = new Sequence();
        for (int i = 0; i < size; i++) {
            System.out.println(sequence.nextId());
        }

//        for (int i = 0; i < size; i++) {
//            executor.execute(()->{
//                for (int j = 0; j < 1000; j++) {
//                    System.out.println(sequence.nextId());
//                }
////                Sleep(1);
//            });
//        }



//        Sleep(10);
    }

    @Test
    void a01_bloomfilter() {
        BloomFilter<String> bf = new FilterBuilder(1000, 0.1).buildBloomFilter();
        bf.add("Just");
        bf.add("a");
        bf.add("test.");

        System.out.println(bf.contains("Just")); //true
        System.out.println(bf.contains("a")); //true
        System.out.println(bf.contains("test.")); //true



    }


}
