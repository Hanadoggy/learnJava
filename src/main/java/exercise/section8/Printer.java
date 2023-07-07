package exercise.section8;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public int addToner(int tonerAmount) {

        if (tonerAmount <= 0 || tonerAmount > 100) {
            return -1;
        } else if (tonerAmount + tonerLevel > 100) {
            return -1;
        }

        return tonerLevel += tonerAmount;
    }

    public int printPages(int pagesToPrint) {

        pagesPrinted += (duplex) ? pagesToPrint * 2 : pagesToPrint;
        return (duplex) ? (pagesToPrint / 2 + pagesToPrint % 2)  : pagesToPrint;
    }

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel > -1 && tonerLevel <= 100) ? tonerLevel : -1;
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
