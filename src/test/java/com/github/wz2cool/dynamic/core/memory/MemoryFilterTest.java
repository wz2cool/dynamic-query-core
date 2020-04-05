package com.github.wz2cool.dynamic.core.memory;

import com.github.wz2cool.dynamic.core.model.ExampleModel;
import com.github.wz2cool.dynamic.core.query.DynamicQuery;
import com.github.wz2cool.dynamic.memory.MemoryFilter;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.github.wz2cool.dynamic.core.query.Expression.greaterThan;
import static com.github.wz2cool.dynamic.core.query.Expression.lessThan;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class MemoryFilterTest {

    @Test
    public void test() {
        DynamicQuery<ExampleModel> query = DynamicQuery.createQuery(ExampleModel.class)
                .and(ExampleModel::getP1, greaterThan(BigDecimal.ONE))
                .and(ExampleModel::getP1, lessThan(BigDecimal.TEN))
                .and(ExampleModel::getP6, greaterThan(1))
                .and(ExampleModel::getP6, lessThan(9));
        Predicate<ExampleModel> predicate = MemoryFilter.getPredicate(query);

        List<ExampleModel> dataList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            ExampleModel exampleModel = new ExampleModel();
            exampleModel.setP1(new BigDecimal(i % 100));
            exampleModel.setP6(i % 100);
            dataList.add(exampleModel);
        }

        for (int i = 0; i < 10; i++) {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            List<ExampleModel> result = dataList.stream().filter(x ->
                    x.getP1().compareTo(BigDecimal.ONE) > 0 && x.getP1().compareTo(BigDecimal.TEN) < 0
                            && x.getP6() > 1 && x.getP6() < 9).collect(Collectors.toList());
            stopWatch.stop();
            System.out.println("plain: " + stopWatch.getTime());
        }

        for (int i = 0; i < 10; i++) {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            List<ExampleModel> result = dataList.stream().filter(predicate).collect(Collectors.toList());
            stopWatch.stop();
            System.out.println("dynamic: " + stopWatch.getTime());
        }


    }
}
