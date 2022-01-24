package com.jinyi.train.dsl;

/**
 * @author liujin
 * @date 2022/1/20
 * @since JDK8
 */
public class UseTrade {
    public static ITradeAdapter use(ITrade trade){
        return new ITradeAdapter(trade);
    }

}
class ITradeAdapter implements ITrade {
    private ITrade trade;

    public ITradeAdapter(ITrade trade) {
        this.trade = trade;
    }

    @Override
    public double value() {
        return trade.value();
    }
    public ITradeAdapter with(TradeDecoratorType decorator){
        switch (decorator){
            case TaxFee: return new ITradeAdapter(new TaxFeeDecorator(trade));
            case Commission:return new ITradeAdapter(new CommissionDecorator(trade));
            default: return this;
        }
    }
}

