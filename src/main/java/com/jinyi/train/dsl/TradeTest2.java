package com.jinyi.train.dsl;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.jinyi.train.dsl.JavaDSL2.show;
import static com.jinyi.train.dsl.TradeDecoratorType.Commission;
import static com.jinyi.train.dsl.TradeDecoratorType.TaxFee;
import static com.jinyi.train.dsl.UseTrade.use;

/**
 * @author liujin
 * @date 2022/1/20
 * @since JDK8
 */
public class TradeTest2 {
    public static void main(String[] args) {
        Trade trade = new Trade(1000);

        please(show).the(tradeValue).of(new CommissionDecorator(new TaxFeeDecorator(trade)));

        please(show).the(tradeValue).of(use(trade));

        please(show).the(tradeValue).of(use(trade).with(TaxFee).with(Commission));
        please(show).the(tradeValue).of(use(trade).with(Commission));

    }

    public static Function<ITrade, Double> tradeValue = it -> it.value();

    public static IShow please(Consumer<String> action) {
        return what -> it -> action.accept("Java: " + what.apply(it));
    }
    //用于比较与纯函数式编码的区别
    public static IShow please2(Consumer<String> action) {
        IShow ishow = new IShowImpl(action);
        return ishow;
    }

}

@FunctionalInterface
interface IShow {
    IValue the(Function<ITrade, Double> what);
}
class IShowImpl implements IShow{
    Consumer<String> action;

    public IShowImpl(Consumer<String> action) {
        this.action = action;
    }

    @Override
    public IValue the(Function<ITrade, Double> what) {
        return new IValueImpl(action,what);
    }
}

@FunctionalInterface
interface IValue {
    void of(ITrade it);
}

class IValueImpl implements IValue{
    Consumer<String> action;
    Function<ITrade, Double> what;

    public IValueImpl(Consumer<String> action, Function<ITrade, Double> what) {
        this.action = action;
        this.what = what;
    }

    @Override
    public void of(ITrade it) {
        action.accept("Java: " + what.apply(it));
    }
}