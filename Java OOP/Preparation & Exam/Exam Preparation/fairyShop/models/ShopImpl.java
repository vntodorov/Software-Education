package ExamPreparation.fairyShop.models;

public class ShopImpl implements Shop{

    @Override
    public void craft(Present present, Helper helper) {
        for (Instrument instrument : helper.getInstruments()){
            while (helper.canWork() && !instrument.isBroken() && !present.isDone()){
                helper.work();
                instrument.use();
                present.getCrafted();
            }
        }
    }
}
