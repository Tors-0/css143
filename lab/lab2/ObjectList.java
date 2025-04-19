public class ObjectList {
    //or IntList, caps at 100 elements with no bullet-proofing or bounds checks, etc.
    private int numElements = 0;
    private Object[] myShapes = new Object[100];

    public void add(Object obj) {
        myShapes[numElements++] = obj;
    }

    @Override
    public String toString() {
        StringBuilder retVal = new StringBuilder();
        for(int i = 0; i < numElements; i++) {
            retVal.append(myShapes[i].toString()).append(" ");
        }
        return retVal.toString();
    }



    public static void main(String[] args) {
        ObjectList a = new ObjectList();
        a.add(95); a.add(100); a.add(58);
        System.out.println(a.toString() );
    }
}
