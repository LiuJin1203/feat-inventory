package com.jinyi.train.dsl;

import static com.jinyi.train.dsl.TradeDecoratorType.Commission;
import static com.jinyi.train.dsl.TradeDecoratorType.TaxFee;
import static com.jinyi.train.dsl.UseTrade.use;

/**
 * @author liujin
 * @date 2022/1/20
 * @since JDK8
 */
public class TradeTest {
    public static void main(String[] args) {
        Trade trade = new Trade(1000);
        ITrade t1 = new CommissionDecorator(new TaxFeeDecorator(trade));
        System.out.println(t1.value());

        ITrade t2 = use(trade);
        System.out.println(t2.value());

        ITrade t3 = use(trade).with(TaxFee).with(Commission);
        System.out.println(t3.value());
    }


}
