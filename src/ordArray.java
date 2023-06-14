public class ordArray {
    private long[] a;
    private int nElements;

    public ordArray(int max) {
        a = new long[max];
        nElements = 0;
    }

    public int size() {
        return nElements;
    }

    public int find(long searchKey) {
        return recFind(searchKey, 0, nElements - 1);
    }

    private int recFind(long searchKey, int lowerBound, int upperBound) {
        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        if (a[curIn] == searchKey)
            return curIn;
        else if (lowerBound > upperBound)
            return nElements;
        else {
            if (a[curIn] < searchKey)
                return recFind(searchKey,curIn + 1, upperBound);
            else
                return recFind(searchKey,lowerBound,curIn - 1);
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElements; j++)
            if (a[j] > value)
                break;
        for (int k = nElements; k > j; k--)
            a[k] = a[k-1];
        a[j] = value;
        nElements++;
    }

    public void display() {
        for (int j = 0; j < nElements; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
}
