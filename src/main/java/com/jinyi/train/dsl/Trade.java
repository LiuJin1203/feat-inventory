package com.jinyi.train.dsl;

/**
 * @author liujin
 * @date 2022/1/20
 * @since JDK8
 */
//➊Trade抽象
public class Trade implements ITrade{
    private double v;

    public Trade(double v) {
        this.v = v;
    }
    //➋计算并返回交易价值 //...
    public double value() {
        return v;
    }
}

//➌装饰器
class TaxFeeDecorator implements ITrade {
    private ITrade trade;

    public TaxFeeDecorator(ITrade trade) {
        this.trade = trade;
    }

    @Override
    public double value() {
        //...; ➍ 税费计算的具体细节
        return trade.value() + trade.value() * 0.1;
    }
}

//➌ 装饰器
class CommissionDecorator implements ITrade {
    private ITrade trade;

    public CommissionDecorator(ITrade trade) {
        this.trade = trade;
    }

    @Override
    public double value() {
        //...; ➎ 佣金计算的具体细节
        return trade.value() + trade.value() * 0.1;
    }
}

interface ITrade{
    double value();
}
