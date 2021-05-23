package unit01;
public class Task3_4 {
    private int productionNumbers;
    public Task3_4(){
        System.out.println("The product of the squares of the first two hundred numbers is:");
        productSquares();
    }

    public void productSquares(){
        setProductionNumbers(1);
        for (int i = 1; i <= 200; i++){
            setProductionNumbers((int) (getProductionNumbers()*Math.pow(i,2)));
        }
    }

    public int getProductionNumbers() {
        return productionNumbers;
    }

    public void setProductionNumbers(int productionNumbers) {
        this.productionNumbers = productionNumbers;
    }
}
