package unit04.simple_classes_and_objects.task06;

public class Time {
    private int hh;
    private int mm;
    private int ss;

    public void setTime(int hh, int mm, int ss){
        setHh(hh);
        setMm(mm);
        setSs(ss);
    }

    @Override
    public String toString() {
        return "Time{" +
                "hh=" + hh +
                ", mm=" + mm +
                ", ss=" + ss +
                '}';
    }

    private void setHh(int hh) {
        if(hh <= 24 && hh >= 0){
            this.hh = hh;
        }else this.hh = 0;
    }

    private void setMm(int mm) {
        if(mm <= 60 && mm >= 0){
            this.mm = mm;
        }else this.mm = 0;
    }

    private void setSs(int ss) {
        if(ss <= 60 && ss >= 0){
            this.ss = ss;
        }else this.ss = 0;
    }

    public void changeHhTo(int hh){
        setHh(this.hh+hh);
    }

    public void changeMmTo(int mm){
        setMm(this.mm+mm);
    }
    public void changeSsTo(int ss){
        setSs(this.ss+ss);
    }

}
